package com.github.clumsy48.model;

import java.util.List;

/**
 * @author shailendras
 */
public class Repo {

  private String repoName;
  private List<ReleaseStep> steps;
  private List<Dependencies> dependencies;

  public Repo() {
  }

  public String getRepoName() {
    return repoName;
  }

  public void setRepoName(String repoName) {
    this.repoName = repoName;
  }

  public List<ReleaseStep> getSteps() {
    return steps;
  }

  public void setSteps(List<ReleaseStep> steps) {
    this.steps = steps;
  }

  public List<Dependencies> getDependencies() {
    return dependencies;
  }

  public void setDependencies(List<Dependencies> dependencies) {
    this.dependencies = dependencies;
  }
}
