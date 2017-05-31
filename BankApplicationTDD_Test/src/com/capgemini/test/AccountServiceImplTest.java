package com.capgemini.test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import com.capgemini.exceptions.InsufficientInitialAmountException;
import com.capgemini.model.Account;
import com.capgemini.service.AccountService;
import com.capgemini.service.AccountServiceImpl;
public class AccountServiceImplTest {

	
	AccountService accountService;
	
	
	@Before
	public void setUp() throws Exception {
	
		accountService = new AccountServiceImpl();
	}

	/*
	 * create account
	 * 1.when the amount is less than 500 system should throw exception
	 * 2.when the valid info is passed account should be created successfully
	 */

	
	
	@Test(expected=com.capgemini.exceptions.InsufficientInitialAmountException.class)
	public void whenTheAmountIsLessThanFiveHundredSystemShouldThrowException() throws InsufficientInitialAmountException
	{
		accountService.createAccount(101, 300);
	}
	
	@Test
	public void whenTheValidInfoIsPassedAccountShouldBeCreatedSuccessfully() throws InsufficientInitialAmountException
	{
		Account account =new Account();
		account.setAccountNumber(101);
		account.setAmount(5000);
		
	    assertEquals(account, accountService.createAccount(101, 5000));
		
	}
}

