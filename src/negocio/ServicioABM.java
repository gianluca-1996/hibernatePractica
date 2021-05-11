package negocio;

import java.util.ArrayList;
import java.util.List;

import dao.ServicioDao;
import datos.Servicio;

public class ServicioABM {

	private static ServicioABM instance = null;
	
	public static ServicioABM getInstance()
	{
		if(instance == null)
			instance = new ServicioABM();
		
		return instance;
	}
	
	public int agregar(Servicio servicio)
	{
		return ServicioDao.getInstance().agregar(servicio);
	}
	
	public Servicio traer(int idServicio) throws Exception
	{
		Servicio servicio = ServicioDao.getInstance().traer(idServicio);
		
		if(servicio == null)
			throw new Exception("ERROR - El servicio no existe...");
		
		return servicio;
	}
	
	public List<Servicio> traer(boolean enPromo)
	{
		List<Servicio> lista = ServicioDao.getInstance().traer();
		List<Servicio> listaEnPromo = new ArrayList<Servicio>();
		
		for(Servicio s : lista)
		{
			if(s.isEnPromocion() == enPromo)
				listaEnPromo.add(s);
		}
		
		return listaEnPromo;
	}
	
	public void actualizar(Servicio servicio)
	{
		ServicioDao.getInstance().actualizar(servicio);
	}
	
	public void eliminar(Servicio servicio)
	{
		ServicioDao.getInstance().eliminar(servicio);
	}
}
