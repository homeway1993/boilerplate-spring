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
public class PathReadServiceImpl implements PathReadService {

    @Override
    public List<Path> getAllRegularFilePath(String path) {
        List<Path> result = new ArrayList<>();
        try (Stream<Path> walk = Files.walk(Paths.get(path))) {
            result = walk.filter(Files::isRegularFile)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
