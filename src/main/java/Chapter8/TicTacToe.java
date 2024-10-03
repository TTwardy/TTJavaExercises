package Chapter8;

import java.util.Scanner;

public class TicTacToe {
   public enum Status{
       X("X"),
       O("O"),
       EMPTY(" ");
       String value;
       Status(String value) {
           this.value=value;
       }
       private String getValue(){
           return value;
       }
   }
   Status[][]game;
   boolean isPlayerXTurn = true;
   boolean isPlayerOTurn = false;
   boolean gameOver = false;
   Scanner scanner = new Scanner(System.in);

   public TicTacToe(){
        this.game= new Status[][]{
               {Status.EMPTY, Status.EMPTY, Status.EMPTY},
               {Status.EMPTY, Status.EMPTY, Status.EMPTY},
               {Status.EMPTY, Status.EMPTY, Status.EMPTY}
       };
   }

   public void startGame(){
       while(!gameOver){
           move();
       }
   }
   public void move (){
       if (isPlayerXTurn){
           System.out.println("Player X move");
           choosePosition("X");
           isPlayerXTurn=false;
           isPlayerOTurn=true;
       } else if (isPlayerOTurn) {
           System.out.println("Player O move");
           choosePosition("O");
           isPlayerOTurn=false;
           isPlayerXTurn=true;
       }
       showBoard();
       gameOver=checkWin();
       if (gameOver){
           if (isPlayerOTurn){
               System.out.println("Player X win");
           } else if (isPlayerXTurn) {
               System.out.println("Player O win");
           }
       }
       checkIfGameOver();
   }

    private void checkIfGameOver() {
       boolean emptyField = false;
        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game[i].length; j++) {
                if (game[i][j] == Status.EMPTY){
                    emptyField = true;
                    break;
                }
            }
        }
        if (!emptyField){
            System.out.println("game over");
            gameOver = true;
        }
    }

    public boolean checkWin() {
        // Check rows for a win
        for (int i = 0; i < 3; i++) {
            if (game[i][0] != Status.EMPTY && game[i][0] == game[i][1] && game[i][1] == game[i][2]) {
                return true; // Row win
            }
        }

        // Check columns for a win
        for (int i = 0; i < 3; i++) {
            if (game[0][i] != Status.EMPTY && game[0][i] == game[1][i] && game[1][i] == game[2][i]) {
                return true; // Column win
            }
        }

        // Check diagonals for a win
        if (game[0][0] != Status.EMPTY && game[0][0] == game[1][1] && game[1][1] == game[2][2]) {
            return true; // Main diagonal win
        }
        if (game[0][2] != Status.EMPTY && game[0][2] == game[1][1] && game[1][1] == game[2][0]) {
            return true; // Anti-diagonal win
        }

        // If no win is found, return false
        return false;
    }

    private void showBoard() {
        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game[i].length; j++) {
                System.out.print("| ");
                System.out.print(game[i][j].getValue() + " | ");
            }
            System.out.println();
        }
    }

    private void choosePosition(String mark) {
       boolean isFieldEmpty = true;
       while(isFieldEmpty){
       System.out.println("Enter row");
        int row = scanner.nextInt() -1 ;
        System.out.println("Enter column");
        int column = scanner.nextInt() - 1;
        if(game[row][column]==Status.EMPTY){
            isFieldEmpty=false;
            if(mark.equalsIgnoreCase("X")){
                game[row][column] = Status.X;
            }
            else {
                game[row][column] = Status.O;
            }
        }
        else {
            System.out.println("The field is not empty");
        }
        }

    }

}
