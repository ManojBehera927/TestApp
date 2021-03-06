package com.capgemini.repository;

import java.util.LinkedList;
import java.util.List;

import com.capgemini.exceptions.InvalidAccountNumberException;
import com.capgemini.model.Account;

public class AccountRepositoryImpl implements AccountRepository {

	List<Account> accounts = new LinkedList<>();
	@Override
	public boolean save(Account account) {
		accounts.add(account);
		return true;
	}

	@Override
	public Account searchAccount(int accountNumber) throws InvalidAccountNumberException {
		for(Account account : accounts)
		{
			if(account.getAccountNumber()==accountNumber)
			{
				return account;
			}
		}
		throw new InvalidAccountNumberException();
	}

}
