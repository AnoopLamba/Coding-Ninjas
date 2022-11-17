package Graphs;

import java.util.Scanner;

public class HasPath {
    public static void hasPath(int[][] adjMatrix, boolean[] visited, int currentVertex) {
        visited[currentVertex] = true;
        for(int i = 0; i < adjMatrix.length; i++) {
            if((visited[i] == false) && (adjMatrix[currentVertex][i] == 1)) {
                hasPath(adjMatrix, visited, i);
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
        
        int v1 = s.nextInt();
        int v2 = s.nextInt();
        boolean[] visited = new boolean[v];
        hasPath(adjMatrix, visited, v1);
        if(v2 < v) {
            System.out.println(visited[v2]);
        } else {
            System.out.println(false);
        }
        
        s.close();
	}
}
