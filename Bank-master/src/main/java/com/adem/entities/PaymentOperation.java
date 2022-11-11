package com.adem.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Description of file PaymentOperation.java
 * 
 * @author adem
 *
 *         It represents a payment operation at an account <br>
 */
@Entity
@DiscriminatorValue(value = "PO")
public class PaymentOperation extends Operation {

	public PaymentOperation() {
		super();
	}

	public PaymentOperation(Date operationDate, double amount, Account account) {
		super(operationDate, amount, account);
	}

}
