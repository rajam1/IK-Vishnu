package divideAndConquer;

import java.util.ArrayList;
import java.util.Arrays;

public class QuickSort_Hoares {
    // If we make arr as static, then we won't have to pass arr in each iteration or to helper.
    // It will be available to all methods
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(5, 8, 3, 9, 4, 1, 7));
        ArrayList<Integer> output = quickSort(arr);
        System.out.println(output);
    }

    static ArrayList<Integer> quickSort(ArrayList<Integer> arr) {
        helper(arr, 0, arr.size() - 1);
        return arr;
    }

    static void helper(ArrayList<Integer> arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int smaller = start + 1;
        int bigger = end;
//        int pivot  = arr.get(start);
        int pivot =  (int) (Math.random() * (end-start)) + start;
        swap(arr,pivot,start);
        while (smaller <= bigger) {
            if (arr.get(smaller) <= arr.get(start)) {
                smaller++;
            } else if (arr.get(bigger) > arr.get(start)) {
                bigger--;
            } else {
                swap(arr, smaller, bigger);
                smaller++;
                bigger--;
            }
        }
        swap(arr, start, bigger);
        helper(arr, start, bigger - 1);
        helper(arr, bigger + 1, end);
    }

    static void swap(ArrayList<Integer> arr, int smaller, int bigger) {
        int temp = arr.get(smaller);
        arr.set(smaller, arr.get(bigger));
        arr.set(bigger, temp);
    }
}
