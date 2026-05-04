package Mastery;

import java.util.Scanner;

public class VehicleTest
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Choose a vehicle:");
        System.out.println("1. Car");
        System.out.println("2. Truck");
        System.out.println("3. Minivan");
        System.out.print("Enter choice: ");
        int choice = input.nextInt();
        input.nextLine(); 

        
        System.out.print("Enter make: ");
        String make = input.nextLine();

        System.out.print("Enter model: ");
        String model = input.nextLine();

        System.out.print("Enter year: ");
        int year = input.nextInt();

        System.out.println();

        if (choice == 1)
        {
            Car car = new Car(make, model, year, 14.0, 10.0, 5, 23.0);

            System.out.println("Car:");
            displayVehicle(car);
        }
        else if (choice == 2)
        {
            Truck truck = new Truck(make, model, year, 16.0, 12.0, 5, 62.0);

            System.out.println("Truck:");
            displayVehicle(truck);
        }
        else if (choice == 3)
        {
            Minivan van = new Minivan(make, model, year, 13.0, 9.0, 8, 101.0);

            System.out.println("Minivan:");
            displayVehicle(van);
        }
        else
        {
            System.out.println("Invalid choice.");
        }

        input.close();
    }

    public static void displayVehicle(Vehicle v)
    {
        System.out.println("Make: " + v.getMake());
        System.out.println("Model: " + v.getModel());
        System.out.println("Year: " + v.getYear());
        System.out.println("City Fuel: " + v.getFuelEconomyCity());
        System.out.println("Highway Fuel: " + v.getFuelEconomyHwy());
        System.out.println("Seating: " + v.getSeatingCapacity());
        System.out.println("Cargo Volume: " + v.getCargoVolume());
    }
}