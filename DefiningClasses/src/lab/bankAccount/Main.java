package lab.bankAccount;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<Integer, BankAccount> bankAccounts = new HashMap<>();

        String[] commandParams = scanner.nextLine().split("\\s+");
        while (!commandParams[0].equalsIgnoreCase("end")) {
            String commandType = commandParams[0];
            switch (commandType.toLowerCase()) {
                case "create":
                    BankAccount bankAccount = new BankAccount();
                    bankAccounts.putIfAbsent(bankAccount.getId(), bankAccount);
                    System.out.println("Account ID" + bankAccount.getId() + " created");
                    break;
                case "deposit":
                    int accountId = Integer.parseInt(commandParams[1]);
                    double amount = Double.parseDouble(commandParams[2]);
                    if (!bankAccounts.containsKey(accountId)) {
                        System.out.println("Account does not exist");
                    } else {
                        bankAccounts.get(accountId).deposit(amount);
                        DecimalFormat format = new DecimalFormat("0.#");
                        System.out.printf("Deposited %s to ID%d%n", format.format(amount), accountId);
                    }

                    break;
                case "setinterest":
                    double interest = Double.parseDouble(commandParams[1]);
                    BankAccount.setInterestRate(interest);
                    break;
                case "getinterest":
                    accountId = Integer.parseInt(commandParams[1]);
                    int years = Integer.parseInt(commandParams[2]);
                    if (!bankAccounts.containsKey(accountId)) {
                        System.out.println("Account does not exist");
                    } else {
                        DecimalFormat format = new DecimalFormat("0.00");
                        System.out.println(format.format(bankAccounts.get(accountId).getInterest(years)));
                    }
            }

            commandParams = scanner.nextLine().split("\\s+");
        }
    }
}
