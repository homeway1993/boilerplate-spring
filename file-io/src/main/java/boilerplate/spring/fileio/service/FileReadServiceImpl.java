package boilerplate.spring.fileio.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class FileReadServiceImpl implements FileReadService {

    @Override
    public List<String> readAsStringList(String fileLocation) {
        List<String> result = new ArrayList<>();

        try (Stream<String> lines = Files.lines(Paths.get(fileLocation))) {
            result = lines.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public List<String> readAsStringList(Path path) {
        List<String> result = new ArrayList<>();

        try (Stream<String> lines = Files.lines(path)) {
            result = lines.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
