<div align="center">

# 🚀 Petstore API Automation Framework

[![Build Status](https://img.shields.io/badge/build-passing-brightgreen.svg)](https://github.com/yourusername/petstore-api-automation)
[![TestNG](https://img.shields.io/badge/TestNG-7.4.0-orange.svg)](https://testng.org/)
[![Rest Assured](https://img.shields.io/badge/RestAssured-5.1.1-blue.svg)](https://rest-assured.io/)
[![Java](https://img.shields.io/badge/Java-11-red.svg)](https://www.oracle.com/java/)
[![License](https://img.shields.io/badge/License-MIT-green.svg)](LICENSE)

</div>

<p align="center">
A comprehensive API testing framework for the Petstore Swagger API built with RestAssured, TestNG, and Java.
</p>

---

## 📋 Table of Contents

- [Overview](#-overview)
- [Key Features](#-key-features)
- [Tech Stack](#-tech-stack)
- [Project Structure](#-project-structure)
- [Key Components](#-key-components)
- [Prerequisites](#-prerequisites)
- [Getting Started](#-getting-started)
- [Running Tests](#-running-tests)
- [Framework Highlights](#-framework-highlights)

---

## 🔍 Overview

This project provides a robust automation test suite for the Petstore Swagger API. It covers various API operations including creation, update, retrieval, and deletion of pets. Designed to run across different environments, the framework ensures high flexibility and maintainability through a data-driven approach.

## ✨ Key Features

- 🔄 **End-to-End API Testing** - Complete coverage of CRUD operations
- 📊 **Data-Driven Design** - External test data management
- 🧪 **Schema Validation** - Ensures API response structure integrity
- 📈 **Custom Reporting** - Enhanced test execution insights
- ⚙️ **CI/CD Integration** - Seamless pipeline integration
- 🧩 **Modular Architecture** - Clear separation of concerns
- 🔄 **Dynamic Test Data** - Realistic test scenarios with Java Faker

## 🛠 Tech Stack

<div align="center">

| ☕ Java | 🧪 TestNG | 🔄 RestAssured | 📦 Maven | 🔄 GitHub Actions |
|:------:|:--------:|:-------------:|:-------:|:-----------------:|
| Core Language | Test Framework | API Testing | Build Tool | CI/CD Pipeline |

</div>

## 📁 Project Structure

```
petstore-api-automation/
├── 📂 src/
│   ├── 📂 main/
│   │   ├── 📂 java/
│   │   │   ├── 📂 com.petstore.api/
│   │   │   ├── 📂 utils/
│   ├── 📂 test/
│   │   ├── 📂 java/
│   │   │   ├── 📂 com.petstore.api.tests/
│   │   │   ├── 📂 com.petstore.api.listeners/
│   └── 📂 resources/
│       ├── 📂 testdata/
│       │   ├── 📄 postPetTestData.json
│       ├── 📂 schemas/
│       │   ├── 📄 postPetTestSchema.json
├── 📄 pom.xml
├── 📄 README.md
└── 📄 testng.xml
```

## 🧩 Key Components

<table>
<tr>
<th width="200">Component</th>
<th>Description</th>
</tr>
<tr>
<td>🧪 <b>Test Cases</b></td>
<td>Located in <code>com.petstore.api.tests</code>, each test class corresponds to a specific API operation.</td>
</tr>
<tr>
<td>🔧 <b>Utilities</b></td>
<td>Helper classes like <code>TestDataManager</code> and <code>SchemaValidator</code> for data management and response validation.</td>
</tr>
<tr>
<td>👀 <b>Listeners</b></td>
<td>Custom TestNG listeners in <code>com.petstore.api.listeners</code> package for enhanced reporting and logging.</td>
</tr>
<tr>
<td>📊 <b>Test Data</b></td>
<td>JSON files in <code>src/test/resources/testdata</code> for data-driven testing approach.</td>
</tr>
<tr>
<td>✅ <b>Schema Validation</b></td>
<td>JSON schema files in <code>src/test/resources/schemas</code> for validating API responses.</td>
</tr>
</table>

## 📋 Prerequisites

- ☕ Java 8+ installed
- 📦 Maven for dependency management
- 🧪 TestNG for test execution
- 🔄 RestAssured for API testing
- 📊 Gson for JSON handling

## 🚀 Getting Started

1. **Clone the Repository**:
   ```bash
   git clone <repository-url>
   cd petstore-api-automation
   ```

2. **Install Dependencies**:
   ```bash
   mvn clean install
   ```

## 🧪 Running Tests

<details>
<summary><b>Click to expand all test execution options</b></summary>

### Run All Tests
```bash
mvn test
```

### Run Tests with TestNG XML
```bash
mvn test -DsuiteXmlFile=testng.xml
```

### Run Specific Test Class
```bash
mvn -Dtest=PostCreateNewPetTest test
```

### Run Tests by Group
```bash
mvn test -Dgroups="smoke"
```

</details>

### Quick Command Reference

| Operation | Command |
|-----------|---------|
| 📦 **Install Dependencies** | `mvn clean install` |
| 🧪 **Run All Tests** | `mvn test` |
| 🎯 **Run Specific Test** | `mvn -Dtest=TestClassName test` |
| 📄 **Run with TestNG XML** | `mvn test -DsuiteXmlFile=testng.xml` |
| 🏷️ **Run by Group** | `mvn test -Dgroups="groupName"` |

## 🌟 Framework Highlights

- **📊 Data-Driven Testing**: Manages test data through external JSON files for flexibility and maintainability
- **🧩 Modular Architecture**: Clear separation between test data, test cases, and utilities
- **🔍 Schema Validation**: Ensures API responses conform to predefined JSON schemas
- **🎭 Dynamic Test Data Generation**: Uses Java Faker to create realistic test scenarios
- **📈 Enhanced Reporting**: Custom listeners for detailed test execution reports
- **🔄 CI/CD Integration**: Configured for automated execution in GitHub Actions