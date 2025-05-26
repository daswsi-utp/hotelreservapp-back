# 🏨 Hotel Booking System - Full Stack App

This project is a web application for hotel reservation management. It is built with a modern layered architecture, using **Spring Boot** for the backend and **React** for the frontend.
In this part of the project the focus is on the messaging module.
---

## 🚀 Technologies used

### Backend (Java + Spring Boot)
- ✅ Spring Boot 3.4.5
- 🔐 Spring Security
- 📬 JavaMailSender
- 🧠 Spring Data JPA + Hibernate
- 🗄️ MySQL
- ⚡ Redis (for message cache)
- 📡 API REST (with DTOs)

### Frontend (JavaScript + React)
- ⚛️ React (Vite)
- 🌐 Axios para llamadas HTTP
- 🔐 Context API for authentication

### DevOps / Tools
- 🐳 Docker (for Redis)
- 📦 Maven
- 🧪 Postman for testing

## ▶️ Execution Commands

### 1. 🔃 Running Redis with Docker

Make sure you have Docker installed. Then run:

`docker run -p 6379:6379 redis`

### 2. 🔃 Running the Backend

`./mvnw spring-boot:run`

### 3. 🔃 Running the Frontend

`npm install`
`npm run dev`
