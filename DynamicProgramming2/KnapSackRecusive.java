package DynamicProgramming2;

public class KnapSackRecusive {
    public static int knapsack(int[] weights, int[] values, int n, int maxWeight) {

        return helper(weights, values, n, maxWeight, 0);
    }

    public static int helper(int[] weights, int[] values, int n, int maxWeight, int i) {
      if (i == weights.length || maxWeight == 0){
          return 0;
      }
      if (weights[i] > maxWeight){
          return helper(weights, values, n, maxWeight, i+1);
      }else {
          int a =  helper(weights, values, n, maxWeight, i+1);
          int b = values[i] + helper(weights, values, n, maxWeight - weights[i], i+1);
          return Math.max(a,b);
      }
    }

    public static void main(String[] args) {
        int n = 4;
        int[] weights = {1,2,4,5};
        int[] values = {5,4,8,6};
        int maxWeight = 13;
        System.out.println(knapsack(weights, values, n, maxWeight));
    }
}
