package com.github.clumsy48.model;

/**
 * @author shailendras
 */
// todo: might be redundant
public class ReleaseStepStatus {
    private ReleaseStatus releaseStatus;
    private String message;

    public ReleaseStatus getReleaseStatus() {
        return releaseStatus;
    }

    public void setReleaseStatus(ReleaseStatus releaseStatus) {
        this.releaseStatus = releaseStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static ReleaseStepStatus build(ReleaseStatus releaseStatus, String message) {
        ReleaseStepStatus status = new ReleaseStepStatus();
        status.setMessage(message);
        status.setReleaseStatus(releaseStatus);
        return status;
    }

}
