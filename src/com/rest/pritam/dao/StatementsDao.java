package com.rest.pritam.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;



import com.rest.pritam.model.Statement;
import com.rest.pritam.util.StatementSortComparator;

public class StatementsDao {
	

	public List<Statement> getAllStatements() throws ParseException {
		List<Statement> statementList = null;

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		/*
		 * String dateInString1 = "12-07-2016"; String dateInString2 =
		 * "14-07-2016"; String dateInString3 = "15-07-2016"; String
		 * dateInString4 = "18-07-2016"; String dateInString5 = "20-07-2016";
		 * 
		 * Date date1 = sdf.parse(dateInString1); Date date2 =
		 * sdf.parse(dateInString2); Date date3 = sdf.parse(dateInString3); Date
		 * date4 = sdf.parse(dateInString4); Date date5 =
		 * sdf.parse(dateInString5); System.out.println(date1);
		 */

		/*
		 * Statement statement1 = new Statement(101, 1, sdf.parse("12-07-2016"),
		 * "debit", 3000); Statement statement2 = new Statement(102, 1,
		 * sdf.parse("14-07-2015"), "credit", 2000);
		 * 
		 * Statement statement3 = new Statement(103, 2, sdf.parse("15-07-2016"),
		 * "debit", 100); Statement statement4 = new Statement(104, 3,
		 * sdf.parse("18-07-2016"), "credit", 500); Statement statement5 = new
		 * Statement(105, 3, sdf.parse("20-07-2016"), "debit", 24000);
		 * 
		 * Statement statement6 = new Statement(106, 1, sdf.parse("10-05-2016"),
		 * "debit", 3000); Statement statement7 = new Statement(107, 1,
		 * sdf.parse("14-06-2015"), "credit", 2000); Statement statement8 = new
		 * Statement(108, 1, sdf.parse("12-07-2016"), "debit", 3000); Statement
		 * statement9 = new Statement(109, 1, sdf.parse("14-08-2015"), "credit",
		 * 2000);
		 */

		statementList = new ArrayList<Statement>();
		statementList.add(new Statement(101, 1, sdf.parse("12-07-2016"), "debit", 3000));
		statementList.add(new Statement(102, 5, sdf.parse("14-07-2015"), "credit", 2000));
		statementList.add(new Statement(103, 2, sdf.parse("15-07-2016"), "debit", 100));
		statementList.add(new Statement(104, 5, sdf.parse("18-07-2016"), "credit", 500));
		statementList.add(new Statement(105, 3, sdf.parse("20-07-2016"), "debit", 24000));

		statementList.add(new Statement(106, 1, sdf.parse("10-05-2016"), "debit", 3000));
		statementList.add(new Statement(107, 5, sdf.parse("14-06-2015"), "credit", 2000));
		statementList.add(new Statement(108, 5, sdf.parse("12-07-2016"), "debit", 3000));
		statementList.add(new Statement(109, 1, sdf.parse("14-08-2015"), "credit", 2000));

		return statementList;
	}

	public List<Statement> getStatementOnAccId(int accId) {

		List<Statement> statementsWithAcc = new ArrayList<>();
		try {
			List<Statement> statements = this.getAllStatements();
			if (null != statements && !statements.isEmpty()) {
				for (Statement statement : statements) {
					int statementAccId = statement.getAcc_id();
					if (accId == statementAccId) {
						statementsWithAcc.add(statement);
					}
				}
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}

		return statementsWithAcc;
	}

	public List<Statement> getSortedStatements(int accId) {

		List<Statement> statementsWithAccSorted = new ArrayList<>();

		try {
			List<Statement> statements = getStatementOnAccId(accId);
			if (null != statements && !statements.isEmpty()) {
				Collections.sort(statements, new StatementSortComparator());
			}
			statementsWithAccSorted = statements;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return statementsWithAccSorted;
	}

	public List<Statement> getStatementsWithinDates(int accId, String pageNumberDate, String endDate) {

		List<Statement> statementsWithDates = new ArrayList<>();

		try {

			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			Date pageNumberDt = formatter.parse(pageNumberDate);
			Date endDt = formatter.parse(endDate);

			List<Statement> statements = this.getSortedStatements(accId);

			if (null != statements && !statements.isEmpty()) {

				for (Statement statement : statements) {
					Date statementDate = statement.getDate();

					if (statementDate.compareTo(pageNumberDt) >= 0 && statementDate.compareTo(endDt) <= 0) {
						statementsWithDates.add(statement);
					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return statementsWithDates;
	}

	public List<Statement> getAllStatementPaginated(int pageNumber, int pageSize) throws ParseException {
		{

			ArrayList<Statement> list = (ArrayList<Statement>) getAllStatements();

			if (pageNumber + pageSize > list.size()) {
				return new ArrayList<Statement>();
			}

			return list.subList(pageNumber, pageNumber + pageSize);

		}

	}

}
