package negocio;

import dao.SistemaDao;
import datos.Sistema;

public class SistemaABM {

	private static SistemaABM instance = null;
	
	public static SistemaABM getInstance()
	{
		if(instance == null)
			instance = new SistemaABM();
		
		return instance;
	}
	
	public int agregar(Sistema sistema)
	{
		return SistemaDao.getInstance().agregar(sistema);
	}
	
	public Sistema traer(int idSistema) throws Exception
	{
		Sistema sistema = SistemaDao.getInstance().traer(idSistema);
		
		if(sistema == null)
			throw new Exception("ERROR - El sistema con ID " + idSistema + " no existe...");
		
		return sistema;
	}
	
	public void eliminar(Sistema sistema)
	{
		SistemaDao.getInstance().eliminar(sistema);
	}
}
