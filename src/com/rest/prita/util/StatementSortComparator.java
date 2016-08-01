package com.rest.prita.util;


import java.util.Comparator;

import com.rest.pritam.model.Statement;

public class StatementSortComparator implements Comparator<Statement> {
	@Override
	public int compare(Statement o1, Statement o2) {
		return o1.getDate().compareTo(o2.getDate());
	}
}
