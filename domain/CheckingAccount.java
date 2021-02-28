package banking.domain;

public class CheckingAccount extends Account
{
	private double overdraftProtection;
	
	public CheckingAccount(double balance)
	{
		super(balance);
	}
	
	public CheckingAccount(double balance, double protect)
	{
		super(balance);
		overdraftProtection = protect;
	}
	
	public double getOverdraftProtection()
	{
		return overdraftProtection;
	}
	
	public void withdraw (double amt) throws OverdraftException
	{
		if (amt <= this.balance)
		{
			this.balance -= amt;
		}else
		if (amt <= this.balance+this.overdraftProtection)
		{
			this.overdraftProtection -= amt - this.balance;
			this.balance = 0;
		}
		
		if (amt > this.balance+this.overdraftProtection)
		{
			if (overdraftProtection == 0)
				throw new OverdraftException("No overdraft protection", amt - balance);
			
			throw new OverdraftException("Insufficient funds for overdraft protection", amt);
		}
		
		
	}
}
