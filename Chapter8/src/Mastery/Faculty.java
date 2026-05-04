package Mastery;

public class Faculty extends UEmployee
{
    private String department;

    public Faculty(String n, double s, String dept)
    {
        super(n, s);
        department = dept;
    }

    public String getDepartment()
    {
        return department;
    }

    public String toString()
    {
        return super.toString() + ", Faculty, Department: " + department;
    }
}
