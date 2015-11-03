##### An example of simple web project

	created project using maven archetype 
_mvn archetype:generate -DgroupId=com.web.application -DartifactId=webapplication -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false_

Added Login/Singnup pages with their controller

To run follow below mentioned steps :

1. mvn clean install
2. mvn jetty:run
3. enter _http://localhost:8080/webapplication/_ url in browser