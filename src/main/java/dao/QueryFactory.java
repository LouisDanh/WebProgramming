package dao;

import java.util.List;

public class QueryFactory {
	// Các toán tử SQL
	public static final String LIKE = "LIKE";
	public static final String EQUALS = "=";
	public static final String NOT_EQUALS = "!=";
	public static final String GREATER_THAN = ">";
	public static final String GREATER_THAN_OR_EQUAL = ">=";
	public static final String LESS_THAN = "<";
	public static final String LESS_THAN_OR_EQUAL = "<=";

	// Các toán tử liên kết
	public static final String AND = "AND";
	public static final String OR = "OR";

	public static String getCondition(String operator, String condition) {
		switch (operator) {
		case LIKE: {
			return condition + " LIKE CONCAT('%', :" + condition + ", '%')";
		}
		case GREATER_THAN:
		case GREATER_THAN_OR_EQUAL:
		case LESS_THAN_OR_EQUAL:
		case LESS_THAN:
		case NOT_EQUALS:
		case EQUALS:
			return condition + operator + " :" + condition;
		default:
			return null;
		}
	}

	public static String muiltiConditions(List<String> operator, List<String> condition, List<String> connectors) {
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append(getCondition(operator.get(0), condition.get(0)));
		for (int i = 0; i < connectors.size(); i++) {
			queryBuilder.append(" " + connectors.get(i));
			queryBuilder.append(getCondition(operator.get(i + 1), condition.get(i + 1)));
		}
		return queryBuilder.toString();
	}
}
