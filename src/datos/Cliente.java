package datos;

import java.util.LinkedHashSet;
import java.util.Set;

public class Cliente {

	private int idCliente;
	private String nombre;
	private String apellido;
	private String dni;
	private Set<Hospedaje> hospedajes;
	
	public Cliente() {}

	public Cliente(String nombre, String apellido, String dni)
	{
		super();
		setNombre(nombre);
		setApellido(apellido);
		setDni(dni);
		setHospedajes(new LinkedHashSet<Hospedaje>());
	}
	
	public int getIdCliente() {
		return idCliente;
	}

	private void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Set<Hospedaje> getHospedajes() {
		return hospedajes;
	}

	public void setHospedajes(Set<Hospedaje> hospedajes) {
		this.hospedajes = hospedajes;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni
				+ "]";
	}
	
	
}
