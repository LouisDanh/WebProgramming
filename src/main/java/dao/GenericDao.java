package dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import models.Account;

public class GenericDao {
	/**
	 * Lấy class dựa trên tên class
	 * 
	 * @param <T>       Kiểu class mà bạn muốn tìm.
	 * @param className Tên đầy đủ của class (bao gồm package).
	 * @return Class nếu tồn tại, nếu không thì trả về null.
	 */
	@SuppressWarnings("unchecked")
	private static <T> Class<T> getClass(String className) {
		Class<T> data = null;
		try {
			data = (Class<T>) Class.forName(className);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.err.println("Lỗi: Class có tên " + className + " không tồn tại ");
		}
		return data;
	}

	/**
	 * Lấy tất cả dữ liệu từ bảng tương ứng với class
	 * 
	 * @param <T>       Kiểu dữ liệu của đối tượng cần tìm.
	 * @param className Tên của lớp (class) cần lấy dữ liệu.
	 * @return Danh sách các đối tượng trong bảng. Nếu có lỗi xảy ra thì trả về danh
	 *         sách rỗng.
	 */
	public static <T> List<T> getAll(String className) {
		Class<T> data = getClass(className);
		if (data == null)
			return Collections.emptyList();
		Transaction transaction = null;
		List<T> result = new ArrayList<>();
		try (Session session = HibernateUtil.getSession()) {
			transaction = session.beginTransaction();
			Query<T> query = session.createQuery("FROM " + data.getName(), data);
			result = query.list();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			System.err.println("Lỗi: Không thể lấy dữ liệu All cho class " + className);
		}
		return result;
	}

