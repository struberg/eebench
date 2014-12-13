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
import java.io.FileWriter;
import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;

/**
 * @author <a href="mailto:struberg@yahoo.de">Mark Struberg</a>
 */
@ApplicationScoped
public class DirectoryManager {
    private File tempDir;


    @PostConstruct
    protected void init() {
        File baseDir = new File(System.getProperty("java.io.tmpdir"));
        tempDir = new File(baseDir, "eebench-tempdir");

        delete(tempDir);

        tempDir.mkdirs();
    }

    @PreDestroy
    protected void cleanUpDir() {
        delete(tempDir);
    }

    public File getThreadDir() {
        String threadName = Thread.currentThread().getName();
        File threadDir = new File(tempDir, threadName);

        threadDir.mkdirs();

        return threadDir;
    }

    public void writeFile(File file, String content) {
        try {
            FileWriter fw = new FileWriter(file);
            fw.write(content);
        }
        catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

    public void delete(File file) {
        if (!file.exists()) {
            return;
        }

        if (file.isDirectory()) {
            for (File c : file.listFiles()) {
                delete(c);
            }
        }
        if (!file.delete()) {
            throw new RuntimeException("Failed to delete file: " + file);
        }
    }
}
