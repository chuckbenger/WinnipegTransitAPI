package com.chuck.service;

import com.chuck.core.WinnipegTransitRequest;
import com.chuck.core.filter.FilterQuery;
import com.chuck.core.filter.Query;
import com.chuck.core.filter.WildCardQuery;
import com.chuck.core.result.location.Locations;
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
public class Location extends TransitService {

    private static final Location INSTANCE = new Location();
    private Serializer serializer = new Persister();

    public Location() {
        requester = new WinnipegTransitRequest();
    }

    /**
     * Returns an pre-created instance of location
     *
     * @return returns a Location object
     */
    public static Location getInstance() {
        return INSTANCE;
    }

    /**
     * Creates a new filter query returning locations around the UTM x, y coordinate
     *
     * @param x          the Utm x coordinate
     * @param y          the Utm y coordinate
     * @param distance   the distance in meters from the coordinates
     * @param maxResults the maximum number of results
     * @return returns a new query object
     */
    public Locations atUTMCoordinate(int x, int y, int distance, int maxResults) throws Exception {
        FilterQuery query = new FilterQuery(this);

        query.addParameter("x", x);
        query.addParameter("y", y);
        query.addParameter("distance", distance);
        query.addParameter("max-results", maxResults);

        return executeQuery(query);
    }

    /**
     * Creates a new filter query returns the locations around the Geographic coordinates
     *
     * @param latitude
     * @param longitude
     * @param distance   the distance in meters from the coordinates
     * @param maxResults the maximum number of results
     * @return returns a new query object
     */
    public Locations atGeographicCoordinate(double latitude, double longitude, int distance, int maxResults) throws Exception {
        FilterQuery query = new FilterQuery(this);

        query.addParameter("lat", latitude);
        query.addParameter("lon", longitude);
        query.addParameter("distance", distance);
        query.addParameter("max-results", maxResults);

        return executeQuery(query);
    }

    /**
     * Executes the input query and returns a Locations instance
     *
     * @param query the query to execute
     * @return returns the Locations instance
     * @throws Exception
     */
    private Locations executeQuery(Query query) throws Exception {

        String xml = requester.sendXMLRequest(query);
        Locations locations = serializer.read(Locations.class, xml);

        return locations;
    }

    /**
     * Creates new wild card query
     *
     * @param wildCard the filter
     * @return returns a new wild card query
     */
    public Locations atWildCardLocation(String wildCard) throws Exception {
        return executeQuery(new WildCardQuery(this, wildCard));
    }

    @Override
    public String getServiceName(APIMode apiMode) {
        return "locations" + (apiMode == APIMode.JSON ? ".json" : "");
    }
}
















