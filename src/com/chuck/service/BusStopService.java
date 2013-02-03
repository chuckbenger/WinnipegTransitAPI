package com.chuck.service;

import com.chuck.core.filter.FilterQuery;
import com.chuck.core.result.stops.Stop;

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
public class BusStopService extends TransitService {

    private static BusStopService INSTANCE;

    /**
     * Returns an instance of BusStopService.
     *
     * @return returns a BusStopService object
     */
    public static BusStopService getInstance() {

        if (INSTANCE == null)
            INSTANCE = new BusStopService();

        return INSTANCE;
    }

    /**
     * Creates a new filter query to locate stops around a coordinate
     *
     * @param x          the Utm x coordinate
     * @param y          the Utm y coordinate
     * @param distance   the distance in meters from the coordinates
     * @param maxResults the maximum number of results
     * @param walking    Whether you want walking distance to be calculated
     * @return returns a new query object
     */
    public URI atUTMCoordinate(int x, int y, int distance, int maxResults, boolean walking) throws Exception {
        FilterQuery query = new FilterQuery(this);

        query.addParameter("x", x);
        query.addParameter("y", y);
        query.addParameter("distance", distance);
        query.addParameter("max-results", maxResults);

        if (walking)
            query.addParameter("walking", true);

        return query.buildQuery();
    }

    /**
     * Creates a new filter query to locate stops around a coordinate
     *
     * @param latitude   The latitude to find locations around
     * @param longitude  The longitude to find locations around
     * @param distance   the distance in meters from the coordinates
     * @param maxResults the maximum number of results
     * @param walking    Whether you want walking distance to be calculated
     * @return returns a new query object
     */
    public URI atGeographicCoordinate(double latitude, double longitude, int distance, int maxResults, boolean walking) throws Exception {
        FilterQuery query = new FilterQuery(this);

        query.addParameter("lat", latitude);
        query.addParameter("lon", longitude);
        query.addParameter("distance", distance);
        query.addParameter("max-results", maxResults);

        if (walking)
            query.addParameter("walking", true);

        return query.buildQuery();
    }

    @Override
    public String getServiceName() {
        return "stops";
    }

    @Override
    public Stop convertStreamToObject(InputStream inputStream) throws Exception {
        return super.convertStreamToObject(Stop.class, inputStream);
    }
}
