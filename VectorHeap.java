import java.util.Vector;

/**
 * Una cola de prioridad genérica implementada como un montículo binario (heap binario).
 * El montículo binario se representa internamente utilizando un vector (array dinámico).
 *
 * @param <E> el tipo de elementos que contiene esta colección
 */
public class VectorHeap<E extends Comparable<E>> {

    /**
     * El vector para almacenar los datos del heap.
     */
    private Vector<E> data;

    /**
     * Construye una nueva cola de prioridad vacía.
     */
    public VectorHeap() {
        data = new Vector<E>();
    }

    /**
     * Devuelve el índice del padre del elemento en el índice {@code i}.
     *
     * @param i el índice del elemento hijo
     * @return el índice del elemento padre
     */
    protected int parent(int i) {
        return (i - 1) / 2;
    }

    /**
     * Devuelve el índice del hijo izquierdo del elemento en el índice {@code i}.
     *
     * @param i el índice del elemento padre
     * @return el índice del hijo izquierdo
     */
    protected int left(int i) {
        return 2 * i + 1;
    }

    /**
     * Devuelve el índice del hijo derecho del elemento en el índice {@code i}.
     *
     * @param i el índice del elemento padre
     * @return el índice del hijo derecho
     */
    protected int right(int i) {
        return 2 * i + 2;
    }

    /**
     * Restaura la propiedad de montículo comenzando desde el índice dado hacia arriba.
     *
     * @param leaf el índice de la hoja desde donde comenzar a subir (percolate up)
     */
    protected void percolateUp(int leaf) {
        int parent = parent(leaf);
        E value = data.get(leaf);
        while (leaf > 0 && (value.compareTo(data.get(parent)) < 0)) {
            data.set(leaf, data.get(parent));
            leaf = parent;
            parent = parent(leaf);
        }
        data.set(leaf, value);
    }

    /**
     * Agrega el elemento especificado a esta cola de prioridad.
     *
     * @param value el elemento a agregar
     */
    public void add(E value) {
        data.add(value);
        percolateUp(data.size() - 1);
    }

    /**
     * Restaura la propiedad de montículo comenzando desde el elemento raíz hacia abajo.
     *
     * @param root el índice del elemento raíz desde donde comenzar a empujar hacia abajo (push down)
     */
    protected void pushDownRoot(int root) {
        int heapSize = data.size();
        E value = data.get(root);
        while (root < heapSize) {
            int childpos = left(root);
            if (childpos < heapSize) {
                if ((right(root) < heapSize) && ((data.get(childpos + 1)).compareTo(data.get(childpos)) < 0)) {
                    childpos++;
                }
                if ((data.get(childpos)).compareTo(value) < 0) {
                    data.set(root, data.get(childpos));
                    root = childpos;
                } else {
                    data.set(root, value);
                    return;
                }
            } else {
                data.set(root, value);
                return;
            }
        }
    }

    /**
     * Devuelve {@code true} si esta cola de prioridad no contiene elementos.
     *
     * @return {@code true} si esta cola de prioridad está vacía
     */
    public boolean isEmpty() {
        return data.isEmpty();
    }    

    /**
     * Recupera y elimina el encabezado de esta cola, o devuelve {@code null} si la cola está vacía.
     *
     * @return el encabezado de la cola, o {@code null} si la cola está vacía
     */
    public E poll() {
        if (data.isEmpty()) {
            return null;
        }
        E minVal = data.get(0);
        data.set(0, data.get(data.size() - 1));
        data.setSize(data.size() - 1);
        if (!data.isEmpty()) {
            pushDownRoot(0);
        }
        return minVal;
    }
}