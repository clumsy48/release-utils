package com.alphasense.releaseutils.steps;

import com.alphasense.releaseutils.cmds.ProcessRunner;
import com.alphasense.releaseutils.model.ProcessStatus;
import com.alphasense.releaseutils.model.ReleaseStepInput;
import com.alphasense.releaseutils.model.ReleaseStepOutput;
import com.alphasense.releaseutils.model.ReleaseStepStatus;
import com.alphasense.releaseutils.utils.Constants;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author shailendras
 */
public class MVNReleasePluginStep extends ReleaseStepFunction {

    @Override
    public ReleaseStepOutput apply(ReleaseStepInput args) {
        // todo: add basic string checks
        String keyLocation = args.getSshKeyLocation();
        String passphraseLocation = args.getSshPassphraseLocation();

        String cmd =
                Constants.CMD_ADD_SSH_PASSPHRASE_IN_SESSION
                        + keyLocation
                        + " "
                        + passphraseLocation
                        + " && "
                        + Constants.CMD_MVN_RELEASE_PLUGIN;

        ProcessStatus status;
        try {
            status = ProcessRunner.startProcess(cmd, args.getRepo());

        } catch (Exception e) {
            System.out.println("# Failed to complete this step " + e.getMessage());
            return ReleaseStepOutput.build(
                    ReleaseStepStatus.build(ProcessStatus.FAILURE, e.getMessage()));
        }
        if (status == ProcessStatus.FAILURE)
            return ReleaseStepOutput.build(ReleaseStepStatus.build(ProcessStatus.FAILURE, ""));

        // here so success
        // get the tag from release.properties
        System.out.println(">>> mvn release plugin completed on " + args.getRepo());
        System.out.println(">>> reading 'release.properties' from " + args.getRepo());
        File mvnReleaseFile =
                new File(args.getRepo() + File.separator + Constants.RELEASE_PROPERTIES_FILE);
        String releaseFileString;
        try (FileInputStream fis = new FileInputStream(mvnReleaseFile)) {
            releaseFileString = IOUtils.toString(fis, Charset.defaultCharset());
        } catch (Exception e) {
            System.out.println("# Failed to read release.properties file: " + e.getMessage());
            return ReleaseStepOutput.build(
                    ReleaseStepStatus.build(ProcessStatus.FAILURE, "Failed to read release properties"));
        }
        Matcher matcher = Pattern.compile(Constants.SCM_TAG_REGEX).matcher(releaseFileString);
        String releaseTag = matcher.find() ? matcher.group(1) : null; // todo: need to add null check
        // set the release tag
        System.out.println(">>> release version found: " + releaseTag);
        return ReleaseStepOutput.build(ReleaseStepStatus.build(ProcessStatus.SUCCESS, ""))
                .tagName(releaseTag);
    }
}
