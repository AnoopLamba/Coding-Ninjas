package Java.TimeComplexity;

import java.util.Arrays;

public class ArrayIntersection {
    public static void intersection(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int i = 0, j = 0;
        while(i < m && j < n) {
            if(arr1[i] == arr2[j]) {
                System.out.print(arr1[i] + " ");
                i++;
                j++;
            }
            if(arr1[i] > arr2[j]) {
                j++;
            }
            if(arr1[i] < arr2[j]) {
                i++;
            }
        }
    }
}
