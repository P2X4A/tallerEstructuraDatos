package co.edu.unbosque.model;

import java.util.EmptyStackException;

// Pila LIFO con arreglo interno (base vista en clase, sin Stack de Java).
public class Stack {
	// Almacenamiento, cima, capacidad y contador.
	private int[] stack;
	private int top;
	private int size;
	private int nItems;

	// Crea la pila vacia.
	public Stack(int maxSize) {
		if (maxSize <= 0) {
			throw new IllegalArgumentException("El tamano debe ser mayor que cero.");
		}
		size = maxSize;
		stack = new int[size];
		top = -1;
		nItems = 0;
	}

	// Apila en la cima (metodo visto en clase).
	public void push(int value) {
		if (isFull()) {
			throw new IllegalStateException("Pila llena (overflow).");
		}
		top++;
		stack[top] = value;
		nItems++;
	}

	// Desapila la cima (metodo visto en clase).
	public int pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		int item = stack[top];
		stack[top] = 0;
		nItems--;
		top--;
		return item;
	}

	// Cima sin extraer.
	public int peek() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return stack[top];
	}

	// Cantidad de elementos (metodo visto en clase).
	public int len() {
		return nItems;
	}

	// Extra: espacio libre antes del overflow.
	public int freeSpace() {
		return size - nItems;
	}

	// Extra: vacia la pila.
	public void clear() {
		for (int i = 0; i <= top; i++) {
			stack[i] = 0;
		}
		top = -1;
		nItems = 0;
	}

	public int getNItems() {
		return nItems;
	}

	public int getSize() {
		return size;
	}

	public boolean isEmpty() {
		return nItems == 0;
	}

	public boolean isFull() {
		return nItems == size;
	}

	// Texto base->cima para que la Vista lo imprima.
	@Override
	public String toString() {
		if (isEmpty()) {
			return "[vacia]";
		}
		StringBuilder sb = new StringBuilder("[");
		for (int i = 0; i <= top; i++) {
			sb.append(stack[i]);
			if (i < top) {
				sb.append(", ");
			}
		}
		sb.append("] <- cima");
		return sb.toString();
	}
}
