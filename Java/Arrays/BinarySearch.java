package Java.Arrays;

public class BinarySearch {
    public static int binarySearch(int[] arr, int x) {
        int n = arr.length;
        int s = 0;
        int e = n-1;
        while(s <= e) {
            int m = (s+e)/2;
            if(arr[m] > x) {
                e = m-1;
            } else if(arr[m] < x) {
                s = m+1;
            } else if(arr[m] == x) {
                return m;
            }
        }

        return -1;
    }
}
