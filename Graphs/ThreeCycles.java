package Graphs;

public class ThreeCycles {
    public static int solve(boolean[][] graph, int n) {
        int cycles = 0;
		for(int i = 0; i < n-2; i++) {
            for(int j = i+1; j < n-1; j++) {
                for(int k = j+1; j < n; k++) {
                    if(graph[i][j] && graph[j][k] && graph[k][i]) {
                        cycles++;
                    }
                }
            }
        }
        return cycles;
	}
}
