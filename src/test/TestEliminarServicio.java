package test;

import datos.Servicio;
import negocio.ServicioABM;

public class TestEliminarServicio {

	public static void main(String[] args) {

		int idServicio = 4;
		
		try
		{
			Servicio servicio = ServicioABM.getInstance().traer(idServicio);
			System.out.println(servicio);
			System.out.println("Despues de eliminar:");
			ServicioABM.getInstance().eliminar(servicio);
			servicio = ServicioABM.getInstance().traer(idServicio);
			System.out.println(servicio);
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}

	}

}
