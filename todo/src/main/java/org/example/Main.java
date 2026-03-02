package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        UserManager userManager = new UserManager();

        boolean loggedIn = false;
        String currentUser = null;

        while (!loggedIn) {
            System.out.println("\n1. Register");
            System.out.println("2. Login");
            System.out.print("Choose: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice > 2 || choice < 1) {
                System.out.println("Wrong choice!");
                return;
            }

            System.out.print("Username: ");
            String username = scanner.nextLine();

            System.out.print("Password: ");
            String password = scanner.nextLine();

            if (choice == 1) {
                userManager.register(username, password);
            } else if (choice == 2) {
                if (userManager.login(username, password)) {
                    loggedIn = true;
                    currentUser = username;
                }
            }
        }

        // After Login → open Todo system
        TaskManager manager = new TaskManager();
        int choice;

        do {
            System.out.println("\n===== TODO MENU =====");
            System.out.println("1. Add Task");
            System.out.println("2. List Tasks");
            System.out.println("3. Delete Task");
            System.out.println("4. Complete Task");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter task title: ");
                    String title = scanner.nextLine();
                    manager.addTask(title);
                    break;

                case 2:
                    manager.listTasks();
                    break;

                case 3:
                    System.out.print("Enter task ID: ");
                    manager.deleteTask(scanner.nextInt());
                    break;

                case 4:
                    System.out.print("Enter task ID: ");
                    manager.completeTask(scanner.nextInt());
                    break;
            }

        } while (choice != 0);

        scanner.close();
    }
}