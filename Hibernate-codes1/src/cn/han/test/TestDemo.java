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
public class TestDemo {
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
		Book book = new Book();
		book.setId(3);
		book.setName("world peace");
		book.setAuthor("han");
		book.setPrice("1000");
		session.save(book);
		
		Book book2 = (Book)session.get(Book.class, 1);
		System.out.println(book2);
		
		Book book3 = (Book)session.get(Book.class, 1);
		System.out.println(book3);
		
		//commit transaction
		transaction.commit();
		//close all the resource
		session.close();
	}
}
