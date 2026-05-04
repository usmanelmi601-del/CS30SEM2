package Mastery;

public class PersonalAccount extends Account
{
    private static final double MIN_BALANCE = 100.0;
    private static final double FEE = 2.0;

    public PersonalAccount(double bal, String fName, String lName)
    {
        super(bal, fName, lName);
    }

    public PersonalAccount(String ID)
    {
        super(ID);
    }

    @Override
    public void withdrawal(double amt)
    {
        super.withdrawal(amt);

        if (getBalance() < MIN_BALANCE)
        {
            System.out.println("Personal fee applied: $" + FEE);
            super.withdrawal(FEE);
        }
    }
}