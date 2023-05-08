package Java.Arrays;

public class SelectionSort {
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for(int i = 0; i < n-1; i++) {
            int min = arr[i];
            int minIndex = i;
            for(int j = i+1; j < n; j++) {
                if(arr[j] < min) {
                    min = arr[j];
                    minIndex = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}
