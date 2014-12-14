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
package org.apacheextras.eebench.cdibench;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apacheextras.eebench.cdibench.beans.ClassInterceptedBean;
import org.apacheextras.eebench.cdibench.beans.MethodInterceptedBean;
import org.apacheextras.eebench.cdibench.beans.SimpleApplicationScopedBeanWithoutInterceptor;
import org.apacheextras.eebench.cdibench.beans.SimpleRequestScopedBeanWithoutInterceptor;

/**
 * @author <a href="mailto:struberg@yahoo.de">Mark Struberg</a>
 */
@RequestScoped
@Named
public class CdiBenchBean {
    private final static int NUM_ITERATIONS = 10000;

    private @Inject SimpleApplicationScopedBeanWithoutInterceptor simpleApplicationScopedBeanWithoutInterceptor;
    private @Inject SimpleRequestScopedBeanWithoutInterceptor simpleRequestScopedBeanWithoutInterceptor;
    private @Inject ClassInterceptedBean classInterceptedBean;
    private @Inject MethodInterceptedBean methodInterceptedBean;

    public String getState() {
        for (int i = 0; i < NUM_ITERATIONS; i++) {
            simpleApplicationScopedBeanWithoutInterceptor.theMeaningOfLife();
            simpleRequestScopedBeanWithoutInterceptor.theMeaningOfLife();
            classInterceptedBean.getMeaningOfLife();
            methodInterceptedBean.getMeaningOfLife();
            methodInterceptedBean.getMeaningOfHalfLife();
        }

        return "OK";
    }
}
