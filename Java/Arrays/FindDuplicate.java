package Java.Arrays;

public class FindDuplicate {
    public static int duplicate(int[] arr) {
        int out = 0;
        int n = arr.length;
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                if(arr[j] == arr[i]) {
                    return arr[i];
                }
            }
        }

        return out;
    }
}
