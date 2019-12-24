package com.github.clumsy48.model;

/**
 * @author shailendras
 */
// todo: might be redundant
public class ReleaseStepStatus {
    private ProcessStatus processStatus;
    private String message;

    public static ReleaseStepStatus build(ProcessStatus processStatus, String message) {
        ReleaseStepStatus status = new ReleaseStepStatus();
        status.setMessage(message);
        status.setProcessStatus(processStatus);
        return status;
    }

    public ProcessStatus getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(ProcessStatus processStatus) {
        this.processStatus = processStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
  }
}
