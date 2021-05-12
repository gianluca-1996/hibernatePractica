package test;

import java.time.LocalDate;
import java.util.List;

import datos.Cliente;
import datos.Gastronomia;
import datos.Hospedaje;
import datos.Servicio;
import datos.Sistema;
import negocio.ServicioABM;

public class TestTraerServicio {

	public static void main(String[] args) {
		
		Sistema sistema = null;
		Servicio servicio = null;
		Servicio servicio1 = null;
		Servicio servicio2 = null;
		Hospedaje hospedaje = null;
		Gastronomia gastronomia = null;
		int idServicio = 2;
		
		try
		{
			//TRAER SERVICIOS EN PROMO
			/*List<Servicio> lista = ServicioABM.getInstance().traer();
			for(Servicio s : lista)
			{
				if(s instanceof Hospedaje)
				{
					hospedaje = (Hospedaje) s;
					System.out.println(s);
				}
			}*/
			
			//TRAER SERVICIO POR ID
			servicio = ServicioABM.getInstance().traer(idServicio);
			
			if(servicio instanceof Hospedaje)
			{
				hospedaje = (Hospedaje) servicio;
				System.out.println(hospedaje);
				
				for(Cliente cliente : hospedaje.getClientesHospedados())
					System.out.println(cliente);
			}
			
			else
			{
				if(servicio instanceof Gastronomia)
				{
					gastronomia = (Gastronomia) servicio;
					System.out.println(gastronomia + " " + gastronomia.getSistema());
				}
			}
			
			
			//ACTUALIZAR SERVICIO
			/*servicio1 = ServicioABM.getInstance().traer(idServicio);
			idServicio = 8;
			servicio2 = ServicioABM.getInstance().traer(idServicio);
			servicio1.setEnPromocion(false);
			servicio2.setEnPromocion(false);
			ServicioABM.getInstance().actualizar(servicio1);
			ServicioABM.getInstance().actualizar(servicio2);*/
			
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}

	}

}
