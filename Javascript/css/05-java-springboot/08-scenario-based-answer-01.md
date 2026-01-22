## 1. Java – Practical / Situation-Based Questions

### Q1. *Your service is slow under high load. How did you identify and fix the performance issue?*

**What they expect**

* Profiling
* Memory/thread analysis
* Code-level optimization

**Strong Answer**

> We used **JProfiler / VisualVM** to identify high CPU usage and thread contention. Found excessive object creation inside loops and synchronized blocks causing thread blocking. Replaced it with immutable objects, caching, and reduced synchronization.

**Practical Example**

```java
// Bad
public synchronized String process() {
    return expensiveCall();
}

// Improved
public String process() {
    return cache.computeIfAbsent(key, k -> expensiveCall());
}
```

Mention:

* GC tuning (`-Xms`, `-Xmx`)
* ExecutorService instead of manual threads
* Streams vs loops (when appropriate)

---

### Q2. *How did you handle concurrency issues in a real project?*

**Expected**

* Thread safety
* Locks, concurrent collections

**Answer**

> We faced race conditions during parallel payment processing. Solved using `ConcurrentHashMap` and `AtomicInteger` instead of synchronized blocks.

```java
AtomicInteger counter = new AtomicInteger(0);
counter.incrementAndGet();
```

---

## 2. Spring Boot – Real Project Scenarios

### Q3. *How did you handle global exception handling in your application?*

**Expected**

* Clean API responses
* Centralized handling

```java
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleNotFound(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(ex.getMessage()));
    }
}
```

Mention:

* Custom exceptions
* Error response standardization

---

### Q4. *How did you secure your APIs?*

**Expected**

* JWT, OAuth2, role-based access

```java
http
  .csrf().disable()
  .authorizeHttpRequests()
  .requestMatchers("/admin/**").hasRole("ADMIN")
  .anyRequest().authenticated()
  .and()
  .oauth2ResourceServer().jwt();
```

Real-world mention:

* Token expiry handling
* Refresh tokens
* API Gateway security

---

## 3. Microservices – Scenario-Based Questions (VERY IMPORTANT)

### Q5. *One microservice is down. How did you prevent system failure?*

**Expected**

* Resilience patterns

**Answer**

> We used **Resilience4j** with circuit breakers and fallback methods.

```java
@CircuitBreaker(name = "orderService", fallbackMethod = "fallback")
public Order getOrder(String id) {
    return restTemplate.getForObject(url, Order.class);
}

public Order fallback(String id, Exception ex) {
    return new Order("DEFAULT");
}
```

Mention:

* Timeout
* Retry
* Bulkhead

---

### Q6. *How did microservices communicate with each other?*

**Expected**

* REST + Async messaging

**Strong Answer**

> For synchronous calls, we used REST with Feign Client. For async events, we used Kafka / Pub-Sub.

```java
@FeignClient(name = "payment-service")
public interface PaymentClient {
    @GetMapping("/payment/{id}")
    Payment getPayment(@PathVariable String id);
}
```

---

### Q7. *How did you handle distributed transactions?*

**Expected**

* No XA transactions
* Saga pattern

**Answer**

> We implemented **Saga pattern** using event-based compensation instead of DB rollback.

Example:

* Order Created → Payment Failed → Order Cancelled event

---

## 4. Cloud (AWS / GCP) – Practical Questions

### Q8. *How did you deploy your Spring Boot application to cloud?*

**AWS Example**

* EC2 / ECS / EKS
* Load balancer
* Auto-scaling

**Answer**

> We containerized the app using Docker and deployed it to **ECS with ALB**.

```dockerfile
FROM openjdk:17
COPY target/app.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
```

Mention:

* Health checks
* Rolling deployments

---

### Q9. *How did you manage configuration in cloud environments?*

**Expected**

* Externalized config

**AWS**

* SSM Parameter Store / Secrets Manager
  **GCP**
* Secret Manager

```yaml
spring:
  datasource:
    password: ${DB_PASSWORD}
```

---

### Q10. *How did you monitor and troubleshoot production issues?*

**Expected**

* Logs + metrics + alerts

**Answer**

> We used **CloudWatch / GCP Monitoring**, centralized logs with **ELK**, and set alerts on latency and error rate.

Mention:

* Correlation IDs
* Distributed tracing (Zipkin, OpenTelemetry)

---

## 5. Final Interview Tip (VERY IMPORTANT)

When answering:
✅ Always say **what problem you faced**
✅ **What tools you used**
✅ **What code/config you changed**
✅ **What was the result**

Bad answer ❌

> “Spring Boot supports circuit breakers.”

Good answer ✅

> “We faced service timeouts in production. Implemented Resilience4j circuit breaker with fallback, reducing failures by 60%.”

