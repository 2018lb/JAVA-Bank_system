package banking.domain;

public class Account
{
	protected double balance;

	public Account(double init_balance)
	{
		this.balance = init_balance;
	}

	public double getBalance()
	{
		return this.balance;
	}
	public boolean deposit(double amount)
	{
		this.balance += amount;
		return true;
	}
	public void withdraw(double amount) throws OverdraftException
	{
		if (amount > this.balance) 
			throw new OverdraftException("Insufficient funds", amount - this.balance);
		else
			this.balance -= amount;
	}
	
	public double getOverdraftProtection()
	{
		return 0;
	}
}

