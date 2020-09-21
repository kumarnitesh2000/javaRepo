import java.util.*;
import java.io.*;


public class Backtracking_N_Queens
{
	public static void main(String[] args) {
	
	Scanner sc = new Scanner(System.in);
	System.out.print("Enter N - ");
	int n = sc.nextInt();
	int[][] board = new int[n][n];
	for(int i=0;i<n;i++){
	    for(int j=0;j<n;j++)
	    board[i][j] = 0;
	    }
	
	//row - Restriction placements
	//NQueensProbRowsRestriction(board,"",0);
	//queen all resrictions
	NQueensProb(board,"",0);
	    
	}
	//this is the function in which no 2 queens are in same row
	//all posibilities
	public static void NQueensProbRowsRestriction(int[][] board,String qsf,int row){
	    
		if(row==board.length) {
			System.out.println(qsf);
			return;
		}
		//options of all the column
		for(int i=0;i<board[0].length;i++) {
			board[row][1] = 1;
			NQueensProbRowsRestriction(board,qsf+row+"-"+i+",",row+1);
			board[row][1] = 0;
			
			
		}
		
		
	}
	//main question with all restrictions 
	public static void NQueensProb(int[][] board,String qsf,int row){
		if(row==board.length) {
			System.out.println(qsf);
			return;
		}
		//options of all the column
		for(int i=0;i<board[0].length;i++) {
			if(isSafePlace(board,row,i)) {
			board[row][i] = 1;
			NQueensProb(board,qsf+row+"-"+i+",",row+1);
			board[row][i] = 0;
			}
		}
		
		
	}
	//check for the safe place
	public static boolean isSafePlace(int[][] board,int row,int col) {
		//check in the current column
		for(int i=row-1;i>=0;i--) {
			if(board[i][col]==1)
				return false;
		}
		//for right side diagonal
		for(int i=row-1,j=col+1; i>=0 && j < board[0].length ;i--,j++) {
			if(board[i][j]==1)
				return false;
		}
		//for the left side diagonal
		for(int i=row-1,j=col-1; i>=0 && j >=0 ;i--,j--) {
			if(board[i][j]==1)
				return false;
		}
		
		return true;
	}
	
	public static void printBoard(int[][] board){
		System.out.println("\nChess Board Display\n");
		
	    for(int i=0;i<board.length;i++){
	        for(int j=0;j<board[0].length;j++){
	            if(board[i][j]==0)
	            System.out.print("\t-");
	            else
	            System.out.print("\t$");
	            
	        }
	    System.out.println();    
	        
	    }
	    
	}
	
}
