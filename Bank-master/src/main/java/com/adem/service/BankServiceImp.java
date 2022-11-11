package com.adem.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adem.dao.AccountRepository;
import com.adem.dao.OperationRepository;
import com.adem.entities.Account;
import com.adem.entities.CurrentAccount;
import com.adem.entities.Operation;
import com.adem.entities.PaymentOperation;
import com.adem.entities.WithdrawalOperation;

@Service
@Transactional
public class BankServiceImp implements IBankService {

	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private OperationRepository operationRepository;

	@Override
	public Account getAccountById(String accountId) {
		Account account = accountRepository.findOne(accountId);
		if (account == null)
			throw new RuntimeException("unfound account");

		return account;
	}

	@Override
	public void payToAccount(String accountId, double amount) {
		Account currentAcc = getAccountById(accountId);
		PaymentOperation paymentOp = new PaymentOperation(new Date(), amount,
				currentAcc);
		operationRepository.save(paymentOp);
		currentAcc.setDiscount(currentAcc.getDiscount() + amount);
		accountRepository.save(currentAcc);

	}

	@Override
	public void removeFromAccount(String accountId, double amount) {
		Account currentAcc = getAccountById(accountId);
		double solde = 0;
		if (currentAcc instanceof CurrentAccount)
			solde = ((CurrentAccount) currentAcc).getOverdraft();
		if (currentAcc.getDiscount() + solde < amount)
			throw new RuntimeException("Insufficient discount ");
		WithdrawalOperation withdrawalOp = new WithdrawalOperation(new Date(),
				amount, currentAcc);
		operationRepository.save(withdrawalOp);
		currentAcc.setDiscount(currentAcc.getDiscount() - amount);
		accountRepository.save(currentAcc);

	}

	@Override
	public void transfer(String accountOriginId, String accountDestId,
			double amount) {
		if (accountOriginId.equals(accountDestId))
			throw new RuntimeException(
					"Impossible operation: account id must be different");
		removeFromAccount(accountOriginId, amount);
		payToAccount(accountDestId, amount);

	}

	@Override
	public Page<Operation> getAccountOperationByPage(String accountId,
			int page, int size) {
		return operationRepository.getAccountOperationsByPage(accountId,
				new PageRequest(page, size));
	}

}
