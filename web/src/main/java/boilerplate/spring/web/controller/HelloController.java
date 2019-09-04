package boilerplate.spring.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String getHello() {
        return "Hello World";
    }

    @PostMapping("/hello")
    public Map postHello(@RequestBody Map map) {
        return map;
    }
}
