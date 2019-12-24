package com.github.clumsy48.model;

/**
 * @author shailendras
 */
public class Dependencies {

    private String dependencyVariableInPom;
    private String expectedRCVersion;

    public Dependencies() {
    }

    public String getDependencyVariableInPom() {
        return dependencyVariableInPom;
    }

    public void setDependencyVariableInPom(String dependencyVariableInPom) {
        this.dependencyVariableInPom = dependencyVariableInPom;
    }

    public String getExpectedRCVersion() {
        return expectedRCVersion;
    }

    public void setExpectedRCVersion(String expectedRCVersion) {
        this.expectedRCVersion = expectedRCVersion;
    }
}
