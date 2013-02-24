#Winnipeg Transit API
##Introduction
This is a simple Java library fully compatible with Android to make use of the Winnipeg Transit API (http://api.winnipegtransit.com).

##Usage
The API is pretty simple just create and instance of a service using the singleton method and you're good to go

	//Pull locations around a geometric coordinate within 100 meters with a limit of 10
	BusStopService service = BusStopService.getInstance();
    URI busStops = service.atGeographicCoordinate(49.895, -97.138, 500, 10, true);
    //Send the web request using whatever library you want
    Stop stop = service.convertStreamToObject(inputstream);

##Currently supports the following API's
* Scheduled times for a stop
* Bus stops around a geometric/UTM position
* System messages
* Routes at a specific stop
* Status of transit


##Dependancies
The following libraries are required to use WinnipegTransitAPI.
* commons-logging-1.1.1.jar
* httpclient-4.2.3.jar
* httpcore-4.2.2.jar
* simple-xml-2.6.9.jar