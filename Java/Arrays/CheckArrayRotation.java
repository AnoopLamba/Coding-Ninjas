package Java.Arrays;

public class CheckArrayRotation {
    public static int checkArrayRotation(int[] arr) {
        int n = arr.length;
        for(int i = 1; i < n; i++) {
            if(arr[i] < arr[i-1]) {
                return i+1;
            }
        }

        return 0;
    }
}
