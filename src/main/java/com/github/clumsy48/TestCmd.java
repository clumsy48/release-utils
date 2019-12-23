package com.github.clumsy48;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestCmd {

    public static void main(String[] args) {
        if(args.length>=1){
            int build = 0;
            while (build<args.length){
                System.out.println(args[build]);
                try {
                    String[] cmds = { "mvn clean install" };
                    if(BuildStatus.FAILURE.equals(executeCommand(cmds[0],args[build]))) break;
                } catch (IOException e) {
                    System.out.println("exception happened - here's what I know: ");
                    e.printStackTrace();
                    System.exit(-1);
                }
                build++;
            }
        }
        else return;
        System.exit(0);
    }
    private static BuildStatus executeCommand(String cmd,String dir) throws IOException {
        BuildStatus status = BuildStatus.FAILURE;
        String s = null;
        Process p = new ProcessBuilder("bash", "-c", cmd)
                        .directory(new File(System.getProperty("user.home") + dir))
                        .start();
        // Process p = Runtime.getRuntime().pa.exec(cmd);
        BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
        BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
        // read the output from the command
        System.out.println("Here is the standard output of the command:\n");
        while ((s = stdInput.readLine()) != null) {
            System.out.println(s);
            if(s.contains("BUILD SUCCESS")){
                status = BuildStatus.SUCCESS;
            }
        }
        // read any errors from the attempted command
        if(status.equals("SUCCESS")) return status;
        System.out.println("Here is the standard error of the command (if any):\n");
        while ((s = stdError.readLine()) != null) {
            System.out.println(s);
        }
        return status;
    }
}
