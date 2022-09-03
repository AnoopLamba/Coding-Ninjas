package DynamicProgramming2;

public class MinimumNumberOfChocolates {
    public static int getMin(int arr[], int N){
        if(N == 0 || N == 1) {
            return N;
        }

        int[] dp = new int[N];
        dp[0] = 1;
        //LTR
        for(int i = 1; i < N; i++) {
            if(arr[i] > arr[i-1]) {
                dp[i] = 1+dp[i-1];
            } else {
                dp[i] = 1;
            }
        }

        //RTL
        for(int i = N-2; i >= 0; i--) {
            if(arr[i] > arr[i+1] && dp[i] <= dp[i+1]) {
                dp[i] = 1+dp[i+1];
            }
        }

        int ans = 0;
        for (int i : dp) {
            ans += i;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {5,1,4,6,7};
        int N = arr.length;
        System.out.println(getMin(arr, N));
    }
}
