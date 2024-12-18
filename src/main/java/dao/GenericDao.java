package dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

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
	 * Tìm dữ liệu theo điều kiện và toán tử cho trước.
	 * 
	 * @param <T>           Kiểu dữ liệu cần tìm.
	 * @param typeCondition Loại điều kiện (ví dụ: "And", "Or").
	 * @param operator      Toán tử tìm kiếm (ví dụ: "=", "LIKE").
	 * @param className     Tên lớp cần tìm.
	 * @param datas         Các điều kiện tìm kiếm dưới dạng cặp key-value
	 *                      (condition-data), trong đó key là tên trường và value là
	 *                      giá trị cần tìm.
	 * @return Danh sách các đối tượng phù hợp với điều kiện, nếu có lỗi trả về danh
	 *         sách rỗng.
	 */
	private static <T> List<T> findIf(String typeCondition, String operator, String className, Object... datas) {
		StringBuilder queryString = new StringBuilder("From ");
		for (int i = 0; i < datas.length - 1; i += 2) {
			queryString.append(datas[i].toString());
			queryString.append(operator + " :" + datas[i + 1]);
			if (typeCondition != null)
				queryString.append(" " + typeCondition + " ");
		}
		Class<T> instance = getClass(className);
		if (instance == null)
			return Collections.emptyList();
		List<T> result = new ArrayList<>();
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSession()) {
			transaction = session.beginTransaction();
			Query<T> query = session.createQuery("FROM " + queryString.toString(), instance);
			for (int i = 0; i < datas.length - 1; i += 2) {
				query.setParameter(datas[i].toString(), datas[i + 1]);
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
	 * Tìm dữ liệu theo điều kiện AND.
	 * 
	 * @param <T>       Kiểu dữ liệu cần tìm.
	 * @param operator  Toán tử tìm kiếm (ví dụ: "=", "LIKE").
	 * @param className Tên lớp cần tìm.
	 * @param datas     Các điều kiện tìm kiếm (key-value).
	 * @return Danh sách các đối tượng tìm thấy theo điều kiện AND.
	 */
	public static <T> List<T> findAnd(String operator, String className, Object... datas) {
		return findIf("And", operator, className, datas);
	}

	/**
	 * Tìm dữ liệu theo điều kiện OR.
	 * 
	 * @param <T>       Kiểu dữ liệu cần tìm.
	 * @param operator  Toán tử tìm kiếm (ví dụ: "=", "LIKE").
	 * @param className Tên lớp cần tìm.
	 * @param datas     Các điều kiện tìm kiếm (key-value).
	 * @return Danh sách các đối tượng tìm thấy theo điều kiện OR.
	 */
	public static <T> List<T> findOr(String operator, String className, Object... datas) {
		return findIf("Or", operator, className, datas);
	}

	/**
	 * Tìm một đối tượng duy nhất trong bảng phù hợp với điều kiện cho trước.
	 * 
	 * @param <T>       Kiểu dữ liệu cần tìm.
	 * @param operator  Toán tử tìm kiếm (ví dụ: "=", "LIKE").
	 * @param className Tên lớp cần tìm.
	 * @param datas     Các điều kiện tìm kiếm (key-value).
	 * @return Đối tượng duy nhất tìm thấy, nếu không có thì trả về null.
	 */
	public static <T> T findOne(String operator, String className, Object... datas) {
		List<T> result = findIf(null, operator, className, datas);
		if (result.isEmpty()) {
			return null;
		}
		return result.get(0);
	}
}
