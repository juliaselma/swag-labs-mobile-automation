# 📱 Swag Labs Mobile Automation (Betsson)

This repository contains the Appium-based mobile test automation framework for the Swag Labs mobile application. It utilizes **Java**, **Cucumber**, and the **Page Object Model (POM)** pattern to deliver robust, scalable, and business-readable test scenarios.

***

## 🚀 Getting Started

### Prerequisites

To run this project, you need the following software installed on your machine:

1.  **Java Development Kit (JDK) 17 or higher**
2.  **Apache Maven** (for dependency management)
3.  **Android Studio** (for Android SDK, platform tools, and AVD/emulator setup)
4.  **Node.js & npm** (for Appium Server installation)
5.  **Appium Server 2.x** (Globally installed via npm)

### Setup Steps

1.  **Clone the Repository:**
    ```bash
    git clone [your-repo-url]
    cd swag-labs-mobile-automation-betsson
    ```

2.  **Install Appium Server and UIAutomator2 Driver:**
    Ensure Appium is running. You must install the **UIAutomator2 driver** for Android testing:
    ```bash
    npm install -g appium
    appium driver install uiautomator2
    ```

3.  **Start Appium Server:**
    Open a terminal and run the server:
    ```bash
    appium
    ```

4.  **Verify Project Dependencies:**
    Build the project to download all necessary dependencies:
    ```bash
    mvn clean install
    ```

***

## ⚙️ Project Structure (POM & Cucumber)

The project adheres to the standard Maven and Page Object Model conventions:

* **`src/test/java/steps/context/`**: Contains the **`TestContext`** class for sharing the Driver, Page Objects, and test data across Cucumber steps.
* **`src/test/java/pages/`**: Houses the **Page Object Model (POM)** classes (e.g., `LoginScreen`, `ProductScreen`).
    * **`BaseScreen.java`**: Contains common utilities like explicit waits, the crucial **dynamic locator generator**, and scrolling helpers (if enabled).
* **`src/test/java/steps/`**: Contains the **Cucumber Step Definitions** (the glue code) that link Gherkin to the Page Object actions.
* **`src/test/resources/features/`**: Contains the **Gherkin `.feature` files** where all test scenarios are defined in plain language.

### Key Implementation Details

The framework uses a **highly reliable dynamic XPath locator pattern** to handle product lists and button state changes:

* **Action Locator:** Targets the clickable container (e.g., for click events).

* **Validation Locator:** Targets the visible text element (e.g., for verifying text change).
    ```java
    getProductButtonTextLocator(productName, "REMOVE") 
    ```

***
🚀 Execution Instructions

This project is a test automation suite designed to be run through its designated Test Runner class.

**Run via IDE**


Run the tests is by executing the Test Runner class directly from your Integrated Development Environment (IDE).

**Locate the Test Runner:**

Navigate to the file: src/test/java/runner/TestRunner.java

**Execute the Tests:**

In IntelliJ IDEA:

Right-click on the TestRunner.java file in the project explorer or open the file and click the green "Run" arrow next to the class declaration.


***
# 💡 Possible Improvements and Future Enhancements
This section outlines potential enhancements for both the existing test automation framework and the Swag Labs mobile application itself.

1. ⚙️ Framework & Test Automation Improvements
   These suggestions focus on making the testing framework more robust, efficient, scalable, and maintainable.

+ Advanced Reporting: Integrate Extent Reports or Allure Reporter to provide rich, visual, interactive reports with screenshots for every step.


+ Detailed Logging: Implement a dedicated logging library (e.g., Log4j 2) to log detailed actions, timestamps, and thread information to a separate file, which is crucial for debugging in CI environments.


+ Parallel Execution: Configure the test runner to run tests in parallel across multiple devices or emulators/simulators to dramatically reduce total execution time.


+ Cloud Integration: Integrate with a commercial device cloud platform (e.g., BrowserStack, Sauce Labs) to access a wider variety of real devices and OS versions for thorough cross-device compatibility testing.


+ Continuous Integration (CI): Set up a CI pipeline (Jenkins, GitHub Actions) to automatically run tests on every code commit, ensuring immediate regression detection.


+ **Complete Negative Scenario Coverage & Error Handling**: 


  + Expand the test suite to include all critical negative paths, specifically focusing on cases where user input or application state should trigger an error or prevent an action. Crucially, tests should include explicit error handling assertions to verify that the application displays the correct user-facing error message and handles the underlying exception gracefully.


  + Shopping Cart/Inventory: Test the boundary conditions for quantities (e.g., entering '0' or a massive number), attempt to add an item to the cart after session timeout, or test the removal of an item when the cart is already empty.


  + Checkout Information: Test submitting the checkout form with empty or invalid fields (e.g., leaving the postal code empty, entering non-numeric characters), ensuring the correct validation error is displayed for each field.

+ **Expanded Test Scenarios for Extensive Coverage:**

  + A. Product Page Coverage (Includes Scrolling & Filtering)
    Scrolling Validation: Verify the user can scroll smoothly from the top of the inventory page to the very bottom, ensuring all products are rendered.

  + Product Detail Navigation: Test tapping a product image or name to correctly navigate to the individual product detail screen and assert the correct product details are displayed.

  + Filter/Sorting Functionality: Test each of the four sorting options and assert that the product list reorders correctly based on the chosen filter.

  + State Persistence: Add an item to the cart, navigate to a different screen (like the Checkout Overview), return to the Inventory, and verify the "Add to Cart" button is correctly switched to "Remove" for that item, asserting session state is maintained.

+ B. Burger Menu (Sidebar) Coverage
  
  + "About" External Navigation: Tap the link and verify that the app successfully launches the correct external web page in the device's browser.

  + "Logout" Function: Tap the "Logout" link and assert the user is successfully returned to the Login screen, verifying the session is properly terminated.


+ C. Checkout Process Expansion
  + Cancellation Functionality: Verify that tapping the "Cancel" button at the Checkout Information step successfully returns the user to the Cart/Inventory, and that all previously added items are still present in the cart.

  + Data Integrity Check: On the Checkout Overview page, assert that the displayed Total Price (including tax) is mathematically correct based on the sum of the individual items' prices.


  + Post-Purchase Navigation: After successfully completing the final screen, attempt to use the device's back button (or the in-app "Back Home" button) and assert that the application navigates to the intended inventory screen and not backward through the finished transaction steps.


And more test scenarios could be included to guarantee extensive coverage
***

2. 📱 App Enhancements for Swag Labs
   These suggestions are based on common best practices for mobile applications and are intended as feedback on the application's user experience (UX) and performance.

+ Improved Checkout Flow: A single, scrollable checkout screen with collapsable sections could streamline the purchase process and potentially reduce cart abandonment.


+ Persistent Cart/Session: Implement a mechanism to retain the items in a user's cart for a reasonable time (e.g., 24 hours), even after the user closes the app (if they haven't explicitly logged out).


+ Image Loading Optimization: Implement lazy loading or ensure all product images are served in a mobile-optimized format/size to improve load times on product pages.


+ Input Validation Feedback: Implement real-time client-side validation on forms (login, checkout) to show users which fields are incorrect before they try to submit the form.


+ Error handling: After errors are fixed in the app the error messages are still displayed making it difficult for the customer to determine if the issue is fixed.


+ Accessibility IDs: Ensure all interactive elements have unique, developer-defined Accessibility IDs. This is vital for both users with screen readers and for robust, stable test automation.