package com.chuck.core.result.location;

import com.chuck.core.result.Result;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * <p/>
 * User: chuck
 * Date: 31/01/13
 * Time: 1:18 PM
 */

@Root
public class Intersection extends Result {

    @Element
    private String key;

    @Element
    private Street street;

    @Element(name = "cross-street", required = false)
    Street crossStreet;

    @Element
    private Centre centre;


    public String getKey() {
        return key;
    }

    public Street getStreet() {
        return street;
    }

    public Street getCrossStreet() {
        return crossStreet;
    }

    public Centre getCentre() {
        return centre;
    }

    @Override
    public String toString() {
        return "Intersection{" +
                "key=" + key +
                ", street=" + street +
                ", crossStreet=" + crossStreet +
                ", centre=" + centre +
                '}';
    }
}






















