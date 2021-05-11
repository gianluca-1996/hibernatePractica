package datos;

import java.time.LocalDate;

public class Gastronomia extends Servicio{

	private int idGastronomia;
	private double precio;
	private int diaSemDesc;
	
	public Gastronomia() {}
	
	public Gastronomia(double porcentajeDescuento, boolean enPromo, double precio, int diaSemDesc, Sistema sistema)
	{
		super(porcentajeDescuento, enPromo, sistema);
		setPrecio(precio);
		setDiaSemDesc(diaSemDesc);
	}

	public int getIdGastronomia() {
		return idGastronomia;
	}

	private void setIdGastronomia(int idGastronomia) {
		this.idGastronomia = idGastronomia;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getDiaSemDesc() {
		return diaSemDesc;
	}

	public void setDiaSemDesc(int diaSemDesc) {
		this.diaSemDesc = diaSemDesc;
	}

	@Override
	public double calcularPrecioFinal(LocalDate dia) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String toString() {
		return "Gastronomia [idGastronomia=" + getIdServicio() + ", precio=" + precio + ", diaSemDesc=" + diaSemDesc
				+ "]";
	}
	
}
