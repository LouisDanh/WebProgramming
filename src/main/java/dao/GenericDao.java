package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import models.CartItem;
import utils.HibernateUtil;

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
		List<T> result = new ArrayList<>();
		try {
			Session session = HibernateUtil.getSession();
			Query<T> query = session.createQuery("FROM " + entityName.getName(), entityName);
			result = query.list();
		} catch (Exception e) {
			System.err.println("Lỗi: Không thể lấy dữ liệu All cho class " + entityName.getName());
		}
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
		try {
			Session session = HibernateUtil.getSession();
			transaction = commitOnComplete ? session.beginTransaction() : session.getTransaction();
			session.update(data);
			if (commitOnComplete)
				transaction.commit();
			return true;
		} catch (Exception e) {
			System.err.println("Lỗi: Không thể cập nhật dữ liệu cho class " + data.getClass().getName());
			e.printStackTrace();
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
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
		try {
			Session session = HibernateUtil.getSession();
			transaction = commitOnComplete ? session.beginTransaction() : session.getTransaction();
			session.save(data);
			if (commitOnComplete)
				transaction.commit();
			return true;
		} catch (Exception e) {
			System.err.println("Lỗi: Không thể thêm dữ liệu cho class " + data.getClass().getName());
			e.printStackTrace();
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}

		}
		return false;
	}

	/**
	 * Thực thi một truy vấn trả về danh sách kết quả.
	 * 
	 * @param <T>         Kiểu dữ liệu trả về trong kết quả truy vấn.
	 * @param <E>         Kiểu entity của bảng dữ liệu.
	 * @param entityClass Class của entity tương ứng với bảng dữ liệu.
	 * @param returnData  Tên trường dữ liệu mà bạn muốn trả về trong kết quả truy
	 *                    vấn.
	 * @param queryString Câu truy vấn để thực thi.
	 * @param data        Danh sách các tham số truyền vào truy vấn.
	 * @return Danh sách các đối tượng thuộc kiểu T thỏa mãn truy vấn. Nếu không có
	 *         kết quả, trả về null.
	 */
	public static <T, E> List<T> excuteQueryGetList(Class<E> entityClass, Class<T> returnData, String queryString,
			Object... data) {
		Session session = HibernateUtil.getSession();
		try {
			Query<T> query = session.createQuery(queryString, returnData);
			if (data != null)
				for (int i = 0; i < data.length; i++) {
					if (data[i] != null)
						query.setParameter(i, data[i]);
				}
			List<T> result = query.getResultList();
			return result;
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Thực thi một truy vấn trả về một đối tượng duy nhất.
	 * 
	 * @param <T>         Kiểu dữ liệu trả về trong kết quả truy vấn.
	 * @param <E>         Kiểu entity của bảng dữ liệu.
	 * @param entityClass Class của entity tương ứng với bảng dữ liệu.
	 * @param returnData  Kiểu dữ liệu trả về trong kết quả truy vấn.
	 * @param queryString Câu truy vấn để thực thi.
	 * @param data        Danh sách các tham số truyền vào truy vấn.
	 * @return Đối tượng duy nhất thỏa mãn truy vấn, hoặc null nếu không có kết quả.
	 */
	public static <T, E> T excuteQueryGetSingle(Class<E> entityClass, Class<T> returnData, String queryString,
			Object... data) {
		Session session = HibernateUtil.getSession();
		Query<T> query = session.createQuery(queryString, returnData);
		for (int i = 0; i < data.length; i++) {
			if (data[i] != null)
				query.setParameter(i, data[i]);
		}
		try {
			T result = query.getSingleResult();
			return result;
		} catch (NoResultException e) {
			return null;
		}
	}

	public static boolean delete(Object data) {
		if (data == null) {
			System.err.println("Dữ liệu không được null khi delete");
			return false;
		}
		Transaction transaction = null;
		try {
			Session session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			session.delete(data);
			transaction.commit();
			return true;
		} catch (Exception e) {
			System.err.println("Lỗi: Không thể xóa dữ liệu cho class " + data.getClass().getName());
			e.printStackTrace();
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}

		}
		return false;
	}
}
