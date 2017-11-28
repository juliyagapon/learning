import java.util.Scanner;

public class TicTacToeApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Allows to cont. games
        boolean doYouWantToPlay = true;
        while (doYouWantToPlay){
            System.out.println("Welocome to Tic Tac Toe! You are about to go against the master of Tic Tac Toe. " +
                    "Are you ready? I hope so!\nBut first, you must pick what character you want to be and which" +
                    "character I will be");
            System.out.println();
            System.out.println("Enter a single character that will be represent you on the board");
            char playerToken = sc.next().charAt(0);
            System.out.println("Enter a single character that will be represent your opponent on the board");
            char opponentToken = sc.next().charAt(0);
            TicTacToe game = new TicTacToe(playerToken, opponentToken);
            AI ai = new AI();
            //Set up the game
            System.out.println();
            System.out.println("Now we can start the game. To play, enter a number and your taken shall be put" +
                    " in its place.\nThe numbers go from 1-9, left and right. Well shell see who will win this round.");
            TicTacToe.printIndexBoard();
            System.out.println();

            //Let's play
            while (game.gameOver().equals("notOver")){
                if (game.currentMarker == game.userMarker){
                    //User turn
                    System.out.println("It's your turn!");
                    int spot = sc.nextInt();
                    while (!game.playTurn(spot)){
                        System.out.println("Try again. " + spot + " is invalid. This spot is already taken" +
                                " or it is out of range");
                        spot = sc.nextInt();
                    }
                    System.out.println("You picked " + spot + "!");
                }
                else {
                    //AI turn
                    System.out.println("It's my turn!");
                    int aiSpot = ai.pickSpot(game);
                    game.playTurn(aiSpot);
                    System.out.println("I picked "+ ai+ "!");
                }
                //Print our new board
                System.out.println();
                game.printBoard();
            }
            System.out.println(game.gameOver());
            System.out.println();
            //Set up a new game .. or not depending of user response
            System.out.println("Do you want to play a new game again? Enter 'Y/N'");
            char response = sc.next().charAt(0);
            doYouWantToPlay = (response == 'Y');
            System.out.println();
            System.out.println();

        }
    }
}
