# react-springrest-ocb
Test project for consuming the open Oslo City Bike api.


System requirements
-------------------
Java 8 and Maven 3.2+ must be installed and properly configured.

Running the code
----------------

In the file src/main/resources/application.properties, set a valid key for the property ocb.api.key.

In the project folder root run the following Maven command to start the application: 

    mvn spring-boot:run

Then visit http://localhost:8080. This will display a presentation of the consumed data. To view raw json data 
for this presentation use the REST endpoint http://localhost:8080/stations.

    
