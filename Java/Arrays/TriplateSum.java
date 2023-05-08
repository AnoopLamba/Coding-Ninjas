package Java.Arrays;

public class TriplateSum {
    public static int triplateSum(int[] arr, int x) {
        int n = arr.length;
        int incr = 0;
        for(int i = 0; i < n-2; i++) {
            for(int j = i+1; j < n-1; j++) {
                for(int k = j+1; k < n; k++) {
                    if(arr[i] + arr[j] + arr[k] == x) {
                        incr++;
                    }
                }
            }
        }

        return incr;
    }
}
