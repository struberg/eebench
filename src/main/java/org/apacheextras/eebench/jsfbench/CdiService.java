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
package org.apacheextras.eebench.jsfbench;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

/**
 * @author <a href="mailto:struberg@yahoo.de">Mark Struberg</a>
 */
@ApplicationScoped
public class CdiService {

    private List<MyDto> myDtos;

    @PostConstruct
    public void init() {
        List<MyDto> dtos = new ArrayList<MyDto>(300);

        for (int i = 0; i < 100; i++) {
            MyDto dto = new MyDto();
            dto.setInt1(i);
            dto.setInt2(i);
            dto.setInt3(i);
            dto.setInt4(i);
            dto.setInt5(i);
            dto.setInt6(i);
            dto.setInt7(i);
            dto.setInt8(i);
            dto.setInt9(i);

            dto.setStr1("Val " + i);
            dto.setStr2("Val " + i);
            dto.setStr3("Val " + i);
            dto.setStr4("Val " + i);
            dto.setStr5("Val " + i);
            dto.setStr6("Val " + i);
            dto.setStr7("Val " + i);
            dto.setStr8("Val " + i);
            dto.setStr9("Val " + i);

            dtos.add(dto);
        }

        myDtos = Collections.unmodifiableList(dtos);
    }


    public List<MyDto> getMyDtos() {
        return myDtos;
    }
}
