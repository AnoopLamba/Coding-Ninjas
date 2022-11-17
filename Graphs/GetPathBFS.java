package Graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GetPathBFS {

    public static void getpath(int[][] matrix, int start, int end) {
        boolean[] visited = new boolean[matrix.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        if(matrix.length == 0) {
            return;
        }

        queue.add(start);
        map.put(start, -1);
        visited[start] = true;
        while(!queue.isEmpty()) {
            int top = queue.poll();
            for(int i = 0; i < matrix.length; i++) {
                if(visited[i] == false && matrix[top][i] == 1) {
                    visited[i] = true;
                    queue.add(i);
                    map.put(i, top);
                    if(i == end) {
                        print(start, end, map);
                    }
                }
            }
        }
    }

    private static void print(int start, int end, HashMap<Integer, Integer> map) {
        System.out.print(end + " ");
        int key = end;
        while(map.get(key) != -1) {
            System.out.print(map.get(key) + " ");
            key = map.get(key);
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
        int start = s.nextInt();
        int end = s.nextInt();
        getpath(matrix, start, end);
        s.close();
    }
}
