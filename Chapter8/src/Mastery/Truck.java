package Mastery;

public class Truck extends Vehicle 
{
    public Truck(String make, String model, int year,
                 double city, double hwy, int seats, double cargo) 
    {
        super(make, model, year, city, hwy, seats, cargo);
    }

    @Override
    public void honk() 
    {
    	
    }
}