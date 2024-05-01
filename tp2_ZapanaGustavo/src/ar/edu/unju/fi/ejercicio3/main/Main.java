package ar.edu.unju.fi.ejercicio3.main;

import ar.edu.unju.fi.ejercicio3.constantes.Provincia;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Provincia[] provincias = Provincia.values();
		mostrarProvincias(provincias);
	}
	
	public static void mostrarProvincias(Provincia[] provincias) {
		for (Provincia prov : provincias) {
			System.out.println(prov.toString());
		}
	}
	

}
