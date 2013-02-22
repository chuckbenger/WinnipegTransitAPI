package com.chuck.core.result.location;


import com.chuck.core.result.Result;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

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
 * Time: 12:41 PM
 */

@Root
public class Locations extends Result {

    @Attribute(name = "query-time")
    private String queryTime;

    @Attribute
    private String base;

    @ElementList(required = false, inline = true)
    private List<Monument> monument;

    @ElementList(required = false, inline = true)
    private List<Address> address;

    @ElementList(required = false, inline = true)
    private List<Intersection> intersection;


    public String getQueryTime() {
        return queryTime;
    }

    public String getBase() {
        return base;
    }

    public List<Monument> getMonument() {
        return monument;
    }

    public List<Address> getAddress() {
        return address;
    }

    public List<Intersection> getIntersection() {
        return intersection;
    }

    @Override
    public String toString() {
        return "Locations{" +
                "queryTime='" + queryTime + '\'' +
                ", base='" + base + '\'' +
                ", \nmonument=" + monument +
                ", \naddress=" + address +
                ", \nintersection=" + intersection +
                '}';
    }
}























