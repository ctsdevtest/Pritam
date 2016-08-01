package com.rest.pritam.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.rest.pritam.model.Account;
import com.rest.pritam.model.Account;

public class AccountDao {
	@SuppressWarnings("unchecked")
	public List<Account> getAllAccounts() {
		List<Account> accountList = null;
		try {
			/*File file = new File("C:\Users\Pritam\workspace_RESTapi\BankAcntStmt_RESTful\src\main\java\com\rest\resources/Accounts.dat");*/
			File file = new File("C://Users/Pritam/Accounts.dat");
			if (!file.exists()) {
				Account account1 = new Account(1, "Pritam", 25000,"Saving");
				Account account2 = new Account(2, "Princy", 22000,"Current");
				Account account3 = new Account(3, "Preeti", 23000,"Saving");
				Account account4 = new Account(4, "Rahul", 24000,"Saving");

				accountList = new ArrayList<Account>();
				accountList.add(account1);
				accountList.add(account2);
				accountList.add(account3);
				accountList.add(account4);

				saveAccountList(accountList);
			} else {
				FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);
				accountList = (List<Account>) ois.readObject();
				ois.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return accountList;
	}

	private void saveAccountList(List<Account> accountList) {
		try {
			File file = new File("Accounts.dat");
			FileOutputStream fos;

			fos = new FileOutputStream(file);

			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(accountList);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
			saveAccountList(accountList);
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
				saveAccountList(accountList);
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
				saveAccountList(accountList);
				return 1;
			}
		}
		return 0;
	}
}
