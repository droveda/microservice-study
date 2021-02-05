# microservice-study
Study with some examples of micro services using spring-boot + spring-cloud

This is an example project using spring cloud technologies.

-Auth 
 * auth server using spring security and oauth2
 
-Config server
 * spring config server
 
-Eureka server
 * spring Eureka server, for service registration and service discovery
 
-Fornecedor
 * microservice with the supplier logic
 
-loja
 * microservice with the shopping logic
 
-microservice-repo
 * contains the microservices properties (.properties and .yaml files) to be used along with Config Server
 
- transportador
 * microservice with the shipping logic
 
- Zuul
 * Netflix zuul API Gateway. (Starting point for client applications call the microservices endpoints)
 
 
 
**The project and microservices uses a postgresql database. You can find the databses to bre created inside "microservice-repo .yaml files". The DDL for the tables will be automatically generated by JPA 
