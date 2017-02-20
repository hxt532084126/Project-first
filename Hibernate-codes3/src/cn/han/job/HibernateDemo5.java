package cn.han.job;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.han.domain.Customer;
import cn.han.domain.Order;
import cn.han.utils.HibernateUtils;

/**
 * 
 * @ClassName: HibernateDemo5
 * @Description: practice the HQL orders in Hibernate
 * @author Heaven
 * @date 2017-2-19 下午9:55:00
 * @version v1.0
 */
public class HibernateDemo5 {
	public static void main(String[] args) {
		Demo8();
	}

	public static void Demo1() {
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		// query all the records
		@SuppressWarnings("unchecked")
		List<Customer> list = session.createQuery("from Customer").list();
		for (Customer customer : list) {
			System.out.println(customer);
		}
		transaction.commit();
		session.close();
	}

	public static void Demo2() {
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		// use nick name
		@SuppressWarnings("unchecked")
		// 这个标记符是从0开始的
		List<Customer> list = session
				.createQuery("from Customer c where c.cname = ?")
				.setString(0, "han").list();
		for (Customer c : list) {
			System.out.println(c);
		}
		transaction.commit();
		session.close();
	}

	public static void Demo3() {
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		// sort function
		@SuppressWarnings("unchecked")
		List<Customer> list = session.createQuery(
				"from Customer c order by c.id asc").list();
		for (Customer c : list) {
			System.out.println(c);
		}
		transaction.commit();
		session.close();
	}

	public static void Demo4() {
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		// pages
		Query query = session.createQuery("from Order");
		query.setFirstResult(1);
		query.setMaxResults(1);
		@SuppressWarnings("unchecked")
		List<Order> list = query.list();
		for (Order customer : list) {
			System.out.println(customer);
		}
		transaction.commit();
		session.close();
	}

	public static void Demo5() {
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		// query the only object (if the result is not unique , the program will
		// throw out a thread which you should deal with)
		Customer customer = (Customer) session
				.createQuery("from Customer where cname=?").setString(0, "han")
				.uniqueResult();
		System.out.println(customer);

		transaction.commit();
		session.close();
	}

	public static void Demo6() {
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		// name bind
		Customer customer = (Customer) session
				.createQuery("from Customer where cid=:id").setInteger("id", 8)
				.uniqueResult();
		System.out.println(customer);

		transaction.commit();
		session.close();
	}

	public static void Demo7() {
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		Customer customer = (Customer) session.get(Customer.class, 7);
		//entity bind
		@SuppressWarnings("unchecked")
		List<Order> list = session
				.createQuery("from Order o where o.customer=?")
				.setEntity(0, customer).list();
		for (Order c : list) {
			System.out.println(c);
		}

		transaction.commit();
		session.close();
	}
	
	public static void Demo8(){
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		//vague query
		Query query = session.createQuery("from Customer where cname like ?");
		@SuppressWarnings("unchecked")
		List<Customer> list = query.setParameter(0, "han").list();
		for(Customer customer : list){
			System.out.println(customer);
		}
		transaction.commit();
		session.close();
	}
	
}
