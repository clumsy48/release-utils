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
      ReleaseManual manual = JSON_READER.readValue(stepsManualFile, ReleaseManual.class);

      // todo: add basic error handling
      for (Repo repo : manual.getRepos()) {
        for (ReleaseStep releaseStep : repo.getSteps()) {
          System.out.println("\n$$$ Running step " + releaseStep + " on " + repo.getRepoName() + " $$$\n");
          ReleaseStepStatus releaseStepStatus =
                  ReleaseStepMap.RELEASE_STEP_FUNCTION_MAP
                          .get(releaseStep)
                          .apply(
                                  new ReleaseStepArguments(
                                          manual.getBaseDir() + File.separator + repo.getRepoName(),
                                          repo.getDependencies()));
          if (releaseStepStatus.getProcessStatus() == ProcessStatus.FAILURE) break;
        }
      }
    }
  }
}