	/**
	 * Cập nhật dữ liệu trong bảng
	 * 
	 * @param data Dữ liệu cần cập nhật (bản ghi muốn thay đổi).
	 * @return true nếu cập nhật thành công, ngược lại trả về false.
	 */
	public static boolean update(Object data) {
		if (data == null) {
			System.err.println("Dữ liệu không được null khi update");
			return false;
		}
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSession()) {
			transaction = session.beginTransaction();
			session.update(data);
			transaction.commit();
			return true;
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			System.err.println("Lỗi: Không thể cập nhật dữ liệu cho class " + data.getClass().getName());
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Thêm dữ liệu vào bảng
	 * 
	 * @param data Dữ liệu cần thêm vào bảng.
	 * @return true nếu thêm thành công, ngược lại trả về false.
	 */
	public static boolean insert(Object data) {
		if (data == null) {
			System.err.println("Dữ liệu không được null khi insert");
			return false;
		}
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSession()) {
			transaction = session.beginTransaction();
			session.save(data);
			transaction.commit();
			return true;
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			System.err.println("Lỗi: Không thể thêm dữ liệu cho class " + data.getClass().getName());
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 
	 * Tìm kiếm dữ liệu từ bảng dựa trên điều kiện linh hoạt.
	 * 
	 * @param <T>        Kiểu dữ liệu của đối tượng (class entity).
	 * @param className  Tên đầy đủ của class entity (bao gồm package).
	 * @param connectors Danh sách các toán tử liên kết điều kiện (AND, OR)
	 * @param conditions Danh sách các tên trường (field) dùng làm điều kiện.
	 * @param operators  Danh sách các toán tử so sánh (ví dụ: =, >, <, v.v.)
	 * @param values     Danh sách các giá trị tương ứng với điều kiện.
	 * @return Danh sách các đối tượng thỏa mãn điều kiện tìm kiếm, hoặc danh sách
	 *         rỗng nếu không tìm thấy.
	 */
	private static <T> List<T> findIf(String className, List<String> connectors, List<String> conditions,
			List<String> operators, List<Object> values) {
		Class<T> data = getClass(className);
		if (data == null)
			return Collections.emptyList();
		StringBuilder queryString = new StringBuilder("From " + data.getName() + " ");
		queryString.append(QueryFactory.muiltiConditions(operators, conditions, connectors));
		List<T> result = new ArrayList<>();
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSession()) {
			transaction = session.beginTransaction();
			Query<T> query = session.createQuery(queryString.toString(), data);
			for (int i = 0; i < conditions.size(); i++) {
				query.setParameter(conditions.get(i), values.get(i));
			}
			result = query.list();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			System.err.println("Lỗi: Không thể lấy dữ liệu cho class " + className);
		}
		return result;
	}

	/**
	 * Tìm kiếm dữ liệu dựa trên điều kiện "AND".
	 * 
	 * @param <T>       Kiểu dữ liệu của đối tượng (class entity).
	 * @param className Tên đầy đủ của class entity (bao gồm package).
	 * @param datas     Danh sách các cặp điều kiện (field - logicOperator -value).
	 *                  Ví dụ: id = 1
	 * @return Danh sách các đối tượng thỏa mãn điều kiện tìm kiếm, hoặc danh sách
	 *         rỗng nếu không tìm thấy.
	 */
	public static <T> List<T> findAnd(String className, Object... datas) {
		List<String> connectors = new ArrayList<String>();
		List<String> operators = new ArrayList<String>();
		List<String> conditions = new ArrayList<String>();
		List<Object> values = new ArrayList<Object>();
		for (int i = 0; i < datas.length; i += 3) {
			prepareConditions(conditions, values, operators, i, datas);
			connectors.add("AND");
		}
		return findIf(className, connectors, operators, conditions, values);
	}

	/**
	 * 
	 * Tìm kiếm dữ liệu dựa trên điều kiện "OR".
	 * 
	 * @param <T>       Kiểu dữ liệu của đối tượng (class entity).
	 * @param className Tên đầy đủ của class entity (bao gồm package).
	 * @param datas     Danh sách các cặp điều kiện (field - logicOperator -value).
	 *                  Ví dụ: id = 1
	 * @return Danh sách các đối tượng thỏa mãn điều kiện tìm kiếm, hoặc danh sách
	 *         rỗng nếu không tìm thấy.
	 */
	public static <T> List<T> findOr(String className, Object... datas) {
		List<String> connectors = new ArrayList<String>();
		List<String> operators = new ArrayList<String>();
		List<String> conditions = new ArrayList<String>();
		List<Object> values = new ArrayList<Object>();
		for (int i = 0; i < datas.length; i += 3) {
			prepareConditions(conditions, values, operators, i, datas);
			connectors.add("OR");
		}
		return findIf(className, connectors, conditions, operators, values);
	}

	/**
	 * 
	 * Tìm danh sách đối tượng dựa trên nhiều điều kiện.
	 * 
	 * @param <T>       Kiểu dữ liệu của đối tượng (class entity).
	 * @param className Tên đầy đủ của class entity (bao gồm package).
	 * @param datas     Danh sách các bộ 4 (field - logicOperator - value
	 *                  -logicConnector ) xác định điều kiện. Ví dụ (id = 1 and).
	 *                  Danh sách có thể chứa bộ 3 (field -logicOperator - value)
	 *                  nêu không cần nhiều điều kiện
	 * @return Danh sách thỏa mãn điều kiện tìm kiếm, hoặc rỗng nếu không tìm thấy.
	 */
	public static <T> List<T> findWithConditions(String className, Object... datas) {
		List<String> connectors = new ArrayList<String>();
		List<String> operators = new ArrayList<String>();
		List<String> conditions = new ArrayList<String>();
		List<Object> values = new ArrayList<Object>();
		for (int i = 0; i < datas.length; i += 4) {
			prepareConditions(conditions, values, operators, i, datas);
			conditions.add(datas[i + 3].toString());
		}
		return findIf(className, connectors, conditions, operators, values);
	}

	/**
	 * 
	 * Tìm 1 đối tượng dựa trên nhiều điều kiện.
	 * 
	 * @param <T>       Kiểu dữ liệu của đối tượng (class entity).
	 * @param className Tên đầy đủ của class entity (bao gồm package).
	 * @param datas     Danh sách các bộ ba (field - logicOperator - value ) xác
	 *                  định điều kiện. Ví dụ (id = 1 ). Danh sách có thể chứa bộ 2
	 *                  (field - value) nêu không cần nhiều điều kiện
	 * @return Đối tượng thỏa mãn điều kiện tìm kiếm, hoặc rỗng nếu không tìm thấy.
	 */
	public static <T> T findOne(String className, Object... datas) {
		List<T> result = findAnd(className, datas);
		if (result.isEmpty())
			return null;
		else
			return result.get(0);
	}

	/**
	 * Chuẩn bị điều kiện tìm kiếm.
	 * 
	 */
	private static void prepareConditions(List<String> conditions, List<Object> values, List<String> operators,
			int index, Object... datas) {
		conditions.add(datas[index].toString());
		operators.add(datas[index + 1].toString());
		values.add(datas[index + 2]);
	}

}
