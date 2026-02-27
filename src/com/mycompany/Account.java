package com.mycompany;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Account {
    private static int idCounter = 1000;
    private static final DateTimeFormatter TXN_TIME_FORMAT =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private final int accountNumber;
    private final String username;
    private String password;
    private double balance;
    private final ArrayList<String> transactionHistory = new ArrayList<>();

    private final double MIN_BALANCE = 100;

    public Account(String username, String password, double balance) {
        this.accountNumber = ++idCounter;
        this.username = username;
        this.password = password;
        this.balance = balance;
        addTransaction("Account created with balance: " + balance);
    }

    public Account(int accountNumber, String username, String password, double balance) {
        this.accountNumber = accountNumber;
        this.username = username;
        this.password = password;
        this.balance = balance;
        if (accountNumber > idCounter) {
            idCounter = accountNumber;
        }
    }

    public Account(int accountNumber, String username, String password, double balance, List<String> transactions) {
        this(accountNumber, username, password, balance);
        if (transactions != null) {
            transactionHistory.addAll(transactions);
        }
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public void changePassword(String newPassword) {
        this.password = newPassword;
        System.out.println("Password changed successfully!");
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            addTransaction("Deposited: " + amount);
            System.out.println("Deposit successful!");
        } else {
            System.out.println("Invalid amount!");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && (balance - amount) >= MIN_BALANCE) {
            balance -= amount;
            addTransaction("Withdrawn: " + amount);
            System.out.println("Withdrawal successful!");
        } else {
            System.out.println("Insufficient balance! Minimum balance required: " + MIN_BALANCE);
        }
    }

    public void transfer(Account receiver, double amount) {
        if (amount > 0 && (balance - amount) >= MIN_BALANCE) {
            balance -= amount;
            receiver.balance += amount;

            String transferTime = LocalDateTime.now().format(TXN_TIME_FORMAT);
            transactionHistory.add("[" + transferTime + "] Transferred " + amount + " to " + receiver.username);
            receiver.transactionHistory.add("[" + transferTime + "] Received " + amount + " from " + username);

            System.out.println("Transfer successful!");
        } else {
            System.out.println("Transfer failed!");
        }
    }

    public void showTransactions() {
        System.out.println("\n--- Transaction History ---");
        for (String record : transactionHistory) {
            System.out.println(record);
        }
    }

    public List<String> getTransactionHistory() {
        return new ArrayList<>(transactionHistory);
    }

    private void addTransaction(String message) {
        String timestamp = LocalDateTime.now().format(TXN_TIME_FORMAT);
        transactionHistory.add("[" + timestamp + "] " + message);
    }

    public void showAccountDetails() {
        System.out.println("\nAccount Number: " + accountNumber);
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        System.out.println("Balance: " + balance);
    }

    public void showAccountDetails2() {
        System.out.println("\nAccount Number: " + accountNumber);
        System.out.println("Username: " + username);
//        System.out.println("Password: " + password);
        System.out.println("Balance: " + balance);
    }
}
