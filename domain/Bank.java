
package banking.domain;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;

public class Bank {
	private Customer customers[] = new Customer[10];
	private static Bank bankInstance = new Bank();
	private int numberOfCustomers = 0;
	
	public static Bank getBank()
	{
		return bankInstance;
	}
	
	public void addCustomer(String f, String l)
	{
		customers[numberOfCustomers++] = new Customer(f,l);
	}
	
	public int getNumOfCustomers()
	{
		return numberOfCustomers;
	}
	
	public Customer getCustomer(int i)
	{
		return customers[i];
	}
	
	public void sortCustomers ()
	{
		
		Arrays.sort(customers, 0, numberOfCustomers);
		 /*for (int i = 0; i < numberOfCustomers - 1; i++)
		 {
			 for (int j = i + 1; j < numberOfCustomers; j++)
			 {
				 if (customers[i].compareTo(customers[j]) > 0)
				 {
					 Customer temp = customers[i];
					 customers[i] = customers[j];
					 customers[j] = temp;
				 }
			 }
		 }*/
	}
	
	public  void searchCustomers (String f, String l)
	{
		int k = -1;
		for (int i = 0; i < numberOfCustomers; i++)
		{
			if (f.equals(this.customers[i].getFirstName())&&l.equals(this.customers[i].getLastName()))
			{
				k = i; 
				break;
			}
		}
		if (k == -1) 
		{
			System.out.println("The customer was not found!");
			return;
		}
	    NumberFormat currency_format = NumberFormat.getCurrencyInstance(Locale.ITALY);
	    
		Customer customer = this.customers[k];

	      System.out.println();
	      System.out.println("Search customer: "
				 + customer.getLastName() + ", "
				 + customer.getFirstName());

	      for ( int acct_idx = 0; acct_idx < customer.getNumOfAccounts(); acct_idx++ ) {
		Account account = customer.getAccount(acct_idx);
		String  account_type = "";

		// Determine the account type
		if ( account instanceof SavingsAccount ) {
		  account_type = "Savings Account";
		} else if ( account instanceof CheckingAccount ) {
		  account_type = "Checking Account";
		} else {
		  account_type = "Unknown Account Type";
		}

		// Print the current balance of the account
		System.out.println("    " + account_type + ": current balance is "
				 + currency_format.format(account.getBalance()));
	     }
	    
		
	}
}
