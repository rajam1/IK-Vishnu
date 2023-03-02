package divideAndConquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MergeSort_1auxArray {
//    public static ArrayList<Integer> aux;

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(5, 8, 3, 9, 4, 1, 7));
//        aux = new ArrayList<Integer>(Collections.nCopies(arr.size(), 0));
        ArrayList<Integer> output = merge_sort(arr);
        System.out.println(output);
    }

    static ArrayList<Integer> merge_sort(ArrayList<Integer> arr) {
        ArrayList<Integer> aux = new ArrayList<Integer>(Collections.nCopies(arr.size(), 0));
        helper(arr, aux, 0, arr.size() - 1);
        return arr;
    }

    private static void helper(ArrayList<Integer> arr, ArrayList<Integer> aux, int start, int end) {
        // leaf node and exit criteria
        if (start == end) {
            return;
        }
        // worker or arbitrary worker node
        // First step is to delegate
        int mid = (start + end) / 2;
        helper(arr, aux, start, mid);
        helper(arr, aux, mid + 1, end);
        //Merge sorted halfs
        int i = start;
        int j = mid + 1;
        int k = start;

        while (i <= mid && j <= end) {
            if (arr.get(i) <= arr.get(j)) {
                aux.set(k, arr.get(i));
                k++;
                i++;
            }
            if (arr.get(j) < arr.get(i)) {
                aux.set(k, arr.get(j));
                k++;
                j++;
            }
        }
        //gather phase - one of the segments is exhausted, so we copy over the remaining from other segment
        while (i <= mid) {
            aux.set(k, arr.get(i));
            k++;
            i++;
        }
        while (j <= end) {
            aux.set(k, arr.get(j));
            k++;
            j++;
        }
        while (start <= end) {
            arr.set(start, aux.get(start));
            start++;
        }
        return;
    }
}
