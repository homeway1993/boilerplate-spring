package boilerplate.spring.jpa.repository;


import boilerplate.spring.jpa.entity.ExchangeRate;
import boilerplate.spring.jpa.pojo.ExchangeRateBuyRateOnly;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ExchangeRateRepository extends CrudRepository<ExchangeRate, String> {

    Optional<ExchangeRateBuyRateOnly> getBuyRateByPaymentMethodTypeAndCurrencyCode(String paymentMethodType,
                                                                                   String currencyCode);
}
