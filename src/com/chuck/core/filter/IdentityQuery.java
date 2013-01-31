package com.chuck.core.filter;

import com.chuck.service.TransitService;
import org.apache.http.client.methods.HttpGet;

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
public class IdentityQuery extends Query {

    private String apiKey;
    private String identity;

    /**
     * Creates a new Identity Query query for the input transitService
     *
     * @param transitService The transitService this query will be used on
     */
    public IdentityQuery(TransitService transitService, String identity) {
        super(transitService);
        this.identity = identity;
    }

    @Override
    public void setAPIKey(String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public HttpGet buildQuery() {
        String url = BASE_REQUEST_URL_WITH_PROTOCOL + identity + "?api-key=" + apiKey;
        return new HttpGet(url);
    }
}
