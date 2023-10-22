package cli;

import exceptions.Exceptions;
import logger.Log4JLogger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CLI {
    public static void executeCommandLine(String command)  {
        ProcessBuilder builder = new ProcessBuilder(
                "cmd.exe", "/c", command);
        builder.redirectErrorStream(true);
        Process p = null;
        try {
            p = builder.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line = null;
        while (true) {
            try {
                if (!((line = r.readLine()) != null)) break;
            } catch (IOException e) {
                Exceptions.handle(CLI.class, e);
            }
            Log4JLogger.logINFO(CLI.class, new Object() {}.getClass().getEnclosingMethod().getName(), line);
            break;
        }
    }
}