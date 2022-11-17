package Graphs;

public class ConnectingDots {
    public static int solve(String[] board, int n, int m) {
        boolean[][] visited = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!visited[i][j]) {
                    if(hasCycle(board,-1,-1,i,j,visited,n,m) == 1) {
                        return 1;
                    }
                }
            }
        }
        return 0;
	}

    public static int hasCycle(String[] board, int fromX, int fromY, int x, int y, boolean[][] visited, int n, int m) {
        if(visited[x][y] == true) {
            return 1;
        }
        visited[x][y] = true;
        int[] xdir = {1,0,0,-1};
        int[] ydir = {0,1,-1,0};
        for(int i = 0; i < 4; i++) {
            int newx = xdir[i] + x;
            int newy = ydir[i] + y;
            if(newx == fromX && newy == fromY) {
                continue;
            }
            if(isValid(newx,newy,n,m) == true && board[newx].charAt(newy) == board[x].charAt(y)) {
                int out = hasCycle(board,x,y,newx,newy,visited,n,m);
                if(out == 1) {
                    return 1;
                }
            }
        }
        return 0;
    }

    private static boolean isValid(int x, int y, int n, int m) {
        if(x >= 0 && y >= 0 && x < n && y < m) {
            return true;
        }
        return false;
    }
}
