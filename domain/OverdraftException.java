package banking.domain;

public class OverdraftException extends Exception{
	private double deficit;
	
	public double getDeficit() 
	{
		return deficit;
	}
	
	public OverdraftException(String message, double init_deficit)
	{
		super (message);
		this.deficit = init_deficit;
	}
}
