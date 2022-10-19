package Graphs;

import java.util.Scanner;

public class Graph {

    public static void dfTraversal(int[][] adjMatrix) {
        boolean[] visited = new boolean[adjMatrix.length];
        helper(adjMatrix, 0, visited);
    }

    private static void helper(int[][] adjMatrix, int currentVertex, boolean[] visited) {
        System.out.print(currentVertex + " ");
        visited[currentVertex] = true;
        for(int i = 0; i < adjMatrix.length; i++) {
            if(visited[i] == false && adjMatrix[currentVertex][i] == 1) {
                helper(adjMatrix, i, visited);
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int e = s.nextInt();
        int[][] adjMatrix = new int[n][n];
        for(int i = 0; i < e; i++) {
            int v1 = s.nextInt();
            int v2 = s.nextInt();
            adjMatrix[v1][v2] = 1;
            adjMatrix[v2][v1] = 1;
        }

        dfTraversal(adjMatrix);
        s.close();
    }
}
