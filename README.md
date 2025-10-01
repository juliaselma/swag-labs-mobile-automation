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
