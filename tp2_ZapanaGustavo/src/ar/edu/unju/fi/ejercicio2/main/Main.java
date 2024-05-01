package ar.edu.unju.fi.ejercicio2.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio2.constantes.Mes;
import ar.edu.unju.fi.ejercicio2.model.Efemeride;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
	    List<Efemeride> lista = new ArrayList<>();
	    int op;
	    do {
	    	System.out.println(invocarMenu());
	    	System.out.println("Ingrese una opcion: ");
	    	op = scanner.nextInt();
	    	
	    	switch(op) {
	    	case 1:
	    		crearEfemeride(lista, scanner);
	    		break;
	    	case 2:
	    		mostrarEfemerides(lista);
	    		break;
	    	case 3:
	    		gestionarEfemeride(scanner, lista, true); 
	    		System.out.println("Eliminación exitosa.");
	    		break;
	    	case 4:
	    		gestionarEfemeride(scanner, lista, false); 
	    		break;
	    	case 5:
	    		System.out.println("FIN PROGRAMA");
	    		break;
	    	}
	    	
	    	
	    }while(op!=5);
	    
	    

	}
	
	public static String invocarMenu() {
		return "1- Crear efemeride \n"+
	           "2- Mostrar efemerides \n"+
			   "3- Eliminar efemeride \n"+
	           "4- Modificar efemeride \n"+
			   "5- Salir";
	}
	
	public static String invocarMenuMes() {
		return "\n---- Mes ----\n1 - Enero\n2 - Febrero\n3 - Marzo\n4 - Abril\n5 - Mayo\n6 - Junio\n" +
                "7 - Julio\n8 - Agosto\n9 - Septiembre\n10 - Octubre\n11 - Noviembre\n12 - Diciembre\n";
	}
	
	public static boolean chequearDia(int dia, Mes mes) {
		if (mes==Mes.FEBRERO) {
			return (dia>=1 && dia<=29);
		}
		else if (mes==Mes.ABRIL || mes==Mes.JUNIO || mes==Mes.SEPTIEMBRE || mes==Mes.NOVIEMBRE) {
			return (dia>=1 && dia<=30);
		}
		else {
			return (dia>=1 && dia<=31);
		}
	}
	
	public static int ingresarDia(Scanner scanner, Mes mes) {
		int dia;
		do {
			System.out.println("Ingrese dia");
			dia = scanner.nextInt();
			if (chequearDia(dia,mes)==false) {
				System.out.println("\nIngrese una día valido para continuar\n");
			}
		} while (chequearDia(dia,mes)==false);
		return dia;
	}
	
	
	public static void actualizarEfemeride (Scanner scanner, Efemeride nuevo, int op) {
		switch(op) {
		case 1: 
			Mes[] meses = Mes.values();
			int opc;
			do {
				System.out.println(invocarMenuMes());
				System.out.println("Ingrese opcion: ");
				opc = scanner.nextInt();
				if(opc<1 || opc >12) {
					System.out.println("Ingrese una opcion correcta.");
				}
				
			}while(opc<1 || opc >12);
			
			nuevo.setMes(meses[opc-1]);
			break;
		case 2:	
			nuevo.setDia(ingresarDia(scanner, nuevo.getMes()));
			break;
		case 3:	
			System.out.println("Ingrese detalle: ");
			String detalle = scanner.next();
			nuevo.setDetalle(detalle);
			break;
		}
	}
	
	public static void crearEfemeride(List<Efemeride> lista,Scanner scanner) {
		Efemeride nuevoEfemeride = new Efemeride();
		for (int i=0;i<=3;i++) {
			if (i==0) {
				int codigo = (lista.isEmpty()) ? 1 : lista.get(lista.size()-1).getCodigo()+1;
				nuevoEfemeride.setCodigo(codigo);
			}
			else {
				actualizarEfemeride(scanner,nuevoEfemeride,i);
			}
		}
		lista.add(nuevoEfemeride);
	}
	
	public static void mostrarEfemerides(List<Efemeride> lista) {
		if (lista.isEmpty()) {
			System.out.println("\nLa lista de efemérides se encuentra vacía\n");
		}
		else {
			lista.forEach(e -> System.out.println(e.toString()));
		}
	}
	

	public static void modificarEfemeride(Scanner scanner, List<Efemeride> efemerides, int pos) {
		int op;
		do {
			System.out.println("Elegir una opcion: ");
			System.out.println("\n1 – Mes \n2 – Dia \n3 – Detalle \n4 - Salir\n");
			op = scanner.nextInt();
			if (op>=1 && op<=4) {
				if (op==1) {
					actualizarEfemeride(scanner,efemerides.get(pos),1);
					actualizarEfemeride(scanner,efemerides.get(pos),2);
				}
				else {
					actualizarEfemeride(scanner,efemerides.get(pos),op);
				}
			}
			else {
		    	System.out.println("\nIngrese una opción valida para continuar\n");
			}
		} while (op!=4);
		
	}
	
	public static int buscarEfemeride(List<Efemeride> lista, int codigo) {
		int buscado=-10;
		for (int i=0;i<lista.size() && buscado==-10;i++) {
			if (lista.get(i).getCodigo()==codigo) {
				buscado=i;
			}
		}
		return buscado;
	}
	
	
	public static void gestionarEfemeride(Scanner scanner, List<Efemeride> lista, boolean eliminar) {
		int codigo=-1;
		//validar ingreso de codigo
		do {
			System.out.println("Ingrese codigo del efemeride: ");
			try {
				codigo = scanner.nextInt();
	        } catch (InputMismatchException e) {
	            scanner.nextLine();
		    	System.out.println("\nIngrese un numero valido para continuar\n");
		    	continue;
	        }
			if (codigo<=0) {
				System.out.println("\nIngreso de un número no positivo\n"); 
			}
		} while (codigo<=0);
		System.out.println(codigo);
        //obtener posicion si es que existe el codigo
		int pos = buscarEfemeride(lista,codigo);
		if (pos!=-10) {
			if (!eliminar) {
				modificarEfemeride(scanner,lista,pos);
			}
			else {
				lista.remove(pos);
			}
		}
		else {
			System.out.println("\nNo se encontro al efeméride ingresado");
		}
	}

}
