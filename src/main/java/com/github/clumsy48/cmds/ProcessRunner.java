package com.github.clumsy48.cmds;

import com.github.clumsy48.model.ProcessStatus;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

/**
 * @author shailendras
 */
public class ProcessRunner {

  public static ProcessStatus startProcess(String cmd, String repo) throws Exception {
    System.out.println("Running " + cmd + " on " + repo);
    Process p = new ProcessBuilder("bash", "-c", cmd).directory(new File(repo)).start();

    BufferedReader processInpStream = new BufferedReader(new InputStreamReader(p.getInputStream()));
    BufferedReader processErrStream = new BufferedReader(new InputStreamReader(p.getInputStream()));

    System.out.println("Process started:");
    String log;
    ProcessStatus processStatus = ProcessStatus.FAILURE;
    while ((log = processInpStream.readLine()) != null) System.out.println(">>> " + log);

    while ((log = processErrStream.readLine()) != null) System.out.println(">>> " + log);

    if (p.waitFor() == 0) // wait for the process to complete // code 0 is terminates normally
      processStatus = ProcessStatus.SUCCESS;

    p.destroy(); // kill the process
    return processStatus;
  }
}
