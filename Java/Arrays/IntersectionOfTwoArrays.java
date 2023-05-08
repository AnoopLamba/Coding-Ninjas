package Java.Arrays;

public class IntersectionOfTwoArrays {
    public static void intersection(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(arr1[i] == arr2[j]) {
                    System.out.print(arr1[i] + " ");
                    arr2[j] = Integer.MIN_VALUE;
                    break;
                }
            }
        }
    }
}
