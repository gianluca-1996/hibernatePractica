package test;

import datos.Hospedaje;
import datos.Servicio;
import datos.Sistema;
import negocio.ServicioABM;
import negocio.SistemaABM;

public class TestAgregarServicios {

	public static void main(String[] args) {

		Servicio servicio;
		Sistema sistema;
		int idSistema = 1;
		
		try
		{
			sistema = SistemaABM.getInstance().traer(idSistema);
			ServicioABM.getInstance().agregar(new Hospedaje(0.20, true, "SUITE DE LUJO", 8000, sistema));
			System.out.println(sistema);
			sistema = SistemaABM.getInstance().traer(idSistema);
			for(Servicio s : sistema.getServicios())
				System.out.println(s);
			
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}

	}

}
