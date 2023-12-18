package Arboles;

import java.util.Locale.IsoCountryCode;

public class Main {
    public static void main(String[] args) {
        char[] nodos = new char[17];
        char raiz = 'A';

        Arbol<Character> arbolGeneral = new Arbol<>(raiz, false);

        for (int i = 0; i < 16; i++) {
            nodos[i] = (char) ('B' + i);
        }

        NodoArbol<Character>[] nodosArbol = new NodoArbol[17];

        for (int i = 0; i < 17; i++) {
            nodosArbol[i] = new NodoArbol<Character>(nodos[i]);
        }
        
        System.out.println("--------------Arbol General--------------");
        arbolGeneral.agregarNodoArbol(arbolGeneral.obtenerRaiz(), nodosArbol[0]);
        arbolGeneral.agregarNodoArbol(nodosArbol[0], nodosArbol[3]);
        arbolGeneral.agregarNodoArbol(nodosArbol[0], nodosArbol[4]);

        arbolGeneral.agregarNodoArbol(nodosArbol[4], nodosArbol[8]);
        arbolGeneral.agregarNodoArbol(nodosArbol[4], nodosArbol[9]);
        arbolGeneral.agregarNodoArbol(nodosArbol[4], nodosArbol[10]);

        arbolGeneral.agregarNodoArbol(arbolGeneral.obtenerRaiz(), nodosArbol[1]);

        arbolGeneral.agregarNodoArbol(arbolGeneral.obtenerRaiz(), nodosArbol[2]);
        arbolGeneral.agregarNodoArbol(nodosArbol[2], nodosArbol[5]);
        arbolGeneral.agregarNodoArbol(nodosArbol[5], nodosArbol[11]);
        arbolGeneral.agregarNodoArbol(nodosArbol[11], nodosArbol[14]);
        arbolGeneral.agregarNodoArbol(nodosArbol[11], nodosArbol[15]);

        arbolGeneral.agregarNodoArbol(nodosArbol[2], nodosArbol[6]);

        arbolGeneral.agregarNodoArbol(nodosArbol[2], nodosArbol[7]);
        arbolGeneral.agregarNodoArbol(nodosArbol[7], nodosArbol[12]);
        arbolGeneral.agregarNodoArbol(nodosArbol[7], nodosArbol[13]);
        System.out.println("¿Está vacío el árbol? " + arbolGeneral.esVacio());
        arbolGeneral.imprimirArbol(Recorrido.INFIJO);
        arbolGeneral.imprimirArbol(Recorrido.PREFIJO);
        arbolGeneral.imprimirArbol(Recorrido.POSFIJO);
        System.out.println("\n" + "Este es la altura del arbol: " + arbolGeneral.alturaArbol());
        // El recorrido empieza desde D
        arbolGeneral.imprimirSubArbol(nodosArbol[2]);

        System.out.println();
        System.out.println("--------------Arbol binario--------------");
        char raizBinario = 'A';
        Arbol<Character> arbolBinario = new Arbol<>(raizBinario, true);
        NodoArbol<Character>[] nodosArbolBinario = new NodoArbol[17];

        for (int i = 0; i < 17; i++) {
            nodosArbolBinario[i] = new NodoArbol<Character>(nodos[i]);
        }

        arbolBinario.agregarNodoArbol(arbolBinario.obtenerRaiz(), nodosArbolBinario[0]);
        arbolBinario.agregarNodoArbol(nodosArbolBinario[0], nodosArbolBinario[3]);
        arbolBinario.agregarNodoArbol(nodosArbolBinario[3], nodosArbolBinario[4]);
        arbolBinario.agregarNodoArbol(nodosArbolBinario[4], nodosArbolBinario[8]);
        arbolBinario.agregarNodoArbol(nodosArbolBinario[8], nodosArbolBinario[9]);
        arbolBinario.agregarNodoArbol(nodosArbolBinario[9], nodosArbolBinario[10]);

        arbolBinario.agregarNodoArbol(nodosArbolBinario[0], nodosArbolBinario[1]);
        arbolBinario.agregarNodoArbol(nodosArbolBinario[1], nodosArbolBinario[2]);
        arbolBinario.agregarNodoArbol(nodosArbolBinario[2], nodosArbolBinario[5]);
        arbolBinario.agregarNodoArbol(nodosArbolBinario[5], nodosArbolBinario[11]);
        arbolBinario.agregarNodoArbol(nodosArbolBinario[11], nodosArbolBinario[14]);
        arbolBinario.agregarNodoArbol(nodosArbolBinario[14], nodosArbolBinario[15]);
        arbolBinario.agregarNodoArbol(nodosArbolBinario[5], nodosArbolBinario[6]);
        arbolBinario.agregarNodoArbol(nodosArbolBinario[6], nodosArbolBinario[7]);
        arbolBinario.agregarNodoArbol(nodosArbolBinario[7], nodosArbolBinario[12]);
        arbolBinario.agregarNodoArbol(nodosArbolBinario[12], nodosArbolBinario[13]);
        System.out.println("¿Está vacío el árbol? " + arbolBinario.esVacio());
        arbolBinario.imprimirArbol(Recorrido.INFIJO);
        arbolBinario.imprimirArbol(Recorrido.PREFIJO);
        arbolBinario.imprimirArbol(Recorrido.POSFIJO);
        System.out.println("\n" + "La altura del arbol binario es: " + arbolBinario.alturaArbol());
        // El recorrido empieza desde D
        arbolBinario.imprimirSubArbol(nodosArbol[2]);

    }

}
