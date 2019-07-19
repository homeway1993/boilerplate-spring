package boilerplate.spring.reactivemongodb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.convert.DbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

@Configuration
public class MongodbConfig {

    /**
     * Spring MongoTemplate will save field "_class" by default.
     * This method will return a converter to let MongoClient do not save field "_class".
     */
    @Bean
    public MappingMongoConverter mappingMongoConverter(final MongoDbFactory mongoDbFactory,
                                                       final MongoMappingContext mongoMappingContext) {

        DbRefResolver dbRefResolver = new DefaultDbRefResolver(mongoDbFactory);
        MappingMongoConverter converter = new MappingMongoConverter(dbRefResolver, mongoMappingContext);
        converter.setTypeMapper(new DefaultMongoTypeMapper(null, mongoMappingContext));
        return converter;
    }
}
