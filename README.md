# MicroService-Movie-Catalog

An small project that demonstrates an end-to-end cloud-native platform using Spring Cloud for building a practical microservices architecture.

Demonstrated concepts:

    Microservice architecture
    Service discovery
    API gateway
    
API gateway:

Each microservice will coordinate with Eureka to retrieve API routes for the entire cluster. Using this strategy each microservice in a cluster can be load balanced and exposed through one API gateway. Each service will automatically discover and route API requests to the service that owns the route. This proxying technique is equally helpful when developing user interfaces, as the full API of the platform is available through its own host as a proxy.
