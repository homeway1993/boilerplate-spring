package boilerplate.spring.fileio.service;

import boilerplate.spring.fileio.pojo.JenkinsfileContext;
import lombok.NonNull;
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
        // To avoid haven't any arguments.
        if (args.getSourceArgs().length == 0) {
            System.out.println("At least one argument [environment] is required.");
        }

        // To avoid invalid environment argument.
        final String environment = getEnvironmentByAlias(args.getSourceArgs()[0]);
        if (environment == null) {
            System.out.println("Wrong environment argument: " + args.getSourceArgs()[0]);
        }

        final String service = args.getSourceArgs().length == 1 ? null : args.getSourceArgs()[1];

        this.svnUpdate();

        List<JenkinsfileContext> contextList = this.getContextList(environment, service);

        System.out.println();
        final String format = "%-30s %-30s %-99s %n";
        System.out.printf(format, "Service", "Branch", "Path");
        for (JenkinsfileContext context : contextList) {
            System.out.printf(format, context.getService(), context.getBranch(), context.getPath());
        }
    }

    /**
     * Get Jenkinsfile context according to giving environment and service.
     * If service is {@code null}, consider it is match all service.
     *
     * @param environment environment name such as "develop" or "release", {@code null} is not allowed.
     * @param service     microservice name such as "product" or "inventory", {@code null} is allowed.
     * @return The Jenkinsfile context.
     */
    @Override
    public List<JenkinsfileContext> getContextList(@NonNull final String environment, final String service) {
        return this.getContextList()
                .stream()
                .filter(context -> context.getEnvironment() != null)
                .filter(context -> context.getEnvironment().equals(environment))
                .filter(context -> context.getService() != null)
                .filter(context -> service == null || context.getService().contains(service))
                .collect(Collectors.toList());
    }

    /**
     * @return List of the Jenkinsfile context.
     */
    @Override
    public List<JenkinsfileContext> getContextList() {
        return pathReadService.getAllRegularFilePath(jenkinsfileLocation)
                .stream()
                .filter(path -> path.getFileName().toString().equalsIgnoreCase("Jenkinsfile"))
                .map(this::getContextList)
                .collect(Collectors.toList());
    }

    /**
     * Execute the Subversion update to the latest version and print STDOUT.
     * Ignored any exception.
     */
    private void svnUpdate() {
        try {
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
        } catch (Exception ignored) {
        }
    }

    /**
     * Analyze the Jenkinsfile environment, service and branch.
     *
     * @param path Jenkinsfile path
     * @return The Jenkinsfile context.
     */
    private JenkinsfileContext getContextList(@NonNull Path path) {
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

        return null;
    }
}
