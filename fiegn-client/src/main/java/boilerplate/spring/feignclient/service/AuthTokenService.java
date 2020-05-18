package boilerplate.spring.feignclient.service;

public interface AuthTokenService {

    String getToken();

    void evictCache();
}
