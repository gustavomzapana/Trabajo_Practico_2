package ar.edu.unju.fi.ejercicio1.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio1.model.Producto;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int op;
		Scanner scanner = new Scanner(System.in);
	
	
		//creando Arraylist
		List<Producto> lista = new ArrayList<>();
		do {
			System.out.println(invocarMenu());
			System.out.println("Ingrese opcion: ");
			op = scanner.nextInt();
			
			switch (op) {
			case 1:
				crearProducto(scanner,lista);
				break;
			case 2:
				mostrarProducto(lista);
				break;
			case 3:
				modificarProducto(scanner, lista);
				break;
			case 4:
				System.out.println("Programa finalizado.");
				break;
			}
			
		}while (op!=4);
		
	}

	public static String invocarMenu() {
		return "\n -- MENU -- \n 1- Crear Producto \n 2- Mostrar Producto \n 3-Modificar Producto \n 4-Salir.";	
	}	
	
	public static void actualizarProducto (Scanner scanner, Producto prod, int op) {
		
		switch(op) {
		case 1:
			System.out.println("Ingrese descripcion: ");
			String cadena = scanner.next();
			prod.setDescripcion(cadena);
			break;
			
		case 2:	
			System.out.println("Ingrese Precio unitario: ");
			float precio = scanner.nextFloat();
			prod.setPrecioUnitario(precio);
			break;
			
		case 3:
			System.out.println("\n---- Origen de fabricación ------\n1 - Argentina\n2 - China\n3 - Brasil\n4 - Uruguay\n");
			System.out.println("Ingrese Origen de fabricacion: ");
			Producto.OrigenFabricacion[] valores = Producto.OrigenFabricacion.values();
			int opc;
			do{
				System.out.println("Ingrese opcion: ");
				opc = scanner.nextInt();
				if(opc<1 || opc >4) {
					System.out.println("Ingrese una opcion valida");
				}
			}while(opc<1 || opc >4);
			prod.setOrigenFabricacion(valores[opc-1]); 
			break;
		case 4:
			System.out.println("\n------ Categoría ------\n1 - Telefonía\n2 - Informática\n3 - Electro hogar\n4 - Herramientas\n");
			System.out.println("Ingrese categoria: ");
			Producto.Categoria[] categorias = Producto.Categoria.values();
			int opcion;
			do {
				System.out.println("Ingrese opcion: ");
				opcion = scanner.nextInt();
				if(opcion<1 || opcion>4) {
					System.out.println("Ingrese una opcion valida");
				}	
			}while(opcion<1 || opcion >4);
			prod.setCategoria(categorias[opcion-1]);

		}
	}
	
	public static void crearProducto (Scanner scanner, List<Producto> lista) {
		Producto producto = new Producto();
		
		for (int i=0;i<=4;i++) {
			if (i==0) {
				int codigo = (lista.isEmpty()) ? 1 : lista.get(lista.size()-1).getCodigo()+1;
				producto.setCodigo(codigo);
			}
			else {
				actualizarProducto(scanner,producto,i);
			}
		}
	
		
		lista.add(producto);
	}
	
	public static void mostrarProducto(List<Producto> lista) {
		if(lista.isEmpty()) {
			System.out.println("La lista de productos esta vacía.");
	
		}else {
			lista.forEach(prod -> System.out.println(prod.toString()));;
		}
	}
	
	public static int buscarProd(List<Producto> lista, int codigo) {
		int buscado=-10;
		for(int i=0;i<lista.size() && buscado==-10;i++) {
			if(lista.get(i).getCodigo()==codigo) {
				buscado=i;
			}
		}
		return buscado;
	}
	public static void modificarProducto(Scanner scanner, List<Producto> lista) {
		System.out.println("Ingrese codigo del producto: ");
		int codigo = scanner.nextInt();
		int pos = buscarProd(lista, codigo);	
		if(pos!=-10) {
			int op;
			do {
				System.out.println("\n1 – Descripción\n2 – Precio unitario\n3 – Origen de fabricación\n4 - Categoría\n5 - Salir\n");
				System.out.println("Elija una opcion para modificar: ");
				op = scanner.nextInt();
				if(op>=1 && op<=5) {
					actualizarProducto(scanner,lista.get(pos),op);
				}
				else {
					System.out.println("Ingrese una opcion valida");
				}	
			}while(op!=5);
		}else {
			System.out.println("No se encontro el producto.");
		}
		
	}
}



