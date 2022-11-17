package Graphs;

public class Islands {
    public static int numConnected(int[][] edges, int n) {
        boolean[] visited = new boolean[edges.length];
        int components = 0;
        for(int i = 0; i < edges.length; i++) {
            if(visited[i] == false) {
                components++;
                helper(edges, i, visited);
            }
        }
        
        return components;
    }

    public static void helper(int[][] matrix, int currentEdge, boolean[] visited) {
        visited[currentEdge] = true;
        for(int i = 0; i < matrix.length; i++) {
            if(visited[i] == false && matrix[currentEdge][i] == 1) {
                helper(matrix, i, visited);
            }
        }
    }
}
