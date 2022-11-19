package Graphs2;

import java.util.Scanner;

public class PrimAlgorithm {

    private static int findMinVertex(boolean[] visited, int[] weight) {
        int minWeight = Integer.MAX_VALUE;
        int minIndex = -1;
        for(int i = 0; i < visited.length; i++) {
            if(!visited[i]) {
                if(weight[i] < minWeight) {
                    minWeight = weight[i];
                    minIndex = i;
                }
            }
        }

        return minIndex;
    }

    public static void primAlgo(int[][] adjMatrix) {
        int v = adjMatrix.length;
        //visited array
        boolean[] visited = new boolean[v];

        //list of all parents and fill 0th vertex
        int[] parents = new int[v];
        parents[0] = -1;

        //array for storing the weight and fill 0th vertex
        int[] weight = new int[v];
        weight[0] = 0;
        for(int i = 1; i < v; i++) {
            weight[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < v; i++) {
            //find vertex with minimum weight
            int minVertex = findMinVertex(visited, weight);
            visited[minVertex] = true;
            //now explore all neighobors of minVertex
            for(int j = 0; j < v; j++) {
                if(adjMatrix[j][minVertex] > 0 && !visited[j]) {
                    if(weight[j] > adjMatrix[j][minVertex]) {
                        weight[j] = adjMatrix[j][minVertex];
                        parents[j] = minVertex;
                    }
                }
            }
        }

        //printing the MST
        for(int i = 1; i < v; i ++) {
            if(i < parents[i]) {
                System.out.println(i + " " + parents[i] + " " + weight[i]);
            } else {
                System.out.println(parents[i] + " " + i + " " + weight[i]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
		int v = s.nextInt();
		int e = s.nextInt();

        //building Edge Array
        int[][] adjMatrix = new int[v][v];
        for(int i = 0; i < e; i++) {
            int v1 = s.nextInt();
            int v2 = s.nextInt();
            int weight = s.nextInt();
            adjMatrix[v1][v2] = weight;
            adjMatrix[v2][v1] = weight;
        }

        primAlgo(adjMatrix);
        s.close();
    }
}
