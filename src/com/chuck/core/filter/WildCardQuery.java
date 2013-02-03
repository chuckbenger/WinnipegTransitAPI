package com.chuck.core.filter;

import com.chuck.service.TransitService;

import java.net.URI;
import java.net.URISyntaxException;

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
public class WildCardQuery extends Query {

    private final String wildCard;
    private String apiKey;

    /**
     * @param transitService the transitService to call
     * @param wildCard       the wild card to filter with
     */
    public WildCardQuery(TransitService transitService, String wildCard) {
        super(transitService);
        this.wildCard = wildCard;
    }

    /**
     * Builds a query using the set wildCard
     *
     * @return a new http get method using the wild card filter
     */
    @Override
    public URI buildQuery() throws URISyntaxException {
        return new URI(BASE_REQUEST_URL_WITH_PROTOCOL + transitService.getServiceName() + ":" + wildCard + "?" + TransitService.getApiKeyParam());
    }
}
