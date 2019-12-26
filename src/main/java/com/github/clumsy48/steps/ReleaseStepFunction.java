package com.github.clumsy48.steps;

import com.github.clumsy48.model.ReleaseStepArguments;
import com.github.clumsy48.model.ReleaseStepStatus;

import java.util.function.Function;

/**
 * @author shailendras
 */
public abstract class ReleaseStepFunction implements Function<ReleaseStepArguments, ReleaseStepStatus> {
}
