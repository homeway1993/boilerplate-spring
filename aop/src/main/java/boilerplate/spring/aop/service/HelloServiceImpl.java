package boilerplate.spring.aop.service;

import boilerplate.spring.aop.annotation.Notify;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class HelloServiceImpl implements HelloService {

    @Override
    @Notify("xxxxx")
    public String getHelloString(String name) {
        String str = "hello " + name + ".";
        log.info(str);
        return str;
    }
}
