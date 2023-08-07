/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hw.lineage.loader;

import com.hw.lineage.common.util.Preconditions;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @description: Base class for some tests related to the plugin mechanism.
 * Provides access to some common test resources.
 * @author: HamaWhite
 */
public abstract class PluginTestBase extends TestLogger {

    public static final String PLUGIN_A = "plugin-a";
    public static final String PLUGIN_B = "plugin-b";
    public static final String PLUGIN_A_JAR = PLUGIN_A + ".jar";
    public static final String PLUGIN_B_JAR = PLUGIN_B + ".jar";
    public static final ClassLoader PARENT_CLASS_LOADER = PluginTestBase.class.getClassLoader();

    public URL createPluginJarURLFromString(String fileString) throws MalformedURLException {
        File file = locateJarFile(fileString);
        return file.toURI().toURL();
    }

    public static File locateJarFile(String fileString) {
        File file = new File(fileString);
        if (!file.exists()) {
            // for maven test
            file = new File("target/" + fileString);
        }
        if (!file.exists()) {
            // for idea test
            file = new File("lineage-loader/target/" + fileString);
        }
        Preconditions.checkState(file.exists(), "Unable to locate jar file for test: " + fileString);
        return file;
    }
}