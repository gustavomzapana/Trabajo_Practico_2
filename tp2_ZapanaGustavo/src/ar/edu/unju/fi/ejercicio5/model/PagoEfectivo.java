package ar.edu.unju.fi.ejercicio5.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio5.interfaces.Pago;

public class PagoEfectivo implements Pago {
	
	private double montoPagado;
	private LocalDate fechaDePago;
	
	public PagoEfectivo() {
		// TODO Auto-generated constructor stub
	}

	
	public PagoEfectivo(double montoPagado, LocalDate fechaDePago) {
		this.montoPagado = montoPagado;
		this.fechaDePago = fechaDePago;
	}

	public double getMontoPagado() {
		return montoPagado;
	}





	public void setMontoPagado(double montoPagado) {
		this.montoPagado = montoPagado;
	}





	public LocalDate getFechaDePago() {
		return fechaDePago;
	}





	public void setFechaDePago(LocalDate fechaDePago) {
		this.fechaDePago = fechaDePago;
	}





	@Override
	public double realizarPago(double monto) {
		double porcentaje=monto*10/100;
		double total=monto-porcentaje;	
		return total;
	}
	
	@Override
	public void imprimirRecibo() {
		System.out.println("**Recibo**");
		System.out.println("Fecha de pago: "+getFechaDePago());
		System.out.println("Monto pagado: "+getMontoPagado());
		
		
	}

}