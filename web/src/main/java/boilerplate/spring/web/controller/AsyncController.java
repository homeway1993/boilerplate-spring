package boilerplate.spring.web.controller;

import boilerplate.spring.web.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

@RestController
@RequestMapping("/async")
public class AsyncController {

    @Autowired
    private AsyncService asyncService;

    @GetMapping("/void")
    public void getVoid() {
        asyncService.count();
    }

    @GetMapping("/future")
    public Future<String> getFuture() {
        return asyncService.getFuture();
    }
}
