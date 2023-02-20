package bruteForcePractice;

import java.util.ArrayList;
import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] input = {5, 8, 3, 9, 4, 1, 7};
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(5, 8, 3, 9, 4, 1, 7));
        ArrayList<Integer> output3 = bubbleSort(arr);
        for (int var : output3) {
            System.out.print(var + " ");
        }
    }

    private static ArrayList<Integer> bubbleSort(ArrayList<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            for (int bub = arr.size() - 1; bub > i; bub--) {
                if (arr.get(bub) < arr.get(bub - 1)) {
                    int temp = arr.get(bub);
                    arr.set(bub, arr.get(bub - 1));
                    arr.set(bub - 1, temp);
                }
            }
        }
        return arr;
    }


}

