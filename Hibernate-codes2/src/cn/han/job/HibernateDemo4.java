package cn.han.job;

import org.hibernate.Session;
import org.hibernate.Transaction;
import cn.han.domain.Customer;
import cn.han.utils.HibernateUtils;

public class HibernateDemo4 {
	public static void main(String[] args) {
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();

		// rely on the id to find out the result
		Customer customer = (Customer) session.get(Customer.class, 1);
		session.delete(customer);

		transaction.commit();
		session.close();
	}
}
