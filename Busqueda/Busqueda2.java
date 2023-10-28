public class BusquedaBinaria {

    public static int[] generarNumerosAleatorios(int contador) {
        int[] numeros = new int[contador];
        for (int i = 0; i < contador; i++) {
            numeros[i] = (int) (Math.random() * 10000);
        }
        return numeros;
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
    
    public static void busquedaBinaria(){
        
        int[] numerosAleatorios = generarNumerosAleatorios(1000);

        System.out.println("Numeros desordenados:");
        for (int i = 0; i < numerosAleatorios.length; i++) {

            System.out.println(numerosAleatorios[i]);
        }
        System.out.println("\n");
        System.out.println("Numeros ordenados: ");

        int[] numerosOrdenados = ordenarNumeros(numerosAleatorios);

        for (int i = 0; i < numerosOrdenados.length; i++) {
            System.out.println(numerosOrdenados[i]);
        }
        
        int busqueda = 9999;
        int primero = 0;
        int ultimo = numerosAleatorios.length - 1;
        int mitad;

        while (primero <= ultimo) {
            mitad = (primero + ultimo) / 2;

            if (numerosAleatorios[mitad] == busqueda) {
                System.out.println("Numero: " + busqueda + " " + "Posicion :" + mitad);
                break;
            }

            if (numerosAleatorios[mitad] < busqueda) {
                primero = mitad + 1;
            } else {
                ultimo = mitad - 1;
            }
        }

        if (primero > ultimo) {
            
            System.out.println("Numero: " + busqueda + " " + "Posicion: No se encontro en la lista");
        }
    }   

    public static void main(String[] args) {

        busquedaBinaria();
    }
}
