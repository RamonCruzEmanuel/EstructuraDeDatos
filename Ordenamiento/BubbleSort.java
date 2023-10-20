package Algoritmos;

import java.util.Arrays;

public class BubbleSort {

    public static int[] bubbleSort(int arr[]) {

        for (int i = 0; i < arr.length - i - 1; i++) {

            for (int j = 0; j < arr.length - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {

                    int cambio = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = cambio;
                }
                System.out.println("-" + Arrays.toString(arr));
            }
        }
        return arr;
    }
}
