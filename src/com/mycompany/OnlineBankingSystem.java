package com.mycompany;

import java.util.Scanner;

public class OnlineBankingSystem {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Bank bank = new Bank();
        Account currentUser = null;

        System.out.println("======================================");
        System.out.println(" Welcome to the Online Banking System ");
        System.out.println("======================================");

        int choice;

        do {
            System.out.println("\n1.Register");
            System.out.println("2.Login");
            System.out.println("3.Owner Admin View All Accounts");
            System.out.println("4.Exit");
            System.out.print("Choose option: ");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter username: ");
                    String user = input.nextLine();

                    System.out.print("Enter password: ");
                    String pass = input.nextLine();

                    System.out.print("Enter initial balance: ");
                    double bal = input.nextDouble();

                    bank.register(user, pass, bal);
                    break;

                case 2:
                    System.out.print("Enter username: ");
                    String loginUser = input.nextLine();

                    System.out.print("Enter password: ");
                    String loginPass = input.nextLine();

                    currentUser = bank.login(loginUser, loginPass);

                    if (currentUser != null) {
                        System.out.println("Login successful!");

                        int userChoice;

                        do {
                            System.out.println("\n1. Deposit");
                            System.out.println("2. Withdraw");
                            System.out.println("3. Transfer");
                            System.out.println("4. Check Balance");
                            System.out.println("5. View Transactions");
                            System.out.println("6. Change Password");
                            System.out.println("7. View Account Details");
                            System.out.println("8. Logout");
                            System.out.print("Choose option: ");

                            userChoice = input.nextInt();
                            input.nextLine();

                            switch (userChoice) {

                                case 1:
                                    System.out.print("Amount: ");
                                    currentUser.deposit(input.nextDouble());
                                    bank.saveAccounts();
                                    break;

                                case 2:
                                    System.out.print("Amount: ");
                                    currentUser.withdraw(input.nextDouble());
                                    bank.saveAccounts();
                                    break;

                                case 3:
                                    System.out.print("Enter receiver username: ");
                                    String receiverName = input.nextLine();
                                    Account receiver = bank.findAccount(receiverName);

                                    if (receiver != null) {
                                        System.out.print("Amount: ");
                                        currentUser.transfer(receiver, input.nextDouble());
                                        bank.saveAccounts();
                                    } else {
                                        System.out.println("Receiver not found!");
                                    }
                                    break;

                                case 4:
                                    System.out.println("Balance: " + currentUser.getBalance());
                                    break;

                                case 5:
                                    currentUser.showTransactions();
                                    break;

                                case 6:
                                    System.out.print("Enter new password: ");
                                    currentUser.changePassword(input.nextLine());
                                    bank.saveAccounts();
                                    break;

                                case 7:
                                    currentUser.showAccountDetails();
                                    break;

                                case 8:
                                    System.out.println("Logged out.");
                                    break;

                                default:
                                    System.out.println("Invalid option!");
                            }

                        } while (userChoice != 8);

                    } else {
                        System.out.println("Invalid login!");
                    }

                    break;

                case 3:
                    System.out.print("Enter admin username: ");
                    String adminUser = input.nextLine();
                    System.out.print("Enter admin password: ");
                    String adminPass = input.nextLine();

                    if (bank.isOwnerAdmin(adminUser, adminPass)) {
                        bank.showAllAccounts();
                        System.out.println("\nTotal accounts in bank: " + bank.getTotalAccounts());
                    } else {
                        System.out.println("Access denied! Owner admin only.");
                    }
                    break;

                case 4:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option!");
            }

        } while (choice != 4);

        input.close();
    }
}
