package PriorityQueue2;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BuyTheTicket {
    public static int buyTicket(int input[], int k) {
		int n = input.length;

		//add the indexes of the elements of given array
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 0; i < n; i++) {
			queue.add(i);
		}

		//fill the pq with the actual elements
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for(int i = 0; i < n; i++) {
			pq.add(input[i]);
		}

		int totalTime = 0;
		while(!pq.isEmpty()) {
			if(input[queue.peek()] == pq.peek()) {
				//if the element is largest than we give a ticket and remove it
				totalTime++;
				
				if(queue.peek() == k) {
					//if the element is largest and matches same index
					break;
				}
				pq.poll();
				queue.poll();
			} else {
				queue.add(queue.poll());
			}
		}

		return totalTime;
	}
}
