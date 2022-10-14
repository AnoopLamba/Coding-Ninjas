package PriorityQueue2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class KsmallestElements {
    public static ArrayList<Integer> kSmallest(int n, int[] input, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        //now fill the queue upto k size to reduce the space used
        for(int i = 0; i < k; i++) {
            pq.add(input[i]);
        }

        //now insert and remove elements from the queue
        for(int i = k; i < input.length; i++) {
            if(pq.peek() > input[i]) {
                pq.poll();
                pq.add(input[i]);
            }
        }

        //now we have to output a list and maintain the space used to k
        ArrayList<Integer> list = new ArrayList<>();
        while(!pq.isEmpty()) {
            list.add(pq.poll());
        }

        return list;
	}
}
