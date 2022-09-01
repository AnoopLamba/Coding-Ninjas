package DynamicProgramming2;

public class KnapSackIterative {
    public static int knapsack(int[] weights, int[] values, int n, int maxWeight) {
		int[][] arr = new int[n+1][maxWeight+1];
        for(int i = n-1; i >= 0; i--) {
            for(int j = 0; j <= maxWeight; j++) {
                int ans;
                if(weights[i] <= maxWeight) {
                    int put = values[i] + arr[i+1][j-weights[i]];
                    int notput = arr[i+1][j];
                    ans = Math.max(put, notput);
                } else {
                    ans = arr[i+1][j];
                }
                arr[i][j] = ans;
            }
        }

        return arr[0][maxWeight];
	}

    public static void main(String[] args) {
        int[] weights = {1,2,4,5};
        int[] values = {5,4,8,6};
        int maxWeight = 13;
        System.out.println(knapsack(weights, values, weights.length, maxWeight));
    }
}
