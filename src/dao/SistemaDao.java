package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Sistema;

public class SistemaDao {

	private static Session session;
	private Transaction tx;
	public static SistemaDao instance = null;
	
	public static SistemaDao getInstance() {
		if(instance == null)
			instance = new SistemaDao();
		
		return instance;
	}
	
	private void iniciaOperacion() throws HibernateException
	{
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	private void manejaExcepcion(HibernateException he) throws HibernateException
	{
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}
	
	public void agregar(Sistema sistema)
	{
		try
		{
			iniciaOperacion();
			session.save(sistema);
			tx.commit();
		}	catch(HibernateException he) {
				manejaExcepcion(he);
				throw he;
			}
			
			finally {
				session.close();
			}
	}
}
