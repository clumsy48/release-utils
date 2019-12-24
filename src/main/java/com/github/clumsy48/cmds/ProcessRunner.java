package com.github.clumsy48.cmds;

import com.github.clumsy48.model.ProcessStatus;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

/**
 * @author shailendras
 */
public class ProcessRunner {

  public static ProcessStatus startProcess(
          String cmd, String repo, String successRegex, String failureRegex) throws Exception {
    System.out.println("Running " + cmd + " on " + repo);
    Process p = new ProcessBuilder("bash", "-c", cmd).directory(new File(repo)).start();

    BufferedReader processInpStream = new BufferedReader(new InputStreamReader(p.getInputStream()));
    BufferedReader processErrStream = new BufferedReader(new InputStreamReader(p.getInputStream()));

    System.out.println("Process started:");
    String log;
    ProcessStatus processStatus = ProcessStatus.FAILURE;
    while ((log = processInpStream.readLine()) != null) {
      System.out.println(">>> " + log);
      if (log.contains(successRegex)) {
        processStatus = ProcessStatus.SUCCESS;
      }
    }
    // System.out.println("Process failed:\n");
    while ((log = processErrStream.readLine()) != null) {
      System.out.println(">>> " + log);
      if (log.contains(failureRegex)) {
        processStatus = ProcessStatus.FAILURE;
      }
    }
    p.destroy(); // kill the process
    return processStatus;
  }
}
