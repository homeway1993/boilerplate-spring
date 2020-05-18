package boilerplate.spring.feignclient.client;

import boilerplate.spring.feignclient.service.AuthTokenService;
import feign.*;
import feign.codec.ErrorDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;

public class AuthClientConfig {

    @Autowired
    private AuthTokenService authTokenService;

    @Value("${feign.client.config.LinePayRetryable.retryPeriod:1000}")
    private long retryPeriod;

    @Value("${feign.client.config.LinePayRetryable.retryMaxAttempts:3}")
    private int retryMaxAttempts;

    /**
     * Setting the retry configuration.
     */
    @Bean
    public Retryer retryer() {
        return new Retryer.Default(retryPeriod, retryPeriod, retryMaxAttempts);
    }

    /**
     * Evict cache and retry when receive the status 401.
     */
    @Bean
    public ErrorDecoder errorDecoder() {
        return (s, response) -> {
            if (response.status() == 401) {
                authTokenService.evictCache();
                throw new RetryableException(401, response.toString(), Request.HttpMethod.GET, null);
            }
            return FeignException.errorStatus(s, response);
        };
    }

    /**
     * Setting the authentication headers.
     */
    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> requestTemplate.header(HttpHeaders.AUTHORIZATION, authTokenService.getToken());
    }
}
