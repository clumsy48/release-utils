package com.github.clumsy.releaseutils.utils;

import com.github.clumsy.releaseutils.model.ReleaseStep;
import com.github.clumsy.releaseutils.steps.*;

import com.github.clumsy.releaseutils.steps.BuildStep;
import com.github.clumsy.releaseutils.steps.GitPushDependencyStep;
import com.github.clumsy.releaseutils.steps.MVNReleasePluginStep;
import com.github.clumsy.releaseutils.steps.ReleaseStepFunction;
import com.github.clumsy.releaseutils.steps.SetJavaStep;
import com.github.clumsy.releaseutils.steps.UpdateDependencyStep;

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
