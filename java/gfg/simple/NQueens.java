package gfg.simple;

import java.util.Arrays;

public class NQueens {

    int[][] board;

    public NQueens(int size){
        this.board = createBoard(size);
    }

    public int[][] createBoard(int size){
        return new int[size][size];
    }

    public  boolean solve(int col){

        if (col >= board.length)
            return true;

        for(int i = 0; i < board.length; i++){
            if(isValidPosition(i,col)) {
                this.board[i][col] = 1;
                if (solve(col + 1))
                    return true;
                this.board[i][col] = 0;
            }
        }

        return false;
    }

    public boolean isValidPosition(int row, int col){

        //check row
        for(int i = 0; i < col ; i++)
            if (board[row][i] != 0)
                return false;


        //check diagonal upper
        int i = row-1;
        int j = col-1;

        while(i >= 0   && j >= 0){
            if(board[i][j] != 0)
                return false;

            i--;
            j--;
        }

        i = row+1;
        j = col-1;
        //check diagonal lower
        while(i < board.length && j >= 0){
            if(board[i][j] != 0)
                return false;

            i++;
            j--;
        }


        return true;
    }

    public void printBoard(){
        for(int[] row : this.board){
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args){
        int size = 9;
        NQueens play = new NQueens(size);
        play.solve(0);
        play.printBoard();

    }
}
