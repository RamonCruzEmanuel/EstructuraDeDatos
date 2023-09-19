package CreacionPila;

public class Nodo {
    
    private int dato;
    private Nodo siguiente;

    public Nodo() {
        this.dato = 0;
        this.siguiente = null;
    }

    public Nodo(int dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
    
}
