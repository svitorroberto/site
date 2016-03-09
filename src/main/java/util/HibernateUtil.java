package util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class HibernateUtil {
	
	     
	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;
	
	public static SessionFactory configureSessionFactory(){
		try {
			Configuration configuration = new Configuration();
			configuration.configure();		
			serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			return sessionFactory;
		} catch (HibernateException e) {
			System.out.println("Erro:" + e);
			throw new ExceptionInInitializerError(e);
		}
	}
	
	 public static SessionFactory getSessionFactory() {
	        return sessionFactory;
	    }
}
