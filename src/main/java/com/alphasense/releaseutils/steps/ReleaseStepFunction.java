package com.alphasense.releaseutils.steps;

import com.alphasense.releaseutils.model.ReleaseStepArguments;
import com.alphasense.releaseutils.model.ReleaseStepStatus;

import java.util.function.Function;

/**
 * @author shailendras
 */
public abstract class ReleaseStepFunction implements Function<ReleaseStepArguments, ReleaseStepStatus> {
}
