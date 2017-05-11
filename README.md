# myRetail
[myRetail](https://github.com/karlojacobsen/myRetail) is a proof-of-concept RESTful web service

## Case Overview
myRetail is a rapidly growing company with HQ in Richmond, VA and over 200 stores
across the east coast. The stores average 80,000 sq. ft. in size and carry around 20,000
products. myRetail wants to provide a multi-channel experience for its customers online.

myRetail is comparing solution options for the online grocery store. The goal is to create an end-to-end POC for a Products service and API, which will return
Product data from the database to the caller. Here is some example data:

id      | sku      | name          | category | price  | last_updated
--------|----------|---------------|----------|--------|-------------
5555    | AEX143   | Stroller      | baby     | 199.99 | 2014-05-23
5543    | IOL123   | Optimus Prime | toys     | 13.37  | 2014-02-01
7563    | XYZ904   | Sega Genesis  | toys     | 149.99 | 1989-04-01

## Design Overview
As the case was a proof-of-concept, my goal was to make this web service as clean and efficient as possible so it can be easily developed and understood. To meet this goal, I decided to implement the following stack because of how well the tools integrate with one-another:
* Gradle 2.9 
* Spring Boot 1.3.1 
* Spring Data JPA
* H2 Database (in-memory)
* Tomcat (embedded in Spring Boot)

To start, I used the [Spring Initializer](http://start.spring.io/) to generate a Gradle project with Spring Boot and JPA, H2, and Web dependencies. Then, rather than starting from scratch, I explored on GitHub and Google to see if there were any projects I could work from, and I found a [tutorial](http://www.javabeat.net/spring-data-jpa/) I could refactor to fit my needs. From there, I built my application as clean and efficient as possible, knowing I needed a web layer to handle my requests and responses, a service layer to act as a transactional boundary and invoke my repositories, and a  repository / data access layer to handle interactions with the database.

My project is organized in the following structure:
* <code>src/main/java/myretail/domain</code> - domain/entity classes 
* <code>src/main/java/myretail/web</code> - controller mapping/logic
* <code>src/main/java/myretail/service</code> - service interfaces
* <code>src/main/java/myretail/repository</code> - data access api
* <code>src/main/resources</code> - app/database config and sample data
* <code>src/test/*</code> - test cases for service, web, and respository

## Installation / Run
**Note:** the only tools required to run the application is [Java8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) and [Gradle](gradle.org/gradle-download/)
<pre>
$ git clone git@github.com:karlojacobsen/myRetail.git
$ cd myRetail
# to build 
$ gradlew build # windows
$ ./gradlew build # unix/linux
# to run
$ gradlew bootRun # windows
$ ./gradlew bootRun # unix/linux
</pre>

When the application is run, it will use the embedded Tomcat Server on port 8080 and the in-memory H2 database. Once the application starts up, the following endpoints are available:
* <code>http://localhost:8080/products</code> - returns all products
* <code>http://localhost:8080/products/{id}</code> - returns a specific product (sample data includes ids: 5543, 5555, 7563)
* <code>http://localhost:8080/products/filter?category={category}</code> - returns all products belonging to a specific category name.
* <code>http://localhost:8080/console</code> - console for H2 in-memory database (database info in <code>application.properties</code>)

