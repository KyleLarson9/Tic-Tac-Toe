package ticTacToe;

public class GameBoard {

	public char[][] board;
	
	public GameBoard() {
		
		board = new char[][] {{' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}};
		
	}
	
	public void printBoard() {
		System.out.println("+---+---+---+");
	    for(int i = 0; i < board.length; i++) {
	    	System.out.print("| ");
	        for(int j = 0; j < board[i].length; j++) {
	        	System.out.print(board[i][j] + " | ");
	        }
	        System.out.println("\n+---+---+---+");
	    }
	}
	
	public boolean isValidMove(int position, char symbol) {
		int rowPlacement = (position - 1) / 3;
	    int columnPlacement = (position - 1) % 3;

	    if(board[rowPlacement][columnPlacement] == ' ') {
	    	return true;
	    }
	        return false;
	}

	public void placeMove(int move, char symbol) {
		int rowPlacement = (move - 1) / 3;
	    int columnPlacement = (move - 1) % 3;
	    board[rowPlacement][columnPlacement] = symbol;
	}
	
	public void placeMove2D(int xPos, int yPos, char symbol) {
		board[xPos][yPos] = symbol;
	}
	
	public void resetBoard() {
		for(int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = ' ';
	        }
		}
	}
	
	
	public boolean fullBoard() {
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				if(board[i][j] == ' ' ) {
					return false;
				}
			}
		}
		return true;
	}
}
