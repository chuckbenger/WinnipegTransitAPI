package com.chuck.service;

import com.chuck.core.filter.FilterQuery;

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
public class Status implements Service {

    private static final Status INSTANCE = new Status();

    /**
     * Returns an pre-created instance of Status
     * @return returns a Status object
     */
    public static Status getInstance() {
        return INSTANCE;
    }

    /**
     * Builds a request that gets the current transit status
     * @return returns the new status
     */
    public FilterQuery getTransitStatus() {
        return new FilterQuery(this);
    }

    @Override
    public String getServiceName(APIMode apiMode) {
        return "statuses" + (apiMode == APIMode.JSON ? ".json" : "");
    }
}
