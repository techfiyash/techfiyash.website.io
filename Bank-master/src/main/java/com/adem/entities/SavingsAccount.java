package com.adem.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Description of file SavingsAccount.java <br>
 * 
 * @author adem
 * 
 *         It represents a saving account in bank <br>
 *
 */
@Entity
@DiscriminatorValue(value = "SA")
public class SavingsAccount extends Account {

	private double interestRate;

	public SavingsAccount() {
		super();
	}

	public SavingsAccount(String accountId, Date creationDate, double discount, Customer customer,
			double interestRate) {
		super(accountId, creationDate, discount, customer);
		this.interestRate = interestRate;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

}
