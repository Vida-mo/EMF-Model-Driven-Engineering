# Middleware & Cloud Architecture Portfolio

Dieses Repository ist ein kompaktes Showcase für moderne **Enterprise-Middleware- und Microservice-Architekturen** auf Basis von **Java 21** und **Spring Boot 3**. 

Es demonstriert praxisnah zentrale Entwurfsmuster für verteilte Systeme:

* **Event-Driven Microservices:** Asynchrone Geschäftslogik mit CQRS, Event Sourcing und Sagas (Axon Framework & Axon Server).
* **Cloud Security:** Absicherung mit OAuth2 / OpenID Connect, JWT und API-Gateway (CloudFoundry UAA).
* **Resilienz & Fehlertoleranz:** Schutz vor Kaskadenausfällen via Circuit Breaker, Rate Limiter und Bulkhead (Resilience4j).
* **Service Mesh & Routing:** Dynamische Service Discovery und intelligentes Routing (Netflix Eureka & Spring Cloud Gateway).
* **Clean Architecture:** Standardisierte REST-APIs mit Schichtenarchitektur (BCE) und Spring Data JPA.

---

### 📂 Projektstruktur

- [`bike-rental-axoniq-microservices/`](./bike-rental-axoniq-microservices/) — Event-Driven Architecture mit Axon Framework & CQRS
- [`2025-swt-spring-cloud-sec-02-oauth2-all-grant-types/`](./2025-swt-spring-cloud-sec-02-oauth2-all-grant-types/) — OAuth2 / OIDC Security mit UAA & Gateway
- [`2025-swt-resilience-demo/`](./2025-swt-resilience-demo/) — Resilience4j Patterns (Circuit Breaker, Bulkhead, Rate Limiter)
- [`2025-swt-spring-cloud-gw-registry/`](./2025-swt-spring-cloud-gw-registry/) — Spring Cloud Gateway & Eureka Service Discovery
- [`2024-swt-demo-person-spring/`](./2024-swt-demo-person-spring/) — REST API mit Schichtenarchitektur (BCE) & Spring Data JPA

---

**Tech-Stack:** Java 21, Spring Boot 3, Spring Cloud, Spring Security, Axon Framework, Docker & Docker Compose.
