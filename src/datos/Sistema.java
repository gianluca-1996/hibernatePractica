package datos;

import java.util.LinkedHashSet;
import java.util.Set;

public class Sistema {

	private int idSistema;
	private String nombre;
	private Set<Servicio> servicios;
	
	public Sistema() {}
	
	public Sistema(String nombre)
	{
		super();
		setNombre(nombre);
		setServicios(new LinkedHashSet<Servicio>());
	}

	public int getIdSistema() {
		return idSistema;
	}

	private void setIdSistema(int idSistema) {
		this.idSistema = idSistema;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Servicio> getServicios() {
		return servicios;
	}

	public void setServicios(Set<Servicio> servicios) {
		this.servicios = servicios;
	}

	@Override
	public String toString() {
		return "Sistema [idSistema=" + idSistema + ", nombre=" + nombre + "]";
	}
	
}
