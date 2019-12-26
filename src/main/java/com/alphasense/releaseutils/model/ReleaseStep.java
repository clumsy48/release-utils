package com.alphasense.releaseutils.model;

/**
 * @author shailendras
 */
public enum ReleaseStep {
    ALL,
    JAVA8,
    MVN_PACKAGE,
    MVN_PACKAGE_SKIP_TESTS,
    UPDATE_DEPENDENCY,
    GIT_PUSH_UPDATED_DEPENDENCY,
    MVN_RELEASE_PLUGIN;
}
