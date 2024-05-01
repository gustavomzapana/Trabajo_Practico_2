package ar.edu.unju.fi.ejercicio2.model;

import ar.edu.unju.fi.ejercicio2.constantes.Mes;

public class Efemeride {
	private int codigo;
	private Mes mes;
	private int dia;
	private String detalle;

	public Efemeride() {
		// TODO Auto-generated constructor stub
	}

	public Efemeride(int codigo, Mes mes, int dia, String detalle) {
		super();
		this.codigo = codigo;
		this.mes = mes;
		this.dia = dia;
		this.detalle = detalle;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Mes getMes() {
		return mes;
	}

	public void setMes(Mes mes) {
		this.mes = mes;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	
	@Override
	public String toString() {
		return "\nCódigo: " + this.getCodigo() + "\n" +
				"Mes: " + this.getMes() + "\n" +
				"Dia: " + this.getDia() + "\n" +
				"Detalle: " + this.getDetalle();
	}
}
