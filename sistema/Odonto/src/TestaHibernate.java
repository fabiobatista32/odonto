import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import br.com.softodonto.dao.Database;

public class TestaHibernate {
	
	public static void main(String[] args) {
        Session session = null;
		try {
			//session = Database.getInstance().getSession().getSessionFactory().openSession();
			session = Database.getInstance().getSession();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("Iniciado com Sucesso \n" + session.toString());
    }

}
