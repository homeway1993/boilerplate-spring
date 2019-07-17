package boilerplate.spring.multiplemongodb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(
        basePackages = "boilerplate.spring.multiplemongodb.repository.primary",
        mongoTemplateRef = MultipleMongodbConfig.PRIMARY_TEMPLATE
)
public class PrimaryMongodbRepositoryConfig {
}
