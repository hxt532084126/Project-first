package cn.han.action;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.han.utils.HibernateUtils;
import cn.han.vo.Customer;

public class TestDemo {
	public static void main(String[] args){
			Demo2();
	}
	
	//Demo2
	public static void Demo2(){
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		
		Customer customer1= (Customer) session.get(Customer.class, 2);
		System.out.println(customer1.getOrders().size());
				
		transaction.commit();
		session.close();
		
		
		
		Session session1 = HibernateUtils.openSession();
		Transaction transaction1 = session1.beginTransaction();
		
		Customer customer3= (Customer) session1.get(Customer.class, 2);
		System.out.println(customer3.getOrders().size());
				
		transaction1.commit();
		session1.close();
	}
	
	//Demo1
	public static void Demo1(){
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		
		Customer customer1= (Customer) session.get(Customer.class, 1);
		Customer customer2= (Customer) session.get(Customer.class, 1);
		System.out.println(customer1);
		System.out.println(customer2);
				
		transaction.commit();
		session.close();
		
		
		
		Session session1 = HibernateUtils.openSession();
		Transaction transaction1 = session1.beginTransaction();
		
		Customer customer3= (Customer) session1.get(Customer.class, 1);
		Customer customer4= (Customer) session1.get(Customer.class, 1);
		System.out.println(customer3);
		System.out.println(customer4);
				
		transaction1.commit();
		session1.close();
	}
}
