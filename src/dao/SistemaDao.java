package dao;

import org.hibernate.Hibernate;
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
	
	public int agregar(Sistema sistema)
	{
		int id;
		try
		{
			iniciaOperacion();
			id = Integer.parseInt(session.save(sistema).toString());
			tx.commit();
		}	catch(HibernateException he) {
				manejaExcepcion(he);
				throw he;
			}
			
			finally {
				session.close();
			}
		return id;
	}
	
	public Sistema traer(int idSistema)
	{
		Sistema sistema = null;
		try
		{
			iniciaOperacion();
			String hql = "from Sistema s where s.idSistema =" + idSistema;
			sistema = (Sistema) session.createQuery(hql).uniqueResult();
			if(sistema != null)
				Hibernate.initialize(sistema.getServicios());
		}finally
		{
			session.close();
		}
		
		return sistema;
	}
	
	public void eliminar(Sistema sistema)
	{
		try
		{
			iniciaOperacion();
			session.delete(sistema);
			tx.commit();
		}catch(HibernateException he)
		{
			manejaExcepcion(he);
			throw he;
		}
		finally
		{
			session.close();
		}
	}
}















