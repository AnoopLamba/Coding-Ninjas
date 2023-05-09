package Java.Arrays;

public class MergeTwoSortedArrays {
    public static int[] merge(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;
        int i = 0;
        int j = 0;
        int k = 0;
        int[] merged = new int[n+m];
        while(i < m && j < n) {
            if(arr1[i] < arr2[j]) {
                merged[k] = arr1[i];
                i++;
                k++;
            } else {
                merged[k] = arr2[j];
                j++;
                k++;
            }
        }

        while(i >= m && j < n) {
            merged[k] = arr2[j];
            j++;
            k++;
        }
        while(j >= n && i < m) {
            merged[k] = arr1[i];
            i++;
            k++;
        }

        return merged;
    }
}
