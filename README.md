# goeuro

This project is a stand-alone Java utility that queries the GoEuro position suggest API for a user input query string.

The results of the query are written to a CSV file under the execution directory, using the following file naming convention: 

{query string}_{query timestamp (ms)}.csv

This allows for sorting previously made queries based on the query string and time of execution.

The project includes:

  - pom.xml for maven build. Running mvn clean install will generate an executable jar with all dependencies GoEuroTest.jar
  - source code under /src/main/java
  - prebuilt jar file under /target
  - logback.xml for setting log level under /src/main/resources
  - spring-context.xml under /src/main/resources
    
* To run the utility using a different API (different version, dev/qa/prod, etc.):
  In spring-context.xml, change the value of the constructor arg with index 0 in the following bean configuration and rebuild the jar:
  
    \<bean id="positionRestTemplate" class="com.goeuro.rest.PositionRestTemplate"\>
    
	   <constructor-arg index="0" value="http://www.goeuro.com/GoEuroAPI/rest/api/v2/position/suggest/en/"/>
	    
    \</bean\>
