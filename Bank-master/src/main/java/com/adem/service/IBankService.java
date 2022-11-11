package com.adem.service;

import org.springframework.data.domain.Page;

import com.adem.entities.Account;
import com.adem.entities.Operation;

/**
 * Description of file IBankService.java
 * 
 * @author adem
 *
 *         This interface provide the functional requirement of the bank
 *         application <br>
 */
public interface IBankService {

	public Account getAccountById(String accountId);

	/**
	 * It is used to add the specified amount at the discount of the specified
	 * account <br>
	 * 
	 * @param accountId
	 * @param amount
	 */
	public void payToAccount(String accountId, double amount);

	/**
	 * This method is used to remove the specified amount from the specified
	 * account
	 * 
	 * @param accountId
	 * @param amount
	 */
	public void removeFromAccount(String accountId, double amount);

	/**
	 * This method is used to make a transfer between two account.
	 * 
	 * @param accountOriginId
	 * @param accountDestId
	 * @param amount
	 */

	public void transfer(String accountOriginId, String accountDestId, double amount);

	/**
	 * This method is used to get operation of the specified account by page
	 * 
	 * @param accountId
	 * @param page
	 * @param size
	 * @return
	 */

	public Page<Operation> getAccountOperationByPage(String accountId, int page, int size);

}
