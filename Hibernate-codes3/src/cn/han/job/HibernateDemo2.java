package cn.han.job;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.han.domain.Book;
import cn.han.utils.HibernateUtils;

/**
 * 
 * @ClassName: HibernateDemo2
 * @Description: make the certain object persistent
 * @author Heaven
 * @date 2017-2-19 下午7:20:49
 * @version v1.0
 */

public class HibernateDemo2 {
	@Test
	public void Demo2(){
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		/**/
		Book book1 = new Book();
		book1.setAuthor("hxt");
		book1.setName("meidusha");
		book1.setPrice("250");
		session.save(book1); 
		
		book1.setAuthor("wo");
		session.update(book1);
		session.flush();
		
		transaction.commit();
		session.close();
		
	}
}
