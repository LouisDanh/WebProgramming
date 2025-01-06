package dao;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import models.Account;

public class GenericDao {
	/**
	 * Lấy tất cả dữ liệu từ bảng tương ứng với class
	 * 
	 * @param <T>       Kiểu dữ liệu của đối tượng cần tìm.
	 * @param className Tên của lớp (class) cần lấy dữ liệu.
	 * @return Danh sách các đối tượng trong bảng. Nếu có lỗi xảy ra thì trả về danh
	 *         sách rỗng.
	 */
	public static <T> List<T> getAll(Class<T> entityName) {
		Transaction transaction = null;
		List<T> result = new ArrayList<>();
		try (Session session = HibernateUtil.getSession()) {
			transaction = session.beginTransaction();
			Query<T> query = session.createQuery("FROM " + entityName.getName(), entityName);
			result = query.list();
		} catch (Exception e) {
			System.err.println("Lỗi: Không thể lấy dữ liệu All cho class " + entityName.getName());
			if (transaction != null) {
				transaction.rollback();
			}
		}
		transaction.commit();
		return result;
	}

	public static void commit() {
		HibernateUtil.getCurrentTransaction().commit();
	}

	/**
	 * Cập nhật dữ liệu trong bảng
	 * 
	 * @param data Dữ liệu cần cập nhật (bản ghi muốn thay đổi).
	 * @return true nếu cập nhật thành công, ngược lại trả về false.
	 */
	public static boolean update(Object data, boolean commitOnComplete) {
		if (data == null) {
			System.err.println("Dữ liệu không được null khi update");
			return false;
		}
		Transaction transaction = null;
		try (Session session = commitOnComplete ? HibernateUtil.getSession() : HibernateUtil.getCurrentSession()) {
			transaction = HibernateUtil.getCurrentTransaction();
			session.save(data);
			if (commitOnComplete)
				transaction.commit();
			return true;
		} catch (Exception e) {
			System.err.println("Lỗi: Không thể cập nhật dữ liệu cho class " + data.getClass().getName());
			e.printStackTrace();
			if (transaction != null)
				transaction.rollback();
		}
		return false;
	}

	/**
	 * Thêm dữ liệu vào bảng
	 * 
	 * @param data             Dữ liệu cần thêm vào bảng.
	 * @param commitOnComplete commit true sẽ commit sau khi hoàn tất, ngược lại cần
	 *                         tự gọi lệnh commit để commit
	 * @return true nếu thêm thành công, ngược lại trả về false.
	 */
	public static boolean insert(Object data, boolean commitOnComplete) {
		if (data == null) {
			System.err.println("Dữ liệu không được null khi insert");
			return false;
		}
		Transaction transaction = null;
		try (Session session = commitOnComplete ? HibernateUtil.getSession() : HibernateUtil.getCurrentSession()) {
			transaction = HibernateUtil.getCurrentTransaction();
			session.save(data);
			if (commitOnComplete)
				transaction.commit();
			return true;
		} catch (Exception e) {
			System.err.println("Lỗi: Không thể thêm dữ liệu cho class " + data.getClass().getName());
			e.printStackTrace();
			if (transaction != null)
				transaction.rollback();

		}
		return false;
	}

	/**
	 * 
	 * Tìm kiếm dữ liệu từ bảng dựa trên điều kiện linh hoạt.
	 * 
	 * @param entityClass class entity .
	 * @param fieldName   Trường dữ liệu muốn lấy
	 * @param connectors  Danh sách các toán tử liên kết điều kiện (AND, OR)
	 * @param conditions  Danh sách các tên trường (field) dùng làm điều kiện.
	 * @param operators   Danh sách các toán tử so sánh (ví dụ: =, >, <, v.v.)
	 * @param values      Danh sách các giá trị tương ứng với điều kiện.
	 * @return Danh sách các đối tượng thỏa mãn điều kiện tìm kiếm, hoặc danh sách
	 *         rỗng nếu không tìm thấy.
	 */
	@SuppressWarnings("unchecked")
	private static <T, E> List<T> findIf(Class<E> entityClass, String fieldName, List<String> connectors,
			List<String> conditions, List<String> operators, List<Object> values) {
		Class<T> dataType = null;
		try {
			Field field = entityClass.getDeclaredField(fieldName);
			dataType = (Class<T>) field.getType();
		} catch (NoSuchFieldException e) {
			System.err.println("Không tìm thấy field: " + fieldName + " trong class " + entityClass.getName());
			e.printStackTrace();
			return Collections.emptyList();
		}
		StringBuilder queryString = new StringBuilder(String.format("Select %s From %s e where ",
				fieldName.equals(QueryFactory.ALL) ? "e" : "e." + fieldName, entityClass.getName()));
		queryString.append(QueryFactory.muiltiConditions(operators, conditions, connectors));
		List<T> result = new ArrayList<>();
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSession()) {
			transaction = session.beginTransaction();
			Query<T> query = session.createQuery(queryString.toString(), dataType);
			for (int i = 0; i < values.size(); i++) {
				query.setParameter(conditions.get(i), values.get(i));
			}
			System.out.println(query.toString());
			result = query.list();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Lỗi: Không thể lấy dữ liệu cho class " + entityClass.getName());
			if (transaction != null) {
				transaction.rollback();
			}

		}

