# Groovy-Neo4j-AngularJS

### Starting the application

You'll need to provide connection credentials for the database. To do this is to set the Neo4j username and password in `src/main/resources/ogm.properties`

```
driver=org.neo4j.ogm.drivers.bolt.driver.BoltDriver
URI=bolt://localhost
username=<Your username here>
password=<Your password here>
```

You can then start the application with gradle:

```
gradlew run
```

And that's it! Head to <http://localhost:5050> to see your application running.


### Loading the initial dataset

<http://localhost:5050/api/reload>
