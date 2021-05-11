package negocio;

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
	
	public void agregar(Servicio servicio)
	{
		ServicioDao.getInstance().agregar(servicio);
	}
	
	public Servicio traer(int idServicio) throws Exception
	{
		Servicio servicio = ServicioDao.getInstance().traer(idServicio);
		
		if(servicio == null)
			throw new Exception("ERROR - El servicio no existe...");
		
		return servicio;
	}
	
	public void actualizar(Servicio servicio)
	{
		ServicioDao.getInstance().actualizar(servicio);
	}
}
