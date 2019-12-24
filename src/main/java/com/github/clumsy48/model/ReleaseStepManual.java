package com.github.clumsy48.model;

import java.util.List;

/**
 * @author shailendras
 */
public class ReleaseStepManual {

  private String baseDir;
  private List<Repo> repos;

  // setter & getter
  public ReleaseStepManual() {
  }

  public String getBaseDir() {
    return baseDir;
  }

  public void setBaseDir(String baseDir) {
    this.baseDir = baseDir;
  }

  public List<Repo> getRepos() {
    return repos;
  }

  public void setRepos(List<Repo> repos) {
    this.repos = repos;
  }
}
