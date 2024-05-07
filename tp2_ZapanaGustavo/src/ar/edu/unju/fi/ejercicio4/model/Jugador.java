package ar.edu.unju.fi.ejercicio4.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio4.constantes.Posicion;

public class Jugador {
private String nombre;
private String apellido;
private LocalDate fechaNac;
private String nacionalidad;
private float estatura;
private float peso;
private Posicion posicion;

public Jugador() {
	// TODO Auto-generated constructor stub
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

public LocalDate getFechaNac() {
	return fechaNac;
}

public void setFechaNac(LocalDate fechaNac) {
	this.fechaNac = fechaNac;
}

public String getNacionalidad() {
	return nacionalidad;
}

public void setNacionalidad(String nacionalidad) {
	this.nacionalidad = nacionalidad;
}

public float getEstatura() {
	return estatura;
}

public void setEstatura(float estatura) {
	this.estatura = estatura;
}

public float getPeso() {
	return peso;
}

public void setPeso(float peso) {
	this.peso = peso;
}

public Posicion getPosicion() {
	return posicion;
}
public void setPosicion(Posicion posicion) {
	this.posicion = posicion;
}

public int calcularEdad() {
	boolean cumpleanios;
	LocalDate today = LocalDate.now();
	cumpleanios = (today.getMonthValue()==this.fechaNac.getMonthValue()) && (today.getDayOfMonth()==this.fechaNac.getDayOfMonth());
	int edad = today.getYear()-this.fechaNac.getYear();
	if(cumpleanios)
		return edad;
	else if (edad==0)
	    return 0;
	else
		return edad-1;
		
}

@Override
public String toString() {
	return "Nombre Jugador: " + this.getNombre() +  "\n" +
           "Apellido Jugador: " + this.getApellido() + "\n" +
		   "Fecha de nacimiento" + this.getFechaNac() + "\n" +
           "Edad: " + this.calcularEdad() + "\n" +
		   "Nacionalidad: "+ this.getPeso() + "\n" +
           "Altura: " + this.getEstatura() + "\n" + 
		   "Peso: " + this.getPeso() + "\n" +
           "Posicion: " + this.getPosicion();
           

}
}
