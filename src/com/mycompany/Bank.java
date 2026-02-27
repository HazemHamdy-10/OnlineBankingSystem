package com.mycompany;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Bank {
    private final ArrayList<Account> accounts = new ArrayList<>();
    private static final Path DATA_FILE = Paths.get("accounts.txt");
    private static final String OWNER_ADMIN_USERNAME = "bankOwner";
    private static final String OWNER_ADMIN_PASSWORD = "Owner@123";

    public Bank() {
        loadAccounts();
    }

    public void register(String username, String password, double balance) {
        if (findAccount(username) != null) {
            System.out.println("Account already exists!");
            return;
        }

        accounts.add(new Account(username, password, balance));
        saveAccounts();
        System.out.println("Account created successfully!");
    }

    public Account login(String username, String password) {
        for (Account acc : accounts) {
            if (acc.getUsername().equals(username) && acc.checkPassword(password)) {
                return acc;
            }
        }
        return null;
    }

    public Account findAccount(String username) {
        for (Account acc : accounts) {
            if (acc.getUsername().equals(username)) {
                return acc;
            }
        }
        return null;
    }

    public void showAllAccounts() {
        System.out.println("\n--- All Bank Accounts ---");
        for (Account acc : accounts) {
            acc.showAccountDetails2();
        }
    }

    public int getTotalAccounts() {
        return accounts.size();
    }

    public boolean isOwnerAdmin(String username, String password) {
        return OWNER_ADMIN_USERNAME.equals(username) && OWNER_ADMIN_PASSWORD.equals(password);
    }

    public void saveAccounts() {
        try (BufferedWriter writer = Files.newBufferedWriter(DATA_FILE)) {
            for (Account acc : accounts) {
                String line = acc.getAccountNumber() + "\t"
                        + acc.getUsername() + "\t"
                        + acc.getPassword() + "\t"
                        + acc.getBalance() + "\t"
                        + encodeTransactions(acc.getTransactionHistory());
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Failed to save accounts: " + e.getMessage());
        }
    }

    private void loadAccounts() {
        if (!Files.exists(DATA_FILE)) {
            return;
        }

        try (BufferedReader reader = Files.newBufferedReader(DATA_FILE)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\t");
                if (parts.length < 4) {
                    continue;
                }

                int accountNumber = Integer.parseInt(parts[0]);
                String username = parts[1];
                String password = parts[2];
                double balance = Double.parseDouble(parts[3]);
                List<String> transactions = parts.length >= 5
                        ? decodeTransactions(parts[4])
                        : new ArrayList<>();

                accounts.add(new Account(accountNumber, username, password, balance, transactions));
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Failed to load accounts: " + e.getMessage());
        }
    }

    private String encodeTransactions(List<String> transactions) {
        if (transactions == null || transactions.isEmpty()) {
            return "";
        }

        ArrayList<String> encoded = new ArrayList<>();
        for (String record : transactions) {
            String safe = record
                    .replace("\\", "\\\\")
                    .replace("|", "\\|")
                    .replace("\t", "\\t");
            encoded.add(safe);
        }

        return String.join("|", encoded);
    }

    private List<String> decodeTransactions(String encoded) {
        ArrayList<String> transactions = new ArrayList<>();
        if (encoded == null || encoded.isEmpty()) {
            return transactions;
        }

        StringBuilder current = new StringBuilder();
        boolean escaping = false;

        for (char ch : encoded.toCharArray()) {
            if (escaping) {
                if (ch == 't') {
                    current.append('\t');
                } else {
                    current.append(ch);
                }
                escaping = false;
            } else if (ch == '\\') {
                escaping = true;
            } else if (ch == '|') {
                transactions.add(current.toString());
                current.setLength(0);
            } else {
                current.append(ch);
            }
        }

        if (escaping) {
            current.append('\\');
        }

        transactions.add(current.toString());
        return transactions;
    }
}
