package dao;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Cliente;

public class ClienteDao {

	private static Session session;
	private Transaction tx;
	private static ClienteDao instance = null;
	
	public static ClienteDao getInstance()
	{
		if(instance == null)
			instance = new ClienteDao();
		
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
	
	public void agregar(Cliente cliente)
	{
		try
		{
			iniciaOperacion();
			session.save(cliente);
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
	
	public Cliente traer(String dni)
	{
		Cliente cliente = null;
		
		try
		{
			iniciaOperacion();
			String hql = "from Cliente c where c.dni=" + dni;
			cliente = (Cliente) session.createQuery(hql).uniqueResult();
			
			if(cliente != null)
				Hibernate.initialize(cliente.getHospedajes());
		}finally
		{
			session.close();
		}
		
		return cliente;
	}
	
}












