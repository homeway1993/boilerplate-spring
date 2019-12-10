package boilerplate.spring.prometheusclient.controller;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private MeterRegistry meterRegistry;

    @GetMapping("/hello")
    public double getHello() {
        Counter counter = meterRegistry.counter("boilerplate.hello");
        counter.increment();
        return counter.count();
    }
}
