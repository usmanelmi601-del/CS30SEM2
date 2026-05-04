package Mastery;

public class UEmployee 
{
    private String name;
    private double salary;

    public UEmployee(String n, double s)
    {
        name = n;
        salary = s;
    }

    public String getName()
    {
        return name;
    }

    public double getSalary()
    {
        return salary;
    }

    public String toString()
    {
        return name + ", Salary: " + salary;
    }
}