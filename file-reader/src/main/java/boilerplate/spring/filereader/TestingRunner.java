package boilerplate.spring.filereader;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

@Component
public class TestingRunner implements ApplicationRunner {

    private static final String SRC_FILE = "C:\\Users\\willie_chang\\Downloads\\_temp\\20191203-epc-1.log";

    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader fileReader = new FileReader(SRC_FILE);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        while (bufferedReader.ready()) {
            System.out.println(bufferedReader.readLine());
        }
        fileReader.close();
    }
}
