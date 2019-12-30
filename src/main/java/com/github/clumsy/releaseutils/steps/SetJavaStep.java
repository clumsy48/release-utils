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
