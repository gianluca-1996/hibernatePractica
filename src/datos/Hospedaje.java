package datos;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

public class Hospedaje extends Servicio{

	private int idHospedaje;
	private String hospedaje;
	private double precioPorNoche;
	private Set<Cliente> clientesHospedados;
	
	public Hospedaje() {}
	
	public Hospedaje(double porcentajeDesc, boolean enPromo, String hospedaje, double precioPorNoche, Sistema sistema)
	{
		super(porcentajeDesc, enPromo, sistema);
		setHospedaje(hospedaje);
		setPrecioPorNoche(precioPorNoche);
		setClientesHospedados(new LinkedHashSet<Cliente>());
	}

	public int getIdHospedaje() {
		return idHospedaje;
	}

	private void setIdHospedaje(int idHospedaje) {
		this.idHospedaje = idHospedaje;
	}

	public String getHospedaje() {
		return hospedaje;
	}

	public void setHospedaje(String hospedaje) {
		this.hospedaje = hospedaje;
	}

	public double getPrecioPorNoche() {
		return precioPorNoche;
	}

	public void setPrecioPorNoche(double precioPorNoche) {
		this.precioPorNoche = precioPorNoche;
	}

	public Set<Cliente> getClientesHospedados() {
		return clientesHospedados;
	}

	public void setClientesHospedados(Set<Cliente> clientesHospedados) {
		this.clientesHospedados = clientesHospedados;
	}

	@Override
	public double calcularPrecioFinal(LocalDate dia) {
		
		double precioFinal = getPrecioPorNoche();
		
		if(this.isEnPromocion())
		{
			if(dia.getDayOfWeek() != DayOfWeek.SUNDAY & dia.getDayOfWeek() != DayOfWeek.SATURDAY )
			{
				precioFinal = getPrecioPorNoche() * getPorcentajeDescuento();
			}
		}
		
		return precioFinal;
	}
	
	@Override
	public String toString() {
		return "Hospedaje [idHospedaje=" + getIdServicio() + ", hospedaje=" + hospedaje + ", precioPorNoche="
				+ precioPorNoche + "]";
	}
	
	
}
