package com.adem.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Description of file WithdrawalOperation <br>
 * 
 * @author adem
 *
 *         It represents a withdrawal operation for an account <br>
 */
@Entity
@DiscriminatorValue(value = "WO")
public class WithdrawalOperation extends Operation {

	public WithdrawalOperation() {
		super();
	}

	public WithdrawalOperation(Date operationDate, double amount, Account account) {
		super(operationDate, amount, account);
	}

}
