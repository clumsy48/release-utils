package com.alphasense.releaseutils.utils;

import com.alphasense.releaseutils.model.ReleaseStep;
import com.alphasense.releaseutils.steps.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shailendras
 */
public class ReleaseStepMap {

  public static final Map<ReleaseStep, ReleaseStepFunction> RELEASE_STEP_FUNCTION_MAP;

  static {
    RELEASE_STEP_FUNCTION_MAP = new HashMap<>();
    RELEASE_STEP_FUNCTION_MAP.put(ReleaseStep.JAVA8, new SetJavaStep());
    RELEASE_STEP_FUNCTION_MAP.put(ReleaseStep.MVN_PACKAGE, new BuildStep());
    RELEASE_STEP_FUNCTION_MAP.put(ReleaseStep.MVN_PACKAGE_SKIP_TESTS, new BuildStep());
    RELEASE_STEP_FUNCTION_MAP.put(ReleaseStep.UPDATE_DEPENDENCY, new UpdateDependencyStep());
    RELEASE_STEP_FUNCTION_MAP.put(
            ReleaseStep.GIT_PUSH_UPDATED_DEPENDENCY, new GitPushDependencyStep());
    RELEASE_STEP_FUNCTION_MAP.put(ReleaseStep.MVN_RELEASE_PLUGIN, new MVNReleasePluginStep());
  }
}
