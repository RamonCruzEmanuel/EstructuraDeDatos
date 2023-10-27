
package Busqueda;

import java.util.Arrays;
import java.util.Random;

public class BusquedaBinaria {

    public static int[] numerosAleatorios() {

        Random random = new Random();
        int[] numerosAleatorios = new int[1000];

        for (int i = 0; i < 1000; i++) {
            numerosAleatorios[i] = random.nextInt();
        }

        for(int i = 0; i <= 1000; i++){
            
            
        }
        return numerosAleatorios;
    }

    public static int[] ordenarNumeros(int arr[]) {

        return ordenarNumeros(arr, 0, arr.length - 1);
    }

    private static int[] ordenarNumeros(int arr[], int primero, int ultimo) {

        int i, j, central;
        double pivote;
        central = (primero + ultimo) / 2;
        pivote = arr[central];
        i = primero;
        j = ultimo;

        do {
            while (arr[i] < pivote) {
                i++;
            }
            while (arr[j] > pivote) {
                j--;
            }
            if (i <= j) {

                int aux = arr[i];
                arr[i] = arr[j];
                arr[j] = aux;

                i++;
                j--;
            }
            
        } while (i <= j);

        if (primero < j) {

            ordenarNumeros(arr, primero, j);
        }

        if (i < ultimo) {

            ordenarNumeros(arr, i, ultimo);
        }
        return arr;
    }

    public int busquedaBinaria(int elementos[], int x) {
        
        int l = 0;
        int r = elementos.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;

            if (elementos[m] == x) {
                return m;
            }

            if (elementos[m] < x) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }
    
    public static void main(String args[]) {

        numerosAleatorios();
        ordenarNumeros(numerosAleatorios());
        
        

    }
}
