/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apacheextras.eebench.filebench;

import java.io.File;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author <a href="mailto:struberg@yahoo.de">Mark Struberg</a>
 */
@RequestScoped
@Named
public class LargeFileBean {
    private final static int NUM_ITERATIONS = 20;


    private @Inject DirectoryManager directoryManager;
    private @Inject ContentManager contentManager;

    public String getState() {
        File dir = directoryManager.getThreadDir();

        for (int i=0; i < NUM_ITERATIONS; i++) {
            File numFile = new File(dir, "largefile_" + i);
            directoryManager.writeFile(numFile, contentManager.getLargeFileContent());
        }

        directoryManager.delete(dir);

        return "OK";
    }
}
