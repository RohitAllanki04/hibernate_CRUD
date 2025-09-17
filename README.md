# Hibernate CRUD Example

## Overview
A simple Java project demonstrating **Create, Read, Update, Delete (CRUD)** operations using **Hibernate ORM 6.x** with **PostgreSQL**.

---

## Features
* Create new records with `session.persist()`
* Read existing records with `session.find()`
* Update entities using `session.merge()`
* Delete entities using `session.remove()`

---

## Project Structure
> hibernate-crud-example/  
> ├── src/  
> │   └── main/  
> │       ├── java/  
> │       │   └── com/  
> │       │       └── springdemo/  
> │       │           └── helloworld/  
> │       │               ├── Main.java      # Entry point with CRUD logic  
> │       │               └── Alien.java     # JPA entity  
> │       └── resources/  
> │           └── hibernate.cfg.xml          # Hibernate configuration  
> ├── pom.xml                                # Maven dependencies  
> └── README.md                              # Project documentation  

---

## Prerequisites
* **Java 17+** (or compatible JDK)  
* **Maven 3+**  
* **PostgreSQL** installed and running

---

## Setup Instructions
1. **Create a PostgreSQL database and user**
    ```bash
    psql -U postgres -c "CREATE DATABASE hibernate_demo;"
    psql -U postgres -c "CREATE USER postgres WITH PASSWORD 'your_password';"
    psql -U postgres -c "GRANT ALL PRIVILEGES ON DATABASE hibernate_demo TO postgres;"
    ```

2. **Update credentials in `src/main/resources/hibernate.cfg.xml`**
    ```xml
    <property name="hibernate.connection.url">jdbc:postgresql://localhost:5432/hibernate_demo</property>
    <property name="hibernate.connection.username">postgres</property>
    <property name="hibernate.connection.password">your_password</property>
    ```

3. **Dependencies (pom.xml)**
    ```xml
    <dependencies>
        <dependency>
            <groupId>org.hibernate.orm</groupId>
            <artifactId>hibernate-core</artifactId>
            <version>6.6.2.Final</version>
        </dependency>
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <version>42.7.3</version>
        </dependency>
    </dependencies>
    ```

4. **Build & Run**
    ```bash
    mvn clean compile
    mvn exec:java -Dexec.mainClass="com.springdemo.helloworld.Main"
    ```

---

## CRUD Quick Reference

| Action  | Hibernate Code                  |
|-------- |---------------------------------|
| Create  | `session.persist(entity)`       |
| Read    | `session.find(Alien.class, id)` |
| Update  | `session.merge(entity)`         |
| Delete  | `session.remove(entity)`        |
