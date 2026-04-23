# Bus Booking and Schedule Management System

A Spring Boot-based bus booking and schedule management application with JSP front-end views. This project supports admin and traveler workflows for managing buses, schedules, bookings, payments, feedback, and user profiles.

## Key Features

- Bus management
- Route and schedule management
- Booking management for travelers and administrators
- Payment processing with booking integration
- User management and profile support
- Feedback management
- Guide schedule management and vehicle assignments

## Technology Stack

- Java 17
- Spring Boot 3.5.6
- Spring MVC
- Spring Data JPA
- MySQL
- JSP / JSTL
- Apache Tomcat embedded via Spring Boot

## Repository Layout

- `Bus Booking and Schedule Management System/`
  - `pom.xml` - Maven project definition
  - `src/main/java/com/example/tripsystem/` - application source code and controllers
  - `src/main/resources/` - configuration files
  - `src/main/webapp/WEB-INF/views/` - JSP pages
  - `src/main/webapp/js/` - frontend JavaScript
  - `src/test/java/` - unit tests

## Prerequisites

- Java 17 SDK
- Maven
- MySQL server

## Configuration

The application uses `src/main/resources/application.properties`.

Default database settings:

- URL: `jdbc:mysql://localhost:3306/busdb_all?createDatabaseIfNotExist=true`
- Username: `root`
- Password: `Sethum@164_2004`
- Server port: `8081`

> Update these values before running the application in your local environment.

## Running the Application

1. Open a terminal in the `Bus Booking and Schedule Management System` folder.
2. Build the project:

```bash
mvn clean package
```

3. Run the application:

```bash
mvn spring-boot:run
```

4. Open your browser at:

```text
http://localhost:8081
```

## Notes

- The application uses JSP views and the Spring MVC `view.prefix`/`view.suffix` configuration.
- The database schema is updated automatically using `spring.jpa.hibernate.ddl-auto=update`.

## Troubleshooting

- If MySQL is not available, create the database manually or update the JDBC URL.
- Check `application.properties` for the correct username/password.
- Confirm Java 17 is active in your environment by running `java -version`.

## License

This repository is a student software engineering project.

