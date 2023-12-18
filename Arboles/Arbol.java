package Arboles;

public class Arbol<T> {
  private NodoArbol<T> raiz;
  private boolean esBinario = false;

  /**
   * Constructor de la clase Arbol que recibe un dato para crear la raiz del árbol
   * 
   * @param dato El dato que se utilizará para crear la raíz del árbol
   */
  public Arbol(T dato, boolean esBinario) {
    raiz = new NodoArbol<T>(dato);
    raiz.setEsBinario(esBinario);
    this.esBinario = esBinario;
  }

  /**
   * Obtiene la raíz del árbol
   *
   * @return La raíz del árbol
   */
  public NodoArbol<T> obtenerRaiz() {
    return raiz;
  }

  public boolean esBinario() {
    return esBinario;
  }

  /**
   * Agrega un nuevo nodo al árbol.
   *
   * @param nodoRaiz     El nodo al que se le agregará el nuevo nodo.
   * @param nodoAgregado El nodo que se agregará como hijo.
   */
  public void agregarNodoArbol(NodoArbol<T> nodoRaiz, NodoArbol<T> nodoAgregado) {
    if (esBinario) {
      nodoAgregado.setEsBinario(esBinario);
    }

    nodoRaiz.agregarHijo(nodoAgregado);
  }

  /*
   * recurre a enum, para poder hacer una busqueda
   * del tipo de recorrido que se puso en el parametro "recorrido" que sirve para
   * leer e imprimir el arbol dependiendo de
   * Prefijo, Infijo, Posfijo,
   */
  public void imprimirArbol(Recorrido recorrido) {
    switch (recorrido.ordinal()) {
      case 0:
        System.out.println("\nPrefijo:");
        raiz.imprimirEnPrefijo();
        break;

      case 1:
        System.out.println("\nInfijo: ");
        raiz.imprimirEnInfijo();
        break;

      case 2:
        System.out.println("\nPosfijo: ");
        raiz.imprimirEnPosfijo();
        break;

      default:
        break;
    }
  }

  /**
   * Evalua si el árbol esta vacío
   *
   * @return true si el árbol se encuentra vacío
   */
  public boolean esVacio() {
    return raiz == null;
  }

  /**
   * Calcula la altura del árbol.
   *
   * @return La altura del árbol.
   */
  public int alturaArbol() {

    return calcularAltura(raiz);

  }

  /**
   * Método para calcular la altura del árbol desde un nodo dado
   *
   * @param nodo El nodo a partir del cual se calculará la altura
   * @return La altura del árbol a partir del nodo dado
   */
  private int calcularAltura(NodoArbol<T> nodo) {
    if (nodo == null) {
      return 0;
    } else {
      NodoArbol<T> hijo = nodo.obtenerPrimerHijo();
      int alturaMaxima = 0;
      while (hijo != null) {
        int alturaHijo = calcularAltura(hijo);
        alturaMaxima = Math.max(alturaMaxima, alturaHijo);
        hijo = hijo.obtenerSiguienteHermano();
      }
      return alturaMaxima + 1;
    }

  }

  /**
   * Método para imprimir el árbol desde el nodo dado
   * El nivel aparacerá por defecto en 0 porque se generará como un subárbol
   * 
   * @param nodo El nodo donde se va a empezar a imprimir
   */
  public void imprimirSubArbol(NodoArbol<T> nodo) {
    if (nodo != null) {
      System.out.println("Subárbol a partir del nodo con dato: " + nodo.getDato());
      imprimirSubArbolRecursivo(nodo, 0);
    } else {
      System.out.println("El nodo proporcionado es nulo. No se puede imprimir el subárbol");
    }
  }

  /**
   * Método para imprimir el árbol desde el nodo dado
   *
   * @param nodo  El nodo donde se va a empezar a imprimir
   * @param nivel El nivel donde se encuentra el árbol y sus subárboles
   */
  private void imprimirSubArbolRecursivo(NodoArbol<T> nodo, int nivel) {
    if (nodo != null) {
      System.out.println("Nivel " + nivel + ": " + nodo.getDato());

      NodoArbol<T> hijo = nodo.obtenerPrimerHijo();
      while (hijo != null) {
        imprimirSubArbolRecursivo(hijo, nivel + 1);
        hijo = hijo.obtenerSiguienteHermano();
      }
    }
  }

}