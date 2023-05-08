package Java.Arrays;

public class PairSum {
    public static int pairSum(int[] arr, int x) {
        int pairs = 0;
        int n = arr.length;
        for(int i = 0; i < n-1; i++) {
            for(int j = i+1; j < n; j++) {
                if(arr[i] + arr[j] == x) {
                    pairs++;
                }
            }
        }

        return pairs;
    }
}
