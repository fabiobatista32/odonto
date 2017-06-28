package br.gov.ma.softodonto.interceptors;

import java.io.Serializable;
import java.sql.Connection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import org.hibernate.CallbackException;
import org.hibernate.EmptyInterceptor;
import org.hibernate.Session;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;
import org.hibernate.internal.SessionImpl;
import org.hibernate.type.Type;

import br.com.softodonto.util.HibernateUtil;
import br.gov.ma.softodonto.interfaces.Auditable;
import br.gov.ma.softodonto.models.Log;


/**
 *
 * Esta Classe é utilizada para interceptar operações efetuadas pelo
 * Hibernate(save, update, delete) e registrá-las no Log para Auditoria.
 * <p>
 * Um objeto desta classe é passado como parâmetro ao criar uma Sessão com o
 * Banco de Dados na Classe dao.Database.
 * 
 */
@ManagedBean
@SessionScoped
public class LogInterceptor extends EmptyInterceptor {

	private static final long serialVersionUID = 1L;

	private Set<Auditable> inserts = new HashSet<>();
	private Set<Auditable> updates = new HashSet<>();
	private Set<Auditable> deletes = new HashSet<>();
	
	private StatelessSession statelessSession;
	
	/*
	 * Antes de salvar
	 * 
	 * @see org.hibernate.EmptyInterceptor#onSave(java.lang.Object,
	 * java.io.Serializable, java.lang.Object[], java.lang.String[],
	 * org.hibernate.type.Type[])
	 */
	public boolean onSave(Object entity, Serializable id, Object[] state,
			String[] propertyNames, Type[] types) throws CallbackException {

		if (entity instanceof Auditable) {
			inserts.add((Auditable)entity);
		}
		return false;

	}

	public boolean onFlushDirty(Object entity, Serializable id,
			Object[] currentState, Object[] previousState,
			String[] propertyNames, Type[] types) throws CallbackException {

		if (entity instanceof Auditable) {
			updates.add((Auditable)entity);
		}
		return false;

	}

	public void onDelete(Object entity, Serializable id, Object[] state,
			String[] propertyNames, Type[] types) {

		if (entity instanceof Auditable) {
			deletes.add((Auditable)entity);
		}
	}

	// called before commit into database
	@Override
	public void preFlush(  @SuppressWarnings("rawtypes") Iterator entities ) {
		
	}

	// called after committed into database
	@Override
	public void postFlush(  @SuppressWarnings("rawtypes") Iterator entities ) {	
		//StatelessSession statelessSession = null;
		Transaction tx = null;
		
		Session hiSession = HibernateUtil.getSession();
		Connection con = ((SessionImpl) hiSession).connection();
		
		statelessSession = HibernateUtil.getSessionFactory().withStatelessOptions().connection(con).openStatelessSession();
		
		if(statelessSession != null){
			try {
	
				tx = statelessSession.beginTransaction();
				
				Integer idUsuario = null;
	
				for (Iterator<Auditable> it = inserts.iterator(); it.hasNext();) {
					Auditable entity = (Auditable) it.next();
					
					String[] className = entity.getClass().getName().split("\\.");
					String entityName = className[className.length - 1];
	
					Log auditRecord = new Log("Inserção", entity.getLogDetail(),
							new Date(), entity.getId(), entityName
									.toString(), idUsuario );
	
					statelessSession.insert(auditRecord);
	
				}
	
				for (Iterator<Auditable> it = updates.iterator(); it.hasNext();) {
					Auditable entity = (Auditable) it.next();
					
					String[] className = entity.getClass().getName().split("\\.");
					String entityName = className[className.length - 1];
	
					Log auditRecord = new Log("Edição", entity.getLogDetail(),
							new Date(), entity.getId(), entityName
									.toString(), idUsuario );
	
					statelessSession.insert(auditRecord);
	
				}
	
				for (Iterator<Auditable> it = deletes.iterator(); it.hasNext();) {
					Auditable entity = (Auditable) it.next();
					
					String[] className = entity.getClass().getName().split("\\.");
					String entityName = className[className.length - 1];
	
					Log auditRecord = new Log("Remoção", entity.getLogDetail(),
							new Date(), entity.getId(), entityName
									.toString(), idUsuario );
	
					statelessSession.insert(auditRecord);
				}
	
				tx.commit();
	
			} catch (Exception e) {
				e.printStackTrace();
				tx.rollback();
			} finally {
				inserts.clear();
				updates.clear();
				deletes.clear();
				statelessSession.close();
			}
		}
	}

}