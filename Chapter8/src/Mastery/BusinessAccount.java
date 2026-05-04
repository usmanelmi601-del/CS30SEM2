package Mastery;

public class BusinessAccount extends Account
{
    private static final double MIN_BALANCE = 500.0;
    private static final double FEE = 10.0;

    public BusinessAccount(double bal, String fName, String lName)
    {
        super(bal, fName, lName);
    }

    public BusinessAccount(String ID)
    {
        super(ID);
    }

    @Override
    public void withdrawal(double amt)
    {
        super.withdrawal(amt);

        if (getBalance() < MIN_BALANCE)
        {
            System.out.println("Business fee applied: $" + FEE);
            super.withdrawal(FEE);
        }
    }
}