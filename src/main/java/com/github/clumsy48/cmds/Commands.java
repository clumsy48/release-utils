package com.github.clumsy48.cmds;

/**
 * @author shailendras
 */
public class Commands {

    public static final String CMD_SET_JAVA_VERSION =
            "export JAVA_HOME=`/usr/libexec/java_home -v 1.8`";
    public static final String CMD_MVN_PACKAGE = CMD_SET_JAVA_VERSION + "; mvn clean package";
    public static final String CMD_MVN_PACKAGE_WITHOUT_TESTS =
            CMD_SET_JAVA_VERSION + "; mvn clean package -DskipTests=true";
    public static final String CMD_MVN_RELEASE_PLUGIN =
            "mvn clean -DskipTests -Darguments=-DskipTests --batch-mode release:prepare"; // skipping
    // tests for mvn
    // release
    // plugin
}
