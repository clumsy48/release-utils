package com.github.clumsy.releaseutils.steps;

import com.github.clumsy.releaseutils.cmds.ProcessRunner;
import com.github.clumsy.releaseutils.model.ProcessStatus;
import com.github.clumsy.releaseutils.model.ReleaseStepInput;
import com.github.clumsy.releaseutils.model.ReleaseStepOutput;
import com.github.clumsy.releaseutils.model.ReleaseStepStatus;
import com.github.clumsy.releaseutils.utils.Constants;

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
