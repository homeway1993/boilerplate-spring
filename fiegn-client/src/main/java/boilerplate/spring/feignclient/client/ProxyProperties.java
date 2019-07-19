package boilerplate.spring.feignclient.client;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "proxy")
@Data
public class ProxyProperties {

    private String host;
    private Integer port;
}
