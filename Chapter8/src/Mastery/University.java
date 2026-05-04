package Mastery;

public class University 
{
    public static void main(String[] args) 
    {
        Faculty f = new Faculty("Dr. Smith", 90000, "Computer Science");
        Staff s = new Staff("Jane Doe", 50000, "Administrator");

        System.out.println(f);
        System.out.println(s);

        System.out.println();
        System.out.println(f.getName() + " works in " + f.getDepartment());
        System.out.println(s.getName() + " is a " + s.getJobTitle());
    }
}