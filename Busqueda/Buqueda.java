public class BusquedaBinaria {

    public static int[] generarNumerosAleatorios(int contador) {
        int[] numeros = new int[contador];
        for (int i = 0; i < contador; i++) {
            numeros[i] = (int) (Math.random() * 10000);
        }
        return numeros;
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    
     public static void main(String[] args) {
        
        int[] numerosAleatorios = generarNumerosAleatorios(1000);
        bubbleSort(numerosAleatorios);

        System.out.println("Numeros aleatorios ordenados:");
        for (int numero : numerosAleatorios) {
            System.out.println(numero);
        }

        int busqueda = 7283;
        int primero = 0;
        int ultimo = numerosAleatorios.length - 1;
        int mitad;

        while (primero <= ultimo) {
            mitad = (primero + ultimo) / 2;

            if (numerosAleatorios[mitad] == busqueda) {
                System.out.println("Numero: " + busqueda + " " + "Posicion " + mitad);
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
}

