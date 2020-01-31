package boilerplate.spring.web.service;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class AsyncServiceImpl implements AsyncService {

    @SneakyThrows
    @Override
    public void count() {
        int count = 5;
        while (count != 0) {
            log.info("count: {}", count--);
            TimeUnit.SECONDS.sleep(1);
        }
    }

    @SneakyThrows
    @Override
    public Future<String> getFuture() {
        int count = 5;
        while (count != 0) {
            log.info("count: {}", count--);
            TimeUnit.SECONDS.sleep(1);
        }

        return new AsyncResult<>("hello world !!!!");
    }
}
