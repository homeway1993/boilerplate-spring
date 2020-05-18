package boilerplate.spring.feignclient.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "AuthTokenClient", url = "${auth.base-url}")
public interface AuthTokenClient {

    @GetMapping("/token")
    String getToken();
}
