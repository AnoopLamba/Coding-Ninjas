package Java.TimeComplexity;

public class PairSum {
    public static int pairSum(int[] arr, int num) {
		int n = arr.length;
        int sum = 0;
        for(int i = 0; i < n-1; i++) {
            for(int j = i+1; j < n; j++) {
                if(arr[i]+arr[j] == num) {
                    sum++;
                }
            }
        }
        
        return sum;
	}
}
