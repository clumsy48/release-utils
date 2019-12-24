package com.github.clumsy48.steps;

import com.github.clumsy48.cmds.Commands;
import com.github.clumsy48.cmds.ProcessRunner;
import com.github.clumsy48.model.ReleaseStatus;
import com.github.clumsy48.model.ReleaseStepStatus;
import com.github.clumsy48.utils.Constants;

/**
 * @author shailendras
 */
public class SetJavaStep extends ReleaseStepFunction {

    @Override
    public ReleaseStepStatus apply(String repo) {
        ReleaseStatus status;
        try {
            status =
                    ProcessRunner.startProcess(
                            Commands.CMD_SET_JAVA_VERSION,
                            repo,
                            Constants.JAVA_8_SUCCESS_REGEX,
                            Constants.JAVA_8_SUCCESS_REGEX);

        } catch (Exception e) {
            System.out.println("Failed to complete this step " + e.getMessage());
            return ReleaseStepStatus.build(ReleaseStatus.FAILURE, e.getMessage());
        }
        if (status == ReleaseStatus.FAILURE) return ReleaseStepStatus.build(ReleaseStatus.FAILURE, "");

        return ReleaseStepStatus.build(ReleaseStatus.SUCCESS, "");
    }
}
