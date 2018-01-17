## Spring Cloud Contract example application

This application demonstrates how to use Spring Cloud Contract for different purposes:

* Defining contracts for your API
* Verifying the your API implementation against the defined contracts
* Generating stubs for consumers (clients) of your API
* Using a stub server during consumer tests
* Consumers can run a stub server locally, using your API, without using the real service implementation.

### Defining the API's behaviour

By far the most important thing to do is defining the API's behaviour. In Spring Cloud Contract you have different options for defining this.

One way of defining the API behaviour is using the Groovy Contract DSL. You need to define the request-response interaction in such a contract dsl.

Example DSL: requesting an order from the server with id=1 should return a response with at least the id fields in the json response.

```groovy
package contracts.order

import org.springframework.cloud.contract.spec.Contract

/**
 * Contract definition, written in a Groovy DSL
 */
Contract.make {

    /**
     * Request response which succeeds, completes HTTP status code 200
     */
    request {
        method 'GET'
        url('/orders/1')
        headers {
            accept("application/json")
        }
    }
    response {
        status 200
        body(["id" : 1])
        headers {
            contentType(applicationJson())
        }
    }
}
```

Based on this DSL we can generate unit test for verifying the real API implementation. But also (WireMock) stubs which can be used for running a stub server by consumers of you service.

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