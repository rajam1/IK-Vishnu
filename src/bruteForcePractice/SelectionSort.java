package bruteForcePractice;

public class SelectionSort {
    public static void main(String[] args) {
        int[] input = {12, 22, 3, 45, 5, 22};
        int[] output = selectionSort(input);
        for (int var : output) {
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

}
