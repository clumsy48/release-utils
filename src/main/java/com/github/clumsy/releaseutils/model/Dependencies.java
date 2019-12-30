package com.github.clumsy.releaseutils.model;

/**
 * @author shailendras
 */
public class Dependencies {

  private String dependencyVariableInPom;
  private String expectedVersion;

    public Dependencies() {}

  public String getDependencyVariableInPom() {
    return dependencyVariableInPom;
  }

  public void setDependencyVariableInPom(String dependencyVariableInPom) {
    this.dependencyVariableInPom = dependencyVariableInPom;
  }

  public String getExpectedVersion() {
    return expectedVersion;
  }

  public void setExpectedVersion(String expectedVersion) {
    this.expectedVersion = expectedVersion;
  }
}
