package com.autobots.bankApp;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BankProApp {

    static Scanner scanner = new Scanner(System.in);


    private static final Map<String, Client> clients = new HashMap<>();

    public static void main(String[] args) {

        Client asan = new Client("Asan Uson", "123");

        DepositAccount asanDepositAccount = new DepositAccount(asan, Currency.USD);
        CreditAccount asanCreditAccount = new CreditAccount(asan, Currency.EUR);

        asan.addAccount(asanDepositAccount);
        asan.addAccount(asanCreditAccount);
        System.out.println(asan.getClientID());

        clients.put(asan.getClientID(),asan);

        System.out.println(" Welcome to Mbank ");
        System.out.println("Please enter client ID");
        String clientID = scanner.nextLine();
        Client client = clients.get(clientID);
        if (client == null) {
            System.out.println("client was not found");
            return;
        }
        System.out.println("Please enter pin code");
        String pinCode = scanner.nextLine();

        
    }

    private static BankAccount findAccount(String accountNumber) {
        for (Client client : clients.values()) {
            for (BankAccount bankAccount : client.getAccounts()) {
                if (bankAccount.getAccountNumber().equals(accountNumber)){
                    return bankAccount;
                }
            }
        }
        return null;
    }
}
