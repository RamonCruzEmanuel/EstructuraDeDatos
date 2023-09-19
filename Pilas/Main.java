package CreacionPila;

public class Main {
    
    public static void main(String[] args) {
        Pila pila = new Pila();

        // Insertamos los elementos en la pila
        pila.insertar(14);
        pila.insertar(27);
        pila.insertar(1);
        pila.insertar(15);
        pila.insertar(10);
        pila.insertar(90);
        pila.insertar(71);
        pila.insertar(37);
        pila.insertar(2);
        pila.insertar(48);

        // Imprimimos el tamaño de la pila
        System.out.println("Tamano de la Pila: " + pila.obtenerTamaño());

        // Quitar 4 elementos de la pila
        for (int i = 0; i < 2; i++) {
            pila.quitar();
        }

        // Imprimir el elemento en la cima de la pila
        System.out.println("Elemento en la cima de la Pila: " + pila.obtenerCima());

        // Vaciar la pila
        pila.vaciar();

        // Comprobar si la pila está vacía
        if (pila.estaVacia()) {
            System.out.println("La Pila esta vacia.");
        } else {
            System.out.println("La Pila no esta vacia.");
        }
    }
    
}
