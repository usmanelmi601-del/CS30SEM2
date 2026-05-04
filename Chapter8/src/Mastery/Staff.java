package Mastery;

public class Staff extends UEmployee
{
    private String jobTitle;

    public Staff(String n, double s, String title)
    {
        super(n, s);
        jobTitle = title;
    }

    public String getJobTitle()
    {
        return jobTitle;
    }

    public String toString()
    {
        return super.toString() + ", Staff, Job Title: " + jobTitle;
    }
}