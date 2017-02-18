package cn.han.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import cn.han.utils.HibernateUtils;

/**
 * 
 * @ClassName: TestDemo
 * @Description: TODO a test about to prove the first period cache's existence
 * @author Heaven
 * @date 2017-2-18 下午8:17:05
 * @version v1.0
 */
public class TestDemo2 {
	/**
	 * 
	 * @Title: Test1
	 * @Description: TODO model one
	 * @return void
	 * @throws
	 * @param
	 */
	@Test
	public void Test1(){
		//get session
		Session session = HibernateUtils.openSession();
		//begin transaction
		Transaction transaction = session.beginTransaction();
		//logic statement
		Book book = (Book)session.get(Book.class, 1);
		//commit transaction
		System.out.println(book);
		session.clear();
		transaction.commit();
		//close all the resource
		session.close();
	}
}
