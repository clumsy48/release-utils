package com.alphasense.releaseutils.steps;

import com.alphasense.releaseutils.model.ReleaseStepInput;
import com.alphasense.releaseutils.model.ReleaseStepOutput;

import java.util.function.Function;

/**
 * @author shailendras
 */
public abstract class ReleaseStepFunction
        implements Function<ReleaseStepInput, ReleaseStepOutput> {
}
