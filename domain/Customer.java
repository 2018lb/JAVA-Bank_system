package banking.domain;
import java.util.ArrayList;
public class Customer implements Comparable<Customer>{
	private String firstName;
	private String lastName;
	ArrayList<Account> account = new ArrayList<Account>();
	
	public Customer(String f, String l)
	{
		this.firstName = f;
		this.lastName = l;
	}

	public String getFirstName ()
	{
		return this.firstName;
	}
	
	public String getLastName  ()
	{
		return this.lastName;
	}
	
	public Account getAccount   (int index)
	{
		return this.account.get(index);
	}
	
	public void addAccount (Account account )
	{
		this.account.add(account);
	}
	
	public int getNumOfAccounts()
	{
		return account.size();
	}
	
	public int compareTo(Customer k) {
		if (lastName.compareTo(k.lastName) != 0) return lastName.compareTo(k.lastName);
		return firstName.compareTo(k.firstName);
	}
}
