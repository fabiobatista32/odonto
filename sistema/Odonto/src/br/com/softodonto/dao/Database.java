package br.com.softodonto.dao;

import javax.naming.NamingException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Database {
	
	private static Database instance;
	private static ThreadLocal<Session> sessionThreadLocal = new ThreadLocal<Session>();
	private SessionFactory sessionFactory;
	
	private Database() throws NamingException { 
		
		if (sessionFactory == null) {		
			Configuration configuration = new Configuration();
			//configuration.setInterceptor(new LogInterceptor());
			configuration.configure("hibernate.cfg.xml");
			ServiceRegistryBuilder registry = new ServiceRegistryBuilder();
			registry.applySettings(configuration.getProperties());
			ServiceRegistry serviceRegistry = registry.buildServiceRegistry();

			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}
	}
	
	public static Database getInstance() throws NamingException {
		if (instance == null) {
			instance = new Database();
		}
		return instance;
	}
	
	public Session getSession(){
		if ( sessionThreadLocal == null || sessionThreadLocal.get() == null ) {
			//AuditLogInterceptor auditLogInterceptor = new AuditLogInterceptor();
			//Session session = this.sessionFactory.openSession(auditLogInterceptor);
			Session session = this.sessionFactory.openSession();
			//auditLogInterceptor.setSession(session);
			sessionThreadLocal = new ThreadLocal<Session>();
			sessionThreadLocal.set(session);
		}		
		return (Session) sessionThreadLocal.get();
	}

	public void closeSession(){
		
		if(sessionThreadLocal != null){
			Session session = (Session) sessionThreadLocal.get();
			if ( session != null && session.isOpen() ) {
				session.close();
				sessionThreadLocal.set(null);
			}
		}
		
	}	
	
}
