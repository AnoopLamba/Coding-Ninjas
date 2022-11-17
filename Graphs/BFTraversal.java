package Graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFTraversal {
    public static void bfTraversal(int[][] adjMatrix) {
        if(adjMatrix.length == 0) {
            return;
        }
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[adjMatrix.length];

        for(int i = 0; i < adjMatrix.length; i++) {
            if(visited[i] == false) {
                queue.add(i);
                visited[i] = true;

                while(!queue.isEmpty()) {
                    int removed = queue.poll();
                    System.out.print(removed + " ");
                    for(int j = 0; j < adjMatrix.length; j++) {
                        if(visited[j] == false && adjMatrix[removed][j] == 1) {
                            queue.add(j);
                            visited[j] = true;
                        }
                    }
                }
            }
        }
    }

	public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int v = s.nextInt();
        int e = s.nextInt();
        int[][] adjMatrix = new int[v][v];
        for(int i = 0; i < e; i++) {
            int v1 = s.nextInt();
            int v2 = s.nextInt();
            adjMatrix[v1][v2] = 1;
            adjMatrix[v2][v1] = 1;
        } 

        bfTraversal(adjMatrix);
        s.close();
	}
}
