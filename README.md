# 🆔 Aadhaar User Backend Service

A backend service built to securely store, retrieve, and manage Aadhaar applicant details. This project implements creation, retrieval, and paginated listing of user profiles using Java Spring Boot and PostgreSQL.

---

## 📌 1. Overview

The Aadhaar registration system requires a robust backend capable of handling:

- Storing applicant information in a structured format
- Fast retrieval of user records
- Pagination and sorting for large datasets
- Input validation and unique constraints
- Secure and scalable data storage

This backend service fulfills all these requirements.

---

## 🚀 2. Features Implemented

✔ **Create a new user (POST)**  
Creates a new applicant profile with validation and unique email check.

✔ **Get user by ID (GET)**  
Fetches a single user record by its unique identifier.

✔ **List users with Pagination + Sorting (GET)**  
Supports:
- `LIMIT`
- `OFFSET`
- `ORDER BY`

via Spring Data JPA.

✔ **Validation**  
Input validation using:
- `@NotBlank`
- `@Email`

✔ **Uniqueness**  
Email is unique in both:
- Code-level (`existsByEmail`)
- Database-level (`unique` constraint in entity)

✔ **PostgreSQL Database**  
Used for reliable, scalable, persistent storage.

✔ **SQL Injection Protection**  
JPA uses prepared statements internally → 100% safe.

---

## 📁 3. Project Structure

```
src/main/java/com/example/aaadharapp/
 ├── controller/          → REST controllers (API endpoints)
 ├── service/             → Business logic layer
 ├── repository/          → Database access layer (JPA)
 ├── model/               → Entity classes (User)
 ├── dto/                 → Request DTOs (validation)
 └── AaadharappApplication.java → Main Spring Boot application
```

This is a clean 3-layer architecture: **Controller → Service → Repository**

---

## 🛠️ 4. Technologies Used

- Java 17
- Spring Boot 3
- Spring Web
- Spring Data JPA
- Hibernate
- PostgreSQL
- Lombok
- Jakarta Validation

---

## 🗄️ 5. Database Setup (PostgreSQL)

### 1️⃣ Create a PostgreSQL database:

```sql
CREATE DATABASE aadhaar_db;
```

### 2️⃣ Update `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/aadhaar_db
spring.datasource.username=postgres
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

Replace `YOUR_PASSWORD` with your actual password.

---

## ▶️ 6. Running the Application

### Option A — Using Maven (Recommended)

Run in VS Code terminal:

```bash
mvn spring-boot:run -DskipTests
```

### Option B — Using Spring Boot Dashboard

In VS Code:
1. Open Spring Boot Dashboard
2. Click ▶️ next to `aaadharapp`

App runs on:

```
http://localhost:8080
```

(or port 9090 if you changed it)

---

## 🔗 7. API Endpoints

### 1️⃣ Create User

**POST** `/api/users`

**Request body:**

```json
{
  "fullName": "John Doe",
  "email": "john@example.com",
  "phone": "9876543210",
  "address": "Bangalore"
}
```

---

### 2️⃣ Get User by ID

**GET** `/api/users/{id}`

**Example:**

```
GET /api/users/1
```

---

### 3️⃣ List Users (Pagination + Sorting)

**GET** `/api/users`

**Query parameters:**

| Param     | Default | Description        |
|-----------|---------|-------------------|
| page      | 0       | page number       |
| size      | 10      | results per page  |
| sortBy    | id      | sorting field     |
| direction | asc     | asc/desc          |

**Example:**

```
GET http://localhost:8080/api/users?page=0&size=5&sortBy=email&direction=asc
```

---

## 📝 8. Database ER Diagram

The system currently contains a single entity representing Aadhaar applicant details.

### ER Diagram

```
+-----------------------------+
|           USERS             |
+-----------------------------+
| id (PK)                     |
| full_name                   |
| email (UNIQUE)              |
| phone                       |
| address                     |
| created_at (optional)       |
+-----------------------------+
```

### Field Explanation

- **id** → Auto-increment primary key
- **full_name** → Applicant's name
- **email** → Unique identifier to avoid duplicate users
- **phone** → Contact number
- **address** → Residential address
- **created_at** → Timestamp of record creation (optional if using Flyway or triggers)

This ERD reflects the current scope of the assignment and can easily be extended with more tables (e.g., documents, verification status, Aadhaar request stage) in future phases.

### SQL Schema (Used by JPA)

```sql
CREATE TABLE users (
   id SERIAL PRIMARY KEY,
   full_name VARCHAR(100) NOT NULL,
   email VARCHAR(100) UNIQUE NOT NULL,
   phone VARCHAR(20),
   address TEXT,
   created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

---

## 🔒 9. Security & Data Integrity

✔ Unique email enforced  
✔ Input validated before saving  
✔ SQL injection protected (JPA prepared statements)  
✔ Pagination prevents large dataset load  
✔ PostgreSQL ensures ACID compliance

---

## 📘 10. Future Enhancements

This backend is designed to be extended with:

- Filtering (city, name, mobile)
- Aadhaar verification service integration
- Authentication & authorization (JWT)
- Swagger API documentation
- Docker deployment

---

## 👨‍💻 11. Author

**Nithesh Ramesh**

---

## 📄 License

This project is open source and available under the [MIT License](LICENSE).

---

## 🤝 Contributing

Contributions, issues, and feature requests are welcome!

---

## ⭐ Show your support

Give a ⭐️ if this project helped you!