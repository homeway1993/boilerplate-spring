package boilerplate.spring.fileio.service;

import boilerplate.spring.fileio.pojo.JenkinsfileContext;
import org.springframework.boot.ApplicationArguments;

import java.util.List;

public interface JenkinsfileReader {

    void printBranch(ApplicationArguments args);

    String getBranch(String environment, String service);

    JenkinsfileContext getContext(String environment, String service);

    List<JenkinsfileContext> getContextList();
}
