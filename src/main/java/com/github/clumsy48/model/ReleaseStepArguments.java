package com.github.clumsy48.model;

import java.util.List;

/**
 * @author shailendras
 */
public class ReleaseStepArguments {

    private String repo;
    private List<Dependencies> dependencies;

    public ReleaseStepArguments() {
    }

    public ReleaseStepArguments(String repo, List<Dependencies> dependencies) {
        this.repo = repo;
        this.dependencies = dependencies;
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
}
