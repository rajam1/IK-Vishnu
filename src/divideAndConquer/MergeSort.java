package divideAndConquer;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(5, 8, 3, 9, 4, 1, 7));
        ArrayList<Integer> output = merge_sort(arr);
        System.out.println(output.toString());
    }

    private static ArrayList<Integer> merge_sort(ArrayList<Integer> arr) {
        helper(arr, 0, arr.size() - 1);
        return arr;
    }

    private static ArrayList<Integer> helper(ArrayList<Integer> arr, int start, int end) {
        // leaf node and exit criteria
        if (start == end) {
            return arr;
        }
        // worker or arbitrary worker node
        // First step is to delegate
        int mid = (start + end) / 2;
        helper(arr, start, mid);
        helper(arr, mid + 1, end);
        //Merge sorted halfs
        int i = start;
        int j = mid + 1;
        ArrayList<Integer> aux = new ArrayList<>();
        while (i <= mid && j <= end) {
            if (arr.get(i) <= arr.get(j)) {
                aux.add(arr.get(i));
                i++;
            }
            if (arr.get(j) < arr.get(i)) {
                aux.add(arr.get(j));
                j++;
            }
        }
        //gather phase - one of the segments is exhausted, so we copy over the remaining from other segment
        while (i <= mid) {
            aux.add(arr.get(i));
            i++;
        }
        while (j <= end) {
            aux.add(arr.get(j));
            j++;
        }
        //copy contents of aux back to arr in the right place. Aux is going to be smaller than arr.
        int c = start;//for arr iteration
        int a = 0;//for aux iteration
        while (c <= end) {
            arr.set(c, aux.get(a));
            c++;
            a++;
        }
        return arr;
    }
}
