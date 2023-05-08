package Java.Arrays;

public class FindUnique {
    public static int unique(int[] arr) {
        int n = arr.length;
        for(int i = 0; i < n; i++) {
            int ctr = 0;
            for(int j = 0; j < n; j++) {
                if(arr[i] == arr[j]) {
                    ctr++;
                }
            }
            if(ctr == 1) {
                return arr[i];
            }
        }

        return arr[0];
    }
}
