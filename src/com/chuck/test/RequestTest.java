package com.chuck.test;

import com.chuck.core.result.location.Locations;
import com.chuck.core.result.message.SystemMessage;
import com.chuck.core.result.route.Route;
import com.chuck.core.result.status.Status;
import com.chuck.core.result.stops.Stop;
import com.chuck.service.*;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

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

@RunWith(JUnit4.class)
public class RequestTest {

    static {
        TransitService.init("");
    }


    @Test
    public void ShouldGetBusStopsAtGeoCoordinate() throws Exception {

        BusStopService service = BusStopService.getInstance();
        URI busStops = service.atGeographicCoordinate(49.895, -97.138, 500, 10, true);
        HttpClient client = new DefaultHttpClient();
        HttpGet get = new HttpGet(busStops);
        HttpResponse response = client.execute(get);
        Stop stop = service.convertStreamToObject(response.getEntity().getContent());

        assert (stop.getStops() != null);
    }

    @Test
    public void ShouldNotGetBusStopsAtGeoCoordinate() throws Exception {

        BusStopService service = BusStopService.getInstance();
        //Random coordinate not in winnipeg
        URI busStops = service.atGeographicCoordinate(30.895, 97.138, 500, 10, true);
        HttpClient client = new DefaultHttpClient();
        HttpGet get = new HttpGet(busStops);
        HttpResponse response = client.execute(get);
        Stop stop = service.convertStreamToObject(response.getEntity().getContent());

        assert (stop.getStops() == null);
    }

    @Test
    public void ShouldGetBusStopsAtUTMCoordinate() throws Exception {

        BusStopService service = BusStopService.getInstance();
        URI busStops = service.atUTMCoordinate(633861, 5525798, 500, 10, true);
        HttpClient client = new DefaultHttpClient();
        HttpGet get = new HttpGet(busStops);
        HttpResponse response = client.execute(get);
        Stop stop = service.convertStreamToObject(response.getEntity().getContent());

        assert (stop.getStops() != null);
    }

    @Test
    public void ShouldNotGetBusStopsAtUTMCoordinate() throws Exception {

        BusStopService service = BusStopService.getInstance();
        //Random coordinate not in winnipeg
        URI busStops = service.atUTMCoordinate(12323, 324324, 500, 10, true);
        HttpClient client = new DefaultHttpClient();
        HttpGet get = new HttpGet(busStops);
        HttpResponse response = client.execute(get);
        Stop stop = service.convertStreamToObject(response.getEntity().getContent());

        assert (stop.getStops() == null);
    }

    @Test
    public void shouldGetTransitStatus() throws Exception {
        StatusService service = StatusService.getInstance();

        URI status = service.getTransitStatus();
        HttpClient client = new DefaultHttpClient();
        HttpGet get = new HttpGet(status);
        HttpResponse response = client.execute(get);
        Status s = service.convertStreamToObject(response.getEntity().getContent());

        assert (s.getStatuses() != null);
    }

    @Test
    public void shouldGetSystemMessages() throws Exception {
        NoticeService service = NoticeService.getInstance();

        URI status = service.getSystemMessages();
        HttpClient client = new DefaultHttpClient();
        HttpGet get = new HttpGet(status);
        HttpResponse response = client.execute(get);
        SystemMessage s = service.convertStreamToObject(response.getEntity().getContent());

        assert (s != null);
    }

    @Test
    public void ShouldGetLocationsAtGeoCoordinate() throws Exception {

        LocationService service = LocationService.getInstance();
        URI locUri = service.atGeographicCoordinate(49.895, -97.138, 500, 10);
        HttpClient client = new DefaultHttpClient();
        HttpGet get = new HttpGet(locUri);
        HttpResponse response = client.execute(get);
        Locations locations = service.convertStreamToObject(response.getEntity().getContent());

        assert (locations.getAddresses() != null);
    }

    @Test
    public void ShouldNotGetLocationsAtGeoCoordinate() throws Exception {

        LocationService service = LocationService.getInstance();
        //Random coordinate not in winnipeg
        URI locUri = service.atGeographicCoordinate(3432, 444.138, 500, 10);
        HttpClient client = new DefaultHttpClient();
        HttpGet get = new HttpGet(locUri);
        HttpResponse response = client.execute(get);
        Locations locations = service.convertStreamToObject(response.getEntity().getContent());

        assert (locations.getAddresses() == null);
    }

    @Test
    public void ShouldGetLocationsAtUTMCoordinate() throws Exception {

        LocationService service = LocationService.getInstance();
        URI locUri = service.atUTMCoordinate(633861, 5525798, 500, 10);
        HttpClient client = new DefaultHttpClient();
        HttpGet get = new HttpGet(locUri);
        HttpResponse response = client.execute(get);
        Locations locations = service.convertStreamToObject(response.getEntity().getContent());

        assert (locations.getAddresses() != null);
    }

    @Test
    public void ShouldNotGetLocationsAtUTMCoordinate() throws Exception {

        LocationService service = LocationService.getInstance();
        //Random coordinate not in winnipeg
        URI locUri = service.atUTMCoordinate(12323, 324324, 500, 10);
        HttpClient client = new DefaultHttpClient();
        HttpGet get = new HttpGet(locUri);
        HttpResponse response = client.execute(get);
        Locations locations = service.convertStreamToObject(response.getEntity().getContent());

        assert (locations.getAddresses() == null);
    }

    @Test
    public void ShouldGetRoutes() throws Exception {
        RoutesService service = RoutesService.getInstance();

        URI routeUri = service.atStop("20165");
        HttpClient client = new DefaultHttpClient();
        HttpGet get = new HttpGet(routeUri);
        HttpResponse response = client.execute(get);
        Route route = service.convertStreamToObject(response.getEntity().getContent());

        assert (route.getRouteNodes() != null);
    }

    @Test
    public void ShouldNotGetRoutes() throws Exception {
        RoutesService service = RoutesService.getInstance();

        URI routeUri = service.atStop("32434543");
        HttpClient client = new DefaultHttpClient();
        HttpGet get = new HttpGet(routeUri);
        HttpResponse response = client.execute(get);
        Route route = service.convertStreamToObject(response.getEntity().getContent());

        assert (route.getRouteNodes() == null);
    }

}












