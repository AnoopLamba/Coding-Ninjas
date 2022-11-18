package Graphs2;

import java.util.Scanner;
import java.util.Arrays;

class Edge implements Comparable<Edge>{
    int v1;
    int v2;
    int weight;

    public Edge(int v1, int v2, int weight) {
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge e) {
        return this.weight - e.weight;
    }
}

public class KruskalAlgorithm {

    private static int findParent(int child, int[] parent) {
        if(parent[child] == child) {
            return child;
        }
        return findParent(parent[child], parent);
    }

    public static Edge[] kruskalAlgo(Edge[] edges, int v, int e) {
        //now sorting Edge array
        Arrays.sort(edges);
        
        //parent array
        int[] parent = new int[v];
        for(int i = 0; i < v; i++) {
            parent[i] = i;
        }

        //output array list
        Edge[] output = new Edge[v-1];

        //now picking edges for Minimum Spanning Tree
        int count = 0, i = 0;
        while(count != v-1) {
            Edge currentEdge = edges[i++];
            int p1 = findParent(currentEdge.v1, parent);
            int p2 = findParent(currentEdge.v2, parent);
            if(p1 != p2) {
                output[count] = currentEdge;
                parent[p1] = p2;
                count++;
            }
        }

        return output;
    }

    public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int v = s.nextInt();
		int e = s.nextInt();

        //building Edge Array
        Edge[] edges = new Edge[e];
        for(int i = 0; i < e; i++) {
            int v1 = s.nextInt();
            int v2 = s.nextInt();
            int weight = s.nextInt();
            Edge newedge = new Edge(v1, v2, weight);
            edges[i] = newedge;
        }

        //calling the function and storing the output
        Edge[] output = kruskalAlgo(edges, v, e);

        //now  printing the final graph
        for(int j = 0; j < output.length; j++) {
            int v1 = output[j].v1, v2 = output[j].v2, weight = output[j].weight; 
            if(v1 < v2) {
                System.out.println(v1 + " " + v2 + " " + weight);
            } else {
                System.out.println(v2 + " " + v1 + " " + weight);
            }
        }

        s.close();
	}
}
