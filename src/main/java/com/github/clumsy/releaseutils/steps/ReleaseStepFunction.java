package com.github.clumsy.releaseutils.steps;

import com.github.clumsy.releaseutils.model.ReleaseStepInput;
import com.github.clumsy.releaseutils.model.ReleaseStepOutput;

import java.util.function.Function;

/**
 * @author shailendras
 */
public abstract class ReleaseStepFunction
        implements Function<ReleaseStepInput, ReleaseStepOutput> {
}
