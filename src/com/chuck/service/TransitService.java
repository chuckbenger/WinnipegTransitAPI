package com.chuck.service;

import com.chuck.core.WinnipegTransitRequest;

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
public abstract class TransitService {

    /**
     * API key to use for requests
     */
    private static String apiKey;

    /**
     * Gets the api get
     *
     * @return returns the api key
     */
    public static String getApiKey() {
        return apiKey;
    }

    /**
     * Sets the api key
     *
     * @param apiKey
     */
    public static void init(String apiKey) {
        TransitService.apiKey = apiKey;
    }

    /**
     * All services shared the same requester instance
     */
    protected WinnipegTransitRequest requester;


    /**
     * Gets the api transitService name set by the implementing class.
     *
     * @return returns the api transitService name
     */
    public abstract String getServiceName(APIMode apiMode);
}
