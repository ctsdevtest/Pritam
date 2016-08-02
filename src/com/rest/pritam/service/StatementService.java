package com.rest.pritam.service;

import java.text.ParseException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.rest.pritam.dao.StatementsDao;
import com.rest.pritam.model.Statement;

@Path("/statementApi")
public class StatementService {
	StatementsDao statementsDao = new StatementsDao();
	
	
	@GET
	@Path("/statements/pagination/{pageNumber}/{pageSize}")
	@Produces(MediaType.APPLICATION_XML)
	public List<Statement> getStatementsPaginated(@QueryParam("pageNumber") int pageNumber, @QueryParam("pageSize") int pageSize)
			throws ParseException {

		if (pageNumber > 0 && pageSize > 0) {
			return statementsDao.getAllStatementPaginated(pageNumber, pageSize);
		}

		return statementsDao.getAllStatements();

	}
}
