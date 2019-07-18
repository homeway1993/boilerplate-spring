package boilerplate.spring.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@FeignClient(name = "ECPay", url = "${ec-pay.base-url}", configuration = ECPayClientConfig.class)
public interface ECPayClient {

    @PostMapping(value = "/SP/CreateTrade", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    String createTrade(@RequestBody Map<String, ?> formData);

    @PostMapping(value = "/Cashier/QueryTradeInfo/V5", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    String queryTrade(Map<String, ?> formData);
}
