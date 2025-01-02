# plusSystem - IntelliJ IDEA Project

This project implements a web-based plus system that allows users to submit addition requests and displays the calculated results.

### Project Structure

    plus-system-ver2/
    ├── cypress/        # E2E Tests (End-to-End)
    ├── frontend/       # Frontend Development
    │   ├── vite/        # Build and Test Tools
    │   │   ├── vue/      # Frontend Framework
    │   │   │   └── ...   # HTML, JavaScript, CSS files
    │   └── ...          # Additional Frontend Files (if any)
    └── backend/        # Backend Development
    └── springBootWeb/ # Spring Boot Web Application
    ├── src/main/java/  # Java source code
    │   └── ...        # Java packages and classes
    └── build.gradle.kts  # Gradle build configuration
    └── package.json    # Frontend package manager config
    └── settings.gradle.kts # Gradle settings


### Libraries Used

**Frontend:**

*   npm (package manager)
*   Vite (build tool)
*   Vitest (unit testing framework)
*   Vue.js (frontend framework)

**Backend:**

*   Spring Boot Web
*   Lombok (for reduced boilerplate code)
*   Mock library (for backend unit testing)

**Testing:**

*   Cypress (E2E testing framework)

**API:**

*   RESTful API

### Getting Started

This section provides instructions on how to set up and run the project.

**Prerequisites:**

*   Java Development Kit (JDK) 17 or higher
*   Node.js and npm (Node Package Manager)
*   Gradle (version specified in `gradle/wrapper/gradle-wrapper.properties` or installed globally)

**Backend Setup:**

1.  Navigate to the backend directory:

    ```bash
    cd backend/springBootWeb
    ```

2.  Build the project using Gradle:

    ```bash
    ./gradlew build # or gradlew.bat build on Windows
    ```

3.  Run the Spring Boot application:

    ```bash
    ./gradlew bootRun # or gradlew.bat bootRun on Windows
    ```
    or after build
    ```bash
    java -jar build/libs/*.jar
    ```

**Frontend Setup:**

1.  Navigate to the frontend directory:

    ```bash
    cd frontend
    ```

2.  Install npm dependencies:

    ```bash
    npm install
    ```

3.  Start the development server:

    ```bash
    npm run dev
    ```

## Running Tests

### Backend Tests

1. Navigate to the backend directory:
    ```bash
    cd backend/springBootWeb
    ```
2. Run tests:
   ```bash
   ./gradlew test # or gradlew.bat test on Windows
### Frontend Tests: 

* Navigate to the frontend directory:
```
bash
    cd frontend
```
### Run tests:
```bash
npm run test:unit # or npm run test (depending on your package.json)
```

### E2E Tests:
* Make sure both the backend and frontend are running.

### Navigate to the cypress directory:

```bash
cd cypress
```

### Run the Cypress tests:

```bash
npx cypress open # Open Cypress Test Runner
```
* or
```bash
npx cypress run # Run tests in headless mode
```

## Coding Conventions
* Module and Project Names
  * Use lowercase letters with hyphens (e.g., plus-system).
* Javadoc
  * All code must be documented using Javadoc comments. Include author and version information.
* Class Names
  * Use camel case (e.g., PlusController).
* Method and Variable Names
  * Start with lowercase letters and use camel case (e.g., calculatePlus). Names should be clear and descriptive.
* Layered Architecture
   * Follow the model-view-controller (MVC) pattern.

## Collaboration Guidelines
* Issue Tracking
  * Use Slack to raise issues and discuss project progress.
* Pull Requests
  * All pull requests require notification and approval from the team via Slack before merging.