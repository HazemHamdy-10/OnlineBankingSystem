package org.example;

import java.io.*;
import java.util.Scanner;

public class UserManager {

    private static final String FILE_NAME = "users.txt";

    public boolean register(String username, String password) {
        if (userExists(username)) {
            System.out.println("Username already exists!");
            return false;
        }

        try (FileWriter fw = new FileWriter(FILE_NAME, true)) {
            fw.write(username + "," + password + "\n");
            System.out.println("Registered successfully!");
            return true;
        } catch (IOException e) {
            System.out.println("Error saving user.");
            return false;
        }
    }

    public boolean login(String username, String password) {
        try (Scanner scanner = new Scanner(new File(FILE_NAME))) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");

                if (parts[0].equals(username) && parts[1].equals(password)) {
                    System.out.println("Login successful!");
                    return true;
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("No users registered yet.");
        }

        System.out.println("Invalid credentials.");
        return false;
    }

    private boolean userExists(String username) {
        try (Scanner scanner = new Scanner(new File(FILE_NAME))) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");

                if (parts[0].equals(username)) {
                    return true;
                }
            }

        } catch (FileNotFoundException e) {
            return false;
        }

        return false;
    }
}