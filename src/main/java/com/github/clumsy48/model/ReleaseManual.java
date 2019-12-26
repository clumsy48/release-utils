package com.github.clumsy48.model;

import java.util.List;

/**
 * @author shailendras
 */
public class ReleaseManual {

  private String baseDir;
  private List<Repo> repos;
  private String sshPrivateKeyLocation;
  private String sshPassphraseLocation;

  // setter & getter
  public ReleaseManual() {
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

  public String getSshPrivateKeyLocation() {
    return sshPrivateKeyLocation;
  }

  public void setSshPrivateKeyLocation(String sshPrivateKeyLocation) {
    this.sshPrivateKeyLocation = sshPrivateKeyLocation;
  }

  public String getSshPassphraseLocation() {
    return sshPassphraseLocation;
  }

  public void setSshPassphraseLocation(String sshPassphraseLocation) {
    this.sshPassphraseLocation = sshPassphraseLocation;
  }
}
