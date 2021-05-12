package test;

import datos.Cliente;
import datos.Hospedaje;
import datos.Servicio;
import negocio.ClienteABM;
import negocio.ServicioABM;

public class TestAgregarClientes {

	public static void main(String[] args) {
		
		int idHospedaje = 4;
		Hospedaje hospedaje = null;
		Cliente cliente1 = null;
		
		

		try
		{
			hospedaje = (Hospedaje) ServicioABM.getInstance().traer(idHospedaje);
			cliente1 = new Cliente("Martin", "martinez", "40321654");
			cliente1.getHospedajes().add(hospedaje);
			ClienteABM.getInstance().agregar(cliente1);
		
			
			
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}

}
