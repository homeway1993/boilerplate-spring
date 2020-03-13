package boilerplate.spring.fileio.service;

import java.nio.file.Path;
import java.util.List;

public interface FileReadService {

    List<String> readAsStringList(String fileLocation);

    List<String> readAsStringList(Path path);
}
