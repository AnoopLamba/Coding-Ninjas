package PriorityQueue2;

public class CheckMaxHeap {
    public static boolean checkMaxHeap(int arr[]) {
        int n = arr.length;
		for(int i = 0; i < n; i++) {
            int parentIndex = i;
            int leftChildIndex = 2*parentIndex + 1;
            int rightChildIndex = 2*parentIndex + 2;
            
            //also check if the child are in the range or not
            if((leftChildIndex < n) && (arr[leftChildIndex] > arr[parentIndex])) {
                return false;
            }
            if((rightChildIndex < n) && (arr[rightChildIndex] > arr[parentIndex])) {
                return false;
            }
        }
        
        return true;
	}
}
