#Winnipeg Transit API
##Introduction
This is a simple Java library fully compatible with Android to make use of the Winnipeg Transit API (http://api.winnipegtransit.com).

##Usage
The API is pretty simple just create and instance of WinnipegTransitRequest class and you're good to go

	//Pull locations around a utm coordinate within 100 meters with a limit of 10
	TransitService.init("my api key");
    Location locationService = Location.getInstance();
    Locations queryResult = locationService.atUTMCoordinate(633861, 5525798,100,10);

##Dependancies
The following libraries are required to use WinnipegTransitAPI. Android has these by default.
* commons-logging-1.1.1.jar
* httpclient-4.2.3.jar
* httpcore-4.2.2.jar
* simple-xml-2.6.9.jar