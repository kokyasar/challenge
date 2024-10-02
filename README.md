## Pinsoft Rest API


• Build a RESTfull service containing two operations explained below.

• Request/Response models can be designed however you want.

• No validation is expected for inputs assuming that always valid inputs are provided.

• All cases should have unit tests.

• Follow SOLID principles and write clean code.

• Please provide your own implementation.

#### Setup
- The application is running on port 8592 
- For running unit test, `mvn test`

#### Technical Details

- SpringBoot is used as application framework
- JDK17 used for programming language
- Project architecture is DDD (Domain-Driven Design) Hexagonal Clean Architecture
- JUnit5 used for unit tests

#### REST API Details


```sh 
POST /api/v1/pinsoft/show-hints          # Minesweeper Game Service
POST /api/v1/pinsoft/calculate           # RPN Calculator Service
```

#### REST API Documentation

Added Swagger for Rest API documentation.

http://localhost:8592/api/v1/swagger-ui.html