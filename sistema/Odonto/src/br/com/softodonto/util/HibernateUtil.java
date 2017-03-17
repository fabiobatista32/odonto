package br.com.softodonto.util;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;

@SuppressWarnings("deprecation")
public class HibernateUtil {

    public static SessionFactory sessionFactory;

    public HibernateUtil() {
    }

	public static SessionFactory getSessionFactory() {

        if (sessionFactory == null) {

            try {
                AnnotationConfiguration annotation = new AnnotationConfiguration();

                sessionFactory = annotation.configure().buildSessionFactory();

            } catch (Throwable ex) {
                System.out.println("Erro ao inicar o Hibernte" + ex);
                throw new ExceptionInInitializerError(ex);
            }

            return sessionFactory;

        } else {
            return sessionFactory;
        }
    }

    public static Session getSession() {
        // TODO Auto-generated method stub
        return null;
    }

}
