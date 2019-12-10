package boilerplate.spring.aop;

import boilerplate.spring.aop.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TestingRunner implements ApplicationRunner {

    @Autowired
    private HelloService helloService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String str = helloService.getHelloString("world");
        log.info("return: {}", str);
    }
}
