package com.rest.pritam.dao;

import java.util.ArrayList;
import java.util.List;

import com.rest.pritam.model.*;

public class AccountDao1 {
	static List<Account> accountList = getAccountList();

	public AccountDao1() {
		super();
		if (accountList == null) {
			accountList = new ArrayList<Account>();
			// Creating some objects of Country while initializing
			/*Account account1 = new Account(1, "princy", 30000, "Savings");
			Account account2 = new Account(2, "preeti", 60000, "Current");
			Account account3 = new Account(3, "vandana", 50000, "Current");
			Account account4 = new Account(4, "shubhi", 140000, "Savings");
			Account account5 = new Account(5, "pritam", 140000, "Current");
			Account account6 = new Account(6, "himanshu", 70000, "Savings");*/
			accountList.add(new Account(1, "princy", 300, "Savings"));
			accountList.add(new Account(2, "preeti", 600, "Current"));
			accountList.add(new Account(3, "vandana", 500, "Current"));
			accountList.add(new Account(4, "shubhi", 1400, "Savings"));
			accountList.add(new Account(5, "pritam", 1400, "Current"));
			accountList.add(new Account(6, "himanshu", 700, "Savings"));
		}
	}

	public List<Account> getAllAccounts() {
		List<Account> accounts = new ArrayList<Account>(accountList);
		return accounts;
	}

	public Account getAccount(int id) {
		List<Account> accounts = getAllAccounts();
		for (Account account : accounts) {
			if (account.getId() == id) {
				return account;
			}
		}
		return null;
	}

	public int addAccount(Account pAccount) {
		List<Account> accountList = getAllAccounts();
		boolean accountExists = false;
		for (Account account : accountList) {
			if (account.getId() == pAccount.getId()) {
				accountExists = true;
				break;
			}
		}
		if (!accountExists) {
			accountList.add(pAccount);

			return 1;
		}
		return 0;
	}

	public int updateAccount(Account pAccount) {
		List<Account> accountList = getAllAccounts();

		for (Account account : accountList) {
			if (account.getId() == pAccount.getId()) {
				int index = accountList.indexOf(account);
				accountList.set(index, pAccount);

				return 1;
			}
		}
		return 0;
	}

	public int deleteAccount(int id) {
		List<Account> accountList = getAllAccounts();

		for (Account account : accountList) {
			if (account.getId() == id) {
				int index = accountList.indexOf(account);
				accountList.remove(index);

				return 1;
			}
		}
		return 0;
	}

	public static List<Account> getAccountList() {
		return accountList;
	}

	/*public static void main(String[] args) {
		AccountDao1 accntdao1=new AccountDao1();
		System.out.println(accntdao1.getAllAccounts());
	}*/
}
