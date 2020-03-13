package boilerplate.spring.fileio.pojo;

import lombok.Data;

import java.nio.file.Path;

@Data
public class JenkinsfileContext {

    private Path path;
    private String environment;
    private String service;
    private String branch;
}
