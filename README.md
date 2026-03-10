ф# API Automation Demo Framework

Demo API test automation framework built with Java, REST Assured, TestNG, Maven, and Allure Reports.

This project demonstrates a clean and scalable API automation architecture with:
- reusable request specification
- client layer for endpoint interactions
- DTO-based request and response models
- positive and negative test coverage
- Allure reporting integration

## Tech Stack

- Java 17
- REST Assured
- TestNG
- Maven
- Jackson
- Allure Reports

## Project Structure

```text
src
 └── test
     ├── java
     │   ├── base
     │   │   └── BaseTest.java
     │   ├── client
     │   │   ├── ApiClient.java
     │   │   └── UserApiClient.java
     │   ├── models
     │   │   ├── request
     │   │   │   └── CreateUserRequest.java
     │   │   └── response
     │   │       ├── CreateUserResponse.java
     │   │       └── UserResponse.java
     │   ├── tests
     │   │   └── UserApiTest.java
     │   └── utils
     │       └── ConfigReader.java
     └── resources
         └── config.properties
```

## Test Scenarios

- GET /users → getUsersShouldReturnUserList
- POST /users → createUserShouldReturnCreatedUser
- GET /users/{id} → getNonExistingUserShouldReturn404

## How to Run

Run all tests:

mvn clean test

Generate Allure report:

allure serve target/allure-results

## Notes

Base URL is configured in config.properties

Request configuration is centralized in ApiClient

Request and response payloads are represented by DTO classes