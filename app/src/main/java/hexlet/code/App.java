package hexlet.code;

import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "gendiff", mixinStandardHelpOptions = true, version = "checksum 4.0",
        description = "Compares two configuration files and shows a difference.")
public class App implements Callable<Integer> {

    @CommandLine.Option(names = { "-h", "--help" }, usageHelp = true, description = "Show this help message and exit.")
    boolean usageHelpRequested;

    @CommandLine.Option(names = {"-V", "--version"}, versionHelp = true,
            description = "Print version information and exit.")
    boolean versionInfoRequested;

    @CommandLine.Option(names = { "-f", "--format" }, paramLabel = "format", defaultValue = "stylish",
            description = "output format [default: stylish]")
    String format;

    @CommandLine.Parameters(paramLabel = "filepath1", description = "path to first file")
    String filepath1;

    @CommandLine.Parameters(paramLabel = "filepath2", description = "path to first file")
    String filepath2;

    @Override
    public Integer call() throws Exception { // your business logic goes here...
        Differ.generate(filepath1, filepath2, format);
        return 0;
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}

