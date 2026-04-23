<div align="center">

<img src="https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java 17"/>
<img src="https://img.shields.io/badge/Spring_Boot-3.5.6-brightgreen?style=for-the-badge&logo=springboot&logoColor=white" alt="Spring Boot"/>
<img src="https://img.shields.io/badge/MySQL-8.0-blue?style=for-the-badge&logo=mysql&logoColor=white" alt="MySQL"/>
<img src="https://img.shields.io/badge/Maven-Build-red?style=for-the-badge&logo=apachemaven&logoColor=white" alt="Maven"/>
<img src="https://img.shields.io/badge/License-Student_Project-lightgrey?style=for-the-badge" alt="License"/>

<br/><br/>

# 🚌 Bus Booking & Schedule Management System

**A full-stack Spring Boot application for managing bus routes, schedules, bookings, and travelers — built for both admins and passengers.**

<br/>

</div>

---

## ✨ Features

| Module | Description |
|---|---|
| 🚍 **Bus Management** | Add, update, and track bus fleet details |
| 🗺️ **Route & Schedule** | Configure routes, stops, and departure times |
| 🎫 **Booking Management** | Traveler and admin booking workflows |
| 💳 **Payment Processing** | Integrated payment handling with booking |
| 👤 **User Profiles** | Registration, login, and profile management |
| 💬 **Feedback System** | Collect and review traveler feedback |
| 🧭 **Guide Scheduling** | Assign guides and manage vehicle allocations |

---

## 🏗️ Technology Stack

<div align="center">

| Layer | Technology |
|---|---|
| **Language** | Java 17 |
| **Framework** | Spring Boot 3.5.6 |
| **Web Layer** | Spring MVC |
| **Persistence** | Spring Data JPA |
| **Database** | MySQL |
| **View Engine** | JSP / JSTL |
| **Server** | Apache Tomcat (embedded) |

</div>

---

## 📁 Repository Layout

```
Bus Booking and Schedule Management System/
├── pom.xml                          # Maven project definition
└── src/
    ├── main/
    │   ├── java/com/example/tripsystem/   # Controllers & application source
    │   ├── resources/                     # application.properties & config
    │   └── webapp/
    │       ├── WEB-INF/views/             # JSP pages
    │       └── js/                        # Frontend JavaScript
    └── test/java/                         # Unit tests
```

---

## ⚙️ Prerequisites

Before running the project, ensure you have the following installed:

- ✅ **Java 17 SDK**
- ✅ **Apache Maven**
- ✅ **MySQL Server**

---

## 🔧 Configuration

The app is configured via `src/main/resources/application.properties`.

<details>
<summary><b>📄 Default Database & Server Settings (click to expand)</b></summary>

<br/>

```properties
# Database
spring.datasource.url=jdbc:mysql://localhost:3306/busdb_all?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=your_password_here

# Server
server.port=8081

# JPA
spring.jpa.hibernate.ddl-auto=update
```

> ⚠️ **Important:** Update the username and password values before running in your local environment.

</details>

---

## 🚀 Getting Started

**1.** Open a terminal inside the project folder:
```bash
cd "Bus Booking and Schedule Management System"
```

**2.** Build the project:
```bash
mvn clean package
```

**3.** Run the application:
```bash
mvn spring-boot:run
```

**4.** Open your browser and navigate to:
```
http://localhost:8081
```

---

## 🛠️ Troubleshooting

<details>
<summary><b>❌ MySQL not available or connection refused</b></summary>

Create the database manually or update the JDBC URL in `application.properties`. Ensure MySQL service is running:
```bash
# Linux/macOS
sudo service mysql start

# Windows
net start MySQL
```
</details>

<details>
<summary><b>❌ Authentication failed for database</b></summary>

Double-check the `spring.datasource.username` and `spring.datasource.password` values in `application.properties` match your local MySQL credentials.
</details>

<details>
<summary><b>❌ Wrong Java version</b></summary>

Confirm Java 17 is active:
```bash
java -version
```
The output should show `openjdk 17` or `java version "17"`.
</details>

---

## 📝 Notes

- The application uses JSP views configured with Spring MVC `view.prefix` / `view.suffix` properties.
- The database schema is managed automatically via `spring.jpa.hibernate.ddl-auto=update` — no manual migration needed.

---

<div align="center">

**📚 Student Software Engineering Project**

*Built with ❤️ using Spring Boot & Java*

</div>
