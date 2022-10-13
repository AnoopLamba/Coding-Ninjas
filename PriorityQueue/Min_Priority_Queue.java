package PriorityQueue;

import java.util.ArrayList;

public class Min_Priority_Queue<T> {
    private ArrayList<Element<T>> heap;

    public Min_Priority_Queue() {
        heap = new ArrayList<>();
    }

    public void insert(T value, int priority) {
        Element<T> e = new Element<>(value, priority);
        heap.add(e);

        //now we have to maintain the heap order property
        int childIndex = heap.size()-1;
        int parentIndex = (childIndex-1)/2;

        while(childIndex > 0) {
            if(heap.get(childIndex).priority < heap.get(parentIndex).priority) {
                //swap
                Element<T> temp = heap.get(childIndex);
                heap.set(childIndex, heap.get(parentIndex));
                heap.set(parentIndex, temp);
                childIndex = parentIndex;
                parentIndex = (childIndex-1)/2;
            } else {
                return;
            }
        }
    }

    public T getMin() throws PriorityQueueEmptyException {
        if(isEmpty()) {
            throw new PriorityQueueEmptyException();
        }
        return heap.get(0).value;
    }

    public T removeMin() throws PriorityQueueEmptyException {
        if(isEmpty()) {
            throw new PriorityQueueEmptyException();
        }

        //swap last element to the first element
        Element<T> lastElement = heap.get(heap.size()-1);
        T ans = heap.get(0).value;
        heap.set(0, lastElement);
        heap.remove(heap.size()-1);

        //now we have to maintain the heap order property
        int parentIndex = 0;
        int leftChild = 2*parentIndex + 1;
        int rightChild = 2*parentIndex + 2;

        while(leftChild < heap.size()) {
            int minIndex = parentIndex;
            if(heap.get(leftChild).priority < heap.get(minIndex).priority) {
                minIndex = leftChild;
            }
            if(rightChild < heap.size() && (heap.get(rightChild).priority < heap.get(minIndex).priority)) {
                minIndex = rightChild;
            }

            //if minIndex is same as the parent than our order is correct and we can exit the loop
            if(minIndex == parentIndex) {
                break;
            }

            //now we swap the minIndex with the parent
            Element<T> temp = heap.get(parentIndex);
            heap.set(parentIndex, heap.get(minIndex));
            heap.set(minIndex, temp);

            //now assigning new parent and child
            parentIndex = minIndex;
            leftChild = 2*parentIndex + 1;
            rightChild = 2*parentIndex + 2;
        }

        return ans;
    }

    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return heap.size() == 0;
    }
}
