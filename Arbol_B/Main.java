package Arbol_B;

public class Main {

    public static void main(String[] args) {
        // grado minimo del Arbol B es t=3
        // Cada nodo soporta 2t hijos y 2t-1 claves
        int t = 4;
        // Se crea el arbol B segun t
        ArbolB arbolB = new ArbolB(t);

        // Valores a ingresar primera ronda
        int[] valoresUno = { 20, 10, 50, 30, 40 };
        System.out.println("-- INICIO --");
        System.out.println("INSERTANDO VALORES AL ARBOL B");
        for (int i = 0; i < valoresUno.length; i++) {
            System.out.println("Insertando... valor " + valoresUno[i]);
            arbolB.insertar(valoresUno[i]);
        }

        // Mostrando arbol B por pantalla en preorder
        System.out.println("ESTADO ARBOL B");
        arbolB.showBTree();
        System.out.println("");

        // Valores a ingresar segunda ronda
        System.out.println("Insertando... valor 60");
        arbolB.insertar(60);
        // Mostrando arbol B por pantalla en preorder
        System.out.println("ESTADO ARBOL B");
        arbolB.showBTree();
        System.out.println("");

        // Valores a ingresar tercera ronda
        System.out.println("Eliminando... valor 60");
        arbolB.eliminar(60);
        System.out.println("Eliminando... valor 10");
        arbolB.eliminar(10);
        System.out.println("Eliminando... valor 20");
        arbolB.eliminar(20);
        // Mostrando arbol B por pantalla en preorder
        System.out.println("ESTADO ARBOL B");
        arbolB.showBTree();
        System.out.println("");

        // Buscar
        System.out.println("\nBuscando el nodo con el valor 80 en el arbol B:");
        arbolB.buscarNodoPorClave(60);// Eliminado en las instruciones anteiores
        arbolB.buscarNodoPorClave(40);///Valor que se encuentra en el árbol

        // IMPLEMENTAR
        System.out.println("\nEl valor maximo del arbol B es : " + arbolB.buscarClaveMayor());

        System.out.print("El nodo minimo de la raiz del arbol B es :");
        arbolB.mostrarClavesNodoMinimo();

        System.out.println("");
        System.out.println("-- FIN --");
    }
}
