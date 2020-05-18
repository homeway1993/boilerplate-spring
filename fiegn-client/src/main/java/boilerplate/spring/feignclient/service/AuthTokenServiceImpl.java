package boilerplate.spring.feignclient.service;

import boilerplate.spring.feignclient.client.AuthTokenClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class AuthTokenServiceImpl implements AuthTokenService {

    @Autowired
    private AuthTokenClient authTokenClient;

    @Override
    @Cacheable(cacheNames = "getToken")
    public String getToken() {
        return authTokenClient.getToken();
    }

    @Override
    @CacheEvict(cacheNames = "getToken")
    public void evictCache() {
    }
}
