package com.chuck.service;

import com.chuck.core.WinnipegTransitRequest;
import com.chuck.core.filter.FilterQuery;
import com.chuck.core.result.status.Status;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

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
    private Serializer serializer;

    public StatusService() {
        requester = new WinnipegTransitRequest();
        serializer = new Persister();
    }

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
    public Status getTransitStatus() throws Exception {

        FilterQuery filterQuery = new FilterQuery(this);
        String xml = requester.sendXMLRequest(filterQuery);
        Status status = serializer.read(Status.class, xml);
        return status;
    }

    @Override
    public String getServiceName() {
        return "statuses";
    }
}
