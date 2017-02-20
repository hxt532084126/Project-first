package cn.han.job;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.han.domain.Book;
import cn.han.utils.HibernateUtils;

/**
 * 
 * @ClassName: HibernateDemo1
 * @Description: to prove the existence of first cache
 * @author Heaven
 * @date 2017-2-19 下午6:45:31
 * @version v1.0
 */
public class HibernateDemo1 {
	@Test
	public void Demo1() {
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		// Book booka = new Book();
		// booka.setAuthor("han");
		// booka.setName("pace world");
		// booka.setPrice("100");
		// session.save(booka);
		// logic part
		Book book1 = (Book) session.load(Book.class, 1);
		// Book book3 = (Book) session.load(Book.class, 2);
		System.out.println(book1);
		// System.out.println(book3);
		// notes : clear first cache
		// session.clear();
		// session.evict(book1);
		book1.setAuthor("bad world");
		session.refresh(book1);
		Book book2 = (Book) session.load(Book.class, 1);
		System.out.println(book2);
		// end part
		transaction.commit();
		session.close();
	}
}
