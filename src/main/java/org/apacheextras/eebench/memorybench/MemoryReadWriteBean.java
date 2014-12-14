/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apacheextras.eebench.memorybench;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * simple Bean which allocates 10 MB and does nothing else
 * with it so the GC can collect it.
 */
@RequestScoped
@Named
public class MemoryReadWriteBean {

    // 5MB
    private static final int SIZE = 5000000;


    public String getState() {

        StringBuilder sb = new StringBuilder();

        byte[] bytes = new byte[SIZE];
        for (int i = 0; i < SIZE; i = i + 10) {

            bytes[i] = 0;
            bytes[i + 1] = 1;
            bytes[i + 2] = 2;
            bytes[i + 3] = 3;
            bytes[i + 4] = 4;
            bytes[i + 5] = 5;
            bytes[i + 6] = 6;
            bytes[i + 7] = 7;
            bytes[i + 8] = 8;
            bytes[i + 9] = 9;

            sb.append("01234567890");
        }

        // just to do something with it
        bytes.toString();
        synchronized(this) {
            // has no effect other than trashing the cache
            bytes.toString();
            sb.toString();
        }

        // and now read it all
        byte b;
        for (int i = 0; i < SIZE; i = i + 10) {
            b = bytes[i];
        }

        return "OK";
    }

}
