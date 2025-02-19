# Petstore API Automation

## Project Overview
This project is an automation test suite built for the Petstore Swagger API using RestAssured, TestNG, and Java. It covers various API operations like creating, updating, retrieving, and deleting pets. The suite is designed to run in different environments, ensuring high flexibility and maintainability with a data-driven approach.

## Framework Highlights
- **RestAssured** is used for making HTTP requests to the Petstore API.
- **TestNG** is used for managing and running test cases with flexible configurations (XML-based).
- **Java Faker** library is used to generate dynamic test data.
- **Schema Validation** is implemented using JSON schema files.
- **Custom Listeners** are integrated for test reporting.
- The project structure is modular and scalable, with a clear separation between test data, test cases, and utilities.
- **GitHub Actions** integration for CI/CD pipeline automation.

## Project Structure
```bash
.
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── com.petstore.api
│   │   │   ├── utils
│   ├── test
│   │   ├── java
│   │   │   ├── com.petstore.api.tests
│   │   │   ├── com.petstore.api.listeners
│   └── resources
│       ├── testdata
│       │   ├── postPetTestData.json
│       ├── schemas
│       │   ├── postPetTestSchema.json
├── pom.xml
├── README.md
└── testng.xml
```
# Key Components
1. **Test Cases**: Located in `com.petstore.api.tests`, each test case corresponds to a specific API operation.
2. **Utilities**: Includes helper classes such as `TestDataManager` and `SchemaValidator` that load test data and validate responses.
3. **Listeners**: Custom listeners are located in the `com.petstore.api.listeners` package for enhanced reporting and logging.
4. **Test Data**: Static test data files are stored under `src/test/resources/testdata` and loaded dynamically during test execution.
5. **Schema Validation**: JSON schema files for response validation are stored in `src/test/resources/schemas`.

## Pre-requisites
- Java 8+
- Maven (for dependencies and building the project)
- TestNG (test framework)
- RestAssured (API testing)
- Gson (JSON serialization/deserialization)

## How to Run Locally
1. **Clone the Repository**:
    ```bash
    git clone <repository-url>
    cd petstore-api-automation
    ```
2. **Install Dependencies**:
   Ensure all dependencies are installed by running:
    ```bash
    mvn clean install
    ```
3. **Run Tests with Maven**:
   You can execute the tests using the Maven command:
    ```bash
    mvn test
    ```
4. **Run Tests with TestNG XML**:
   You can also run the tests using the `testng.xml` configuration:
    ```bash
    mvn test -DsuiteXmlFile=testng.xml
    ```
   The `testng.xml` file allows you to run specific test cases or groups.

## How to Run Specific Tests
1. **Run a Specific Test Class**:
   You can run a specific test by specifying the class name:
    ```bash
    mvn -Dtest=PostCreateNewPetTest test
    ```
2. **Run Tests with TestNG Groups**:
   If you want to run tests based on groups defined in the `testng.xml`, you can use:
    ```bash
    mvn test -Dgroups="smoke"
    ```

## Commands Summary
- **Install Dependencies**: `mvn clean install`
- **Run All Tests**: `mvn test`
- **Run Specific Test Class**: `mvn -Dtest=TestClassName test`
- **Run with TestNG XML**: `mvn test -DsuiteXmlFile=testng.xml`
- **Run TestNG Groups**: `mvn test -Dgroups="groupName"`

## Framework Highlights
- **Data-Driven Testing**: Test data is managed through external JSON files, allowing flexibility and easy updates.
- **Schema Validation**: Ensures the API responses conform to predefined JSON schemas.
- **Dynamic Test Data**: The use of Java Faker ensures dynamic and realistic test data, reducing dependency on static data.
- **Custom Listeners**: Integrated with TestNG for enhanced test reporting and logging.
- **CI/CD Integration**: Configured to run in CI/CD pipelines with GitHub Actions or Jenkins.

