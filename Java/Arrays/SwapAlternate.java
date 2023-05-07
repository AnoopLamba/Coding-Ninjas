package Java.Arrays;

public class SwapAlternate {
    public static void swap(int[] arr){
        for(int i = 0; i < arr.length; i += 2) {
            int j = i+1;
            if(j < arr.length) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    } 
}
