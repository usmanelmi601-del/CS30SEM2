package Mastery;

import java.text.NumberFormat;

public class Account {

    private double balance;
    private Customer cust;
    private String acctID;

    /**
     * Constructor - creates full account
     */
    public Account(double bal, String fName, String lName) {

        this.balance = Math.max(0, bal); // prevent negative balance
        this.cust = new Customer(fName, lName);

        // Safe account ID creation
        if (fName.length() > 0 && lName.length() > 0) {
            this.acctID = fName.substring(0, 1).toUpperCase() + lName.toUpperCase();
        } else {
            this.acctID = "UNKNOWN";
        }
    }

    /**
     * Constructor - used for searching by ID
     */
    public Account(String ID) {
        this.balance = 0;
        this.cust = new Customer("", "");
        this.acctID = ID;
    }

    /**
     * Returns account ID (IMPORTANT: return only ID)
     */
    public String getID() {
        return acctID;
    }

    /**
     * Returns current balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Deposit money
     */
    public void deposit(double amt) {
        if (amt > 0) {
            balance += amt;
        }
    }

    /**
     * Withdraw money if enough balance
     */
    public void withdrawal(double amt) {
        if (amt > 0 && amt <= balance) {
            balance -= amt;
        }
    }

    /**
     * Proper equals override (SAFE)
     */
    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (!(obj instanceof Account)) return false;

        Account other = (Account) obj;
        return this.acctID.equals(other.acctID);
    }

    /**
     * Required when equals is overridden
     */
    @Override
    public int hashCode() {
        return acctID.hashCode();
    }

    /**
     * String representation of account
     */
    @Override
    public String toString() {

        NumberFormat money = NumberFormat.getCurrencyInstance();

        return "Account ID: " + acctID +
               "\nCustomer: " + cust.toString() +
               "\nCurrent Balance: " + money.format(balance);
    }
}