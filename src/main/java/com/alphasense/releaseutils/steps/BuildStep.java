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
public class BuildStep extends ReleaseStepFunction {

  @Override
  public ReleaseStepOutput apply(ReleaseStepInput args) {
    ProcessStatus status;
    try {
      status =
              ProcessRunner.startProcess(
                      Constants.CMD_MVN_PACKAGE_WITHOUT_TESTS, // practical enough, simple for demo
                      args.getRepo());

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
