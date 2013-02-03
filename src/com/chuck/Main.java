package com.chuck;


import com.chuck.core.result.stops.Stop;
import com.chuck.service.BusStopService;
import com.chuck.service.TransitService;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.net.URI;

public class Main {

    public static void main(String args[]) throws Exception {

        TransitService.init("7etYvCE5gIvO3t8K8P");
        BusStopService instance = BusStopService.getInstance();
        URI busStops = instance.atGeographicCoordinate(49.895, -97.138, 500, 10, true);

        HttpClient client = new DefaultHttpClient();
        HttpGet get = new HttpGet(busStops);
        HttpResponse httpResponse = client.execute(get);

        Stop stop = instance.convertStreamToObject(httpResponse.getEntity().getContent());
    }
}
