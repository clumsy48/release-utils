package com.alphasense.releaseutils.steps;

import com.alphasense.releaseutils.cmds.ProcessRunner;
import com.alphasense.releaseutils.model.ProcessStatus;
import com.alphasense.releaseutils.model.ReleaseStepArguments;
import com.alphasense.releaseutils.model.ReleaseStepStatus;
import com.alphasense.releaseutils.utils.Constants;

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
