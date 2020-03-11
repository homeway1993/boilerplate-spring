package boilerplate.spring.fileio;

import boilerplate.spring.fileio.service.FileReadService;
import boilerplate.spring.fileio.service.FileWriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class TestRunner implements ApplicationRunner {

    @Autowired
    private FileReadService fileReadService;

    @Autowired
    private FileWriteService fileWriteService;

    @Override
    public void run(ApplicationArguments args) {
        /* Writing test code at here. */
    }
}
