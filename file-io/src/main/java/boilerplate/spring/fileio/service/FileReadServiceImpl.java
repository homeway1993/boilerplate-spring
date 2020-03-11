package boilerplate.spring.fileio.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FileReadServiceImpl implements FileReadService {

    @Override
    public List<String> readAsStringList(String fileLocation) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileLocation))) {

            return bufferedReader.lines()
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }
}
