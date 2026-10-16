package co.edu.unbosque.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Consola {
	private Scanner consola;

	public Consola() {
		consola = new Scanner(System.in);
	}

	public int mostrarMenu() {
		System.out.println("""
				===== MENU PRINCIPAL =====
				1. Trabajar Con Un Arreglo (Array)
				2. Trabajar Con Una Pila (Stack)
				3. Trabajar Con Una Cola Circular (Queue)
				0. Salir Del Programa
				""");
		return leerOpcion("Seleccione una opcion: ", 0, 3);
	}

	public int mostrarSubmenuArray() {
		System.out.println("""
				===== ARREGLO (ARRAY) =====
				1. Insertar un elemento
				2. Eliminar un elemento por posicion
				3. Buscar un elemento
				4. Mostrar todos los elementos
				5. Obtener el valor maximo
				6. Obtener el valor minimo *
				7. Obtener el promedio *
				8. Vaciar el arreglo *
				0. Volver al menu principal
				""");
		return leerOpcion("Seleccione una opcion: ", 0, 8);
	}

	public int mostrarSubmenuStack() {
		System.out.println("""
				===== PILA (STACK) =====
				1. Apilar (push)
				2. Desapilar (pop)
				3. Consultar la cima (peek)
				4. Mostrar el contenido
				5. Verificar si esta vacia
				6. Vaciar la pila *
				7. Ver cantidad y espacio libre *
				0. Volver al menu principal
				""");
		return leerOpcion("Seleccione una opcion: ", 0, 7);
	}

	public int mostrarSubmenuQueue() {
		System.out.println("""
				===== COLA CIRCULAR (QUEUE) =====
				1. Encolar (enqueue)
				2. Desencolar (dequeue)
				3. Consultar el primer elemento
				4. Mostrar el contenido
				5. Consultar la cantidad
				6. Consultar el ultimo *
				7. Vaciar la cola *
				0. Volver al menu principal
				""");
		return leerOpcion("Seleccione una opcion: ", 0, 7);
	}

	public int leerEntero(String mensaje) {
		while (true) {
			try {
				System.out.print(mensaje);
				return consola.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Error: debe ingresar un numero entero.");
				consola.nextLine();
			}
		}
	}

	public int leerEnteroPositivo(String mensaje) {
		while (true) {
			int v = leerEntero(mensaje);
			if (v <= 0) {
				System.out.println("Error: el valor debe ser mayor que cero.");
				continue;
			}
			return v;
		}
	}

	private int leerOpcion(String mensaje, int min, int max) {
		while (true) {
			try {
				System.out.print(mensaje);
				int op = consola.nextInt();
				if (op < min || op > max) {
					throw new IllegalArgumentException("Opcion fuera de rango (" + min + "-" + max + ").");
				}
				return op;
			} catch (InputMismatchException e) {
				System.out.println("Error: debe ingresar un numero entero.");
				consola.nextLine();
			} catch (IllegalArgumentException e) {
				System.out.println("Error: " + e.getMessage());
			}
		}
	}

	public void mostrarMensaje(String mensaje) {
		System.out.println(mensaje);
	}
}
