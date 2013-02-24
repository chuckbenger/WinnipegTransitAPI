package com.chuck.core.result.schedule;

import org.simpleframework.xml.Element;

import java.io.Serializable;

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
 */

@Element
public class Bus implements Serializable {

    @Element(name = "bike-rack")
    private Boolean bikeRack;

    @Element(name = "easy-access")
    private Boolean easyAccess;

    public Boolean getBikeRack() {
        return bikeRack;
    }

    public Boolean getEasyAccess() {
        return easyAccess;
    }

    @Override
    public String toString() {
        return "\nBus{" +
                "bikeRack=" + bikeRack +
                ", easyAccess=" + easyAccess +
                '}';
    }
}