		return result;
	}

	/**
	 * Tìm kiếm dữ liệu dựa trên điều kiện "AND".
	 * 
	 * @param entityClass class entity .
	 * @param fieldName   Trường dữ liệu muốn lấy
	 * @param datas       Danh sách các cặp điều kiện (field - logicOperator - value
	 *                    - logicConnector(optional) ). Ví dụ: id = 1
	 * @return Danh sách các đối tượng thỏa mãn điều kiện tìm kiếm, hoặc danh sách
	 *         rỗng nếu không tìm thấy.
	 */
	public static <T, E> List<T> findAnd(Class<E> entityClass, String fieldName, Object... datas) {
		List<String> connectors = new ArrayList<String>();
		List<String> operators = new ArrayList<String>();
		List<String> conditions = new ArrayList<String>();
		List<Object> values = new ArrayList<Object>();
		for (int i = 0; i < datas.length; i += 3) {
			if (i != 0 && i != datas.length) {
				connectors.add("AND");
			}
			prepareConditions(conditions, values, operators, i, datas);

		}
		return findIf(entityClass, fieldName, connectors, conditions, operators, values);
	}

	/**
	 * 
	 * Tìm kiếm dữ liệu dựa trên điều kiện "OR".
	 * 
	 * @param entityClass class entity .
	 * @param fieldName   Trường dữ liệu muốn lấy
	 * @param datas       Danh sách các cặp điều kiện (field - logicOperator - value
	 *                    - logicConnector(optional) ). Ví dụ: id = 1
	 * @return Danh sách các đối tượng thỏa mãn điều kiện tìm kiếm, hoặc danh sách
	 *         rỗng nếu không tìm thấy.
	 */
	public static <T, E> List<T> findOr(Class<E> entityClass, String fieldName, Object... datas) {
		List<String> connectors = new ArrayList<String>();
		List<String> operators = new ArrayList<String>();
		List<String> conditions = new ArrayList<String>();
		List<Object> values = new ArrayList<Object>();
		for (int i = 0; i < datas.length; i += 3) {
			if (i != 0 && i != datas.length) {
				connectors.add("OR");
			}
			prepareConditions(conditions, values, operators, i, datas);
		}
		return findIf(entityClass, fieldName, connectors, conditions, operators, values);
	}

	/**
	 * 
	 * Tìm danh sách đối tượng dựa trên nhiều điều kiện.
	 * 
	 * @param entityClass class entity .
	 * @param fieldName   Trường dữ liệu muốn lấy
	 * @param datas       Danh sách các cặp điều kiện (field - logicOperator - value
	 *                    - logicConnector(optional) ) xác định điều kiện. Ví dụ (id
	 *                    = 1).
	 * @return Danh sách thỏa mãn điều kiện tìm kiếm, hoặc rỗng nếu không tìm thấy.
	 */
	public static <T, E> List<T> findWithConditions(Class<E> entityClass, String fieldName, Object... datas) {
		List<String> connectors = new ArrayList<String>();
		List<String> operators = new ArrayList<String>();
		List<String> conditions = new ArrayList<String>();
		List<Object> values = new ArrayList<Object>();
		for (int i = 0; i < datas.length; i += 4) {
			prepareConditions(conditions, values, operators, i, datas);
			conditions.add(datas[i + 3].toString());
		}
		return findIf(entityClass, fieldName, connectors, conditions, operators, values);
	}

	/**
	 * 
	 * Tìm 1 đối tượng dựa trên nhiều điều kiện.
	 * 
	 * @param entityClass class entity .
	 * @param fieldName   Trường dữ liệu muốn lấy
	 * @param datas       Danh sách các cặp điều kiện (field - logicOperator - value
	 *                    - logicConnector(optional) ) xác định điều kiện. Ví dụ (id
	 *                    = 1).
	 * @return Đối tượng thỏa mãn điều kiện tìm kiếm, hoặc rỗng nếu không tìm thấy.
	 */
	public static <T, E> T findOne(Class<E> entityClass, String fieldName, Object... datas) {
		List<T> result = findAnd(entityClass, fieldName, datas);
		if (result.isEmpty())
			return null;
		else
			return result.get(0);
	}

	/**
	 * Chuẩn bị điều kiện tìm kiếm.
	 * 
	 */
	private static <E> void prepareConditions(List<String> conditions, List<Object> values, List<String> operators,
			int index, Object... datas) {
		conditions.add(datas[index].toString());
		operators.add(datas[index + 1].toString());
		if (index + 2 < datas.length)
			values.add(datas[index + 2]);
	}

}
