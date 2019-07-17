package boilerplate.spring.multiplereactivemongodb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@Configuration
@EnableReactiveMongoRepositories(
        basePackages = "boilerplate.spring.multiplereactivemongodb.repository.secondary",
        reactiveMongoTemplateRef = MultipleMongodbConfig.SECONDARY_TEMPLATE
)
public class SecondaryMongodbRepositoryConfig {
}
