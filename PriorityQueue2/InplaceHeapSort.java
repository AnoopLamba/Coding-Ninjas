package PriorityQueue2;

public class InplaceHeapSort {

    public static void heapSort(int[] arr) {
        //build the heap using our own down heapify function
        int n = arr.length;
        for(int i = (n/2)-1; i >= 0; i--) {
            upHeapify(arr, i, n);
        }

        //remove elements from heap
        for(int i = n-1; i >= 0; i--) {
            //swap first and i element
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            upHeapify(arr, 0, i);
        }
    }

    public static void upHeapify(int[] arr, int i, int n) {
        int parentIndex = i;
        int leftChildIndex = 2*parentIndex + 1;
        int rightChildIndex = 2*parentIndex + 2;

        while(leftChildIndex < n) {
            int minIndex = parentIndex;
            if(arr[leftChildIndex] < arr[minIndex]) {
                minIndex = leftChildIndex;
            }
            if(rightChildIndex < n && (arr[rightChildIndex] < arr[minIndex])) {
                minIndex = rightChildIndex;
            }
            if(minIndex == parentIndex) {
                return;
            }

            int temp = arr[parentIndex];
            arr[parentIndex] = arr[minIndex];
            arr[minIndex] = temp;

            parentIndex = minIndex;
            leftChildIndex = 2*parentIndex + 1;
            rightChildIndex = 2*parentIndex + 2;
        }
    }

    public static void main(String[] args) {
        int[] arr = {4,7,3,2,8,9,6,1};
        heapSort(arr);
        for(int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
