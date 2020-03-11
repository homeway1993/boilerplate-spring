package boilerplate.spring.fileio.service;

import java.util.List;

public interface FileWriteService {

    void writeByStringList(List<String> contents, String fileLocation);
}
