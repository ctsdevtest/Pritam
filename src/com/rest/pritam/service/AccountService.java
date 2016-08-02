package com.rest.pritam.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.rest.pritam.dao.AccountDao1;
import com.rest.pritam.dao.StatementsDao;
import com.rest.pritam.model.Account;
import com.rest.pritam.model.Statement;

@Path("/accountApi")
public class AccountService {
	AccountDao1 accountDao = new AccountDao1();

	StatementsDao statementsDao = new StatementsDao();

	private static final String SUCCESS_RESULT = "<result>success</result>";
	private static final String FAILURE_RESULT = "<result>failure</result>";

	@GET
	@Path("/accounts")
	@Produces(MediaType.APPLICATION_XML)
	public List<Account> getAccounts() {
		return accountDao.getAllAccounts();
	}

	@GET
	@Path("/account/{accountid}")
	@Produces(MediaType.APPLICATION_XML)
	public Account getAccount(@PathParam("accountid") int accountid) {
		return accountDao.getAccount(accountid);
	}

	@GET
	@Path("/account/{accountid}/statements")
	@Produces(MediaType.APPLICATION_XML)
	public List<Statement> getAccountStatements(@PathParam("accountid") int accountid) {
		return statementsDao.getStatementOnAccId(accountid);
	}

	@GET
	@Path("/account/{accountid}/statements/sorted")
	@Produces(MediaType.APPLICATION_XML)
	public List<Statement> getAccountStatementsInSortedOrder(@PathParam("accountid") int accountid) {
		return statementsDao.getSortedStatements(accountid);
	}

	@GET
	@Path("/account/{accountId}/statements/{pageNumberDate}/{endDate}")
	@Produces(MediaType.APPLICATION_XML)
	public List<Statement> getAccountStatementsOnDate(@PathParam("accountId") int accountid,
			@PathParam("pageNumberDate") String pageNumberDate, @PathParam("endDate") String endDate) {

		return statementsDao.getStatementsWithinDates(accountid, pageNumberDate, endDate);
	}

	

	@PUT
	@Path("/accounts")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String createAccount(@FormParam("id") int id, @FormParam("name") String name,
			@FormParam("balance") int balance, @FormParam("accnt_type") String accnt_type,
			@Context HttpServletResponse servletResponse) throws IOException {
		Account account = new Account(id, name, balance, accnt_type);
		int result = accountDao.addAccount(account);
		if (result == 1) {
			return SUCCESS_RESULT;
		}
		return FAILURE_RESULT;
	}

	@POST
	@Path("/accounts")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String updateAccount(@FormParam("id") int id, @FormParam("name") String name,
			@FormParam("balance") int balance, @FormParam("accnt_type") String accnt_type,
			@Context HttpServletResponse servletResponse) throws IOException {
		Account account = new Account(id, name, balance, accnt_type);
		int result = accountDao.updateAccount(account);
		if (result == 1) {
			return SUCCESS_RESULT;
		}
		return FAILURE_RESULT;
	}

	@DELETE
	@Path("/accounts/{accountid}")
	@Produces(MediaType.APPLICATION_XML)
	public String deleteAccount(@PathParam("accountid") int accountid) {
		int result = accountDao.deleteAccount(accountid);
		if (result == 1) {
			return SUCCESS_RESULT;
		}
		return FAILURE_RESULT;
	}

}
