package boilerplate.spring.web.controller;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
@RequestMapping("webFlux")
public class HelloWebFluxController {

    @GetMapping("/hello")
    public Mono<String> getHello() {
        return Mono.just("hello");
    }

    @PostMapping("/hello")
    public Mono<Map> postHello(@RequestBody Map map) {
        return Mono.just(map);
    }
}
