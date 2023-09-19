package CreacionPila;

public class Pila {
    
    private Nodo cima;
    private int tamaño;

    public Pila() {
        cima = null;
        tamaño = 0;
    }

    public void insertar(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (cima == null) {
            cima = nuevoNodo;
        } else {
            nuevoNodo.setSiguiente(cima);
            cima = nuevoNodo;
        }
        tamaño++;
    }

    public int quitar() {
        if (cima == null) {
            throw new IllegalStateException("La pila está vacía");
        }
        int dato = cima.getDato();
        cima = cima.getSiguiente();
        tamaño--;
        return dato;
    }

    public boolean estaVacia() {
        return cima == null;
    }

    public void vaciar() {
        cima = null;
        tamaño = 0;
    }

    public int obtenerCima() {
        if (cima == null) {
            throw new IllegalStateException("La pila está vacía");
        }
        return cima.getDato();
    }

    public int obtenerTamaño() {
        return tamaño;
    }
    
}
