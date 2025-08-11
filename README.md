# 🚀 Spring Boot REST API — Third Party API + Local Data Integration

![Java](https://img.shields.io/badge/Java-17-orange?style=for-the-badge)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?style=for-the-badge)
![REST API](https://img.shields.io/badge/REST-API-blue?style=for-the-badge)
![Maven](https://img.shields.io/badge/Maven-Build-red?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-Active-success?style=for-the-badge)

---

## 📌 Overview
This project is a **Spring Boot REST API** that **integrates with a third-party API** and **enriches it with local database data**.  
It demonstrates **real-world backend engineering skills** — fetching remote API data, combining it with your own DB fields, and serving it in a clean JSON response.

**Live Example Response:**
```json
{
    "data": {
        "nationalId": 111111111,
        "name": "ABC",
        "post": {
            "userId": 1,
            "id": 4,
            "title": "eum et est occaecati",
            "body": "ullam et saepe reiciendis voluptatem adipisci\nsit amet autem assumenda provident rerum culpa\nquis hic commodi nesciunt rem tenetur doloremque ipsam iure\nquis sunt voluptatem rerum illo velit"
        },
        "contactNumber": "1234567890",
        "email": "abc_def@gmail.com"
    },
    "statusMessage": "Success",
    "statusCode": 200
}
```
---
## ✨ Key Features
🔗 Third-Party API Consumption – Fetches post details from ``` http://localhost:8080/api/1077147443```

🗄 Local DB Merge – Combines API data with local entity data like nationalId, name, contactNumber, email

⚡ Fast & Lightweight – Minimal response time with Spring Boot REST

🛡 Clean JSON Response – Proper status message and code

📂 Layered Architecture – Follows Controller → Service → Repository pattern

## 🏗 Tech Stack
Java 17

Spring Boot 3.x

Spring Web

Spring Data JPA

MySQL / Any Relational DB

Maven

JSON Placeholder API (Mock REST API)

---
## 📂 Project Structure
```
src/
 ├── main/
 │   ├── java/com/thirdpartyapiintegration/
 │   │    ├── controller/       # REST Endpoints
 │   │    ├── postservice/      # Business Logic
 │   │    ├── repository/       # Data Access Layer
 │   │    └── model/            # Entities
 │   └── resources/
 │        ├── application.properties
 │        └── static/           # (Optional)
 └── test/                      # Unit Tests
```
---
## 🚦 API Endpoints
### 1️⃣ Fetch All Posts
GET /posts
Returns: All posts from the remote API (optionally merged with DB).


### 2️⃣ Fetch User Details with Post by National ID
GET /api/{nationalId}
Example Request:

```
GET http://localhost:8080/api/111111111
Example Response:

{
    "data": {
        "nationalId": 111111111,
        "name": "ABC",
        "post": {
            "userId": 1,
            "id": 4,
            "title": "eum et est occaecati",
            "body": "ullam et saepe reiciendis voluptatem adipisci..."
        },
        "contactNumber": "1234567890",
        "email": "abc_def@gmail.com"
    },
    "statusMessage": "Success",
    "statusCode": 200
}
```
---
## 🔧 Installation & Setup

### 1. Clone the Repo
```
git clone https://github.com/shrutinarad16/SpringBootRestAPI.git
cd third-party-api-integration
```

### 2. Configure Database
src/main/resources/application.properties:
```
spring.datasource.url=jdbc:mysql://localhost:3306/thirdpartyapi
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

```
---

### 3. Run the Application
mvn spring-boot:run
🎯 Use Cases
API + DB integration demonstration for portfolios

Microservice that enriches remote data with local storage

Backend learning project for Spring Boot REST APIs

Precursor for enterprise API gateway systems

---

## 📸 Social Preview Suggestion
<img>

## 🏆 Why This Project is Impressive

Shows API consumption and data enrichment skills

Demonstrates clean JSON response handling

Displays layered architecture understanding

Includes real API integration experience

## 📜 License
MIT License — free to use for personal and commercial projects.
