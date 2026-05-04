package Mastery;

public class Minivan extends Vehicle 
{
    public Minivan(String make, String model, int year,
                   double city, double hwy, int seats, double cargo) 
    {
        super(make, model, year, city, hwy, seats, cargo);
    }

    @Override
    public void honk() 
    {
       
    }
}