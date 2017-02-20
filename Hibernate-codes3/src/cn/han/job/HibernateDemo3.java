package cn.han.job;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.han.domain.Customer;
import cn.han.domain.Order;
import cn.han.utils.HibernateUtils;

/**
 * 
 * @ClassName: HibernateDemo3
 * @Description: model : one to many
 * @author Heaven
 * @date 2017-2-19 下午7:35:35
 * @version v1.0
 */

public class HibernateDemo3 {
	public static void main(String[] args){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		//test how many expression have been sent out
		Customer c1 = new Customer();
		Customer c2 = new Customer();
		c1.setCname("hxt");
		c2.setCname("han");
		Order o1 = new Order();
		Order o2 = new Order();
		Order o3 = new Order();
		o1.setAddr("NanJing Road");
		o2.setAddr("TianJing Road");
		o3.setAddr("BeiJing Road");
		
		
		
		//o1.setCustomer(c1);
		c1.getOrders().add(o2);
		c1.getOrders().add(o3);
		c2.getOrders().add(o1);
		//session.save(o1);
		session.save(c1);
		session.save(c2);
		//session.save(o3);
		tx.commit();
		session.close();
		
		
	}
}
