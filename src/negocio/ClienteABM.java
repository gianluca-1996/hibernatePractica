package negocio;

import dao.ClienteDao;
import datos.Cliente;

public class ClienteABM {
	
	public static ClienteABM instance = null;
	
	public static ClienteABM getInstance() {
		
		if(instance == null)
			instance = new ClienteABM();
		
		return instance;
	}
	
	public void agregar(Cliente cliente)
	{
		ClienteDao.getInstance().agregar(cliente);
	}
	
	public Cliente traer(String dni) throws Exception
	{
		Cliente cliente = ClienteDao.getInstance().traer(dni);
		
		if(cliente == null)
			throw new Exception("ERROR - El cliente no existe...");
		
		return cliente;
	}

}
