package boilerplate.spring.multiplereactivemongodb.config;

import com.mongodb.ConnectionString;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.convert.CustomConversions;
import org.springframework.data.mongodb.ReactiveMongoDatabaseFactory;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.SimpleReactiveMongoDatabaseFactory;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.convert.NoOpDbRefResolver;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

@Configuration
@EnableConfigurationProperties(MultipleMongodbProperties.class)
public class MultipleMongodbConfig {

    public static final String PRIMARY_TEMPLATE = "primaryReactiveMongoTemplate";
    public static final String SECONDARY_TEMPLATE = "secondaryReactiveMongoTemplate";

    @Autowired
    private MultipleMongodbProperties multipleMongodbProperties;

    @Autowired
    private MongoMappingContext mongoMappingContext;

    @Autowired
    private BeanFactory beanFactory;

    @Primary
    @Bean(name = PRIMARY_TEMPLATE)
    public ReactiveMongoTemplate primaryMongoTemplate() {
        return new ReactiveMongoTemplate(primaryFactory(), getMappingMongodbConverter());
    }

    @Primary
    @Bean
    public ReactiveMongoDatabaseFactory primaryFactory() {
        MongoProperties properties = multipleMongodbProperties.getPrimary();
        return new SimpleReactiveMongoDatabaseFactory(new ConnectionString(properties.getUri()));
    }

    @Bean(name = SECONDARY_TEMPLATE)
    public ReactiveMongoTemplate secondaryMongoTemplate() {
        return new ReactiveMongoTemplate(secondaryFactory(), getMappingMongodbConverter());
    }

    @Bean
    public ReactiveMongoDatabaseFactory secondaryFactory() {
        MongoProperties properties = multipleMongodbProperties.getSecondary();
        return new SimpleReactiveMongoDatabaseFactory(new ConnectionString(properties.getUri()));
    }

    /**
     * Spring mongodb template will safe field "_class" by default.
     * This method will return converter let mongodb template do not save field "_class".
     */
    private MappingMongoConverter getMappingMongodbConverter() {
        NoOpDbRefResolver dbRefResolver = NoOpDbRefResolver.INSTANCE;
        MappingMongoConverter mappingConverter = new MappingMongoConverter(dbRefResolver, mongoMappingContext);

        try {
            mappingConverter.setCustomConversions(beanFactory.getBean(CustomConversions.class));
        } catch (NoSuchBeanDefinitionException ignore) {
            mappingConverter.setTypeMapper(new DefaultMongoTypeMapper(null));
            return mappingConverter;
        }

        // Don't save field "_class" to mongodb
        mappingConverter.setTypeMapper(new DefaultMongoTypeMapper(null, mongoMappingContext));
        mappingConverter.afterPropertiesSet();
        return mappingConverter;
    }
}
