package cn.han.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 
 * @ClassName: HibernateUtils
 * @Description: TODO
 * @author Heaven
 * @date 2017-2-21 下午2:34:32
 * @version v1.0
 */
public class HibernateUtils {
	private static Configuration configuration;
	private static SessionFactory sessionFactory;
	
	static{
		configuration = new Configuration().configure();
		sessionFactory = configuration.buildSessionFactory();
	}
	
	public static Session openSession(){
		return sessionFactory.openSession();
	}
	
	public static Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	public static void main(String[] args) {
		openSession();
	}
}
