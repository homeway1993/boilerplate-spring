package boilerplate.spring.feignclient;

import boilerplate.spring.feignclient.client.ECPayClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class TestingRunner implements CommandLineRunner {

    @Autowired
    private ECPayClient ecPayClient;

    @Override
    public void run(String... args) throws Exception {
        /* Writing test code at here. */
        ecPayClient.queryTrade(new HashMap<>());
    }
}
