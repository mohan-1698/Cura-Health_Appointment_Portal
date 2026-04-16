# CuraHealth Automation

## Project Overview

CuraHealth Automation is a test automation framework built using Selenium WebDriver, TestNG, and Maven. This project automates testing for the CURA Healthcare Services application, which is a demo healthcare appointment booking system. The framework follows the Page Object Model design pattern and uses data-driven testing with TestNG data providers.

## Project Details

- **Project Name:** curahealth-automation
- **Group ID:** com.srm.hackathon
- **Artifact ID:** curahealth-automation
- **Version:** 0.0.1-SNAPSHOT
- **Type:** Test Automation Framework (JAR)
- **Application URL:** https://katalon-demo-cura.herokuapp.com/

## Key Technologies and Dependencies

- **Selenium WebDriver:** 4.34.0 - Browser automation library
- **TestNG:** 7.10.2 - Testing framework for test execution and parallel testing
- **WebDriverManager:** 5.9.2 - Automatic WebDriver binary management
- **Apache POI:** 5.4.1 - Excel file handling for test data
- **Extent Reports:** 5.1.1 - Advanced test reporting with visual details
- **GSON:** 2.10.1 - JSON parsing and handling
- **Maven Surefire Plugin:** 3.1.2 - Test execution and reporting

## Project Structure

```
curahealth-automation/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/srm/hackathon/curahealth/
│   │   │       ├── base/
│   │   │       │   └── BasePage.java                    # Base class for all page objects with common methods
│   │   │       │
│   │   │       ├── factory/
│   │   │       │   ├── DriverFactory.java               # Initializes and manages WebDriver instances
│   │   │       │   └── DriverManager.java               # Thread-safe driver management using ThreadLocal
│   │   │       │
│   │   │       ├── pages/
│   │   │       │   ├── HomePage.java                    # HomePage POM with navigation methods
│   │   │       │   ├── LoginPage.java                   # LoginPage POM with login functionality
│   │   │       │   ├── AppointmentPage.java             # AppointmentPage POM for booking appointments
│   │   │       │   ├── ConfirmationPage.java            # ConfirmationPage POM for verification
│   │   │       │   ├── HistoryPage.java                 # HistoryPage POM for viewing appointment history
│   │   │       │   └── ProfilePage.java                 # ProfilePage POM for user profile management
│   │   │       │
│   │   │       └── utils/
│   │   │           ├── ConfigReader.java                # Reads configuration from properties file
│   │   │           ├── ScreenshotUtil.java              # Utility for capturing screenshots on failure
│   │   │           ├── ExtentManager.java               # Manages Extent Report generation
│   │   │           ├── ExcelUtil.java                   # Excel operations for reading/writing test data
│   │   │           └── JsonReader.java                  # JSON parsing utility for test data
│   │   │
│   │   └── resources/
│   │       └── config.properties                        # Configuration file for browser, URL, credentials
│   │
│   └── test/
│       ├── java/
│       │   └── com/srm/hackathon/curahealth/
│       │       ├── base/
│       │       │   └── BaseTest.java                    # Base test class with setup and teardown
│       │       │
│       │       ├── tests/
│       │       │   ├── AuthenticationTest.java          # Tests for login and authentication
│       │       │   ├── AppointmentBookingTest.java      # Tests for appointment booking functionality
│       │       │   ├── AppointmentHistoryTest.java      # Tests for viewing appointment history
│       │       │   ├── MultipleAppointmentsTest.java    # Tests for booking multiple appointments
│       │       │   └── FormValidationTest.java          # Tests for form validation and error handling
│       │       │
│       │       ├── dataproviders/
│       │       │   ├── LoginDataProvider.java           # Provides test data for login tests
│       │       │   └── AppointmentDataProvider.java     # Provides test data for appointment tests
│       │       │
│       │       └── listeners/
│       │           └── TestListener.java                # Custom TestNG listener for test events
│       │
│       └── resources/
│           ├── appointmentData.json                     # Test data in JSON format for appointments
│           └── testdata/
│               └── LoginData.xlsx                       # Excel file with login test data
│
├── reports/
│   └── ExtentReport.html                               # Generated test report after test execution
│
├── screenshots/                                         # Captured screenshots on test failures
│   ├── testBookAppointment_*.png
│   ├── testMultipleAppointments_*.png
│   ├── testPastDateValidation_*.png
│   └── ... (other test screenshots)
│
├── test-output/                                         # TestNG generated reports and logs
│   └── ... (TestNG reports and results)
│
├── target/                                              # Maven build output directory
│   ├── classes/                                         # Compiled main source classes
│   ├── test-classes/                                    # Compiled test classes
│   ├── surefire-reports/                                # Surefire test execution reports
│   └── ... (other build artifacts)
│
├── pom.xml                                             # Maven configuration and dependencies
├── testng.xml                                          # TestNG suite configuration for test execution
├── Design Document.pdf                                 # Project design and test strategy documentation
├── README.md                                           # Project documentation
└── .classpath, .project, .settings/                    # Eclipse IDE configuration files
```

