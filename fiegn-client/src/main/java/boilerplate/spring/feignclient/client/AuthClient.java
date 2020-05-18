package boilerplate.spring.feignclient.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "AuthClient", url = "${auth.base-url}", configuration = AuthClientConfig.class)
public interface AuthClient {

    @GetMapping
    void get();
}
