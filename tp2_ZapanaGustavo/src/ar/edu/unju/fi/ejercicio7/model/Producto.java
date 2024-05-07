package ar.edu.unju.fi.ejercicio7.model;

public class Producto {
	private String codigo;
	private String descripcion;
	private Double precioUnitario;
	private origenFabricacion origeFabricacion;
	private categoria categoria;
	private boolean stock;
	
	public Producto() {
		// TODO Auto-generated constructor stub
	}

	public Producto(String codigo, String descripcion, Double precioUnitario, origenFabricacion origeFabricacion,
			categoria categoria, boolean stock) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
		this.origeFabricacion = origeFabricacion;
		this.categoria = categoria;
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Producto \nCodigo: " + codigo + "\nDescripcion: " + descripcion + "\nPrecio Unitario: $" + precioUnitario;
	}
	


	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(Double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public origenFabricacion getOrigeFabricacion() {
		return origeFabricacion;
	}

	public void setOrigeFabricacion(origenFabricacion origeFabricacion) {
		this.origeFabricacion = origeFabricacion;
	}

	public categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(categoria categoria) {
		this.categoria = categoria;
	}
	
	public boolean isStock() {
		return stock;
	}

	public void setStock(boolean stock) {
		this.stock = stock;
	}

	public enum origenFabricacion{
		ARGENTINA, CHINA, BRASIL, URUGUAY
	}

	public enum categoria{
		TELEFONIA, INFORMATICA, ELECTROHOGAR, HERRAMIENTAS
	}
}