## File Descriptions

### Core Classes

#### Base Classes
- **BasePage.java:** Contains reusable methods for all page classes including waits, clicks, text input, element visibility checks, and dropdown selections.
- **BaseTest.java:** Provides setup and teardown methods for all test classes, manages driver initialization and closing.

#### Factory Pattern
- **DriverFactory.java:** Handles WebDriver initialization based on browser configuration (Chrome, Firefox, etc.). Supports headless mode.
- **DriverManager.java:** Provides thread-safe driver management using ThreadLocal to support parallel test execution.

#### Page Object Model (POM)
- **HomePage.java:** Represents the home page with methods for menu navigation and login access.
- **LoginPage.java:** Handles login functionality with username and password input.
- **AppointmentPage.java:** Manages appointment booking with facility selection, program selection, date entry, and comments.
- **ConfirmationPage.java:** Verifies appointment confirmation after successful booking.
- **HistoryPage.java:** Displays appointment history and verification methods.
- **ProfilePage.java:** Manages user profile information and settings.

#### Utilities
- **ConfigReader.java:** Reads configuration values from config.properties file for browser type, base URL, timeout settings, and credentials.
- **ScreenshotUtil.java:** Captures screenshots on test failures for debugging purposes.
- **ExtentManager.java:** Creates and configures Extent Reports for detailed test result documentation.
- **ExcelUtil.java:** Reads and writes data from Excel files for test data management.
- **JsonReader.java:** Parses JSON files containing test data for appointment details.

#### Test Data Providers
- **LoginDataProvider.java:** Provides multiple login credentials (valid and invalid) for parameterized login tests.
- **AppointmentDataProvider.java:** Provides appointment details like facility, program, date, and comments for booking tests.

#### Listeners
- **TestListener.java:** Custom TestNG listener that handles test execution events (start, success, failure, skip) for logging and report generation.

### Configuration Files
- **config.properties:** Contains environment configuration including browser type, base URL, timeout values, and test user credentials.
- **appointmentData.json:** JSON file containing appointment test data for data-driven tests.
- **LoginData.xlsx:** Excel spreadsheet with login credentials for testing various login scenarios.
- **testng.xml:** TestNG suite configuration that defines test structure with 5 test modules running in parallel with 5 threads.

## Test Modules

The project contains 5 main test modules as defined in testng.xml:

1. **AuthenticationTests** - Tests login functionality with valid and invalid credentials
2. **AppointmentBookingTests** - Tests appointment booking with various facility and program options
3. **AppointmentHistoryTests** - Tests viewing and retrieving appointment history
4. **MultipleAppointmentsTests** - Tests booking multiple appointments in sequence
5. **FormValidationTests** - Tests form validation, required field checks, and error handling

