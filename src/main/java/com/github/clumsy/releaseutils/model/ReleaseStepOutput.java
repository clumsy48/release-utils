package com.github.clumsy.releaseutils.model;

/**
 * @author shailendras
 */
public class ReleaseStepOutput {

    private ReleaseStepStatus releaseStepStatus;
    private String releaseTagName = "<EMPTY>";

    public static ReleaseStepOutput build(ReleaseStepStatus releaseStepStatus) {
        ReleaseStepOutput releaseStepOutput = new ReleaseStepOutput();
        releaseStepOutput.setReleaseStepStatus(releaseStepStatus);
        return releaseStepOutput;
    }

    public ReleaseStepOutput tagName(String releaseTagName) {
        this.setReleaseTagName(releaseTagName);
        return this;
    }

    public ReleaseStepStatus getReleaseStepStatus() {
        return releaseStepStatus;
    }

    public void setReleaseStepStatus(ReleaseStepStatus releaseStepStatus) {
        this.releaseStepStatus = releaseStepStatus;
    }

    public String getReleaseTagName() {
        return releaseTagName;
    }

    public void setReleaseTagName(String releaseTagName) {
        this.releaseTagName = releaseTagName;
    }
}
