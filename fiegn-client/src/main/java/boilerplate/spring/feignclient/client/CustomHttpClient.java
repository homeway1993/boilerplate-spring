package boilerplate.spring.feignclient.client;

import feign.Client;
import feign.httpclient.ApacheHttpClient;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClientProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class CustomHttpClient {

    @Autowired
    private FeignClientProperties feignClientProperties;

    @Autowired
    private ProxyProperties proxyProperties;

    /**
     * Use Apache HttpClient to supported the PATCH method and setting the proxy.
     */
    @Bean
    public Client client() {
        // use feign client default configuration
        FeignClientProperties.FeignClientConfiguration defaultConfig = feignClientProperties.getConfig().get("default");
        RequestConfig.Builder configBuilder = RequestConfig.custom()
                .setSocketTimeout(defaultConfig.getReadTimeout())
                .setConnectTimeout(defaultConfig.getConnectTimeout());

        // setting proxy
        if (proxyProperties.getHost() != null && proxyProperties.getPort() != null) {
            configBuilder.setProxy(new HttpHost(proxyProperties.getHost(), proxyProperties.getPort()));
        }

        // create HTTP client
        CloseableHttpClient httpClient = HttpClients.custom()
                .setDefaultRequestConfig(configBuilder.build())
                .build();

        return new ApacheHttpClient(httpClient);
    }
}
