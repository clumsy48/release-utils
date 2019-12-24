package com.github.clumsy48.steps;

import com.github.clumsy48.cmds.Commands;
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
                      Commands.CMD_SET_JAVA_VERSION,
                      args.getRepo(),
                      Constants.JAVA_8_SUCCESS_REGEX,
                      Constants.JAVA_8_SUCCESS_REGEX);

    } catch (Exception e) {
      System.out.println("# Failed to complete this step " + e.getMessage());
      return ReleaseStepStatus.build(ProcessStatus.FAILURE, e.getMessage());
    }
    if (status == ProcessStatus.FAILURE) return ReleaseStepStatus.build(ProcessStatus.FAILURE, "");

    return ReleaseStepStatus.build(ProcessStatus.SUCCESS, "");
  }
}
