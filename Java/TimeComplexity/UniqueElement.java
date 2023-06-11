package Java.TimeComplexity;

import java.util.Arrays;

public class UniqueElement {
    public static int findUnique(int[] arr) {
		int n = arr.length;
        int unique = arr[0];
        Arrays.sort(arr);
        int i = 0;
        
        while(i < n) {
            if(i == n-1) {
                unique = arr[i];
            } else if(arr[i] != arr[i+1]) {
                unique = arr[i];
                break;
            }
            
            i += 2;
        }
        
        return unique;
	}
}
