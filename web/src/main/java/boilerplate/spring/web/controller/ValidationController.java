package boilerplate.spring.web.controller;

import boilerplate.spring.web.pojo.ValidationRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/validation")
public class ValidationController {

    @PostMapping
    public ValidationRequest post(@RequestBody @Valid ValidationRequest request) {
        return request;
    }
}
