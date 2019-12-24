package com.github.clumsy48;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.clumsy48.model.*;
import com.github.clumsy48.utils.ReleaseStepMap;

import java.io.File;

public class TestCmd {

    private static final ObjectMapper JSON_READER = new ObjectMapper();

    public static void main(String[] args) throws Exception {

        if (args.length >= 1) {
            File stepsManualFile = new File(args[0]);
            ReleaseStepManual manual = JSON_READER.readValue(stepsManualFile, ReleaseStepManual.class);

            // todo: add basic error handling
            for (Repo repo : manual.getRepos()) {
                System.out.println("Repo: " + repo.getRepoName());
                for (ReleaseStep releaseStep : repo.getSteps()) {
                    System.out.println("Step: " + releaseStep);
                    ReleaseStepStatus releaseStepStatus =
                            ReleaseStepMap.RELEASE_STEP_FUNCTION_MAP
                                    .get(releaseStep)
                                    .apply(manual.getBaseDir() + File.separator + repo.getRepoName());
                    if (releaseStepStatus.getReleaseStatus() == ReleaseStatus.FAILURE) break;
                }
            }
        }
    }
}
