package hexlet.code;

import picocli.CommandLine;
import hexlet.code.Differ;

public class App {

    public static void main(String[] args) {
        int exitCode = new CommandLine(new Differ()).execute(args);
        System.exit(exitCode);
    }
}