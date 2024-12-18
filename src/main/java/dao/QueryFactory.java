package dao;

import java.util.List;

public class QueryFactory {
	public static String getCondition(String operator, String condition) {
		switch (operator) {
		case "like": {
			return condition + " LIKE CONCAT('%', :" + condition + ", '%')";
		}
		case ">":
		case ">=":
		case "<=":
		case "<":
		case "!=":
		case "=":
			return condition + operator + " :" + condition;
		default:
			return null;
		}
	}

	public static String muiltiConditions(List<String> operator, List<String> condition, List<String> typeLink) {
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append(getCondition(operator.get(0), condition.get(0)));
		for (int i = 0; i < typeLink.size(); i++) {
			queryBuilder.append(" " + typeLink.get(i));
			queryBuilder.append(getCondition(operator.get(i + 1), condition.get(i + 1)));
		}
		return queryBuilder.toString();
	}
}
