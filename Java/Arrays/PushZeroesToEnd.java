package Java.Arrays;

public class PushZeroesToEnd {
    public static void pushZeroes(int[] arr) {
        int n = arr.length;
        int i = 0;
        for(int j = 0; j < n; j++) {
            if(arr[j] != 0) {
                arr[i] = arr[j];
                i++;
            }
        }

        for(int k = i; k < n; k++) {
            arr[k] = 0;
        }
    }
}
