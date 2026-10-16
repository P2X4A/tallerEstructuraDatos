package co.edu.unbosque.model;

import java.util.NoSuchElementException;

// Cola circular FIFO con arreglo interno (base vista en clase, sin Queue de Java).
public class Queue {
	// Almacenamiento circular, frente, final, capacidad y contador.
	private int[] queue;
	private int front;
	private int rear;
	private int size;
	private int nItems;

	// Crea la cola vacia.
	public Queue(int maxSize) {
		if (maxSize <= 0) {
			throw new IllegalArgumentException("El tamano debe ser mayor que cero.");
		}
		size = maxSize;
		queue = new int[size];
		front = 0;
		rear = -1;
		nItems = 0;
	}

	// Encola al final con avance circular (metodo visto en clase).
	public void enqueue(int value) {
		if (isFull()) {
			throw new IllegalStateException("Cola llena (overflow).");
		}
		rear = (rear + 1) % size;
		queue[rear] = value;
		nItems++;
	}

	// Desencola el frente (metodo visto en clase).
	public int dequeue() {
		if (isEmpty()) {
			throw new NoSuchElementException("Cola vacia (underflow).");
		}
		int value = queue[front];
		queue[front] = 0;
		front = (front + 1) % size;
		nItems--;
		return value;
	}

	// Frente sin extraer.
	public int peek() {
		if (isEmpty()) {
			throw new NoSuchElementException("Cola vacia, sin primero.");
		}
		return queue[front];
	}

	// Extra: ultimo encolado (util en logistica para ver el mas reciente).
	public int peekRear() {
		if (isEmpty()) {
			throw new NoSuchElementException("Cola vacia, sin ultimo.");
		}
		return queue[rear];
	}

	// Extra: espacio libre antes del overflow.
	public int freeSpace() {
		return size - nItems;
	}

	// Extra: vacia la cola.
	public void clear() {
		for (int i = 0; i < size; i++) {
			queue[i] = 0;
		}
		front = 0;
		rear = -1;
		nItems = 0;
	}

	public boolean isEmpty() {
		return nItems == 0;
	}

	public boolean isFull() {
		return nItems == size;
	}

	public int getNItems() {
		return nItems;
	}

	public int getSize() {
		return size;
	}

	// Copia en orden de atencion (frente a final).
	public int[] getAll() {
		int[] copia = new int[nItems];
		for (int i = 0; i < nItems; i++) {
			copia[i] = queue[(front + i) % size];
		}
		return copia;
	}

	// Texto frente->final para que la Vista lo imprima.
	@Override
	public String toString() {
		if (isEmpty()) {
			return "[vacia]";
		}
		StringBuilder sb = new StringBuilder("[frente: ");
		for (int i = 0; i < nItems; i++) {
			sb.append(queue[(front + i) % size]);
			if (i + 1 < nItems) {
				sb.append(", ");
			}
		}
		sb.append(" :final]");
		return sb.toString();
	}
}
