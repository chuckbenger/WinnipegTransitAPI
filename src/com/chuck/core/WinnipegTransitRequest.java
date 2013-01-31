package com.chuck.core;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

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
public class WinnipegTransitRequest {

    private String apiKey;
    private final HttpClient httpClient = new DefaultHttpClient();

    /**
     * Creates and sets the API Key to be used for transit requests
     *
     * @param apiKey the apiKey to use
     */
    public WinnipegTransitRequest(String apiKey) {
        this.apiKey = apiKey;
    }

    /**
     * Sends a request to the server and returns the result
     *
     * @param query the query to execute
     * @return returns the query result or null if exception occured
     */
    public Result sendRequest(Query query) {

        Result queryResult = null;

        try {
            query.addAPIKey(apiKey);
            HttpGet httpGet = query.buildQuery();
            HttpResponse response = httpClient.execute(httpGet);
            queryResult = parseResponse(response);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return queryResult;
    }

    /**
     * Parses the response and returns a Result object
     *
     * @param response The http response to parse
     * @return returns the result
     * @throws IOException
     */
    private static Result parseResponse(HttpResponse response) throws IOException {

        HttpEntity entity = response.getEntity();
        System.out.println(convertStreamToString(entity.getContent()));
        return null;
    }

    /**
     * Reads from the input stream and returns the result in a string
     *
     * @param is the input stream to read from
     * @return returns the result of the stream
     */
    private static String convertStreamToString(InputStream is) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append((line + "\n"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

}

















