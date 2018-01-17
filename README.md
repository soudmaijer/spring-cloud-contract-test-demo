## Spring Cloud Contract example application

This application demonstrates how to use Spring Cloud Contract for different purposes:

* Defining contracts for APIs
* Verifying the API implementation against the defined contract
* Generating stubs for consumers (clients) of an API
* Using a stub server during consumer (client) tests
* Using a stub server while running a client locally (not using the real service implementation)

### Building the project

You can build the project using maven by executing the following command on top level:

```bash
mvn clean install
```

Or using the maven wrapper

```bash
mvnw clean install
```

### Running the client

The client application is a web application that uses another service for displaying an html page. 

This application can be started in different modes:

* Using the stub server for simulating responses from the other service
* Using the real server dependency

#### Client with stubs

Starting the client with stubs enabled:

```bash
mvn -rf client spring-boot:run -Dspring.profiles.active=stub
```


#### Client without stubs

Now you also need to start the server application to get real responses:

The server application can be started by executing the following command:

```bash
mvn -rf server spring-boot:run
```

Starting the client using the real service:

```bash
mvn -rf client spring-boot:run
```

That's it!