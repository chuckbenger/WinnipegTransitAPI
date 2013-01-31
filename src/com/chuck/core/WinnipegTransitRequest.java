package com.chuck.core;

import com.chuck.core.exceptions.ServiceNotFound;
import com.chuck.core.filter.Query;
import com.chuck.service.TransitService;
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

    private final HttpClient httpClient = new DefaultHttpClient();

    /**
     * Sends a request to the server requesting xml
     *
     * @param query the query to send
     * @return returns a xml string
     * @throws Exception
     */
    public String sendXMLRequest(Query query) throws Exception {
        return sendRequest(query);
    }

    /**
     * Sends a request to the server and returns the result
     *
     * @param query the query to execute
     * @return returns the query result
     * @throws Exception exception occurred during request
     */
    private String sendRequest(Query query) throws Exception {

        String queryResult;

        try {
            query.setAPIKey(TransitService.getApiKey());
            HttpGet httpGet = query.buildQuery();
            HttpResponse response = httpClient.execute(httpGet);
            String result = parseResponse(response).trim();

            if (validResult(result))
                queryResult = result;
            else
                throw new ServiceNotFound(httpGet.getURI().toString() + " transitService was not found");

        } catch (Exception e) {
            throw e;
        }

        return queryResult;
    }

    /**
     * Check if the data returned started with an xml or json tag. If it
     * doesn't then assume an error occurred or the transitService wasn't found
     *
     * @param result The query result
     * @return returns true if valid else false
     */
    private static boolean validResult(String result) {
        return result.startsWith("{") || result.startsWith("<");
    }

    /**
     * Parses the response and returns a Result object
     *
     * @param response The http response to parse
     * @return returns the result
     * @throws IOException
     */
    private static String parseResponse(HttpResponse response) throws IOException {

        HttpEntity entity = response.getEntity();
        return convertStreamToString(entity.getContent());
    }

    /**
     * Reads from the input stream and returns the result in a string
     *
     * @param is the input stream to read from
     * @return returns the result of the stream
     */
    private static String convertStreamToString(InputStream is) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String xml = "";

        String line;
        try {
            while ((line = reader.readLine()) != null) {
                xml += line;
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
        return xml;
    }

}

















