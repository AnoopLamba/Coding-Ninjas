package TicTacToe;

import java.util.Scanner;

public class Manager {
    private Player player1, player2;
    private Board board;
    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        Manager manager = new Manager();
        manager.startGame();
        s.close();
    }

    public void startGame() {
        //take players input
        player1 = takePlayerInputs(1);
        player2 = takePlayerInputs(2);
        while(player1.getSymbol() == player2.getSymbol()) {
            System.out.println("Both symbols cannot be same, choose another one");
            player2.setSymbol(s.nextLine().charAt(0));
        }

        //create the board
        board = new Board(player1.getSymbol(), player2.getSymbol());

        //start the game
        boolean p1turn = true;
        int status = Board.INCOMPLETE;
        while(status == Board.INCOMPLETE || status == Board.INVALID) {
            if(p1turn) {
                System.out.println("Player 1 - " + player1.getName() + "'s turn");
                System.out.println("Enter x:");
                int x = s.nextInt();
                System.out.println("Enter y:");
                int y = s.nextInt();

                status = board.move(player1.getSymbol(),x,y);
                if(status == Board.INVALID) {
                    System.out.println("Invalid move !! make your move again");
                    continue;
                }
            } else {
                System.out.println("Player 2 - " + player2.getName() + " 's turn");
                System.out.println("Enter x:");
                int x = s.nextInt();
                System.out.println("Enter y:");
                int y = s.nextInt();

                status = board.move(player2.getSymbol(),x,y);
                if(status == Board.INVALID) {
                    System.out.println("Invalid move !! make your move again");
                    continue;
                }
            }
            p1turn = !p1turn;
            board.print();
        }

        if(status == Board.PLAYER1WIN) {
            System.out.println("Player 1 - " + player1.getName() + " won !!");
        } else if(status == Board.PLAYER2WIN) {
            System.out.println("Player 2 - " + player2.getName() + " won !!");
        } else {
            System.out.println("This game is a draw");
        }
    }

    private Player takePlayerInputs(int num) {
        System.out.println("Enter player " + num + " name");
        String name = s.nextLine();
        System.out.println("Enter player " + num + " symbol");
        char symbol = s.nextLine().charAt(0);
        Player player = new Player(name, symbol);
        return player;
    }
}
