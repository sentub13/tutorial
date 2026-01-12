### 1. Can you discuss how you have used Spring Boot and microservices architecture to build scalable backend services, highlighting how you handled service discovery, configuration management, and data persistence?

* I've worked extensively with Spring Boot to build scalable microservices architecture for our e-commerce platform

* For service discovery, we used Netflix Eureka which allowed services to register themselves and discover other services dynamically
  - Each microservice registers with Eureka server on startup
  - Client-side service discovery pattern for resilience

* Configuration management was handled through Spring Cloud Config
  - Externalized all configurations to Git repository 
  - Used Spring Cloud Bus to dynamically refresh configs
  - Environment specific properties files for dev/staging/prod

* For data persistence:
  - Each microservice had its own database (polyglot persistence)
  - Used Spring Data JPA with PostgreSQL for transactional data
  - MongoDB for product catalog and user preferences
  - Redis for caching and session management

* Additional patterns implemented:
  - Circuit breaker using Hystrix
  - API Gateway using Spring Cloud Gateway
  - Distributed tracing with Sleuth and Zipkin
  - Centralized logging with ELK stack

This architecture allowed us to independently scale and deploy services while maintaining resilience and observability.

### 2. How would you design and implement a Docker-based CI/CD pipeline using Jenkins to deploy a full-stack application with zero downtime and automated rollback?

### 3. Describe your approach to securing authentication and authorization in a web application using JWT and Spring Security, and explain how you would integrate this with an Angular or React front end.

### 4. Given performance issues in a large Angular application using Nx monorepos, what strategies would you use to optimize build times and runtime performance?

### 5. How do you manage state in React applications with Redux, and how do you structure actions, reducers, and middleware to keep the codebase maintainable as the application grows?

### 6. What considerations do you take into account when orchestrating microservices with Kubernetes, including configuration management, rolling updates, and monitoring?

### 7. Explain your approach to database schema design and SQL query optimization for a microservices-based system when you encounter latency issues in PostgreSQL or MySQL.
