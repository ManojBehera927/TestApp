package com.capgemini.service;

import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InsufficientInitialAmountException;
import com.capgemini.exceptions.InvalidAccountNumberException;
import com.capgemini.model.Account;
import com.capgemini.repository.AccountRepository;
import com.capgemini.repository.AccountRepositoryImpl;

public class AccountServiceImpl implements AccountService {
	
	AccountRepository accountRepository = new AccountRepositoryImpl();
	
	
	/* (non-Javadoc)
	 * @see com.capgemini.service.AccountService#createAccount(int, int)
	 */
	@Override
	public Account createAccount(int accountNumber,int amount) throws InsufficientInitialAmountException
	{
		if(amount<500)
		{
			throw new InsufficientInitialAmountException();
		}
		
		Account account = new Account();
		account.setAccountNumber(accountNumber);
		account.setAmount(amount);
		
		if(accountRepository.save(account))
		{
			return account;
		}
		
		return null;
		}
		



/* (non-Javadoc)
 * @see com.capgemini.service.AccountService#depositAmount(int, int)
 */
@Override
public int depositAmount(int accountNumber,int amount)throws InvalidAccountNumberException
{
	return 0;
}


/* (non-Javadoc)
 * @see com.capgemini.service.AccountService#withdrawAmount(int, int)
 */
@Override
public int withdrawAmount(int accountNumber,int amount)throws InvalidAccountNumberException,InsufficientBalanceException
{
	return 0;
}

}