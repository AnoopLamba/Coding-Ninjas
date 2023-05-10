package Java.Arrays;

public class SumOfTwoArrays {
    public static void sum(int[] arr1, int[] arr2, int[] out) {
        int m = arr1.length, n = arr2.length, o = out.length;

        int i = m-1, j = n-1, k = o-1;
        int carry = 0;

        while(i >= 0 && j >= 0) {
            int sum = arr1[i]+arr2[j]+carry;
            out[k] = sum%10;
            carry = sum/10;
            i--;
            j--;
            k--;
        }

        while(j < 0 && i >= 0) {
            int sum = arr1[i]+carry;
            out[k] = sum%10;
            carry = sum/10;
            i--;
            k--;
        }

        while(i < 0 && j >= 0) {
            int num = arr2[j] + carry;
            out[k] = num%10;
            carry = num/10;
            j--;
            k--;
        }

        out[k] = carry;
    }
}
