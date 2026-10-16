package co.edu.unbosque.controller;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

import co.edu.unbosque.model.Array;
import co.edu.unbosque.model.Queue;
import co.edu.unbosque.model.Stack;
import co.edu.unbosque.view.Consola;

public class Controlador {
	private Consola vista;
	private Array arreglo;
	private Stack pila;
	private Queue cola;

	public Controlador() {
		vista = new Consola();
		int op;
		do {
			op = vista.mostrarMenu();
			switch (op) {
			case 1:
				manejarArray();
				break;
			case 2:
				manejarStack();
				break;
			case 3:
				manejarQueue();
				break;
			case 0:
				vista.mostrarMensaje("Saliendo del programa...");
				break;
			default:
				vista.mostrarMensaje("Opcion no valida.");
				break;
			}
		} while (op != 0);
	}

	private void manejarArray() {
		if (arreglo == null) {
			try {
				arreglo = new Array(vista.leerEnteroPositivo("Tamano del arreglo: "));
				vista.mostrarMensaje("Arreglo creado.");
			} catch (IllegalArgumentException e) {
				vista.mostrarMensaje("Error: " + e.getMessage());
				return;
			}
		}
		int op;
		do {
			op = vista.mostrarSubmenuArray();
			try {
				switch (op) {
				case 1:
					arreglo.insert(vista.leerEntero("Valor a insertar: "));
					vista.mostrarMensaje("Insertado. " + arreglo.toString());
					break;
				case 2:
					int e = arreglo.deleteByPosition(vista.leerEntero("Posicion a eliminar: "));
					vista.mostrarMensaje("Eliminado: " + e + " " + arreglo.toString());
					break;
				case 3:
					int pos = arreglo.find(vista.leerEntero("Valor a buscar: "));
					vista.mostrarMensaje(pos == -1 ? "No encontrado." : "Encontrado en posicion: " + pos);
					break;
				case 4:
					vista.mostrarMensaje(arreglo.toString() + " (" + arreglo.getNItems() + "/" + arreglo.getSize() + ")");
					break;
				case 5:
					vista.mostrarMensaje("Maximo: " + arreglo.getMax());
					break;
				case 6:
					vista.mostrarMensaje("Minimo: " + arreglo.getMin());
					break;
				case 7:
					vista.mostrarMensaje("Promedio: " + arreglo.getAverage());
					break;
				case 8:
					arreglo.clear();
					vista.mostrarMensaje("Arreglo vaciado.");
					break;
				case 0:
					break;
				default:
					vista.mostrarMensaje("Opcion no valida.");
					break;
				}
			} catch (IllegalStateException | IndexOutOfBoundsException | IllegalArgumentException e) {
				vista.mostrarMensaje("Error: " + e.getMessage());
			}
		} while (op != 0);
	}

	private void manejarStack() {
		if (pila == null) {
			try {
				pila = new Stack(vista.leerEnteroPositivo("Tamano de la pila: "));
				vista.mostrarMensaje("Pila creada.");
			} catch (IllegalArgumentException e) {
				vista.mostrarMensaje("Error: " + e.getMessage());
				return;
			}
		}
		int op;
		do {
			op = vista.mostrarSubmenuStack();
			try {
				switch (op) {
				case 1:
					pila.push(vista.leerEntero("Valor a apilar: "));
					vista.mostrarMensaje("Apilado. " + pila.toString());
					break;
				case 2:
					vista.mostrarMensaje("Desapilado: " + pila.pop() + " " + pila.toString());
					break;
				case 3:
					vista.mostrarMensaje("Cima: " + pila.peek());
					break;
				case 4:
					vista.mostrarMensaje(pila.toString() + " (" + pila.len() + "/" + pila.getSize() + ")");
					break;
				case 5:
					vista.mostrarMensaje(pila.isEmpty() ? "La pila esta vacia." : "La pila no esta vacia.");
					break;
				case 6:
					pila.clear();
					vista.mostrarMensaje("Pila vaciada.");
					break;
				case 7:
					vista.mostrarMensaje("Cantidad: " + pila.len() + "/" + pila.getSize() + ", libre: " + pila.freeSpace());
					break;
				case 0:
					break;
				default:
					vista.mostrarMensaje("Opcion no valida.");
					break;
				}
			} catch (IllegalStateException | IllegalArgumentException | EmptyStackException e) {
				vista.mostrarMensaje("Error: " + (e.getMessage() != null ? e.getMessage() : "pila vacia o llena."));
			}
		} while (op != 0);
	}

	private void manejarQueue() {
		if (cola == null) {
			try {
				cola = new Queue(vista.leerEnteroPositivo("Tamano de la cola: "));
				vista.mostrarMensaje("Cola creada.");
			} catch (IllegalArgumentException e) {
				vista.mostrarMensaje("Error: " + e.getMessage());
				return;
			}
		}
		int op;
		do {
			op = vista.mostrarSubmenuQueue();
			try {
				switch (op) {
				case 1:
					cola.enqueue(vista.leerEntero("Valor a encolar: "));
					vista.mostrarMensaje("Encolado. " + cola.toString());
					break;
				case 2:
					vista.mostrarMensaje("Desencolado: " + cola.dequeue() + " " + cola.toString());
					break;
				case 3:
					vista.mostrarMensaje("Primero: " + cola.peek());
					break;
				case 4:
					vista.mostrarMensaje(cola.toString() + " (" + cola.getNItems() + "/" + cola.getSize() + ")");
					break;
				case 5:
					vista.mostrarMensaje("Cantidad: " + cola.getNItems() + "/" + cola.getSize());
					break;
				case 6:
					vista.mostrarMensaje("Ultimo: " + cola.peekRear());
					break;
				case 7:
					cola.clear();
					vista.mostrarMensaje("Cola vaciada.");
					break;
				case 0:
					break;
				default:
					vista.mostrarMensaje("Opcion no valida.");
					break;
				}
			} catch (IllegalStateException | IllegalArgumentException | NoSuchElementException e) {
				vista.mostrarMensaje("Error: " + e.getMessage());
			}
		} while (op != 0);
	}
}
