package Mastery;

import java.util.Scanner;

public class Customer {
    private String firstName, lastName;
    private String street, city, province, postalCode;

    
    public Customer(String fName, String lName)
    {
        firstName = fName;
        lastName = lName;
        street = "";
        city = "";
        province = "";
        postalCode = "";
    }

    
    public void changeCity()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter city: ");
        city = input.nextLine();
    }

  
    public void changeStreet()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter street: ");
        street = input.nextLine();
    }

 
    public void changeProvince()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter province: ");
        province = input.nextLine();
    }

   
    public void changePostalCode()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter postal code: ");
        postalCode = input.nextLine();
    }

    
    public String toString() {
        return firstName + " " + lastName + "\n" +
               "Street: " + street + "\n" +
               "City: " + city + "\n" +
               "Province: " + province + "\n" +
               "Postal Code: " + postalCode + "\n";
    }
}