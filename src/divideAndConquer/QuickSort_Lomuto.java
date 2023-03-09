package divideAndConquer;

import java.util.ArrayList;
import java.util.Arrays;

public class QuickSort_Lomuto {
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
//       Leaf node
        if (start >= end) {
            return;
        }
//        Internal node
        int pivot = (int) ((Math.random() * (start - end)) + end);
        swap(arr, start, pivot);
        int smaller = start;
        for (int bigger = start + 1; bigger <= end; bigger++) {
            if (arr.get(bigger) < arr.get(start)) {
                smaller++;
                swap(arr, smaller, bigger);
            }
        }
        swap(arr, start, smaller);
        helper(arr, start, smaller - 1);
        helper(arr, smaller + 1, end);
    }

    static void swap(ArrayList<Integer> arr, int smaller, int bigger) {
        int temp = arr.get(smaller);
        arr.set(smaller, arr.get(bigger));
        arr.set(bigger, temp);
    }
}
