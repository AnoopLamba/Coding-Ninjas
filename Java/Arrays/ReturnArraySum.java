package Java.Arrays;

import java.util.Scanner;

public class ReturnArraySum {

    private static int returnSum(int[] arr) {
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-->0) {
            int n = s.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++) {
                arr[i] = s.nextInt();
            }
            System.out.println(returnSum(arr));
        }
    }

}
