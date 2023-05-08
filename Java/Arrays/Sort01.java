package Java.Arrays;

public class Sort01 {
    public static void sortZeroOne(int[] arr) {
        int n = arr.length;
        int zeroes = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i] == 0) {
                zeroes++;
            }
        }

        for(int i = 0; i < zeroes; i++) {
            arr[i] = 0;
        }
        for(int i = zeroes; i < n; i++) {
            arr[i] = 1;
        }
    }
}
