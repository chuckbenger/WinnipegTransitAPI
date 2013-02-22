package com.chuck.service;

import com.chuck.core.filter.FilterQuery;
import com.chuck.core.result.route.Route;

import java.io.InputStream;
import java.net.URI;

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
public class RoutesService extends TransitService {

    private static RoutesService INSTANCE;

    /**
     * Returns an instance of RoutesService.
     *
     * @return returns a RoutesService object
     */
    public static RoutesService getInstance() {

        if (INSTANCE == null)
            INSTANCE = new RoutesService();

        return INSTANCE;
    }

    /**
     * Builds a query to get all routes that stop at the specified stop
     *
     * @param stopNumber the stop number to get stops at
     * @return Returns the built query
     * @throws Exception
     */
    public URI atStop(String stopNumber) throws Exception {
        FilterQuery query = new FilterQuery(this);

        query.addParameter("stop", stopNumber);

        return query.buildQuery();
    }

    @Override
    public String getServiceName() {
        return "routes";
    }

    @Override
    public Route convertStreamToObject(InputStream inputStream) {
        return super.convertStreamToObject(Route.class, inputStream);
    }
}
