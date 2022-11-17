package Graphs;

public class LargestPiece {
    static int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};

    static int validPoint(int x, int y, int n) {
        if(x >= 0 && x < n && y >= 0 && y < n) {
            return 1;
        }
        return 0;
    }

    static int largestPiece(String[] edge, int n, int row, int col, int[][] visited) {
        visited[row][col] = 1;
        int sum = 0;
        for(int i = 0; i < 4; i++) {
            int newRow = row + direction[i][0];
            int newCol = col + direction[i][1];
            if(validPoint(newRow,newCol,n) == 1 && visited[newRow][newCol] == 0 && edge[newRow].charAt(newCol) == '1') {
                sum += largestPiece(edge,n,newRow,newCol,visited);
            }
        }

        return 1 + sum;
    }

	public static int dfs(String[] edge, int n) {
		int[][] visited = new int[n][n];
        int maxSize = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(visited[i][j] == 0 && edge[i].charAt(j) == '1') {
                    int out = largestPiece(edge,n,i,j,visited);
                    if(out > maxSize) {
                        maxSize = out;
                    }
                }
            }
        }

        return maxSize;
	}
}
