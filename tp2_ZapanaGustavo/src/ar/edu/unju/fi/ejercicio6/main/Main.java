package ar.edu.unju.fi.ejercicio6.main;

import ar.edu.unju.fi.ejercicio6.interfaces.funcionales.Converter;
import ar.edu.unju.fi.ejercicio6.model.FelinoDomestico;
import ar.edu.unju.fi.ejercicio6.model.FelinoSalvaje;

public class Main {

	public static void main(String[] args) {
		FelinoDomestico gato = new FelinoDomestico("Garfield", (byte)12, 10f);
		Converter<FelinoDomestico, FelinoSalvaje> converter = x-> new FelinoSalvaje(x.getNombre(),x.getEdad(),x.getPeso());
		FelinoSalvaje felino1 = converter.convert(gato);
		converter.mostrarObjeto(felino1);


		FelinoSalvaje gatoSalvaje = new FelinoSalvaje("Tanner", (byte)20, 186f);
		if(Converter.isNotNull(gatoSalvaje)) {
			Converter<FelinoSalvaje, FelinoDomestico> convert = x-> new FelinoDomestico(x.getNombre(),x.getEdad(),x.getPeso());
			FelinoDomestico gatoNuevo = convert.convert(gatoSalvaje);
			convert.mostrarObjeto(gatoNuevo);
		}else {
			System.out.println("Es una Clase Null");
		}


	}

}
