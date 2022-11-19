package Graphs2;

import java.util.Scanner;

public class DijkstraAlgorithm {

    private static int findMinVertex(int[] distance, boolean[] visited) {
        int minVertex = -1;
        int minDistance = Integer.MAX_VALUE;
        for(int i = 0; i < distance.length; i++) {
            if(!visited[i]) {
                if(distance[i] < minDistance) {
                    minDistance = distance[i];
                    minVertex = i;
                }
            }
        }

        return minVertex;
    }

    public static void dijkstraAlgo(int[][] adjMatrix) {
        int v = adjMatrix.length;
        boolean[] visited = new boolean[v];

        //fill the distance array;
        int[] distance = new int[v];
        distance[0] = 0;
        for(int i = 1; i < v; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < v; i++) {
            int mv = findMinVertex(distance, visited);
            visited[mv] = true;
            for(int j = 0; j < v; j++) {
                if(!visited[j] && adjMatrix[mv][j] > 0) {
                    int distViaMV = distance[mv] + adjMatrix[mv][j];
                    if(distViaMV < distance[j]) {
                        distance[j] = distViaMV;
                    }
                }
            }
        }

        //now print the vertex and its distance for source
        for(int i = 0; i < v; i++) {
            System.out.println(i + " " + distance[i]);
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
            int weight = s.nextInt();
            adjMatrix[v1][v2] = weight;
            adjMatrix[v2][v1] = weight;
        }

        dijkstraAlgo(adjMatrix);
        s.close();
    }
}
