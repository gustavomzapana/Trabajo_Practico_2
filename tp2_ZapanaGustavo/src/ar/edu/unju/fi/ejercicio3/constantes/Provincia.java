package ar.edu.unju.fi.ejercicio3.constantes;

public enum Provincia {
	JUJUY(770881,53244), SALTA(1424397,155340),
	TUCUMAN(1694656,22592), CATAMARCA(415438,101486),
	LA_RIOJA(393531,91493), SANTIAGO_DEL_ESTERO(978313,136934);
	
	private int CANTIDAD_POBLACION;
	private float SUPERFICIE;
	
	private Provincia() {
		// TODO Auto-generated constructor stub
	}
	
	private Provincia(int CANTIDAD_POBLACION, float SUPERFICIE) {
		this.CANTIDAD_POBLACION = CANTIDAD_POBLACION;
		this.SUPERFICIE = SUPERFICIE;
	}

	public int getCANTIDAD_POBLACION() {
		return CANTIDAD_POBLACION;
	}

	public float getSUPERFICIE() {
		return SUPERFICIE;
	}
	
	public float calcularDensidad() {
		return this.getCANTIDAD_POBLACION()/this.getSUPERFICIE();
	}
	
	@Override
	public String toString() {
		return "Provincia: " + this.name() + "\n" +
			   "Cantidad de habitantes: " + this.getCANTIDAD_POBLACION() + "\n" +
			   "Superficie: " + this.getSUPERFICIE () + "km²\n" +
			   "Calcular densidad: " + this.calcularDensidad() + "\n";
	}


}
