package boilerplate.spring.client;

import feign.Client;
import feign.form.FormEncoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;


class ECPayClientConfig {

    @Autowired
    private CustomHttpClient customHttpClient;

    @Bean
    public Client client() {
        return customHttpClient.client();
    }

    /**
     * handle request Content-Type application/x-www-form-urlencoded
     */
    @Bean
    public FormEncoder formEncoder(ObjectFactory<HttpMessageConverters> messageConverters) {
        return new FormEncoder(new SpringEncoder(messageConverters));
    }
}
