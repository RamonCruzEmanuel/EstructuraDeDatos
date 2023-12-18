package Arbol_AVL;

public class Main {

  public static void main(String[] args) {
    ArbolAVL arbol = new ArbolAVL();
    System.out.println("Insertando valores");
    arbol.insertar(5);
    arbol.insertar(10);
    arbol.insertar(18);
    arbol.insertar(15);
    arbol.insertar(25);
    arbol.insertar(20);
    arbol.insertar(100);
    arbol.mostrarArbolAVL();
    System.out.println("Eliminando Valores");
    arbol.eliminar(25);
    arbol.eliminar(20);
    System.out.println("Buscando valores");
    // Este valor se elimino en la intrucciones anteriores
    arbol.buscar(25);
    // Este valor si se encuentra en el arbol
    arbol.buscar(5);

  }
}