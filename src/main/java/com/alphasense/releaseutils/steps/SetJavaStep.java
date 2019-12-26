package com.alphasense.releaseutils.steps;

import com.alphasense.releaseutils.cmds.ProcessRunner;
import com.alphasense.releaseutils.model.ProcessStatus;
import com.alphasense.releaseutils.model.ReleaseStepInput;
import com.alphasense.releaseutils.model.ReleaseStepOutput;
import com.alphasense.releaseutils.model.ReleaseStepStatus;
import com.alphasense.releaseutils.utils.Constants;

/**
 * @author shailendras
 */
@Deprecated
public class SetJavaStep extends ReleaseStepFunction {

  @Override
  public ReleaseStepOutput apply(ReleaseStepInput args) {
    ProcessStatus status;
    try {
        status = ProcessRunner.startProcess(Constants.CMD_SET_JAVA_VERSION, args.getRepo());

    } catch (Exception e) {
      System.out.println("# Failed to complete this step " + e.getMessage());
        return ReleaseStepOutput.build(
                ReleaseStepStatus.build(ProcessStatus.FAILURE, e.getMessage()));
    }
      if (status == ProcessStatus.FAILURE)
          return ReleaseStepOutput.build(ReleaseStepStatus.build(ProcessStatus.FAILURE, ""));

      return ReleaseStepOutput.build(ReleaseStepStatus.build(ProcessStatus.SUCCESS, ""));
  }
}
