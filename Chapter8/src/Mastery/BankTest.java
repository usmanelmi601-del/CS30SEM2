package Mastery;

import java.util.Scanner;

public class BankTest
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Choose account type:");
        System.out.println("1. Personal Account");
        System.out.println("2. Business Account");
        System.out.print("Enter choice: ");
        int choice = input.nextInt();
        input.nextLine(); 

        
        System.out.print("Enter first name: ");
        String fName = input.nextLine();

        System.out.print("Enter last name: ");
        String lName = input.nextLine();

        System.out.print("Enter starting balance: ");
        double balance = input.nextDouble();
        input.nextLine();

        Account acct;

        if (choice == 1)
        {
            acct = new PersonalAccount(balance, fName, lName);
        }
        else if (choice == 2)
        {
            acct = new BusinessAccount(balance, fName, lName);
        }
        else
        {
            System.out.println("Invalid choice.");
            input.close();
            return;
        }

        
        System.out.println("\nEnter address info:");
        acct.cust.changeStreet();
        acct.cust.changeCity();
        acct.cust.changeProvince();
        acct.cust.changePostalCode();

        
        System.out.println("\n=== Account Created ===");
        System.out.println(acct);

        
        System.out.print("\nEnter amount to withdraw: ");
        double withdrawAmt = input.nextDouble();

        acct.withdrawal(withdrawAmt);

        System.out.println("\n=== Account After Withdrawal ===");
        System.out.println(acct);

        input.close();
    }
}