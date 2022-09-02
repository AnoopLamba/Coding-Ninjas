package DynamicProgramming2;
import java.util.Arrays;

/* this is solved using a 2-d array */

public class WaysToMakeCoinChange {
    public static int countWaysToMakeChange(int denominations[], int value){
        int n = denominations.length;
        int[][] arr = new int[n+1][value+1];
        for(int i = 0; i < arr.length; i++) {
            Arrays.fill(arr[i], -1);
        }
        return helper(denominations, value, n, arr);
	}

    public static int helper(int denominations[], int value, int n, int[][] arr) {
        //base case
        if(value == 0) {
            return arr[n][value] = 1;
        }
        if(n == 0) {
            return arr[n][value] = 0;
        }

        //minimum work to do
        if(arr[n][value] != -1) {
            return arr[n][value];
        }
        if(denominations[n-1] <= value) {
            int take = helper(denominations, value-denominations[n-1], n, arr);
            int notake = helper(denominations, value, n-1, arr);
            return take+notake;
        } else {
            return helper(denominations, value, n-1, arr);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        int value = 250;
        System.out.println(countWaysToMakeChange(arr, value));
    }
}
