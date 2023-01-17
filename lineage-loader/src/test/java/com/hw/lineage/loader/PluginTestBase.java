package com.hw.lineage.loader;

import com.hw.lineage.util.Preconditions;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @description: Base class for some tests related to the plugin mechanism.
 * Provides access to some common test resources.
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/1/17 12:31 AM
 */
public abstract class PluginTestBase extends TestLogger{

    /** Optional prefix to the jar folder if run from an IDE. */
    private static final String OPT_PREFIX = "target/";

    public static final String PLUGIN_A = "plugin-a";
    public static final String PLUGIN_B = "plugin-b";
    public static final String PLUGIN_A_JAR = PLUGIN_A+".jar";
    public static final String PLUGIN_B_JAR = PLUGIN_B+".jar";
    public static final ClassLoader PARENT_CLASS_LOADER = PluginTestBase.class.getClassLoader();

    URL createPluginJarURLFromString(String fileString) throws MalformedURLException {
        File file = locateJarFile(fileString);
        return file.toURI().toURL();
    }

    public static File locateJarFile(String fileString) {
        File file = new File(fileString);
        if (!file.exists()) {
            file = new File(OPT_PREFIX + fileString);
        }
        Preconditions.checkState(
                file.exists(), "Unable to locate jar file for test: " + fileString);
        return file;
    }
}