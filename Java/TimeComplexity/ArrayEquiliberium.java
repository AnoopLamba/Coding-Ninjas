package Java.TimeComplexity;

public class ArrayEquiliberium {
    public static int equiliberium(int[] arr) {
        int n = arr.length;
        int rightSum = 0, leftSum = 0;
        for(int i = 0; i < n; i++) {
            leftSum += arr[i];
        }

        for(int i = 0; i < n; i++) {
            if(rightSum == (leftSum-arr[i])) {
                return i;
            }
            rightSum += arr[i];
            leftSum -= arr[i];
        }

        return -1;
    }
}
