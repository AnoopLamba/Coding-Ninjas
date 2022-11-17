package Graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class IsConnected {

    public static void isConnected(int[][] matrix) {
        if(matrix.length == 0) {
            System.out.println(true);
            return;
        }
        boolean[] visited = new boolean[matrix.length];
        helper(matrix, 0, visited);
        for(int i = 0; i < matrix.length; i++) {
            if(visited[i] == false) {
                System.out.println(false);
                return;
            }
        }
        System.out.println(true);
    }

    public static void isconnectedBFS(int[][] matrix) {
        if(matrix.length == 0) {
            System.out.println(true);
            return;
        }
        boolean[] visited = new boolean[matrix.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;

        while(!queue.isEmpty()) {
            int top = queue.poll();
            for(int i = 0; i < matrix.length; i++) {
                if(visited[i] == false && matrix[top][i] == 1) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }

        for(int i = 0; i < matrix.length; i++) {
            if(visited[i] == false) {
                System.out.println(false);
                return;
            }
        }
        System.out.println(true);
    }

    private static void helper(int[][] matrix, int currentVertex, boolean[] visited) {
        visited[currentVertex] = true;
        for(int i = 0; i < matrix.length; i++) {
            if(visited[i] == false && matrix[currentVertex][i] == 1) {
                helper(matrix, i, visited);
            }
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int v = s.nextInt();
        int e = s.nextInt();
        int[][] matrix = new int[v][v];
        for(int i = 0; i < e; i++) {
            int v1 = s.nextInt();
            int v2 = s.nextInt();
            matrix[v1][v2] = 1;
            matrix[v2][v1] = 1;
        }
        isConnected(matrix);
        s.close();
    }
}