## Configuration

### Browser Configuration
The project supports multiple browsers:
- Chrome (default)
- Firefox
- Edge

### Configuration Properties (config.properties)
```
browser=chrome                                          # Browser type (chrome, firefox, edge)
baseUrl=https://katalon-demo-cura.herokuapp.com/       # Application URL
timeout=10                                              # Explicit wait timeout in seconds
headless=true                                           # Run browser in headless mode
username=John Doe                                       # Test username
password=ThisIsNotAPassword                             # Test password
```

## How to Run Tests

### Prerequisites
- Java JDK 8 or higher
- Maven 3.6 or higher
- Internet connection for browser driver download

### Running All Tests
```
mvn clean test
```

### Running Specific Test Suite
```
mvn clean test -Dgroups="AuthenticationTests"
```

### Running in Parallel Mode
Tests are configured to run in parallel with 5 threads as defined in testng.xml. Modify the thread-count value to adjust parallelization.

### Running with Headless Mode
Edit config.properties and set:
```
headless=true
```

## Test Reports

### Extent Report
After test execution, a detailed HTML report is generated at:
```
reports/ExtentReport.html
```

### TestNG Report
TestNG generates reports at:
```
test-output/index.html
```

### Screenshots
Screenshots of failed tests are automatically captured and stored in:
```
screenshots/
```

## Design Patterns Used

### 1. Page Object Model (POM)
- Each page of the application is represented by a separate class
- Page elements are defined as private variables
- Page interactions are represented as public methods
- Reduces code duplication and improves maintainability

### 2. Factory Pattern
- DriverFactory creates WebDriver instances
- Supports multiple browsers through factory methods
- Centralizes driver initialization logic

### 3. Singleton Pattern
- DriverManager uses ThreadLocal for singleton driver management
- Ensures only one driver instance per thread
- Supports parallel test execution

### 4. Data Provider Pattern
- TestNG data providers supply test data
- Supports multiple test data sources (Excel, JSON)
- Enables data-driven testing without code modification

### 5. Listener Pattern
- Custom TestNG listeners handle test lifecycle events
- Integrates reporting and screenshots on failures
- Enables automatic report generation

## Best Practices Implemented

1. **Separation of Concerns:** Configuration, page objects, utilities, and tests are kept separate.
2. **Reusability:** Common methods are centralized in BasePage and BaseTest.
3. **Maintainability:** Using POM makes tests easier to maintain and update.
4. **Scalability:** Thread-safe driver management allows parallel execution.
5. **Reporting:** Extent Reports provide comprehensive test execution details.
6. **Data-Driven Testing:** Test data is externalized using JSON and Excel files.
7. **Error Handling:** Screenshots are captured on failures for debugging.

## Troubleshooting

### WebDriver Not Found
- WebDriverManager automatically downloads the required driver
- Ensure internet connectivity is available

### Test Timeout Issues
- Increase the timeout value in config.properties
- Check application responsiveness

### Parallel Execution Issues
- Ensure thread-safe operations in test code
- Avoid shared state between tests
- Use ThreadLocal for driver management (already implemented)

### Report Generation Issues
- Check write permissions for reports directory
- Ensure sufficient disk space
- Verify Extent Reports dependency is available

## Future Enhancements

1. Integration with CI/CD pipelines (Jenkins, GitHub Actions)
2. Enhanced cross-browser testing capabilities
3. Mobile testing support with Appium
4. Performance testing metrics
5. Integration with test management tools (JIRA, TestRail)
6. API testing layer
7. Visual regression testing

## Contributing

When adding new tests or modifying existing ones:
1. Follow the Page Object Model pattern
2. Add meaningful comments and documentation
3. Use appropriate wait strategies
4. Capture screenshots on failures
5. Update this README with any structural changes

## License

This project is part of SRM Hackathon automation series.

## Contact

For questions or issues related to this project, please contact the development team.
