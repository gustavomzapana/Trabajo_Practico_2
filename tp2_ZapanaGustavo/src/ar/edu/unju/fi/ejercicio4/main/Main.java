package ar.edu.unju.fi.ejercicio4.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio4.constantes.Posicion;
import ar.edu.unju.fi.ejercicio4.model.Jugador;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		 //Arraylist
		List<Jugador> listaJugadores = new ArrayList<>();
		int opcion;
		
		do {
			System.out.println(menu());
			opcion = ingresoNumero(scanner,"Ingrese opcion: ");
			
			switch(opcion) {
			case 1: 
				altaJugador(scanner,listaJugadores);
				break;
			case 2:
				mostrarJugadores(listaJugadores);
				break;
			case 3: 
				gestionarJugador(scanner,listaJugadores,opcion);
				break;
			case 4:
				gestionarJugador(scanner,listaJugadores,opcion);
				break;
			case 5:
				System.out.println("Fin Programa.");
				break;
			default:
				System.out.println("ERROR. Ingrese una opcion valida.");
			}

			
		}while (opcion!=5);

     
	}
	public static String menu(){
		return "\n 1 – Alta de jugador \n 2 – Mostrar todos los jugadores ordenados por apellido\n " +
				 "3 - Modificar la posicion de un jugador \n 4 – Eliminar un jugador \n ";
	}
	
	public static float validarValor(Scanner scanner, String frase) { 
		float n = -1f;
		do {
			System.out.println(frase);
			try {
				n = scanner.nextFloat();
	        } catch (InputMismatchException e) {
	            scanner.nextLine();
		    	System.out.println("\nIngrese una número valido para continuar\n");
		    	continue;
	        }
			if (n<=0) {
				System.out.println("\nIngreso de un número no positivo\n"); 
			}
		} while (n<=0);
        scanner.nextLine();
		return n;
	}
	public static int validarNumero(Scanner scanner) {
		int n = -1;
		do {
			try {
				n = scanner.nextInt();
	        } catch (InputMismatchException e) {
	            scanner.nextLine();
		    	System.out.println("\nIngrese una número valido para continuar\n");
		    	continue;
	        }
			if (n<=0) {
				System.out.println("\nIngreso de un número no positivo\n"); 
			}
		} while (n<=0);
        scanner.nextLine();
		return n;
	}
	
	public static Posicion ingresarPosicion(Scanner scanner) {
		Posicion[] posiciones = Posicion.values();
		int op;
		do {
			System.out.println("\n1 – Delantero\n2 – Medio\n3 – Defensa\n4 - Arquero\n");
            System.out.println("Ingrese opcion");
			op = validarNumero(scanner);	
			if (op<1 || op>4) {
				System.out.println("\nPosición de jugador inválida\n");
			}
		} while (op<1 || op>4);
		return posiciones[op-1];
	}
	
	public static void altaJugador (Scanner scanner,List <Jugador> jugadores) {
		Jugador jugador = new Jugador();
		
			jugador.setNombre(ingresoCadena(scanner,"Ingrese nombre: "));
			jugador.setApellido(ingresoCadena(scanner, "Ingrese apellido: "));
			jugador.setFechaNac(ingresoFecha(scanner, "Ingrese fecha: "));
			jugador.setNacionalidad(ingresoCadena(scanner,"Ingrese nacionalidad: "));
			jugador.setEstatura(validarValor(scanner,"Ingrese estatura(valor decimal): "));
			jugador.setPeso(validarValor(scanner,"Ingrese peso(valor decimal): "));
			jugador.setPosicion(ingresarPosicion(scanner));
		
		jugadores.add(jugador);
	}
	
	public static String ingresoCadena(Scanner scanner, String frase) {
		System.out.println(frase);
		String cadena = scanner.next();
		return cadena;
	}
	
	public static LocalDate ingresoFecha(Scanner scanner, String frase) {
		LocalDate fecha = null;
		int anio,mes,dia;
				
		        anio = ingresoNumero(scanner,frase + "\nIngrese año: ");
		    	mes = ingresoNumero(scanner,"Ingrese mes: ");
		    	dia = ingresoNumero(scanner,"Ingrese dia: ");
		    	fecha = LocalDate.of(anio,mes,dia);

		return fecha;
	}
	
	
	public static int ingresoNumero(Scanner scanner, String frase) {
		int n=0;
		do {
			System.out.println(frase);
			n = scanner.nextInt();
			if (n<=0) {
				System.out.println("\n ERROR. Debe ingresar un N° positivo.\n"); 
			}
		 } while (n<=0);
		return n;
	}
	
	
	public static String determinarPosicion(int opc) {
		if (opc==1) {
			return "Delantero";
		}
		else if(opc==2) {
			return "Medio";
		}
		else {
			return (opc==3) ? "Defensa" : "Arquero";
		}
	}
	
	
	
	public static String ingresoPosicion(Scanner scanner, String frase) {
		int opc= -1;
		do { 
			
			System.out.println("\n 1 – Delantero\n 2 – Medio\n 3 – Defensa\n 4 - Arquero\n");
		     try {
		    	 opc = ingresoNumero(scanner, "Ingrese opcion: ");
		    			 
		     } catch(InputMismatchException e) {
		    	 scanner.nextLine();
		    	 System.out.println("ERROR. Ingrese un numero valido.");
		    	 continue; 	 
		     }
		     if(opc<1 || opc>4)
		    	 System.out.println("Ingrese una posicion valida.");
			
		}while(opc<1 || opc>4);
    return determinarPosicion(opc);		
	}
	
	
	public static int buscarJugador(List<Jugador> jugadores, String nombre, String apellido) {
	    Iterator<Jugador> iteratorJugadores = jugadores.iterator();
	    int i=0;
	    boolean encontrado=false;
	    while (iteratorJugadores.hasNext() && !encontrado) {
	    	Jugador jug = iteratorJugadores.next();
	    	if(jug.getNombre().equalsIgnoreCase(nombre) && jug.getApellido().equalsIgnoreCase(apellido)) {
	    		encontrado = true;
	    		continue;
	    	}
	     i++;    
	    }
		if(encontrado)
			return i;
		else
		    return -1;
	}
	
	
	public static void modificarJugador(Scanner scanner, List<Jugador> jugadores, int pos){
	    		Jugador jugador = jugadores.get(pos);
	    		System.out.println("CAMBIO POSICION");
	    		jugador.setPosicion(ingresarPosicion(scanner));

	}
	
	public static void gestionarJugador(Scanner scanner, List<Jugador> jugadores,int op) {
		String nombre = ingresoCadena(scanner,"Ingrese nombre: ");
		String apellido = ingresoCadena(scanner, "ingrese apellido: ");
		int pos = buscarJugador(jugadores,nombre, apellido);
		if(pos==-1) {
			System.out.println("No se encontro el jugador.");	
		}
		else {
			 if (op == 3) {
				modificarJugador(scanner,jugadores,pos);
			}
			else
				jugadores.remove(pos);
			    System.out.println("Jugador eliminado con éxito.");
		}
	}

	
	public static void mostrarJugadores(List<Jugador> jugadores) {
		if (jugadores.isEmpty()) {
			System.out.println("\nLa lista de jugadores se encuentra vacía\n");
		}
		else {
			jugadores.sort(Comparator.comparing(Jugador::getApellido));
			jugadores.forEach(jug -> System.out.println(jug.toString()));
		}
	}
	
	

}

