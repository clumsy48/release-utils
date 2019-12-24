package com.github.clumsy48.steps;

import com.github.clumsy48.model.Dependencies;
import com.github.clumsy48.model.ProcessStatus;
import com.github.clumsy48.model.ReleaseStepArguments;
import com.github.clumsy48.model.ReleaseStepStatus;
import com.github.clumsy48.utils.Constants;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author shailendras
 */
public class UpdateDependencyStep extends ReleaseStepFunction {

    @Override
    public ReleaseStepStatus apply(ReleaseStepArguments args) {
        File file = new File(args.getRepo() + File.separator + Constants.POM_FILE);
        // todo: add basic checks, if file not present
        // todo: add basic check for dependencies
        String pom;
        try {
            pom = IOUtils.toString(new FileInputStream(file), Charset.defaultCharset());
        } catch (Exception e) {
            System.out.println("# Failed to read pom file " + e.getMessage());
            return ReleaseStepStatus.build(ProcessStatus.FAILURE, e.getMessage());
        }
        for (Dependencies dependencies : args.getDependencies()) {
            String dependency = dependencies.getDependencyVariableInPom();
            String dependencyRegex = "<" + dependency + ">(.*?)</" + dependency + ">";
            String expectedDependencyRegex = "<" + dependency + ">" + dependencies.getExpectedVersion() + "</" + dependency + ">";
            Matcher matcher = Pattern.compile(dependencyRegex).matcher(pom);
            System.out.println(
                    "==> Updating dependency "
                            + dependency
                            + " from "
                            + (matcher.find() ? matcher.group(1) : "<not-found>") // todo: handle these error cases
                            + " to "
                            + dependencies.getExpectedVersion());

            pom = pom.replaceAll(dependencyRegex, expectedDependencyRegex);
        }
        // rewrite the pom file
        try {
            FileUtils.writeStringToFile(file, pom, Charset.defaultCharset());
        } catch (Exception e) {
            System.out.println("# Failed to rewrite updated pom file " + e.getMessage());
        }

        return ReleaseStepStatus.build(ProcessStatus.SUCCESS, "");
    }
}
