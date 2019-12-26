package com.alphasense.releaseutils;

import com.alphasense.releaseutils.model.*;
import com.alphasense.releaseutils.utils.ReleaseStepMap;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class Main {

  private static final ObjectMapper JSON_READER = new ObjectMapper();

  public static void main(String[] args) throws Exception {

    if (args.length >= 1) {
      File stepsManualFile = new File(args[0]);
      ReleaseManual manual = JSON_READER.readValue(stepsManualFile, ReleaseManual.class);

      // todo: add basic error handling
      for (Repo repo : manual.getRepos()) {
        for (ReleaseStep releaseStep : repo.getSteps()) {
          System.out.println(
                  "\n$$$ Running step " + releaseStep + " on " + repo.getRepoName() + " $$$\n");
          ReleaseStepOutput releaseStepOutput =
                  ReleaseStepMap.RELEASE_STEP_FUNCTION_MAP
                          .get(releaseStep)
                          .apply(
                                  new ReleaseStepInput(
                                          manual.getBaseDir() + File.separator + repo.getRepoName(),
                                          repo.getDependencies(),
                                          manual.getSshPrivateKeyLocation(),
                                          manual.getSshPassphraseLocation()));
          if (releaseStepOutput.getReleaseStepStatus().getProcessStatus() == ProcessStatus.FAILURE)
            break;
          System.out.println(
                  "\n$$$ Completed step " + releaseStep + " on " + repo.getRepoName() + " $$$\n");
        }
      }
    }
  }
}
