package test;

import java.time.LocalDate;
import java.util.List;

import datos.Gastronomia;
import datos.Hospedaje;
import datos.Servicio;
import datos.Sistema;
import negocio.ServicioABM;

public class TestTraerServicio {

	public static void main(String[] args) {
		
		Sistema sistema = null;
		Servicio servicio1 = null;
		Servicio servicio2 = null;
		Hospedaje hospedaje = null;
		Gastronomia gastronomia = null;
		int idServicio = 3;
		
		try
		{
			//TRAER SERVICIOS EN PROMO
			/*List<Servicio> listaEnPromo = ServicioABM.getInstance().traer(true);
			for(Servicio s : listaEnPromo)
				System.out.println(s + " " + s.isEnPromocion());*/
			
			//TRAER SERVICIO POR ID
			/*servicio = ServicioABM.getInstance().traer(idServicio);
			
			if(servicio instanceof Hospedaje)
			{
				hospedaje = (Hospedaje) servicio;
				System.out.println(hospedaje + " " + hospedaje.getSistema());
			}
			
			else
			{
				if(servicio instanceof Gastronomia)
				{
					gastronomia = (Gastronomia) servicio;
					System.out.println(gastronomia + " " + gastronomia.getSistema());
				}
			}*/
			
			
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
