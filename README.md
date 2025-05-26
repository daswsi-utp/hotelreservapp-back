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

## 🖼️ Captures of command executions and test executions

### 1. 🔃 Running Redis with Docker and Running the Backend
![image](https://github.com/user-attachments/assets/1fecde00-6445-4f43-a8e8-b52269341b30)

### 2. 🔃 Running the Frontend

![{E9C2C426-D130-4366-87A4-C1BF1B80F67A}](https://github.com/user-attachments/assets/6382b91c-0d18-4b59-8014-0a96832830c1)

### 3. 🔃 Postman for testing

![{CA61073D-DCCB-4960-BA3B-6240510B513E}](https://github.com/user-attachments/assets/a16753f6-de6f-4087-939a-f2b2f1194182)
