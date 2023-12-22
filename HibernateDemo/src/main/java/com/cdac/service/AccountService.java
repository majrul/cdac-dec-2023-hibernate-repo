package com.cdac.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import com.cdac.dao.GenericDao;
import com.cdac.entity.Account;
import com.cdac.entity.Transaction;
import com.cdac.entity.Account.Status;
import com.cdac.exception.AccountException;

//classes which contain business logic are commonly
//referred to as service classes
public class AccountService {

	public void openAccount(Account account) {
		if(account.getBalance() >= 10000) {
			GenericDao dao = new GenericDao();
			account.setStatus(Status.ACTIVE);
			dao.save(account);
		}
		else
			throw new AccountException("Minimum 10,000/- required for opening account!");
	}
	
	public void closeAccount(int acno) {
		GenericDao dao = new GenericDao();
		Account account = (Account) dao.fetchById(Account.class, acno);
		if(account.getBalance() >= 0) {
			//withdraw(acno, account.getBalance());
			account.setStatus(Status.CLOSED);
			dao.save(account);
		}
		else
			throw new AccountException("Please clear your dues before closing the account!");
	}
	
	public void withdraw(int acno, double amount) {
		//balance should get updated in account table
		//a new record should get inserted in transaction table
		GenericDao dao = new GenericDao();
		Account account = (Account) dao.fetchById(Account.class, acno);
		if(account.getStatus() == Status.ACTIVE) {
			if(account.getBalance() > amount) {
				account.setBalance(account.getBalance() - amount);
				dao.save(account);
				Transaction tx = new Transaction();
				tx.setAccount(account);
				tx.setDateTime(LocalDateTime.now());
				tx.setAmount(amount);
				tx.setType("Withdraw");
				dao.save(tx);
			}
			else
				throw new AccountException("Cannot withdraw, Insufficient Balance!");
		}
		else
			throw new AccountException("Cannot withdraw, Account is inactive!");
	}

	public void deposit(int acno, double amount) {
		GenericDao dao = new GenericDao();
		Account account = (Account) dao.fetchById(Account.class, acno);
		if(account.getStatus() == Status.ACTIVE) {
			account.setBalance(account.getBalance() + amount);
			dao.save(account);
			Transaction tx = new Transaction();
			tx.setAccount(account);
			tx.setDateTime(LocalDateTime.now());
			tx.setAmount(amount);
			tx.setType("Deposit");
			dao.save(tx);
		}
		else
			throw new AccountException("Cannot deposit, Account is inactive!");
		
	}
	
	public void transfer(int fromAccno, int toAcno, double amount) {
		withdraw(fromAccno, amount);
		deposit(toAcno, amount);
	}

	public double balance(int acno) {
		return 0;
	}
	
	public List<Transaction> miniStatement(int acno) {
		//return recent 5 transactions of the given account
		return null;
	}
}
