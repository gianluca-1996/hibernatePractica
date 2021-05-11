package datos;

import java.time.LocalDate;

public abstract class Servicio {

	private int idServicio;
	private double porcentajeDescuento;
	private boolean enPromocion;
	private Sistema sistema;
	
	public Servicio() {}
	
	public Servicio(double porcentajeDesc, boolean enPromo, Sistema sistema)
	{
		super();
		setPorcentajeDescuento(porcentajeDesc);
		setEnPromocion(enPromo);
		setSistema(sistema);
	}

	public int getIdServicio() {
		return idServicio;
	}

	protected void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}

	public double getPorcentajeDescuento() {
		return porcentajeDescuento;
	}

	public void setPorcentajeDescuento(double porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}

	public boolean isEnPromocion() {
		return enPromocion;
	}

	public void setEnPromocion(boolean enPromocion) {
		this.enPromocion = enPromocion;
	}

	public Sistema getSistema() {
		return sistema;
	}

	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
	}

	public abstract double calcularPrecioFinal(LocalDate dia);
	
	@Override
	public String toString() {
		return "Servicio [idServicio=" + idServicio + ", porcentajeDescuento=" + porcentajeDescuento + ", enPromocion="
				+ enPromocion + "]";
	}
	
}
