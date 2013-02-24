package com.chuck.core.result.stops;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementMap;

import java.io.Serializable;
import java.util.Map;

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
public class Distance implements Serializable {

    @ElementMap(entry = "direct", key = "unit", attribute = true, inline = true)
    private Map<String, Double> direct;

    @ElementMap(entry = "walking", key = "unit", attribute = true, inline = true)
    private Map<String, Double> walking;


    public Map<String, Double> getDirect() {
        return direct;
    }

    public Map<String, Double> getWalking() {
        return walking;
    }

    /**
     * Returns a string containing all the distance metrics covered in the walking map
     *
     * @return returns the metric string
     */
    public String getWalkingString() {
        String walkingString = "";

        for (String key : walking.keySet())
            walkingString += walking.get(key) + " " + key + "/";

        //Trim off the last backslash
        if (walkingString.length() >= 1)
            walkingString = walkingString.substring(0, walkingString.length() - 1);

        return walkingString;
    }

    @Override
    public String toString() {
        return "Distance{" +
                "direct=" + direct +
                ", walking=" + walking +
                '}';
    }
}
