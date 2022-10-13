package PriorityQueue;

import java.util.ArrayList;

public class Max_Priority_Queue<T> {
    private ArrayList<Element<T>> heap;

    public Max_Priority_Queue() {
        heap = new ArrayList<>();
    }

    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return heap.size() == 0;
    }

    public T getMax() throws PriorityQueueEmptyException{
        if(isEmpty()) {
            throw new PriorityQueueEmptyException();
        }
        return heap.get(0).value;
    }

    public void insert(T value, int priority) {
        //add it to heap;
        Element<T> e = new Element<T>(value, priority);
        heap.add(e);

        //now maintain the heap order property
        int childIndex = heap.size()-1;
        int parentIndex = (childIndex-1)/2;

        while(childIndex > 0) {
            if(heap.get(childIndex).priority > heap.get(parentIndex).priority) {
                //now we will swap
                Element<T> temp = heap.get(childIndex);
                heap.set(childIndex, heap.get(parentIndex));
                heap.set(parentIndex, temp);
                //now change the parent index and child index
                childIndex = parentIndex;
                parentIndex = (childIndex-1)/2;
            } else {
                return;
            }
        }
    }

    public T removeMax() throws PriorityQueueEmptyException{
        if(isEmpty()) {
            throw new PriorityQueueEmptyException();
        }

        //swap last to first
        Element<T> lastElement = heap.get(heap.size()-1);
        T ans = heap.get(0).value;
        heap.set(0, lastElement);
        heap.remove(heap.size()-1);

        //heap order property
        int parentIndex = 0;
        int leftChild = 2*parentIndex + 1;
        int rightChild = 2*parentIndex + 2;

        while(leftChild < heap.size()) {
            int maxIndex = parentIndex;
            if(heap.get(leftChild).priority > heap.get(maxIndex).priority) {
                maxIndex = leftChild;
            }
            if(rightChild < heap.size() && (heap.get(rightChild).priority > heap.get(maxIndex).priority)) {
                maxIndex = rightChild;
            }

            //check the max index
            if(maxIndex == parentIndex) {
                break;
            }

            //swap maxIndex with the parent
            Element<T> temp = heap.get(parentIndex);
            heap.set(parentIndex, heap.get(maxIndex));
            heap.set(maxIndex, temp);

            //change the parent and childs
            parentIndex = maxIndex;
            leftChild = 2*parentIndex + 1;
            rightChild = 2*parentIndex + 2;
        }

        return ans;
    }
}
