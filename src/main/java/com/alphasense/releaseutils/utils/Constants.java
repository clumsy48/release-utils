package com.alphasense.releaseutils.utils;

/**
 * @author shailendras
 */
public class Constants {

  public static final String POM_FILE = "pom.xml";
  public static final String RELEASE_UTILS_BANNER = "release-utils";
  public static final String CMD_SET_JAVA_VERSION =
          "export JAVA_HOME=`/usr/libexec/java_home -v 1.8`";
  public static final String CMD_MVN_PACKAGE = CMD_SET_JAVA_VERSION + "; mvn clean package";
  public static final String CMD_MVN_PACKAGE_WITHOUT_TESTS =
          CMD_SET_JAVA_VERSION + "; mvn clean package -DskipTests=true";
  public static final String CMD_GIT_PUSH_DEPENDENCY =
          "git commit -a -m \"[" + Constants.RELEASE_UTILS_BANNER + "] updated dependency versions\"; git push";
  public static final String CMD_MVN_RELEASE_PLUGIN =
          "mvn clean -DskipTests -Darguments=-DskipTests --batch-mode release:prepare"; // skipping
}
