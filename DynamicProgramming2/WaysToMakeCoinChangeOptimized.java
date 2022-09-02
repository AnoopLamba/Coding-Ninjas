package DynamicProgramming2;

public class WaysToMakeCoinChangeOptimized {
    public static int countWaysToMakeChange(int denominations[], int value){
        int n = denominations.length;
        int[] arr = new int[value+1];
        arr[0] = 1;

        for(int i = 0; i < n; i++) {
            for(int j = denominations[i]; j <= value; j++) {
                arr[j] = arr[j] + arr[j - denominations[i]];
            }
        }
        /*here j is not starting from 0 beacuse
        if suppose j == 0 and denomination[i] == 3,
        than j-denomination[i] will give a negative
        value and will end in Negative Array Index */

        return arr[value];
	}

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        int value = 250;
        System.out.println(countWaysToMakeChange(arr, value));
    }
}
