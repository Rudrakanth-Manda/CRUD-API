# Book Management System – Spring Boot CRUD API

## Project Description
A RESTful web application built using Java and Spring Boot to manage book records. It supports creating, retrieving, updating, and deleting books using REST APIs.

## Features
- Add a new book.
- Retrieve all books.
- Retrieve a book by ID.
- Update book details (title and author).
- Delete a book by ID.
- Handle HTTP responses and status codes.

## Technologies Used
- **Java** – Programming language.
- **Spring Boot** – Backend application development.
- **Spring Web** – REST API development.
- **Spring Data JPA** – Database operations.
- **Hibernate** – ORM implementation, if configured.
- **MySQL / Other Relational Database** – Data storage, depending on configuration.
- **Postman** – API testing.
- **Maven** – Build and dependency management, if used.

## API Endpoints

| HTTP Method | Endpoint | Function |
|---|---|---|
| GET | `/getAllBooks` | Get all books |
| GET | `/getBookById/{id}` | Get a book by ID |
| POST | `/addBook` | Add a book |
| PUT | `/updateBookById/{id}` | Update a book |
| DELETE | `/deleteBookById/{id}` | Delete a book |

## How to Run
1. Clone the repository.
2. Open the project in IntelliJ IDEA.
3. Configure the database in `application.properties`.
4. Run the Spring Boot main application class.
5. Test the endpoints using Postman.

## Learning Outcomes
- REST API development.
- CRUD operations.
- Database integration using Spring Data JPA.
- HTTP status handling.
- Spring Boot annotations and dependency injection.
