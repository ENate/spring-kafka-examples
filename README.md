# kafka spring Boot, spring kafka projects
This repository contains two project: a kafka producer spring boot application and a multi-module spring cloud stream application. For the spring kafka producer-consumer application, we demonstrate how spring kafka module can be used to implement a spring boot basic application. We define a producer and a consumer in the producer-service and consumer-service respectively.

The second part of the repository consists of a multi-module spring boot microservices application (util-service, user-service and user-composite). The multi-module application demonstrates how to use the functional programming paradigm in implementing a spring kafka streams application (via the spring cloud framework).

To run these examples, we need the following technology stack:

+ kafka and spring cloud (kafka streams)
+ spring-boot v.3.0.6
+ mysql
+ spring cloud
+ spring JPA (for persistence, etc)
+ Spring web
+ docker and docker-compose
+ jdk 17+

## Steps to run the codes

Clone the repository using:

```git

git clone https://github.com/ENate

```

Also, we need to install ``kafka`` using the instructions on the Kafka homepage. The directories consist of the repository consist of the following projects:

+ Kafka producer service named ``producer-service``
+ And a consumer service named ``consumer-service``

Each of the projects can be run separately as individual services. Note that ``jdk 17+`` are required to run the examples.


