# Spring Boot Bookstore API

A simple RESTful API for a bookstore application built with Spring Boot. It provides complete CRUD (Create, Read, Update, Delete) functionality for managing books. The application is architected to seamlessly connect with either **Microsoft SQL Server** or **PostgreSQL** as the backend database.

## Features

- RESTful endpoints for book and employee management.
- Standard CRUD operations (Create, Read, Update, Delete).
- Powered by Spring Boot, Spring Data JPA, and Hibernate.
- Dual database support: Microsoft SQL Server and PostgreSQL.
- Uses Spring Profiles for easy database configuration switching.

## Technologies Used

- **Java 17+**
- **Spring Boot 3.x**
- **Spring Data JPA**
- **Hibernate**
- **Maven** (for dependency management)
- **Microsoft SQL Server** (with `mssql-jdbc` driver)
- **PostgreSQL** (with `postgresql` driver)

## Prerequisites

Before you begin, ensure you have the following installed:

- JDK 17 or later
- Apache Maven
- Git
- A running instance of Microsoft SQL Server or PostgreSQL

## Getting Started

Follow these instructions to get the project up and running on your local machine.

### 1. Clone the Repository

```bash
git clone https://github.com/sendjainabhi/bookstore.git
cd bookstore
```

### 2. Configure the Database

This application uses Spring Profiles to manage database-specific configurations. You will need to provide your database credentials in the appropriate properties file located in `src/main/resources/`.

You can create two separate files for each database profile.



**File: `src/main/resources/application.properties`**
```properties
# PostgreSQL Configuration
spring.datasource.url=jdbc:postgresql://localhost:5432/<db name>?sslmode=require
spring.datasource.username=your_postgres_user
spring.datasource.password=your_postgres_password
spring.datasource.driver-class-name=org.postgresql.Driver

# Hibernate settings
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

# MS SQL Server Configuration
spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=BookstoreDB;encrypt=true;trustServerCertificate=true;
spring.datasource.username=your_mssql_user
spring.datasource.password=your_mssql_password
spring.datasource.driver-class-name=com.microsoft.sqlserver.jdbc.SQLServerDriver

# Hibernate settings
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.SQLServerDialect
spring.jpa.hibernate.ddl-auto=update
```
> **Note:** The `encrypt=true;trustServerCertificate=true;` parameters in the MSSQL URL are often required to prevent SSL-related connection errors with modern JDBC drivers.

### 3. Build the Application

Open your terminal, navigate to the project's root directory, and run the following Maven command to build the project and download dependencies.

```bash
mvn clean install
```

### 4. Run the Application

You must activate the desired database profile (`pg` or `mssql`) when running the application.

```
mvn spring-boot:run 
```

The application will start on `http://localhost:8080`.

## API Endpoints

The base path for all API endpoints is `/` 

**Book Service API Endpoints**

| Method   | Endpoint          | Description                        |
| :------- | :---------------- | :--------------------------------- |
| `GET`    | `/books`          | Retrieves a list of all books.     |
| `GET`    | `/books/{id}`     | Retrieves a single book by its ID. |
| `POST`   | `/books/new`      | Creates a new book.                |
| `PUT`    | `/books/{id}`     | Updates an existing book by its ID.|
| `DELETE` | `/books/{id}`     | Deletes a book by its ID.          |


### Example Payloads

**Book JSON Object:** Primary key id will be generated from DB sequence , not require to pass from client.
```json
{
  "name": "Book",
  "author": "author"
}

```

**Employee Service API Endpoints**

| Method   | Endpoint          | Description                        |
| :------- | :---------------- | :--------------------------------- |
| `GET`    | `/employee`          | Retrieves a list of all employees.     |
| `GET`    | `/employee/{id}`     | Retrieves a single employee by its ID. |
| `POST`   | `/employee/add`      | Creates a new employee.                |
| `PUT`    | `/employee/{id}`     | Updates an existing employee by its ID.|
| `DELETE` | `/employee/{id}`     | Deletes a employee by its ID.          |


### Example Payloads

**Book JSON Object:** Primary key id will be generated from DB sequence , not require to pass from client.
```json
{
  "name": "Test",
  "role": "Developer"
}

```

## Usage Examples 

Please use the Spring Swagger UI to test all the API endpoints.

```
http://localhost:8080/swagger-ui/index.html#

```


## Contributing

Contributions are welcome! Please feel free to submit a pull request.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request



