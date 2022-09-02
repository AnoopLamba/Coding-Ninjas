package DynamicProgramming2;
import java.util.Arrays;
public class SubsetSumMemoization {
    static boolean isSubsetPresent(int[] arr, int n, int sum) {
        int[][] temp = new int[n+1][sum+1];
        for(int i = 0; i < temp.length; i++) {
            Arrays.fill(temp[i], -1);
        }

        if(helper(arr, n, sum, temp) != 0) {
            return true;
        } else {
            return false;
        }
    }

    public static int helper(int[] arr, int n, int sum, int[][] temp) {
        //base case
        if(sum == 0) {
            return 1;
        }
        if(sum < 0 || n <= 0) {
            return 0;
        }

        //minimum work to do
        if(temp[n][sum] != -1) {
            return temp[n][sum];
        }
        if(arr[n-1] <= sum) {
            int take = helper(arr, n-1, sum-arr[n-1], temp);
            int notake = helper(arr, n-1, sum, temp);
            if(take != 0 || notake != 0) {
                return temp[n][sum] = 1;
            } else {
                return temp[n][sum] = 0;
            }
        } else {
            return helper(arr, n-1, sum, temp);
        }
    }
}
