package com.github.clumsy48.cmds;

import com.github.clumsy48.model.ReleaseStatus;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

/**
 * @author shailendras
 */
public class ProcessRunner {

    public static ReleaseStatus startProcess(String cmd, String repo, String successRegex, String failureRegex)
            throws Exception {
        System.out.println("Running " + cmd + " on " + repo);
        Process p = new ProcessBuilder("bash", "-c", cmd).directory(new File(repo)).start();

        BufferedReader processInpStream = new BufferedReader(new InputStreamReader(p.getInputStream()));
        BufferedReader processErrStream = new BufferedReader(new InputStreamReader(p.getInputStream()));

        System.out.println("Process started:\n");
        String log;
        while ((log = processInpStream.readLine()) != null) {
            System.out.println(log);
            if (log.contains(successRegex)) {
                return ReleaseStatus.SUCCESS;
            }
        }
        //System.out.println("Process failed:\n");
        while ((log = processErrStream.readLine()) != null) {
            System.out.println(log);
            if (log.contains(failureRegex)) {
                return ReleaseStatus.FAILURE;
            }
        }
        return ReleaseStatus.FAILURE; // fall back option
    }
}
