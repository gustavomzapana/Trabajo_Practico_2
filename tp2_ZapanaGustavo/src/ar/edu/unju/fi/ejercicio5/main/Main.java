package ar.edu.unju.fi.ejercicio5.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio5.model.Product.origenFabricacion;
import ar.edu.unju.fi.ejercicio5.model.PagoEfectivo;
import ar.edu.unju.fi.ejercicio5.model.PagoTarjeta;
import ar.edu.unju.fi.ejercicio5.model.Product;
import ar.edu.unju.fi.ejercicio5.model.Product.categoria;

public class Main {

	public static void main(String[] args) {
		List<Product> arrayProducto = new ArrayList<Product>();
		List<Product> arrayProdCarrito = new ArrayList<Product>();

		int opcion=0;
		Scanner scanner = new Scanner(System.in);

		cargarProductos(arrayProducto);
		do {
			try {
				System.out.println("--- MENU ---");
				System.out.println("1 – Mostrar Productos en Stock");
				System.out.println("2 – Realizar compra ");
				System.out.println("3 – Salir");
				System.out.println("9 – Mostrar Todos los Productos");
				System.out.println("Ingrese opcion: ");
				opcion=scanner.nextInt();

				switch(opcion) {
				case 1:
					mostrarStock(arrayProducto);
					break;
				case 2:
					realizarCompra(arrayProducto, arrayProdCarrito);
					break;
				case 3:
					System.out.println("Adios...");
					break;
				case 4:

					break;
				case 9:
					mostrarProductos(arrayProducto);
					break;

				default:
					System.out.println("ERROR");
				}
			}catch(InputMismatchException e) {
				System.out.println("debe ingresar un numero");
				scanner.next();
			}
		}while(opcion!=3);
	}
	
	public static void cargarProductos(List<Product> listaProd) {
		
		Product prod1 = new Product("p1", "Lavarropas", 28550.0, origenFabricacion.ARGENTINA, categoria.ELECTROHOGAR, false);
		listaProd.add(prod1);	
		Product prod2 = new Product("p2", "Televisor", 35000.0, Product.origenFabricacion.CHINA, Product.categoria.ELECTROHOGAR, true);
		listaProd.add(prod2);	
		Product prod3 = new Product("p3", "Laptop", 65000.0, Product.origenFabricacion.CHINA, Product.categoria.INFORMATICA, true);
		listaProd.add(prod3);		
		Product prod4 = new Product("p4", "Taladro", 1500.0, Product.origenFabricacion.URUGUAY, Product.categoria.HERRAMIENTAS, false);
		listaProd.add(prod4);		
		Product prod5 = new Product("p5", "Smartphone", 20000.0, Product.origenFabricacion.BRASIL, Product.categoria.TELEFONIA, false);
		listaProd.add(prod5);	
		Product prod6 = new Product("p6", "Impresora", 5000.0, Product.origenFabricacion.ARGENTINA, Product.categoria.INFORMATICA, true);
		listaProd.add(prod6);
		Product prod7 = new Product("p7", "Aspiradora", 8000.0, Product.origenFabricacion.CHINA, Product.categoria.ELECTROHOGAR, false);
		listaProd.add(prod7);
		Product prod8 = new Product("p8", "Martillo", 200.0, Product.origenFabricacion.URUGUAY, Product.categoria.HERRAMIENTAS, true);
		listaProd.add(prod8);
		Product prod10 = new Product("p10", "Licuadora", 3000.0, Product.origenFabricacion.ARGENTINA, Product.categoria.ELECTROHOGAR, true);
		listaProd.add(prod10);	
		Product prod11 = new Product("p11", "Destornillador", 150.0, Product.origenFabricacion.URUGUAY, Product.categoria.HERRAMIENTAS, true);
		listaProd.add(prod11);
		Product prod12 = new Product("p12", "Cámara", 18000.0, Product.origenFabricacion.BRASIL, Product.categoria.INFORMATICA, false);
		listaProd.add(prod12);
		Product prod13 = new Product("p13", "Microondas", 6000.0, Product.origenFabricacion.ARGENTINA, Product.categoria.ELECTROHOGAR, true);
		listaProd.add(prod13);
		Product prod14 = new Product("p14", "Alicate", 100.0, Product.origenFabricacion.URUGUAY, Product.categoria.HERRAMIENTAS, true);
		listaProd.add(prod14);
		Product prod15 = new Product("p15", "Reproductor de DVD", 2500.0, Product.origenFabricacion.BRASIL, Product.categoria.ELECTROHOGAR, false);
		listaProd.add(prod15);
	}

