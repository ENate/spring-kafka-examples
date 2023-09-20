### A kafka spring boot microservices application
This repository contains a kafka, spring boot application and a multi-module spring cloud stream application. For the spring kafka producer-consumer application, we demonstrate how a loose coupling between services. We define a producer and a consumer in the producer-service and consumer-service respectively.

The second part of the repository consists of a multi-module spring boot microservices application (util-service, user-service and user-composite). The multi-module application demonstrates how to use the functional programming paradigm in implementing a spring kafka streams application (via the spring cloud framework).

The following stack is required to run the application:

+ kafka and spring cloud (kafka streams)
+ spring-boot v.3.1+
+ mysql
+ spring cloud
+ spring JPA (for persistence, etc)
+ Spring web
+ docker and docker-compose
+ jdk 17+
+ maven
+ rabbitmq
+ kafka


### Steps to run the codes

Clone the repository using:

```git

git clone <name of repo>

```
And then change to the directory
```
cd spring-kafka-examples
```
For the purpose of this tutorial, I ran kafka via docker-compose using 
```
docker-compose up -d
```
To run the application, use 
```
mvn spring-boot:run
```
To install kafka, you can use the instructions provided on 
```https://kafka.apache.org/quickstart``, or use an enterprise based kafka.
or install  ``kafka`` using the instructions on the Kafka homepage. 

### Contents of the repo

The directories consist of the repository consist of the following projects:

+ Kafka producer service named ``producer-service`` to produce messages
+ And a consumer service named ``consumer-service`` to consumer messages

### Other Services
+ A composite named ```collect services``` provides composite implementation 
 to the ``ùser-`` and `util` services
+ the utils service contains utility classes and methods, while the
+ the `user-service` contains basic CRUD operations for the user-service.

### Output Notes
When a call is made such as to create user (via the corresponding endpoint
provided in the `collect-services`, an event is created and an event registered in kafka. The `collect-services`calls
the `ùser-service` using a distributed architecture. By registering the event using the choices defined in the 
`util-service`, an event bus alerts other services which can serve as consumers. This design pattern takes care of situations whereby
database updates can be performed in an optimal pattern between microservices. It also enforces the notion of using loose coupling between participating services,
and can be easily extended to include spring Application Events. This method also enables the use of SAGA pattern
which is vital in establishing the SAGA orchestration pattern in microservices.

Both the 
+ Consumer - and
+ producer services can be run together. 

While the collect-services can be run together with user-, util-, consumer-, producer 
services. Note that ``jdk 17+`` are required to run the examples.


