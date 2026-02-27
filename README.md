 # 🏦 Online Banking System (Java OOP Project)

## 📌 Project Overview

The **Online Banking System** is a console-based Java application developed using **Java Basics and Object-Oriented Programming (OOP)** principles.

This system simulates a real-world banking environment where users can create accounts, log in securely, perform financial transactions, and where an administrator can monitor the overall bank system.

The goal of this project is to demonstrate:

* OOP concepts
* File handling (data persistence)
* Business logic implementation
* Input validation
* Simple security mechanisms

# 🚀 Features

## 👤 User Features

* Register new account
* Secure login system
* Deposit money
* Withdraw money
* Transfer money to another account
* View account balance
* View transaction history
* View last 3 transactions
* Change password
* PIN verification for sensitive operations
* Daily withdrawal limit protection
* Minimum balance protection

## 🔐 Security Features

* 3 failed login attempts → account gets locked
* PIN required for withdrawals & transfers
* Prevent duplicate usernames
* Prevent weak passwords
* Reserved username protection (admin cannot be registered)
* Account status system (Active / Suspended)

## 🏛 Admin Features

Admin has a separate login panel and can:

* View all bank accounts
* View account details
* View total number of accounts
* View total money inside the bank
* Access bank summary statistics

Only the bank owner (Admin) can access these features.

# 💾 Data Persistence (File-Based Database)

This system uses **File Handling instead of a real database**.

* All accounts are saved inside `accounts.txt`
* Data remains saved even after closing the program
* Accounts are automatically loaded when the system starts

This simulates a simple database using Java file I/O.

# 🧠 OOP Concepts Used

This project applies the following Object-Oriented Programming principles:

* Classes & Objects
* Encapsulation (private variables + getters)
* Constructors
* Static variables
* Method abstraction
* Object interaction
* Business logic separation (Bank class manages accounts)

---

# 🏗 Project Structure

```
OnlineBankingSystem.java
│
├── Account Class
│     ├── Account Details
│     ├── Deposit
│     ├── Withdraw
│     ├── Transfer
│     ├── Transaction History
│     └── Security Methods
│
├── Bank Class
│     ├── Register
│     ├── Login
│     ├── Find Account
│     ├── Load From File
│     ├── Save To File
│     └── Admin Functions
│
└── Main Class
      ├── Welcome Screen
      ├── User Menu
      ├── Admin Menu
      └── System Controller
```

# 📊 Business Logic Implemented

The system simulates real banking rules:

* Minimum balance required
* Daily withdrawal limit
* Unique account numbers (auto-generated)
* Transaction ID for each operation
* Account creation date tracking
* Account lock after multiple failed attempts

# 🖥 How to Run

1. Open the project in IntelliJ IDEA.
2. Make sure `accounts.txt` exists in the project folder (it will auto-create if not).
3. Run the `Main` class.
4. Follow the console instructions.

# 🔧 Technologies Used

* Java
* OOP Principles
* ArrayList
* File Handling (BufferedReader / BufferedWriter)
* Scanner (User Input)

# 🎯 Learning Objectives

This project was built to:

* Practice Java basics
* Understand object-oriented design
* Implement real-world system logic
* Simulate a database using files
* Improve problem-solving and system thinking skills

# 📈 Future Improvements (Optional)

* GUI version using Java Swing
* Database integration (MySQL)
* Password encryption
* ATM simulation interface
* Interest auto-calculation system
* Multi-user role management

# 👨‍💻 Developer

**Name:** Your Name Here
**Course:** Software Engineering / Java Programming
**Project Type:** Academic Assignment

# 📜 License

This project is for educational purposes only.

# ⭐ Final Note

This project demonstrates how a real banking system can be simulated using only Java basics and OOP principles, without advanced frameworks or external databases.
