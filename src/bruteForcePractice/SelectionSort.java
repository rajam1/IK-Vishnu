package bruteForcePractice;

import java.util.ArrayList;
import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] input = {5, 8, 3, 9, 4, 1, 7};
        int[] output = selectionSort(input);
        for (int var : output) {
            System.out.print(var + " ");
        }
        System.out.println("\n"+"without using min variable");
        int[] output2 = selectionSortWithoutUsingMinVar(input);
        for (int var : output2) {
            System.out.print(var + " ");
        }
        System.out.println("\n"+"array list implementation");
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(5, 8, 3, 9, 4, 1, 7));
        ArrayList<Integer> output3 = selection_sort(arr);
        for (int var : output3) {
            System.out.print(var + " ");
        }
    }

    private static int[] selectionSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = a[i];
            int minIndex = i;
            for (int k = i + 1; k < a.length; k++) {
                if (a[k] < min) {
                    min = a[k];
                    minIndex = k;
                }
            }
            if (i != minIndex) {
                int temp = a[i];
                a[i] = a[minIndex];
                a[minIndex] = temp;
            }
        }
        return a;
    }

    private static int[] selectionSortWithoutUsingMinVar(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int minIndex = i;
            for (int k = i + 1; k < a.length; k++) {
                if (a[k] < a[minIndex]) {
                    minIndex = k;
                }
            }
            if (i != minIndex) {
                int temp = a[i];
                a[i] = a[minIndex];
                a[minIndex] = temp;
            }
        }
        return a;
    }


    static ArrayList<Integer> selection_sort(ArrayList<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
//            int min = arr.get(i);
            int minIndex = i;
            for (int j = i + 1; j < arr.size(); j++) {
                if (arr.get(j) < arr.get(minIndex)) {
//                    min = arr.get(j);
                    minIndex = j;
                }
            }
            //swap values
            int temp = arr.get(i);
            arr.set(i, arr.get(minIndex));
            arr.set(minIndex, temp);
        }
        return arr;
    }


}
