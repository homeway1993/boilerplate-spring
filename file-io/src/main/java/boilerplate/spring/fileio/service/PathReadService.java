package boilerplate.spring.fileio.service;

import java.nio.file.Path;
import java.util.List;

public interface PathReadService {

    List<Path> getAllRegularFilePath(String path);
}
