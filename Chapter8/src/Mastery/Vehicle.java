package Mastery;

public abstract class Vehicle 
{
    private String make;
    private String model;
    private int year;

    private double fuelEconomyCity;
    private double fuelEconomyHwy;
    private int seatingCapacity;
    private double cargoVolume;

    public Vehicle(String make, String model, int year,
                   double city, double hwy, int seats, double cargo) 
    {
        this.make = make;
        this.model = model;
        this.year = year;
        this.fuelEconomyCity = city;
        this.fuelEconomyHwy = hwy;
        this.seatingCapacity = seats;
        this.cargoVolume = cargo;
    }

    public String getMake() { return make; }
    public String getModel() { return model; }
    public int getYear() { return year; }

    public double getFuelEconomyCity() { return fuelEconomyCity; }
    public double getFuelEconomyHwy() { return fuelEconomyHwy; }
    public int getSeatingCapacity() { return seatingCapacity; }
    public double getCargoVolume() { return cargoVolume; }

    public abstract void honk();
}