package com.github.clumsy48.steps;

import com.github.clumsy48.cmds.ProcessRunner;
import com.github.clumsy48.model.ProcessStatus;
import com.github.clumsy48.model.ReleaseStepArguments;
import com.github.clumsy48.model.ReleaseStepStatus;
import com.github.clumsy48.utils.Constants;

/**
 * @author shailendras
 */
public class BuildStep extends ReleaseStepFunction {

  @Override
  public ReleaseStepStatus apply(ReleaseStepArguments args) {
    ProcessStatus status;
    try {
      status =
              ProcessRunner.startProcess(
                      Constants.CMD_MVN_PACKAGE_WITHOUT_TESTS, // practical enough, simple for demo
                      args.getRepo());

    } catch (Exception e) {
      System.out.println("# Failed to complete this step " + e.getMessage());
      return ReleaseStepStatus.build(ProcessStatus.FAILURE, e.getMessage());
    }
    if (status == ProcessStatus.FAILURE) return ReleaseStepStatus.build(ProcessStatus.FAILURE, "");

    return ReleaseStepStatus.build(ProcessStatus.SUCCESS, "");
  }
}
