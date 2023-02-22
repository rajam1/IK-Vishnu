package decreaseAndConquer;

import java.util.ArrayList;
import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(5, 8, 3, 9, 4, 1, 7));
        ArrayList<Integer> output = insertionSort(arr);
        for (int var : output) {
            System.out.print(var + " ");
        }
    }

    private static ArrayList<Integer> insertionSort(ArrayList<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            int temp = arr.get(i);
            int red = i - 1;
            while (red >= 0 && arr.get(red) > temp) {
                arr.set(red + 1, arr.get(red));
                red--;
            }
            arr.set(red + 1, temp);
        }
        return arr;
    }
}