	public static void mostrarStock(List<Product> listaProd) {
		for(Product prod:listaProd) {
			if(prod.isStock()==true) {
				System.out.println(prod.toString());
				
			}
		}
	}
	public static void mostrarProductos(List<Product> listaProd) {
		for(Product prod:listaProd) {
			System.out.println(prod.toString());
			System.out.println("Stock existente: "+prod.isStock());
		}
	}

	public static void realizarCompra(List<Product> listaProd, List<Product>listaCarrito) {
		Scanner scanner = new Scanner(System.in);
		int rta='#';
		String codigo;
		int i;
		double sumaTotal=0;

		do {
			try {
				boolean encontrado=false;
				mostrarStock(listaProd);
				System.out.println("¿Que desea comprar?");
				codigo=scanner.next();
				//buscar
				for(i=0;i<listaProd.size() && encontrado==false;i++) {
					if(listaProd.get(i).getCodigo().equals(codigo) && listaProd.get(i).isStock()==true) {
						encontrado=true;
						listaCarrito.add(listaProd.get(i));
						sumaTotal=sumaTotal+listaProd.get(i).getPrecioUnitario();
						System.out.println("Producto Agregado con Exito");
						System.out.println("");
						System.out.println("Precio Total: $"+sumaTotal);
					}else {
						encontrado=false;
					}
				}
				if(encontrado==false) {
					System.out.println("Producto no Encontrado");
				}
				System.out.println("¿Desea Seguir Comprando? s/n");
				rta=scanner.next().charAt(0);

			}catch(InputMismatchException e) {
				System.out.println("debe Ingresar un Caracter");
			}

		}while(rta!='n');
		System.out.println("CARRITO");
		mostrarStock(listaCarrito);
		System.out.println("***Precio Total $: "+ sumaTotal+" ***");

		boolean pagoRealizado=false;
		int opcion;
		double nuevoPrecio;
		do {
			try {
				System.out.println("¿Como deseea Pagar?");
				System.out.println("1 - Pagar Efectivo - %10 descuento");
				System.out.println("2 - Pagar Con Tarjeta - %15 aumento");
				opcion=scanner.nextInt();
				switch(opcion) {
				case 1:
					PagoEfectivo pago1 = new PagoEfectivo();
					pago1.setFechaDePago(LocalDate.now());
					nuevoPrecio=pago1.realizarPago(sumaTotal);
					pago1.setMontoPagado(nuevoPrecio);

					pago1.imprimirRecibo();
					pagoRealizado=true;
					break;
				case 2:

					System.out.println("Ingrese Numero de la tarjeta");
					String numTarjeta=scanner.next();
					PagoTarjeta pago2 = new PagoTarjeta();
					pago2.setFechaDePago(LocalDate.now());
					pago2.setNumeroTarjeta(numTarjeta);


					nuevoPrecio=pago2.realizarPago(sumaTotal);

					pago2.setMontoPagado(nuevoPrecio);

					pago2.imprimirRecibo();
					pagoRealizado=true;
					break;
				default:
					System.out.println("Ingreso Incorrecto de Opcion");
				}
			}catch(InputMismatchException e) {
				System.out.println("Error");
			}
		}while(!pagoRealizado);


	}

}