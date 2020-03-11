package boilerplate.spring.fileio.service;

import java.util.List;

public interface FileReadService {

    List<String> readAsStringList(String fileLocation);
}
