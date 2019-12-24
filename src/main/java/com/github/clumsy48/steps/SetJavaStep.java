package com.github.clumsy48.steps;

import com.github.clumsy48.cmds.ProcessRunner;
import com.github.clumsy48.model.ProcessStatus;
import com.github.clumsy48.model.ReleaseStepArguments;
import com.github.clumsy48.model.ReleaseStepStatus;
import com.github.clumsy48.utils.Constants;

/**
 * @author shailendras
 */
@Deprecated
public class SetJavaStep extends ReleaseStepFunction {

  @Override
  public ReleaseStepStatus apply(ReleaseStepArguments args) {
    ProcessStatus status;
    try {
      status =
              ProcessRunner.startProcess(
                      Constants.CMD_SET_JAVA_VERSION,
                      args.getRepo());

    } catch (Exception e) {
      System.out.println("# Failed to complete this step " + e.getMessage());
      return ReleaseStepStatus.build(ProcessStatus.FAILURE, e.getMessage());
    }
    if (status == ProcessStatus.FAILURE) return ReleaseStepStatus.build(ProcessStatus.FAILURE, "");

    return ReleaseStepStatus.build(ProcessStatus.SUCCESS, "");
  }
}
