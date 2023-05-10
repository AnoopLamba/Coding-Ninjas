package Java.Arrays;

public class RotateArray {
    public static void solutionOne(int[] arr, int d) {
        //This solution can give time limit exceeded error
        int n = arr.length;
        for(int i = 0; i < d; i++) {
            int zeroeth = arr[0];
            for(int j = 1; j < n; j++) {
                arr[j-1] = arr[j];
            }
            arr[n-1] = zeroeth;
        }
    }

    public static void solutionTwo(int[] arr, int d) {
        int n = arr.length;

        int[] temp = new int[d];
        for(int i = 0; i < d; i++) {
            temp[i] = arr[i];
        }

        for(int i = 0; i < n-d; i++) {
            arr[i] = arr[i-d];
        }

        int index = 0;
        for(int i = n-d; i < n; i++) {
            arr[i] = temp[index];
            index++;
        }
    }
}
