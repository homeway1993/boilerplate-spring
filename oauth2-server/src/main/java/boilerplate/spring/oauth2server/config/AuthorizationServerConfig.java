package boilerplate.spring.oauth2server.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.builders.InMemoryClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@Configuration
@EnableAuthorizationServer
@Slf4j
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private OAuth2ClientProperties clientProperties;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        InMemoryClientDetailsServiceBuilder builder = clients.inMemory();

        clientProperties.getClients().forEach((name, client) -> {
            log.info("client register: {}", name);
            builder.withClient(client.getClientId())
                    .secret(passwordEncoder().encode(client.getClientSecret()))
                    .authorizedGrantTypes(client.getAuthorizedGrantTypes())
                    .scopes(client.getScope())
                    .accessTokenValiditySeconds(client.getAccessTokenValiditySeconds());
        });
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
