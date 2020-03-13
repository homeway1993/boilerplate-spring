package boilerplate.spring.fileio.service;

import boilerplate.spring.fileio.pojo.JenkinsfileContext;
import lombok.NonNull;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JenkinsfileReaderImpl implements JenkinsfileReader {

    @Value("${jenkinsfile.location}")
    private String jenkinsfileLocation;

    @Autowired
    private PathReadService pathReadService;

    @Autowired
    private FileReadService fileReadService;

    /**
     * Print the current branch according to giving arguments.
     *
     * @param args Arguments pass by command line.
     */
    @Override
    public void printBranch(ApplicationArguments args) {
        final String environment = args.getSourceArgs()[0];
        final String service = args.getSourceArgs()[1];
        final String branch = this.getBranch(environment, service);
        System.out.println("Current branch is [" + branch + "]");
    }

    /**
     * Get the current branch according to giving environment and service.
     *
     * @param environment environment name such as "develop" or "release", allow inaccurate name like "dev".
     * @param service     microservice name such as "product" or "inventory".
     * @return current branch
     */
    @Override
    public String getBranch(String environment, String service) {
        environment = getEnvironmentByAlias(environment);
        return this.getContext(environment, service)
                .getBranch();
    }

    /**
     * Get Jenkinsfile context according to giving environment and service.
     *
     * @param environment environment name such as "develop" or "release".
     * @param service     microservice name such as "product" or "inventory".
     * @return The Jenkinsfile context.
     */
    @Override
    public JenkinsfileContext getContext(final String environment, final String service) {
        return this.getContextList()
                .stream()
                .filter(context -> context.getEnvironment() != null)
                .filter(context -> context.getEnvironment().equals(environment))
                .filter(context -> context.getService() != null)
                .filter(context -> context.getService().equals(service))
                .findFirst()
                .orElseThrow(() -> new AssertionError("Has over 1 context."));
    }

    /**
     * @return List of the Jenkinsfile context.
     */
    @Override
    public List<JenkinsfileContext> getContextList() {
        this.svnUpdate();

        return pathReadService.getAllRegularFilePath(jenkinsfileLocation)
                .stream()
                .filter(path -> path.getFileName().toString().equalsIgnoreCase("Jenkinsfile"))
                .map(this::getContext)
                .collect(Collectors.toList());
    }

    /**
     * Execute the Subversion update to the latest version and print STDOUT.
     */
    @SneakyThrows
    private void svnUpdate() {
        String command = "svn update " + jenkinsfileLocation;
        System.out.println(command);
        Process process = Runtime.getRuntime().exec(command);
        BufferedReader output = new BufferedReader(new InputStreamReader(process.getInputStream()));
        while (process.isAlive()) {
            String line = output.readLine();
            if (line != null) {
                System.out.println(output.readLine());
            }
        }
        process.waitFor();
        System.out.println("exit value: " + process.exitValue());
    }

    /**
     * Analyze the Jenkinsfile environment, service and branch.
     *
     * @param path Jenkinsfile path
     * @return The Jenkinsfile context.
     */
    private JenkinsfileContext getContext(@NonNull Path path) {
        JenkinsfileContext result = new JenkinsfileContext();
        result.setPath(path);

        for (String s : fileReadService.readAsStringList(path)) {
            if (s.matches("^.*(choice).*(Environment).*$")) {
                int pre = s.indexOf("['");
                int post = s.indexOf("']");
                result.setEnvironment(s.substring(pre + 2, post));
            }

            if (s.matches("^.*(SERVICE =).*$")) {
                int pre = s.indexOf("'");
                int post = s.indexOf("'", pre + 1);
                result.setService(s.substring(pre + 1, post));
            }

            if (s.matches("^.*(BRANCH =).*$")) {
                int pre = s.indexOf("'");
                int post = s.indexOf("'", pre + 1);
                result.setBranch(s.substring(pre + 1, post));

                break;
            }
        }

        return result;
    }

    /**
     * Change the inaccurate environment name to accurate name.
     *
     * @param environment inaccurate environment name.
     * @return accurate environment name.
     */
    private String getEnvironmentByAlias(@NonNull String environment) {
        if (environment.matches("^(test|testing|dev|develop)$")) {
            return "develop";
        } else if (environment.matches("^(uat|prod|production|release)$")) {
            return "release";
        }

        throw new AssertionError("The wrong environment: " + environment);
    }
}
