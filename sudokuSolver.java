import java.util.Scanner;

class solution{
    public void printBoard(char[][]board){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.print("\n");
        }
    }

    public boolean isSafe(char[][]board,int row,int col,int number){
        for(int i =0;i<board.length;i++){
            if(board[i][col]== (char)number+'0'){
                return false;
            }
            if(board[row][i]== (char)number+'0'){
                return false;
            }
        }

        // To Check in the 3x3 Grid
        int sr = (row/3)*3;
        int sc = (col/3)*3;
        for(int i = sr;i<sr+3;i++){
            for (int j = sc; j < sc+3; j++) {
                if(board[i][j]== (char)number+'0'){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isSolved(char[][] board,int row,int col){
        if(row == board.length){
            printBoard(board);
            return true;
        }
        
        int nrow = 0,ncol=0;
        if(col!=board.length-1){
            nrow = row;
            ncol = col +1;
        }else{
            nrow = row+1;
            col= 0;
        }

        if(board[row][col]!='.'){
            if(isSolved(board, nrow, ncol)){
                return true;
            }
        }else{
                for(int i = 1;i<=9;i++){
                    if(isSafe(board,row,col,i)){
                        board[row][col] = (char)(i+'0');
                       if (isSolved(board, nrow, ncol)){
                        return true;
                       }else{
                        board[row][col]='.';
                       }
                    }
                }
            }
            return false;
        }
       

    public void solveSuduko(char[][] board){
        isSolved(board, 0, 0);
    }
}


public class sudokuSolver {
   public static void main(String[] args) {
    char[][] myBoard= new char[9][9];

    System.out.println("Hello Friend");
    System.out.println("Enter your sudoku and we will solve it");
    System.out.println("..........................................");
    System.out.println("Enter your numbers in rows and enter . for space left");

    Scanner sc = new Scanner(System.in);

    for (int i = 0; i < myBoard.length; i++) {
        for (int j = 0; j < myBoard.length; j++) {
            myBoard[i][j] = sc.next().charAt(0);
        }
    }
    
    solution vc = new solution();
    vc.solveSuduko(myBoard);

   }
}