package DynamicProgramming2;
public class SubsetSum {
    static boolean isSubsetPresent(int[] arr, int n, int sum) {
        //base case
        if(sum == 0) {
            return true;
        }
        if(sum < 0 || n <= 0) {
            return false;
        }

        //minimum work to do
        if(arr[n-1] <= sum) {
            boolean ans1 = isSubsetPresent(arr, n-1, sum-arr[n-1]);
            boolean ans2 = isSubsetPresent(arr, n-1, sum);
            return ans1 || ans2;
        } else {
            return isSubsetPresent(arr, n-1, sum);
        }
    }

    public static void main(String[] args) {
        int[] arr = {4,2,5,6,7};
        int sum = 14;
        System.out.println(isSubsetPresent(arr, arr.length, sum));
    }
}
