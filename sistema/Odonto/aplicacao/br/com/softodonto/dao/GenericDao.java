package br.com.softodonto.dao;

import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.softodonto.util.HibernateUtil;


public class GenericDao {
	public static Session session = getSession();
	
	public GenericDao() {

	}
	
	public boolean saveOrUpdate(Object obj) throws Exception {
		Transaction tx = session.beginTransaction();		
		try {
			session.saveOrUpdate(obj);
			tx.commit();
		}
		catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
			e.getCause();
			throw new Exception(e);
		}	
		return true;
	}
	
	public boolean save(Object obj) throws Exception {
		Transaction tx = session.beginTransaction();		
		try {
			session.save(obj);
			tx.commit();
		}
		catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
			e.getCause();
			throw new Exception(e);
		}		
		return true;
	}
	
	public boolean update(Object obj) throws Exception {
		Transaction tx = session.beginTransaction();		
		try {
			session.update(obj);
			tx.commit();
		}
		catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
			e.getCause();
			throw new Exception(e);
		}		
		return true;
	}
	
	public boolean delete(Object obj) throws Exception {
		Transaction tx = session.beginTransaction();
		try {
			session.delete(obj);
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();			
			throw new Exception(e);			
		}		
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public <T> Collection<T> findAll(Class<T> classe) {
		Criteria c = createCriteria(classe);
		return c.list();
	}	
	
	@SuppressWarnings("unchecked")
	public <T> Collection<T> findAll(Class<T> classe, int size) {
		Criteria c = createCriteria(classe);
		c.setMaxResults(size);
		return c.list();
	}	
	
	/**
	 * @param classe
	 * @param orderBy
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> Collection<T> findAll(Class<T> classe, String orderBy) {
		Criteria c = createCriteria(classe);
		c.addOrder(Order.asc(orderBy));
		return c.list();		
	}	
	
	@SuppressWarnings("unchecked")
	public <T> Collection<T> findAllOrderDesc(Class<T> classe, String orderBy) {
		Criteria c = createCriteria(classe);
		c.addOrder(Order.desc(orderBy));
		return c.list();		
	}
	
	@SuppressWarnings("unchecked")
	public <T> T findById(Class<T> classe, Long id){
		Criteria c = createCriteria(classe);
		c.add(Restrictions.eq("id", id));
		return (T) c.uniqueResult();
	}	
	
	protected Criteria createCriteria(Class<?> classe){
		return GenericDao.session.createCriteria(classe);
	}
	
	protected Query createQuery(String sql){
		return GenericDao.session.createQuery(sql);
	}
	
	/*
	 * Método que inicia a transação da session
	 */
	protected void begin() {
		session.beginTransaction();
	}

	/*
	 * Método que realiza o commit da transação da session
	 */
	protected void commit() {
		session.getTransaction().commit();
	}

	/*
	 * Método que realiza o rollback da transação da session
	 */
	protected void rollback() {
		session.getTransaction().rollback();
	}

	public static Session getSession() {		
		try {
			return HibernateUtil.getSession();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}	
	
	public void closeSession(){
		try {
			HibernateUtil.closeSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	@SuppressWarnings("static-access")
	public void recreateSession(){
		this.closeSession();
		this.session = this.getSession();
	}
}