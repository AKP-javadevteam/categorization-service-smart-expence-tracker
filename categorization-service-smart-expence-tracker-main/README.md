# Categorization Service — Smart Expense Project

This is the **Categorization Service** for the Smart Expense project.  
It manages **transaction categories** and provides APIs for creating, updating, and retrieving categories.  
It also supports integration with **AI/ML models** to automatically classify transactions.

---

## 🚀 Tech Stack

- **Project**: Maven, Java 17
- **Spring Boot**: 3.5.4

### Dependencies
- **Spring Web** — REST controllers for managing categories.
- **Spring Security** — JWT-based resource server for authorization.
- **Spring Data JPA** — persistence layer for category entities.
- **PostgreSQL Driver** — relational database for storing categories.
- **Flyway** — database schema migrations.
- **Validation** — ensure input correctness (e.g., category name).
- **Spring Boot Actuator** — monitoring and health checks.

---

## 📂 Project Purpose
- Provide APIs for **category management** (CRUD).
- Support **transaction classification** with category references.
- Enable optional integration with **ML-based categorization models**.
- Secure endpoints with **JWT validation**.
- Manage schema changes with **Flyway**.
- Provide health and monitoring endpoints via **Actuator**.

---
