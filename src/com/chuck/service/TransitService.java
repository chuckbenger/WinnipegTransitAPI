package com.chuck.service;

import com.chuck.core.WinnipegTransitRequest;
import com.chuck.core.filter.Query;
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
     * Initializes the requester and serializer
     */
    protected TransitService() {
        this.requester = new WinnipegTransitRequest();
        this.serializer = new Persister();
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
     * Used for converting xml to a java object
     */
    protected Serializer serializer;

    /**
     * Gets the api transitService name set by the implementing class.
     *
     * @return returns the api transitService name
     */
    public abstract String getServiceName();


    /**
     * Executes the input query and returns a Locations instance
     *
     * @param query        the query to execute
     * @param parsedObject the class the parser will use to convert the xml to
     * @param <T>          The type of the passed in class
     * @return returns the Locations instance
     * @throws Exception
     */
    protected <T> T executeQuery(Query query, Class<T> parsedObject) throws Exception {

        String xml = requester.sendXMLRequest(query);
        return serializer.read(parsedObject, xml);
    }
}
