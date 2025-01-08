package utils;

public class QueryUtil {
	// Các toán tử SQL
	public static final String ALL = "*";
	public static final String EMPTY = " ";
	public static final String LIKE = "LIKE";
	public static final String EQUALS = "=";
	public static final String NOT_EQUALS = "!=";
	public static final String GREATER_THAN = ">";
	public static final String GREATER_THAN_OR_EQUAL = ">=";
	public static final String LESS_THAN = "<";
	public static final String LESS_THAN_OR_EQUAL = "<=";
	public static final String IS_NULL = "IS NULL";
	public static final String IS_NOT_NULL = "IS NOT NULL";

	// Các toán tử liên kết
	public static final String AND = "AND";
	public static final String OR = "OR";

	private static String getCondition(String operator, String condition, int index) {
		switch (operator) {
		case LIKE: {
			return condition + " " + " LIKE CONCAT('%',?" + index + ", '%')";
		}
		case GREATER_THAN:
		case GREATER_THAN_OR_EQUAL:
		case LESS_THAN_OR_EQUAL:
		case LESS_THAN:
		case NOT_EQUALS:
		case EQUALS:
			return condition + " " + operator + " ?" + index;
		case IS_NULL:
		case IS_NOT_NULL:
			return condition + " " + operator;
		default:
			return null;
		}
	}


	/**
	 * Tạo điều kiện kiểm tra
	 * 
	 * @param condition Điều kiện kiểm tra
	 * @param operator  Toán tử cho điều kiện
	 * @param index  Vị trí điều kiện
	 * @param operator  Toán tử liên kết (không cần liên kết thì thay bằng QueryUtil.EMPTY)
	 * @return điều kiện cho query
	 */
	public static String createCondition(String condition, String operator, int index, String connector) {
		return "e." + getCondition(operator, condition, index) + connector;
	}

	/**
	 * Tạo query
	 * 
	 * @param <E>
	 * @param entityClass table muốn lấy dữ liệu
	 * @param returnData  dữ liệu muốn lấy từ bảng (tên thuộc tính)
	 * @param conditions  danh sách điều kiện
	 * @return query để thực hiện tìm kiếm dữ liệu trên db
	 */
	public static <E> String createQuery(Class<E> entityClass, String returnData, String... conditions) {
		String defaultQuery = String.format("select %s from %s e ", returnData.equals(ALL) ? "e" : "e." + returnData,
				entityClass.getName());
		if (conditions[0].equals(EMPTY)) {
			return defaultQuery;
		} else {
			StringBuilder stringBuilder = new StringBuilder(defaultQuery);
			stringBuilder.append("where ");
			for (String condition : conditions) {
				stringBuilder.append(condition);
			}
			return stringBuilder.toString();
		}

	}

}
