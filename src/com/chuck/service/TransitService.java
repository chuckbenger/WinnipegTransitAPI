package com.chuck.service;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.InputStream;

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
     * Gets the api get as an http param
     *
     * @return returns the api key
     */
    public static String getApiKeyParam() {
        return "api-key=" + apiKey;
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
     * Gets the api transitService name set by the implementing class.
     *
     * @return returns the api transitService name
     */
    public abstract String getServiceName();

    /**
     * Returns the class that can be used to map the returned xml to java objects
     *
     * @param convertToClass the class to map the result to
     * @param inputStream    the stream to read from
     * @return returns a object mapping of the xml
     * @throws Exception
     */
    protected <T> T convertStreamToObject(Class<T> convertToClass, InputStream inputStream) throws Exception {
        Serializer serializer = new Persister();
        return serializer.read(convertToClass, inputStream);
    }

    /**
     * Override to map an input stream to a specific object
     *
     * @param inputStream the input stream to read from
     * @param <T>         The object that will be returned
     * @return return the input stream mapped to an object
     * @throws Exception
     */
    public abstract <T> T convertStreamToObject(InputStream inputStream) throws Exception;
}
