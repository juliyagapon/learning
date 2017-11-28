public class TicTacToe {
    protected char[] board;
    protected char userMarker;
    protected char aiMarker;
    protected char winer;
    protected char currentMarker;

    public TicTacToe(char playerToken, char aiMarker) {
        this.userMarker = playerToken;
        this.aiMarker = aiMarker;
        this.winer = '-';
        this.board = setBoard();
        this.currentMarker = userMarker;
    }

    private static char[] setBoard() {
        char [] board = new char[9];
        for (int i = 0; i < board.length; i++){
            board[i] = '-';
        }
        return board;
    }

    public boolean playTurn(int spot){
        boolean isValid = withinRange(spot) && !isSpotTaken(spot);
        if (isValid){
            board[spot-1] = currentMarker;
            currentMarker = (currentMarker == userMarker) ? aiMarker : userMarker;
        }
        return isValid;
    }

    //check if our spot is in range
    public boolean withinRange(int spot) {
        return spot > 0 && spot < board.length + 1;
    }

    //check if the spot is taken
    public boolean isSpotTaken(int spot) {
        return board[spot-1] != '-';
    }

    public void printBoard(){
        //|-|-|-
        //-----
        //|-|-|-
        //-----
        //|-|-|-
        System.out.println();
        for (int i = 0; i < board.length; i++){
            if (i % 3 == 0 && i != 0){
                System.out.println();
                System.out.println("-------------");
            }
            System.out.print(" | " + board[i]);
        }
        System.out.println();
    }

    public static void printIndexBoard(){
        System.out.println();
        for (int i = 0; i < 9; i++){
            if (i % 3 == 0 && i != 0){
                System.out.println();
                System.out.println("-------------");
            }
            System.out.print(" | " + (i + 1));
        }
        System.out.println();
    }
    
    public boolean isThereAWinner(){
        boolean diagonalsAndMiddels = (rightDi() || leftDi() || middeleRow() || seconCol()) && board[4] != '-';
        boolean topAndFirst = (topRow() || firstCol()) && board[0] != '-';
        boolean bottomAndFirst = (bottomRow() || thirdCol()) && board[8] != '-';
        if (diagonalsAndMiddels){
            System.out.println("di");
            this.winer = board[4];
        }
        else if (topAndFirst){
            System.out.println("m");
            this.winer = board[0];
        }
        else if (bottomAndFirst){
            System.out.println("l");
            this.winer = board[4];
        }
        return diagonalsAndMiddels || topAndFirst || bottomAndFirst;
    }

    public boolean rightDi() {
        return board[0] == board[4] && board[4] == board[8];
    }

    public boolean leftDi() {
        return board[2] == board[4] && board[4] == board[6];
    }

    public boolean seconCol() {
        return board[1] == board[4] && board[4] == board[7];
    }

    public boolean thirdCol() {
        return board[2] == board[5] && board[5] == board[8];
    }

    public boolean topRow(){
        return board[0] == board[1] && board[1] == board[2];
    }

    public boolean middeleRow(){
        return board[3] == board[4] && board[4] == board[5];
    }

    public boolean bottomRow(){
        return board[6] == board[7] && board[7] == board[8];
    }

    public boolean firstCol(){
        return board[0] == board[3] && board[3] == board[6];
    }

    public boolean isBoardFilled(){
        for (int i = 0; i < board.length; i++) {
            if (board[i] == '-'){
                return false;
            }
        }
        return true;
    }

    public String gameOver(){
        boolean didSomeoneWin = isThereAWinner();
        if (didSomeoneWin){
            return "We have a winner " + this.winer + "'s";
        }else if (isBoardFilled()){
            return "Draw: Game over!";
        }else {
            return "notOver";
        }
    }

 }

