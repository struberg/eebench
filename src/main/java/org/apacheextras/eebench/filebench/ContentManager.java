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

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

/**
 * @author <a href="mailto:struberg@yahoo.de">Mark Struberg</a>
 */
@ApplicationScoped
public class ContentManager {
    private String smallFileContent;
    private String largeFileContent;

    @PostConstruct
    protected void init() {
        smallFileContent = getContent(1000);
        largeFileContent = getContent(1000000);
    }

    public String getSmallFileContent() {
        return smallFileContent;
    }

    public String getLargeFileContent() {
        return largeFileContent;
    }

    private String getContent(int size) {
        StringBuilder sb = new StringBuilder(1000);
        for (int i = 0; i < size/10; i++) {
            sb.append("0123456789");
        }
        return sb.toString();
    }
}
