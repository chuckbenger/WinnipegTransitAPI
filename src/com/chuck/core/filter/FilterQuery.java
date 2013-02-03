package com.chuck.core.filter;

import com.chuck.service.TransitService;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

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
public class FilterQuery extends Query {

    private final ArrayList<NameValuePair> parameters = new ArrayList<NameValuePair>();

    /**
     * Creates a new filter query for the input transitService
     *
     * @param transitService The transitService this query will be used on
     */
    public FilterQuery(TransitService transitService) {
        super(transitService);
    }

    /**
     * Adds a filter parameter to the query
     *
     * @param key   the parameter key
     * @param value the parameter value
     */
    public void addParameter(String key, Object value) {
        parameters.add(new BasicNameValuePair(key, value.toString()));
    }

    /**
     * Builds a http get for the transitService specified
     *
     * @return returns the  HTTP get
     */
    @Override
    public URI buildQuery() throws URISyntaxException {
        addParameter("api-key", TransitService.getApiKey());
        return URIUtils.createURI("http", BASE_REQUEST_URL, 0, transitService.getServiceName(), URLEncodedUtils.format(parameters, "UTF-8"), null);
    }
}

















