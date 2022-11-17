package Graphs;

import java.util.ArrayList;
import java.util.Scanner;

public class GetPathDFS {

    public static void getpath(int[][] adjMatrix, int start, int end) {
        boolean[] visited = new boolean[adjMatrix.length];
        ArrayList<Integer> out = helper(adjMatrix, start, end, visited);
        if(out != null) {
            for(int x: out) {
                System.out.println(x + " ");
            }
        }
    }

    public static ArrayList<Integer> helper(int[][] adjMatrix, int currentVertex, int end, boolean[] visited) {
        visited[currentVertex] = true;
        if(currentVertex == end) {
            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(currentVertex);
            return ans;
        }
        for(int i = 0; i < adjMatrix.length; i++) {
            if((visited[i] == false) && (adjMatrix[currentVertex][i] == 1)) {
                ArrayList<Integer> out = helper(adjMatrix, i, end, visited);
                if(out != null) {
                    out.add(currentVertex);
                    return out;
                }
            }
        }

        return null;
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
        int start = s.nextInt();
        int end = s.nextInt();
        getpath(adjMatrix, start, end);
        s.close();
    }
}
