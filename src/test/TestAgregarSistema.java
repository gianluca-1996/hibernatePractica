package test;

import java.util.Set;

import datos.Gastronomia;
import datos.Hospedaje;
import datos.Servicio;
import datos.Sistema;
import negocio.SistemaABM;

public class TestAgregarSistema {

	public static void main(String[] args) {
		
		
		Sistema sistema = new Sistema("HOTEL SHERATON");
		Servicio servicio1 = new Gastronomia(0.15, true, 200, 3, sistema);
		Servicio servicio2 = new Hospedaje(0.15, false, "Habitacion doble", 400, sistema);
		sistema.getServicios().add(servicio1);
		sistema.getServicios().add(servicio2);
		
		try
		{
			SistemaABM.getInstance().agregar(sistema);
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}

	}

}
