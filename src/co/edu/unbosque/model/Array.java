package co.edu.unbosque.model;

// Arreglo fijo de enteros (base vista en clase, sin listas de Java).
public class Array {
	// Almacenamiento interno, capacidad y contador.
	private int[] array;
	private int size;
	private int nItems;

	// Crea el arreglo vacio.
	public Array(int maxSize) {
		if (maxSize <= 0) {
			throw new IllegalArgumentException("El tamano debe ser mayor que cero.");
		}
		size = maxSize;
		array = new int[size];
		nItems = 0;
	}

	// Inserta al final (metodo visto en clase).
	public void insert(int item) {
		if (isFull()) {
			throw new IllegalStateException("Arreglo lleno (overflow).");
		}
		array[nItems] = item;
		nItems++;
	}

	// Elimina por posicion y desplaza a la izquierda.
	public int deleteByPosition(int position) {
		if (isEmpty()) {
			throw new IllegalStateException("Arreglo vacio (underflow).");
		}
		if (position < 0 || position >= nItems) {
			throw new IndexOutOfBoundsException("Posicion " + position + " fuera de rango 0-" + (nItems - 1) + ".");
		}
		int deleted = array[position];
		for (int i = position; i < nItems - 1; i++) {
			array[i] = array[i + 1];
		}
		nItems--;
		array[nItems] = 0;
		return deleted;
	}

	// Busqueda secuencial (metodo visto en clase).
	public int find(int item) {
		for (int i = 0; i < nItems; i++) {
			if (array[i] == item) {
				return i;
			}
		}
		return -1;
	}

	// Valor maximo almacenado.
	public int getMax() {
		if (isEmpty()) {
			throw new IllegalStateException("Arreglo vacio, sin maximo.");
		}
		int max = array[0];
		for (int i = 1; i < nItems; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		return max;
	}

	// Extra: valor minimo.
	public int getMin() {
		if (isEmpty()) {
			throw new IllegalStateException("Arreglo vacio, sin minimo.");
		}
		int min = array[0];
		for (int i = 1; i < nItems; i++) {
			if (array[i] < min) {
				min = array[i];
			}
		}
		return min;
	}

	// Extra: promedio de los elementos.
	public double getAverage() {
		if (isEmpty()) {
			throw new IllegalStateException("Arreglo vacio, sin promedio.");
		}
		long suma = 0;
		for (int i = 0; i < nItems; i++) {
			suma += array[i];
		}
		return (double) suma / nItems;
	}

	// Extra: vacia la estructura.
	public void clear() {
		for (int i = 0; i < nItems; i++) {
			array[i] = 0;
		}
		nItems = 0;
	}

	// Copia de los elementos actuales.
	public int[] getAll() {
		int[] copia = new int[nItems];
		for (int i = 0; i < nItems; i++) {
			copia[i] = array[i];
		}
		return copia;
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

	// Texto "[a, b]" para que la Vista lo imprima.
	@Override
	public String toString() {
		if (isEmpty()) {
			return "[vacio]";
		}
		StringBuilder sb = new StringBuilder("[");
		for (int i = 0; i < nItems; i++) {
			sb.append(array[i]);
			if (i + 1 < nItems) {
				sb.append(", ");
			}
		}
		sb.append("]");
		return sb.toString();
	}
}
