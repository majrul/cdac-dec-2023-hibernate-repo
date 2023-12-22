package com.cdac.app;

import com.cdac.entity.Account;
import com.cdac.service.AccountService;

public class AccountApp {

	public static void main(String[] args) {
		AccountService accServ = new AccountService();
		
		//open account
		/*Account acc = new Account();
		acc.setName("Vipul");
		acc.setType("Savings");
		acc.setBalance(15000);
		accServ.openAccount(acc);*/
		
		//close account
		//accServ.closeAccount(2);
		
		//accServ.withdraw(3, 1000);
		
		//accServ.deposit(3, 5000);
		
		accServ.transfer(1, 3, 1000);
	}
}
