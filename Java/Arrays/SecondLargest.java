package Java.Arrays;

public class SecondLargest {
    public static int secondLargest(int[] arr) {
        int n = arr.length;
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            if(arr[i] > second) {
                if(arr[i] > first) {
                    second = first;
                    first = arr[i];
                }
                if(arr[i] > second && arr[i] < first) {
                    second = arr[i];
                }
            }
        }

        return second;
    }
}
