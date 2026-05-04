package Mastery;

public class Car extends Vehicle 
{
    public Car(String make, String model, int year,
               double city, double hwy, int seats, double cargo) 
    {
        super(make, model, year, city, hwy, seats, cargo);
    }

    @Override
    public void honk() 
    {
    
    }
}