package Arboles;

/**
 * Clase que representa un nodo de un árbol genérico.
 *
 * @param <T> Tipo de dato que almacenará el nodo.
 */
public class NodoArbol<T> {
  private T dato;
  private boolean esBinario = false;
  private NodoArbol<T> primerHijo;
  private NodoArbol<T> siguienteHermano;

  /**
   * Constructor de la clase NodoArbol que recibe un dato para crear el nodo.
   *
   * @param dato El dato que se almacenará en el nodo.
   */
  public NodoArbol(T dato) {
    this.dato = dato;
    primerHijo = null;
    siguienteHermano = null;
  }

  /**
   * Agrega un nuevo nodo como hijo del nodo actual en un árbol.
   * Si el nodo actual no tiene ningún hijo, el nuevo nodo se asigna como el
   * primer hijo.
   * Si ya tiene un hijo, se agrega el nuevo nodo como un hermano del hijo
   * existente.
   * En el caso de un árbol binario, se permite dos hijos por nodo.
   * Si el árbol no es binario, se permiten múltiples hijos por nodo.
   *
   * @param hijo El nodo que se agregará como hijo del nodo actual.
   */

  public void agregarHijo(NodoArbol<T> hijo) {

    if (primerHijo == null) {
      primerHijo = hijo;
    } else {
      NodoArbol<T> hermano = this.primerHijo;

      if (esBinario) {
        if (hermano.siguienteHermano != null) {
          System.err.println("El nodo ya tiene un hijo, no se debe agregar " + hijo.getDato());
        } else {
          hermano.siguienteHermano = hijo;
        }
      } else {
        while (hermano.siguienteHermano != null) {
          hermano = hermano.siguienteHermano;
        }
        hermano.siguienteHermano = hijo;
      }
    }
  }

  /**
   * Obtiene el primer hijo del nodo actual.
   *
   * @return El primer hijo del nodo actual.
   */
  public NodoArbol<T> obtenerPrimerHijo() {
    return primerHijo;
  }

  /**
   * Obtiene el siguiente hermano del nodo actual.
   *
   * @return El siguiente hermano del nodo actual.
   */

  public NodoArbol<T> obtenerSiguienteHermano() {
    return siguienteHermano;
  }

  /**
   * Obtiene el dato almacenado en el nodo.
   *
   * @return El dato almacenado en el nodo.
   */
  public T getDato() {
    return dato;
  }

  /**
   * Verifica si el nodo es parte de un árbol binario.
   *
   * @return true si el nodo es parte de un árbol binario, false en caso
   *         contrario.
   */
  public boolean esBinario() {
    return esBinario;
  }

  /**
   * Establece si el nodo es parte de un árbol binario.
   *
   * @param esBinario true si el nodo es parte de un árbol binario, false en caso
   *                  contrario.
   */
  public void setEsBinario(boolean esBinario) {
    this.esBinario = esBinario;
  }

  /**
   * Imprime los nodos en un recorrido en preorden desde el nodo actual.
   */
  public void imprimirEnPrefijo() {
    System.out.print(dato + "\t");
    NodoArbol<T> hijo = primerHijo;

    while (hijo != null) {
      hijo.imprimirEnPrefijo();
      hijo = hijo.siguienteHermano;
    }
  }

  /**
   * Imprime los nodos en un recorrido en orden (inorden) desde el nodo actual.
   */
  public void imprimirEnInfijo() {
    NodoArbol<T> hijo = primerHijo;

    if (hijo != null) {
      hijo.imprimirEnInfijo();
    }

    System.out.print(dato + "\t");
    while (hijo != null) {
      hijo = hijo.siguienteHermano;
      if (hijo != null) {
        hijo.imprimirEnInfijo();
      }
    }
  }

  /**
   * Imprime los nodos en un recorrido en postorden desde el nodo actual.
   */

  public void imprimirEnPosfijo() {
    NodoArbol<T> hijo = primerHijo;

    while (hijo != null) {
      hijo.imprimirEnPosfijo();
      hijo = hijo.siguienteHermano;
    }

    System.out.print(dato + "\t");
  }
}
