package boilerplate.spring.fileio.service;

import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
public class FileWriteServiceImpl implements FileWriteService {

    @Override
    public void writeByStringList(List<String> contents, String fileLocation) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileLocation))) {
            for (String content : contents) {
                bufferedWriter.write(content);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
