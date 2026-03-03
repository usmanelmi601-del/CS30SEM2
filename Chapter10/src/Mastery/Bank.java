package Mastery;

import java.util.ArrayList;

public class Bank {

    // List of accounts
    private ArrayList<Account> accounts;

    /**
     * Constructor
     */
    public Bank() {
        accounts = new ArrayList<>();
    }

    /**
     * Adds a new account and returns its ID
     */
    public String addAccount(String fName, String lName, double balance) {

        if (balance < 0) {
            return "Beginning balance cannot be negative.";
        }

        Account newAcct = new Account(balance, fName, lName);
        accounts.add(newAcct);

        return "Account created successfully.\nAccount ID: " + newAcct.getID();
    }

    /**
     * Deletes an existing account
     */
    public String deleteAccount(String acctID) {

        Account acct = findAccount(acctID);

        if (acct != null) {
            accounts.remove(acct);
            return "Account removed successfully.";
        }

        return "Account does not exist.";
    }

    /**
     * Performs deposit (1) or withdrawal (2)
     */
    public String transaction(int transCode, String acctID, double amt) {

        Account acct = findAccount(acctID);

        if (acct == null) {
            return "Account does not exist.";
        }

        if (amt <= 0) {
            return "Amount must be greater than zero.";
        }

        if (transCode == 1) {
            acct.deposit(amt);
        } 
        else if (transCode == 2) {
            acct.withdrawal(amt);
        } 
        else {
            return "Invalid transaction type.";
        }

        return acct.toString();
    }

    /**
     * Displays account balance and information
     */
    public String checkBalance(String acctID) {

        Account acct = findAccount(acctID);

        if (acct != null) {
            return acct.toString();
        }

        return "Account does not exist.";
    }

    /**
     * Helper method to find an account
     */
    private Account findAccount(String acctID) {

        for (Account acct : accounts) {
            if (acct.getID().equals(acctID)) {
                return acct;
            }
        }

        return null;
    }
}
