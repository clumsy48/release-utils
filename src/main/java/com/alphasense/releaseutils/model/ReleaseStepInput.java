package com.alphasense.releaseutils.model;

import java.util.List;

/**
 * @author shailendras
 */
public class ReleaseStepInput {

    private String repo;
    private List<Dependencies> dependencies;
    private String sshKeyLocation;
    private String sshPassphraseLocation;

    public ReleaseStepInput() {
    }

    public ReleaseStepInput(
            String repo,
            List<Dependencies> dependencies,
            String sshKeyLocation,
            String sshPassphraseLocation) {
        this.repo = repo;
        this.dependencies = dependencies;
        this.sshKeyLocation = sshKeyLocation;
        this.sshPassphraseLocation = sshPassphraseLocation;
    }

    // setter & getters
    public String getRepo() {
        return repo;
    }

    public void setRepo(String repo) {
        this.repo = repo;
    }

    public List<Dependencies> getDependencies() {
        return dependencies;
    }

    public void setDependencies(List<Dependencies> dependencies) {
        this.dependencies = dependencies;
    }

    public String getSshKeyLocation() {
        return sshKeyLocation;
    }

    public void setSshKeyLocation(String sshKeyLocation) {
        this.sshKeyLocation = sshKeyLocation;
    }

    public String getSshPassphraseLocation() {
        return sshPassphraseLocation;
    }

    public void setSshPassphraseLocation(String sshPassphraseLocation) {
        this.sshPassphraseLocation = sshPassphraseLocation;
    }
}
