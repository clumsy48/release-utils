package com.github.clumsy48.utils;

import com.github.clumsy48.model.ReleaseStep;
import com.github.clumsy48.steps.BuildStep;
import com.github.clumsy48.steps.ReleaseStepFunction;
import com.github.clumsy48.steps.SetJavaStep;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shailendras
 */
public class ReleaseStepMap {

    public final static Map<ReleaseStep, ReleaseStepFunction> RELEASE_STEP_FUNCTION_MAP;

    static {
        RELEASE_STEP_FUNCTION_MAP = new HashMap<>();
        RELEASE_STEP_FUNCTION_MAP.put(ReleaseStep.JAVA8, new SetJavaStep());
        RELEASE_STEP_FUNCTION_MAP.put(ReleaseStep.MVN_PACKAGE, new BuildStep());
        RELEASE_STEP_FUNCTION_MAP.put(ReleaseStep.MVN_PACKAGE_SKIP_TESTS, new BuildStep());
    }


}
