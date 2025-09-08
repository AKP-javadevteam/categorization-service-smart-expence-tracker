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
## 🏗 Architecture
The Categorization Service is part of the Smart Expense Data Pipeline:
flowchart :
A[Transactions Service] -->|GET /internal/transactions-by-user| B[Categorization Service]
B -->|Categorized Transactions| C[Budgets Service]
B -->|Categorized Transactions| D[Reports & Insights Service]

---
## 📦 Project Structure
src/main/java/com/smartexpense/categorization
├── CategorizationApplication.java   # Main Spring Boot entrypoint
├── config/                          # Security & Feign config
├── controller/                      # REST endpoints
├── domain/                          # Entities: Category, Subcategory, Rule
├── dto/                             # Data Transfer Objects
├── repository/                      # JPA repositories
├── service/                         # Business logic
│    ├── RuleService.java
│    ├── CategorizationService.java
│    └── TransactionsClient.java
└── util/                            # Utilities & helpers

---
## 🧩 Key Components
**Domain**
- Category — high-level spending group (e.g., Food, Housing).
- Subcategory — optional refinement (e.g., Groceries, Restaurants).
- Rule — user-defined categorization rule (priority, conditions, enabled flag).

**Service Layer**
- RuleService — manages rule creation and execution.
- CategorizationService — applies rules to transactions and assigns categories.
- TransactionsClient — Feign client to fetch user transactions from the Transactions Service.

**Controllers**
- HealthController — GET /internal/health for readiness checks.
- CategoryController — list available categories.
- RuleController — CRUD for user rules.
- CategorizationController — categorize transactions manually or via TransactionsClient.

---
## 🔐 Security
- JWT authentication enforced on all endpoints (validated via SecurityConfig).
- Tokens issued by the Auth Service.
- Only authenticated requests via API Gateway are allowed.

---
## 📬 API Endpoints
GET/internal/health - Health check
GET/ internal/categories - List all categories
POST/internal/rules - Create a rule
GET/internal/rules?userId={id} - List rules by user
POST/internal/categorize?userId={id} - Categorize provided transactions
POST/internal/categorize/user/{id} - Categorize via Transaction Service

---
## 🧪 Local Testing
**Start DB & Service**

docker compose -f docker-compose.dev.yml up -d
./mvnw spring-boot:run

- Service runs at http://localhost:8084/internal
- Swagger UI: http://localhost:8084/internal/swagger - pending

**Postman Collection**
- A ready to import Postman collection available at:
   postman/Categorization-Service.postman_collection.json
  Includes:
- Health Check
- List Categories
- Create Rule 
- List Rules by User
- Categorization requests

---
## 🐳 Deployment
**Docker**
docker build -t categorization-service:latest .
docker run -p 8084:8084 categorization-service:latest

---







