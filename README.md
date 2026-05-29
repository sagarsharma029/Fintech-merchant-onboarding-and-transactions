# FinTech Merchant Onboarding & Transaction Automation Framework

## Overview

This project is a Selenium-based automation framework developed to automate the complete Merchant Onboarding and Payment Processing workflows for a FinTech payment platform. The framework covers the entire merchant lifecycle, from merchant registration and configuration to successful payment transactions across multiple payment methods.

## Tech Stack

- Java
- Selenium WebDriver
- TestNG
- Maven
- Page Object Model (POM)
- JSON (Test Data Storage)
- Microsoft Edge WebDriver

## Features

### Merchant Onboarding Automation

Automates:
- Merchant Registration
- Merchant Mapping
- Fee/TDR Configuration
- Fraud Risk Management (FRM) Setup
- Settlement Configuration
- Merchant Account Activation
- Routing Rule Configuration

### Transaction Automation

Automates end-to-end payment transactions for:
- Credit Card
- Debit Card
- Net Banking
- Wallet
- UPI

## Framework Highlights

- Dynamic test data generation for merchant name, email, and phone number to prevent duplicate registration failures.
- JSON-based data persistence and sharing between onboarding and transaction test suites.
- Robust handling of alerts, popups, searchable dropdowns, dynamic tables, and dependent UI elements.
- Dynamic table automation capable of handling varying numbers of Payment Types and MOPs without hardcoded row indexes.
- Rule configuration automation supporting multiple payment methods with dynamic UI refresh handling.

## Test Flow

### MerchantRegistrationTest

1. Login to Admin Portal
2. Register Merchant
3. Configure Merchant Mapping
4. Configure Fee/TDR Settings
5. Configure FRM Rules
6. Configure Settlement Settings
7. Activate Merchant Account
8. Configure Routing Rules
9. Save Merchant Data (including Pay ID) to JSON

### MerchantTransactionsTest

1. Read Merchant Data from JSON
2. Open Payment Page
3. Execute transactions using multiple payment methods
4. Validate successful payment responses

## Key Challenges Solved

### Dynamic Configuration Table Handling

Implemented a dynamic row-processing solution for configuration screens where rows are generated based on mapped Payment Types and MOPs. The framework identifies and processes rows at runtime, eliminating dependency on hardcoded indexes and improving maintainability.

### Dynamic Rule Configuration

Automated routing rule creation across multiple payment methods while handling dynamic page refreshes, dependent controls, and changing UI states.

## Execution

Run Merchant Onboarding:

```bash
mvn test -Dtest=MerchantRegistrationTest
```

Run Merchant Transactions:

```bash
mvn test -Dtest=MerchantTransactionsTest
```

Run Complete Suite:

```bash
mvn test
```

## Author

**Sagar Sharma**

QA Automation Engineer specializing in Selenium Automation, Test Framework Development, FinTech Domain Testing, and End-to-End Workflow Automation.