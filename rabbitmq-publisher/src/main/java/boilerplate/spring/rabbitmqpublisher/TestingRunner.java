package boilerplate.spring.rabbitmqpublisher;

import boilerplate.spring.rabbitmqpublisher.sender.HelloSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class TestingRunner implements ApplicationRunner {

    @Autowired
    private HelloSender helloSender;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        helloSender.send("hello");
        System.out.println("done");
    }
}
