package boilerplate.spring.fileio;

import boilerplate.spring.fileio.service.FileReadService;
import boilerplate.spring.fileio.service.FileWriteService;
import boilerplate.spring.fileio.service.JenkinsfileReader;
import boilerplate.spring.fileio.service.PathReadService;
import lombok.SneakyThrows;
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

    @Autowired
    private PathReadService pathReadService;

    @Autowired
    private JenkinsfileReader jenkinsfileReader;

    @Override
    @SneakyThrows
    public void run(ApplicationArguments args) {
        /* Writing test code at here. */
    }
}
