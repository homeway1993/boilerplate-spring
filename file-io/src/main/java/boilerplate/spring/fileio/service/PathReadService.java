package boilerplate.spring.fileio.service;

import java.nio.file.Path;
import java.util.List;

public interface PathReadService {

    List<Path> getAllRegularFilePath(String path);

    default List<Path> getDirectories(String path) {
        return getDirectories(path, 1);
    }

    List<Path> getDirectories(String path, int maxDepth);
}
