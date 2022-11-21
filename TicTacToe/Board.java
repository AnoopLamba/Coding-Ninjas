package TicTacToe;

public class Board {
    private char[][] board;
    private char p1symbol, p2symbol;
    private int boardSize = 3;
    private int count;
    private static final char EMPTY = ' ';
    public static final int PLAYER1WIN = 1;
    public static final int PLAYER2WIN = 2;
    public static final int DRAW = 3;
    public static final int INCOMPLETE = 4;
    public static final int INVALID = 5;


    public Board(char p1symbol, char p2symbol) {
        board = new char[boardSize][boardSize];
        for(int i = 0; i < boardSize; i++) {
            for(int j = 0; j < boardSize; j++) {
                board[i][j] = EMPTY;
            }
        }
        this.p1symbol = p1symbol;
        this.p2symbol = p2symbol;
    }

    public int cellCount() {
        return count;
    }

    public int move(char symbol, int x, int y) {
        //if the move is not valid
        if(!isMoveValid(x, y)) {
            return 5;
        }

        //if the move is valid
        board[x][y] = symbol;
        count++;

        //now after the player played
        //Row
        if(board[x][0] == board[x][1] && board[x][0] == board[x][2]) {
            return (symbol == p2symbol) ? PLAYER2WIN : PLAYER1WIN; 
        }

        //column
        if(board[0][y] == board[1][y] && board[0][y] == board[2][y]) {
            return (symbol == p1symbol) ? PLAYER1WIN : PLAYER2WIN; 
        }

        //diagonal 1
        if(board[0][0] != EMPTY && board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
            return (symbol == p1symbol) ? PLAYER1WIN : PLAYER2WIN; 
        }
        //diagonal 2
        if(board[0][2] != EMPTY && board[0][2] == board[1][1] && board[0][2] == board[2][0]) {
            return (symbol == p1symbol) ? PLAYER1WIN : PLAYER2WIN; 
        }

        //if board if full and game gets draw
        if(count == boardSize*boardSize) {
            return 3;
        }
        
        return 4;
    }

    private boolean isMoveValid(int x, int y) {
        if(x >= 0 && y >= 0 && x < boardSize && y < boardSize) {
            if(board[x][y] == EMPTY) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public void print() {
        System.out.println("---------------");
        for(int i = 0; i < boardSize; i++) {
            for(int j = 0; j < boardSize; j++) {
                System.out.print("| " + board[i][j] + " |");
            }
            System.out.println();
        }
        System.out.println("---------------");
    }
}
