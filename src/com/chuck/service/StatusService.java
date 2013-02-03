package com.chuck.service;

import com.chuck.core.filter.FilterQuery;
import com.chuck.core.result.status.Status;

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
public class StatusService extends TransitService {

    private static StatusService INSTANCE;

    /**
     * Returns an instance of StatusService
     *
     * @return returns a StatusService object
     */
    public static StatusService getInstance() {

        if (INSTANCE == null)
            INSTANCE = new StatusService();

        return INSTANCE;
    }

    /**
     * Builds a request and gets the current transit status
     *
     * @return returns the status of the transit service
     */
    public URI getTransitStatus() throws Exception {
        FilterQuery filterQuery = new FilterQuery(this);
        return filterQuery.buildQuery();
    }

    @Override
    public Status convertStreamToObject(InputStream inputStream) throws Exception {
        return super.convertStreamToObject(Status.class, inputStream);
    }

    @Override
    public String getServiceName() {
        return "statuses";
    }
}
