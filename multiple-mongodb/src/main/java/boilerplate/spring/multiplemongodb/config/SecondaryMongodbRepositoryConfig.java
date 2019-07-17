package boilerplate.spring.multiplemongodb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(
        basePackages = "boilerplate.spring.multiplemongodb.repository.secondary",
        mongoTemplateRef = MultipleMongodbConfig.SECONDARY_TEMPLATE
)
public class SecondaryMongodbRepositoryConfig {
}
