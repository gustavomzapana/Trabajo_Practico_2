package ar.edu.unju.fi.ejercicio5.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio5.interfaces.Pago;

public class PagoTarjeta implements Pago{
	
	private String numeroTarjeta;
	private LocalDate fechaDePago;
	private double montoPagado;
	
	
	public PagoTarjeta() {
		// TODO Auto-generated constructor stub
	}

	public PagoTarjeta(String numeroTarjeta, LocalDate fechaDePago, double montoPagado) {
		this.numeroTarjeta = numeroTarjeta;
		this.fechaDePago = fechaDePago;
		this.montoPagado = montoPagado;
	}
	
	

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public LocalDate getFechaDePago() {
		return fechaDePago;
	}

	public void setFechaDePago(LocalDate fechaDePago) {
		this.fechaDePago = fechaDePago;
	}

	public double getMontoPagado() {
		return montoPagado;
	}

	public void setMontoPagado(double montoPagado) {
		this.montoPagado = montoPagado;
	}

	@Override
	public double realizarPago(double monto) {
		double porcentaje=monto*15/100;
		double total=monto+porcentaje;	
		return total;
	}

	@Override
	public void imprimirRecibo() {
		System.out.println("**Recibo**");
		System.out.println("Numero de Tarjeta: "+getNumeroTarjeta());
		System.out.println("Fecha de pago: "+getFechaDePago());
		System.out.println("Monto pagado: $"+getMontoPagado());		
	}

}