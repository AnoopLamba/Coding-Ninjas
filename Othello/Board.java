package Othello;

public class Board {
    private int board[][];
	final static int player1Symbol = 1;
	final static int player2Symbol = 2;
	final static int EMPTY = 0;
	final static int boardSize = 8;

    public Board() {
        board = new int[8][8];
		board[3][3] = player1Symbol;
		board[3][4] = player2Symbol;
		board[4][3] = player2Symbol;
		board[4][4] = player1Symbol;
    }

    public boolean move(int symbol, int x, int y) {
        //is move valid or not
        if(x < 0 || y < 0 || x >= boardSize || y >= boardSize) {
            return false;
        }
        if(board[x][y] != EMPTY) {
            return false;
        }

        //it is in the bounds
        //now, can we actually place it or not
        int[] xdir = {-1,-1,0,1,1,1,0,-1};
        int[] ydir = {0,1,1,1,0,-1,-1,-1};
        boolean isConversionPossible = false;

        for(int i = 0; i < 8; i++) {
            int count = 0;
			int xStep = xdir[i];
			int yStep = ydir[i];
            int newx = x + xStep;
            int newy = y + yStep;
            while(inBounds(newx, newy) && board[newx][newy] != EMPTY && board[newx][newy] != symbol ) {
                count++;
				newx += xStep;
				newy += yStep;
            }

            if(inBounds(newx, newy) && board[newx][newy] == symbol && count != 0) {
                //then conversion is possible here
                isConversionPossible = true;
				board[x][y] = symbol;
                newx = x + xStep;
                newy = y + yStep;
                while(inBounds(newx, newy) && board[newx][newy] != symbol) {
                    board[newx][newy] = symbol;
                    newx += xStep;
                    newy += yStep;
                }
            }
        }

        return isConversionPossible;
    }

    private boolean inBounds(int x, int y) {
        if(x >= 0 && y >= 0 && x < boardSize && y < boardSize) {
            return true;
        }
        return false;
    }

    public void print() {
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
}
