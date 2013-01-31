package com.chuck.core.result.location;

import org.simpleframework.xml.Element;
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
 * Time: 12:53 PM
 */

@Root
public class Monument {

    @Element
    private String key;

    @Element
    private String name;

    @ElementList
    private List<String> categories;

    @Element
    private Address address;

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public List<String> getCategories() {
        return categories;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Monument{" +
                "key=" + key +
                ", name='" + name + '\'' +
                ", categories=" + categories +
                ", address=" + address +
                '}';
    }
}




















