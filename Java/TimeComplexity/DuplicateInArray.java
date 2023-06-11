package Java.TimeComplexity;

import java.util.Arrays;

public class DuplicateInArray {
    public static int findDuplicate(int[] arr) {
		int n = arr.length;
        int duplicate = 0;
        
        Arrays.sort(arr);
        for(int i = 1; i < n; i++) {
            if(arr[i] == arr[i-1]) {
                duplicate = arr[i];
                break;
            }
        }
        
        return duplicate;
	}
}
