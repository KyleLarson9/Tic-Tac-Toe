package ticTacToe;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

	// make game look more appealing, center it, *******************
	// randomize who goes first
    private Scanner scan = new Scanner(System.in);
    private Random rand = new Random();

    private boolean gameOver;
    private char playerSymbol = 'X';
    private char computerSymbol = 'O';

    private ScoringSystem score;
    private GameBoard gameBoard;
    public TicTacToe() {
        score = new ScoringSystem();
        gameBoard = new GameBoard();
        
        gameLoop();
    }
    
    private void gameLoop() {
        while (!gameOver) {
            //gameBoard.printBoard();
            gameOver = false;
            while (!gameOver) {
            	
            	computerTurn();
                gameBoard.printBoard();
                if (checkWinner(computerSymbol)) {
                    System.out.println("Computer wins!");
                    score.yScoreCount++;
                    score.updateyScore();
                    break;
                }
                playerTurn();
                gameBoard.printBoard();
                if (checkWinner(playerSymbol)) {
                    System.out.println("Player wins!");
                    score.xScoreCount++;
                    score.updatexScore();
                    break;
                }
             
              
            }
            menu();
        }
    }
    
    private void playerTurn() {
        int userInput;
        while (true) {
            System.out.println("Enter position: ");
            userInput = scan.nextInt();
            if (gameBoard.isValidMove(userInput, playerSymbol)) {
                break;
            } else {
                System.out.println(userInput + " is not a valid move.");
            }
        }
        gameBoard.placeMove(userInput, playerSymbol);
    }

    private void computerTurn() {
        int computerMove = 0;
        

        if(checkFor2(computerSymbol, computerSymbol)) { // check if computer can win
        	return;
        } else if(checkFor2(computerSymbol, playerSymbol)) { // check if computer can block
        	return;
        }
        do {
        	computerMove = rand.nextInt(9) + 1;
        } while (!gameBoard.isValidMove(computerMove, computerSymbol));	
        
        
        System.out.println("Computer chose " + computerMove);
        gameBoard.placeMove(computerMove, computerSymbol);
    }

    private boolean checkFor2(char currentSymbol, char checkingSymbol) {
    	
    	 // check rows
        for(int i = 0; i < gameBoard.board.length; i++) {
        	int count = 0;
        	int emptyPos = -1;
        	for(int j = 0; j < gameBoard.board[i].length; j++) {
        		if(gameBoard.board[i][j] == checkingSymbol) 
        			count++;
        		if(gameBoard.board[i][j] == ' ') 
        			emptyPos = j;
        	}        	
        	if(count == 2 && emptyPos != -1) {
        		gameBoard.placeMove2D(i, emptyPos, currentSymbol);
        		return true;
        	}
        }
        
        for(int j = 0; j < gameBoard.board[0].length; j++) {
        	int count = 0;
        	int emptyPos = -1;
        	for(int i = 0; i < gameBoard.board.length; i++) {
        		if(gameBoard.board[i][j] == checkingSymbol) 
        			count++;
        		if(gameBoard.board[i][j] == ' ')
        			emptyPos = i;
        		
        	}     	
        	if(count == 2 && emptyPos != -1) {
        		gameBoard.placeMove2D(emptyPos, j, currentSymbol);
        		return true;
        	}
        }
        
        return false;
    }

    private boolean checkWinner(char symbol) {
        // Check rows
        for (int row = 0; row < gameBoard.board.length; row++) {
            int count = 0;
            for (int col = 0; col < gameBoard.board[row].length; col++) {
                if (gameBoard.board[row][col] == symbol) {
                    count++;
                }
            }
            if (count == 3) {
                return true;
            }
        }

        // Check columns
        for (int col = 0; col < gameBoard.board[0].length; col++) {
            int count = 0;
            for (int row = 0; row < gameBoard.board.length; row++) {
                if (gameBoard.board[row][col] == symbol) {
                    count++;
                }
            }
            if (count == 3) {
                return true;
            }
        }

        // Check diagonals
        if (gameBoard.board[0][0] == symbol && gameBoard.board[1][1] == symbol && gameBoard.board[2][2] == symbol) {
            return true;
        }
        if (gameBoard.board[0][2] == symbol && gameBoard.board[1][1] == symbol && gameBoard.board[2][0] == symbol) {
            return true;
        }

        return false; // No winner found
    }
    
    private void menu() {
    	
		String choice = "";
    	
    	do {
        	System.out.println("1. Press y to play again" + 
        					   "\n2. View scores");
        	choice = scan.next();
    		switch(choice) {
	        	case "1":	
	        		gameBoard.resetBoard();
	                return;
	        	case "2":
	                score.printScores();
	                break;
    		}
    	} while(choice != "1");
    	
    }
   
}

