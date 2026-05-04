package Mastery;

import java.text.NumberFormat;

public class Account
{
    private double balance;
    Customer cust;
    private String acctID;

    public Account(double bal, String fName, String lName)
    {
        balance = bal;
        cust = new Customer(fName, lName);
        acctID = fName.substring(0, 1).toUpperCase() + lName;
    }

    public Account(String ID)
    {
        balance = 0;
        cust = new Customer("","");
        acctID = ID;
    }

    public String getID()
    {
        return acctID;
    }

    public double getBalance()
    {
        return balance;
    }

    public void deposit(double amt)
    {
        if (amt > 0)
        {
            balance += amt;
        }
    }

    public void withdrawal(double amt)
    {
        if (amt <= balance)
        {
            balance -= amt;
        }
        else
        {
            System.out.println("Not enough money in account.");
        }
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof Account)
        {
            Account other = (Account) obj;
            return acctID.equals(other.acctID);
        }
        return false;
    }

    @Override
    public String toString()
    {
        NumberFormat money = NumberFormat.getCurrencyInstance();

        return acctID + "\n" +
               cust.toString() +
               "Current balance: " + money.format(balance);
    }
}