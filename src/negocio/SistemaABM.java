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
	
	public void agregar(Sistema sistema)
	{
		SistemaDao.getInstance().agregar(sistema);
	}
}
