package test;

import java.time.LocalDate;

import datos.Gastronomia;
import datos.Hospedaje;
import datos.Servicio;
import datos.Sistema;
import negocio.ServicioABM;

public class TestTraerServicio {

	public static void main(String[] args) {
		
		Sistema sistema = null;
		Servicio servicio = null;
		Hospedaje hospedaje = null;
		Gastronomia gastronomia = null;
		int idServicio = 2;
		
		try
		{
			servicio = ServicioABM.getInstance().traer(idServicio);
			
			if(servicio instanceof Hospedaje)
			{
				hospedaje = (Hospedaje) servicio;
				System.out.println(hospedaje + " " + hospedaje.isEnPromocion());
				System.out.println("MODIFICAR HOSPEDAJE : EN PROMOCION TRUE");
				hospedaje.setEnPromocion(false);
				ServicioABM.getInstance().actualizar(hospedaje);
				System.out.println(hospedaje);
				System.out.println("Precio final = " + hospedaje.calcularPrecioFinal(LocalDate.of(2021, 3, 22)));
			}
			
			else
			{
				if(servicio instanceof Gastronomia)
				{
					gastronomia = (Gastronomia) servicio;
					System.out.println(gastronomia + " Sistema: " + gastronomia.getSistema());
				}
			}
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}

	}

}
