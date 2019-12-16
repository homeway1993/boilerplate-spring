package boilerplate.spring.prometheusclient.controller;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private MeterRegistry meterRegistry;

    @GetMapping("/counter/{tag}")
    public double getHello(@PathVariable String tag) {
        Counter counter = meterRegistry.counter("boilerplate.spring.counter", "tag", tag);
        counter.increment();
        return counter.count();
    }
}
