package ar.edu.unju.fi.ejercicio7.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import ar.edu.unju.fi.ejercicio7.model.Producto.origenFabricacion;
import ar.edu.unju.fi.ejercicio7.model.Producto;
import ar.edu.unju.fi.ejercicio7.model.Producto.categoria;

public class Main {

	public static void main(String[] args) {
		List<Producto> arrayProducto = new ArrayList<Producto>();
		List<Producto> arrayProdAux = new ArrayList<Producto>();
		List<Producto> productosIncrementados = new ArrayList<Producto>();
		arrayProdAux=arrayProducto;
		int opcion=0;
		Scanner scanner = new Scanner(System.in);

		cargarProductos(arrayProducto);
		do {
			try {
				System.out.println("--MENU--");
				System.out.println("1 – Mostrar Productos en Stock");
				System.out.println("2 – Mostrar Productos Sin Stock");
				System.out.println("3 – Incrementar precio de productos %20");
				System.out.println("4 – Mostrar productos Electrohogar y en stock");
				System.out.println("5 – Ordenar por precio de forma descendiente");
				System.out.println("6 – Mostrar los productos con los nombres en Mayusculas");
				System.out.println("9 – Salir");
				System.out.println("Ingrese opcion: ");
				opcion=scanner.nextInt();

				switch(opcion) {
				case 1:
					mostrarStock(arrayProducto);
					break;
				case 2:
					arrayProdAux=mostrarSinStock(arrayProducto);
					mostrarSimple(arrayProdAux);
					break;
				case 3:
					productosIncrementados=aumentarPrecio(arrayProducto);
					mostrarSimple(productosIncrementados);
					break;
				case 4:
					arrayProdAux=mostrarElectrohogar(arrayProducto);
					mostrarSimple(arrayProdAux);
					break;
				case 5:
					arrayProdAux=ordenarPrecio(arrayProducto);
					mostrarSimple(arrayProdAux);
					break;
				case 6:
					arrayProdAux=mayusculas(arrayProducto);
					mostrarSimple(arrayProdAux);
					break;
				case 9:
					System.out.println("Hasta pronto");
					break;
				default:
					System.out.println("ERROR. INGRESE NUEVAMENTE");
				}
			}catch(InputMismatchException e) {
				System.out.println("debe ingresar un numero");
				scanner.next();
			}
		}while(opcion!=9);
	}
	public static void cargarProductos(List<Producto> listaProd) {
		Producto prod1 = new Producto("p1", "Lavarropas", 28550.0, origenFabricacion.ARGENTINA, categoria.ELECTROHOGAR, false);
		listaProd.add(prod1);
		Producto prod2 = new Producto("p2", "Televisor", 35000.0, Producto.origenFabricacion.CHINA, Producto.categoria.ELECTROHOGAR, true);
		listaProd.add(prod2);
		Producto prod3 = new Producto("p3", "Laptop", 65000.0, Producto.origenFabricacion.CHINA, Producto.categoria.INFORMATICA, true);
		listaProd.add(prod3);
		Producto prod4 = new Producto("p4", "Taladro", 1500.0, Producto.origenFabricacion.URUGUAY, Producto.categoria.HERRAMIENTAS, false);
		listaProd.add(prod4);
		Producto prod5 = new Producto("p5", "Smartphone", 20000.0, Producto.origenFabricacion.BRASIL, Producto.categoria.TELEFONIA, false);
		listaProd.add(prod5);
		Producto prod6 = new Producto("p6", "Impresora", 5000.0, Producto.origenFabricacion.ARGENTINA, Producto.categoria.INFORMATICA, true);
		listaProd.add(prod6);
		Producto prod7 = new Producto("p7", "Aspiradora", 8000.0, Producto.origenFabricacion.CHINA, Producto.categoria.ELECTROHOGAR, false);
		listaProd.add(prod7);
		Producto prod8 = new Producto("p8", "Martillo", 200.0, Producto.origenFabricacion.URUGUAY, Producto.categoria.HERRAMIENTAS, true);
		listaProd.add(prod8);
		Producto prod9 = new Producto("p9", "Tablet", 120000.0, Producto.origenFabricacion.BRASIL, Producto.categoria.INFORMATICA, true);
		listaProd.add(prod9);
		Producto prod10 = new Producto("p10", "Licuadora", 3000.0, Producto.origenFabricacion.ARGENTINA, Producto.categoria.ELECTROHOGAR, true);
		listaProd.add(prod10);
		Producto prod11 = new Producto("p11", "Destornillador", 150.0, Producto.origenFabricacion.URUGUAY, Producto.categoria.HERRAMIENTAS, true);
		listaProd.add(prod11);
		Producto prod12 = new Producto("p12", "Cámara", 18000.0, Producto.origenFabricacion.BRASIL, Producto.categoria.INFORMATICA, false);
		listaProd.add(prod12);
		Producto prod13 = new Producto("p13", "Microondas", 6000.0, Producto.origenFabricacion.ARGENTINA, Producto.categoria.ELECTROHOGAR, true);
		listaProd.add(prod13);
		Producto prod14 = new Producto("p14", "Alicate", 100.0, Producto.origenFabricacion.URUGUAY, Producto.categoria.HERRAMIENTAS, true);
		listaProd.add(prod14);
		Producto prod15 = new Producto("p15", "Reproductor de DVD", 2500.0, Producto.origenFabricacion.BRASIL, Producto.categoria.ELECTROHOGAR, true);
		listaProd.add(prod15);
	}

	public static void mostrarStock(List<Producto> listaProd) {
		Consumer<Producto> stock = s->{
			if(s.isStock()==true) {
				System.out.println(s.toString());
			}
		};
		listaProd.forEach(stock);
	}
	public static List<Producto> mostrarSinStock(List<Producto> listaProd) {
		Predicate<Producto> noStock = s->s.isStock()==false;
		return listaProd.stream().filter(noStock).collect(Collectors.toList());
	}
	public static void mostrarSimple(List<Producto>listaProd) {
		for(Producto prod:listaProd) {
			System.out.println(prod.toString());
		}
	}
	
	public static List<Producto> aumentarPrecio(List<Producto> listaProd){
		Function<Producto,Producto> nuevoPrecio = p ->{
			p.setPrecioUnitario(p.getPrecioUnitario()*1.20f);
			return p;
		};
		return listaProd.stream().map(nuevoPrecio).collect(Collectors.toList());
	}
	
	public static List<Producto> mostrarElectrohogar(List<Producto>listaProd) {
		Predicate<Producto> electro = e->e.getCategoria()==categoria.ELECTROHOGAR;
		return listaProd.stream().filter(electro).collect(Collectors.toList());
	}
	
	public static List<Producto> ordenarPrecio(List<Producto> listaProd){
		Comparator<Producto> x = Comparator.comparing(Producto :: getPrecioUnitario).reversed();
		listaProd.sort(x);
		return listaProd;
	}
	
	public static List<Producto> mayusculas(List<Producto> listaProd){
		Function<Producto,Producto> mayus = m ->{
			m.setDescripcion(m.getDescripcion().toUpperCase());
			return m;
		};
		return listaProd.stream().map(mayus).collect(Collectors.toList());
	}
	
}