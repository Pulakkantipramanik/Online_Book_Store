# Bookstore App (Spring Boot + Thymeleaf) - Runnable JAR

## Overview
Simple online Book Store with a Thymeleaf UI. Features:
- Add / Edit / Delete / List books
- Uses MySQL database `bookstore_db`

## Prerequisites
- Java 17+
- Maven
- MySQL server running
  - Create database: `CREATE DATABASE bookstore_db;`
  - Username: `root`
  - Password: `admin`

## Build & Run
1. Create database in MySQL:
```sql
CREATE DATABASE bookstore_db;
```

2. From project root build JAR:
```bash
mvn clean package
```

3. Run JAR:
```bash
java -jar target/bookstore-0.0.1-SNAPSHOT.jar
```

Or run with Maven directly:
```bash
mvn spring-boot:run
```

4. Open browser: http://localhost:8080/

## Notes
- The project uses `spring.jpa.hibernate.ddl-auto=update` to create/update schema.
- Sample data is inserted from `src/main/resources/data.sql`.
