## Overview
Spring Authentication API is a robust and secure authentication system built with Java and Spring Boot. It leverages JWT (JSON Web Tokens) for stateless authentication, allowing users to sign up, sign in, and logout efficiently. Additionally, it includes role-based access control, enabling administrators to manage and view user information seamlessly.

## Features
- User Registration: New users can create an account with a unique username and email.
- User Login: Authenticate users and provide JWT tokens for secure access.
- Role-Based Access Control: Assign roles like USER, MODERATOR, and ADMIN to manage permissions.
- Admin Dashboard: Admins can view all registered users and their roles.
- Secure Logout: Invalidate JWT tokens to ensure secure logout.
- JWT Token Management: Generate, validate, and blacklist JWT tokens for enhanced security.
- API Testing with Postman: Easily test API endpoints using Postman with provided configurations.


## Technologies Used
- Java 17
- Spring Boot
- Spring Security
- JWT (JSON Web Tokens)
- Hibernate & JPA
- MySQL
- Postman
- Maven

## Getting Started
### Prerequisites
- Before you begin, ensure you have met the following requirements:

- Java Development Kit (JDK) 17 or higher installed.
- Maven installed for dependency management.
- MySQL installed and running.
- Postman for API testing.
- Git installed for version control.

## Installation
### 1. Clone the Repository
- git clone https://github.com/your-username/spring_authentication.git
- cd spring_authentication

### 2. Configure the Database
Create a MySQL database named test (or any name you prefer).
Update the application.properties file with your MySQL credentials:
- spring.datasource.url=jdbc:mysql://localhost:3306/test?useSSL=false
- spring.datasource.username=your_mysql_username
- spring.datasource.password=your_mysql_password

### 3. Set JWT Properties
In application.properties, ensure you have a secure JWT secret and define the token
- kshitij.app.jwtSecret=your_secure_jwt_secret_key
- kshitij.app.jwtExpirationMs=86400000

### 4. Build the Project
- mvn clean install

### 5. Running the Application
##### Start the Spring Boot application using Maven:
- mvn spring-boot:run

## API Documentation
### Authentication Endpoints
#### Sign Up
- URL: /api/auth/signup
- Method: POST
- Description: Registers a new user with a username, email, and password. Optionally, roles can be assigned.
![User Signup Demo](path_or_url "Optional Title")
#### Responses:
- 200 OK: User registered successfully.
- 400 Bad Request: Username or email already exists.
---  
#### Sign In
- URL: /api/auth/signin
- Method: POST
- Description: Authenticates a user and returns a JWT token upon successful login.
![User Signup Demo](path_or_url "Optional Title")
#### Responses:
- 200 OK: Returns JWT token and user details.
- 401 Unauthorized: Invalid credentials.

#### Logout
- URL: /api/auth/logout
- Method: POST
- Description: Logs out the user by invalidating the JWT token.
#####  Headers:
- Authorization: Bearer <JWT_TOKEN>
![User Signup Demo](path_or_url "Optional Title")
#### Responses:
- 200 OK: User logged out successfully.
- 400 Bad Request: Invalid or missing token.
- 401 Unauthorized: Authentication required.

### Admin Endpoints
#### Get All Users
- URL: /api/auth/admin/users
- Method: GET
- Description: Retrieves information of all registered users. Accessible only by admins.
#### Headers:
- Authorization: Bearer <ADMIN_JWT_TOKEN>
![User Signup Demo](path_or_url "Optional Title")
#### Responses:
- 200 OK: Returns a list of users with their details and roles.
- 403 Forbidden: Access denied for non-admin users.
- 401 Unauthorized: Authentication required.





