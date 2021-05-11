package dao;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Servicio;

public class ServicioDao {

	private static Session session;
	private Transaction tx;
	private static ServicioDao instance = null;
	
	public static ServicioDao getInstance()
	{
		if(instance == null)
			instance = new ServicioDao();
		
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
	
	public void agregar(Servicio servicio)
	{
		try
		{
			iniciaOperacion();
			session.save(servicio);
			tx.commit();
		}	catch(HibernateException he) {
				manejaExcepcion(he);
				throw he;
			}
			
			finally {
				session.close();
			}
	}
	
	public Servicio traer(int idServicio)
	{
		Servicio servicio = null;
		
		try
		{
			iniciaOperacion();
			String hql = "from Servicio s where s.idServicio =" + idServicio;
			servicio = (Servicio) session.createQuery(hql).uniqueResult();

			if(servicio != null)
				Hibernate.initialize(servicio.getSistema());
		}finally
		{
			session.clear();
		}
		
		return servicio;
	}
	
	public void actualizar(Servicio servicio)
	{
		try
		{
			iniciaOperacion();
			session.update(servicio);
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
