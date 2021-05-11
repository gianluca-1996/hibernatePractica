package test;

import java.util.LinkedHashSet;
import java.util.Set;

import dao.SistemaDao;
import datos.Gastronomia;
import datos.Hospedaje;
import datos.Servicio;
import datos.Sistema;
import negocio.SistemaABM;

public class TestAgregarSistema {

	public static void main(String[] args) {
		
		int idSistema;
		Sistema sistema = new Sistema("MGM GRAND LAS VEGAS");
		Set<Servicio> servicios = new LinkedHashSet<Servicio>();
		servicios.add(new Gastronomia(0.15, true, 200, 3, sistema));
		servicios.add(new Hospedaje(0.15, true, "Suite de lujo 5 estrellas", 40000, sistema));
		servicios.add(new Hospedaje(0.15, false, "Suite de lujo 4 estrellas", 30000, sistema));
		sistema.setServicios(servicios);
		
		try
		{
			idSistema = SistemaABM.getInstance().agregar(sistema);
			sistema = SistemaABM.getInstance().traer(idSistema);
			System.out.println(sistema);
			for(Servicio s : sistema.getServicios())
				System.out.println(s);
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}

	}

}
