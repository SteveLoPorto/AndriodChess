package com.example.movies;

import java.util.Objects;
import java.util.Scanner;

/**
 * Board Class
 * 
 *Steven LoPorto
 *
 */

public class Board {

	static Piece[][] board = new Piece[8][8];
	static String turn = "White's";
	static Pawn last2MovePawn;
	static Boolean draw = false;
	static Boolean moveSinceDraw = true;
	static String winner = null;
	private Piece[][] lastBoard = new Piece[8][8];

	/**
	 * Initializes the board with all standard chess pieces
	 * 
	 * 
	 */
	
	
	static void initalize() {

		// white pieces

		King bK = new King("bK", "black", 0, 4);
		board[0][4] = bK;
		King wK = new King("wK", "white", 7, 4);
		board[7][4] = wK;

		Pawn wP1 = new Pawn("wp", "white", 6, 0);
		board[6][0] = wP1;
		Pawn wP2 = new Pawn("wp", "white", 6, 1);
		board[6][1] = wP2;
		Pawn wP3 = new Pawn("wp", "white", 6, 2);
		board[6][2] = wP3;
		Pawn wP4 = new Pawn("wp", "white", 6, 3);
		board[6][3] = wP4;
		Pawn wP5 = new Pawn("wp", "white", 6, 4);
		board[6][4] = wP5;
		Pawn wP6 = new Pawn("wp", "white", 6, 5);
		board[6][5] = wP6;
		Pawn wP7 = new Pawn("wp", "white", 6, 6);
		board[6][6] = wP7;
		Pawn wP8 = new Pawn("wp", "white", 6, 7);
		board[6][7] = wP8;

		Rook wR1 = new Rook("wR", "white", 7, 0);
		board[7][0] = wR1;
		Rook wR2 = new Rook("wR", "white", 7, 7);
		board[7][7] = wR2;

		Knight wN1 = new Knight("wN", "white", 7, 1);
		board[7][1] = wN1;
		Knight wN2 = new Knight("wN", "white", 7, 6);
		board[7][6] = wN2;

		Bishop wB1 = new Bishop("wB", "white", 7, 2);
		board[7][2] = wB1;
		Bishop wB2 = new Bishop("wB", "white", 7, 5);
		board[7][5] = wB2;

		Queen wQ = new Queen("wQ", "white", 7, 3);
		board[7][3] = wQ;

		Pawn bP1 = new Pawn("bp", "black", 1, 0);
		board[1][0] = bP1;

		Pawn bP2 = new Pawn("bp", "black", 1, 1);
		board[1][1] = bP2;
		Pawn bP3 = new Pawn("bp", "black", 1, 2);
		board[1][2] = bP3;
		Pawn bP4 = new Pawn("bp", "black", 1, 3);
		board[1][3] = bP4;
		Pawn bP5 = new Pawn("bp", "black", 1, 4);
		board[1][4] = bP5;
		Pawn bP6 = new Pawn("bp", "black", 1, 5);
		board[1][5] = bP6;
		Pawn bP7 = new Pawn("bp", "black", 1, 6);
		board[1][6] = bP7;
		Pawn bP8 = new Pawn("bp", "black", 1, 7);
		board[1][7] = bP8;

		Rook bR1 = new Rook("bR", "black", 0, 0);
		board[0][0] = bR1;
		Rook bR2 = new Rook("bR", "black", 0, 7);
		board[0][7] = bR2;

		Knight bN1 = new Knight("bN", "black", 0, 1);
		board[0][1] = bN1;
		Knight bN2 = new Knight("bN", "black", 0, 6);
		board[0][6] = bN2;

		Bishop bB1 = new Bishop("bB", "black", 0, 2);
		board[0][2] = bB1;
		Bishop bB2 = new Bishop("bB", "black", 0, 5);
		board[0][5] = bB2;

		Queen bQ = new Queen("bQ", "black", 0, 3);
		board[0][3] = bQ;

	}

	/**
	 * prints the board with it current pieces
	 */
	public void printBoard() {
		int rightBar = 8;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (board[i][j] == null) {
					if ((i % 2 == 0 && j % 2 == 1) || (i % 2 == 1 && j % 2 == 0)) {
						System.out.print("## ");
					} else {
						System.out.print("   ");
					}
				} else {
					System.out.print(board[i][j] + " ");
				}

				if (i == 7 && j == 7) {
					System.out.print(rightBar);
					System.out.println();
					System.out.println(" a  b  c  d  e  f  g  h");
					System.out.println();

				} else if (j == 7) {
					System.out.print(rightBar);
					System.out.println();
					rightBar--;

				}
			}
		}
	}

	// Asks the user for its next move
	/**
	 * Asks the user for its next move
	 * 
	 * @return A string representation of the move inputed
	 */
	public String promptMove() {

		@SuppressWarnings("resource") // closing Scanner was giving me errors for some reason so I'm suppressing the
										// warning
		Scanner myObj = new Scanner(System.in);
		System.out.print(turn + " move: ");
		String move = myObj.nextLine();
		System.out.println();
		return move;

	}

	/**
	 * the method that executes the next move
	 */
	public void execute() {
		printBoard();
		String move = promptMove();
		parse(move);

	}

	/**
	 * reads the move and changes the board accordingly
	 * 
	 * @param move a String input of FileRank FileRank - example: e2 e3
	 */
	public String parse(String move) {
		String state = null;

		if (move.equals("draw")) {
			if(!draw) {
				System.out.println("Illegal move, try again");
				System.out.println();
				//execute();
			}
			
			System.out.println("draw");
			//System.exit(0);
		} else if (move.equals("resign")) {
			// Terminate and diplay who wins
			changeTurn();
			winner = turn.substring(0, 5);
			System.out.print(turn.substring(0, 5) + " wins");
			//System.exit(0);
		}
		else if (move.equals("undo")){
			changeTurn();
			for(int x=0; x<8; x++){
				for(int y=0; y<8; y++){
					board[x][y] = lastBoard[x][y];
				}
			}
		}
		else {
			for(int x=0; x<8; x++){
				for(int y=0; y<8; y++){
					lastBoard[x][y] = board[x][y];
				}
			}
			String currentLocation = move.substring(0, 2);
			String destinationLocation = move.substring(3, 5);
			if (move.length() == 11) {
				// Draw requested
				draw = true;
				moveSinceDraw = false;
				System.out.println();

			}

			int currentI = rowToArrayIndex(currentLocation.charAt(1));
			int currentJ = charToInt(currentLocation.charAt(0));

			int destinationI = rowToArrayIndex(destinationLocation.charAt(1));
			int destinationJ = charToInt(destinationLocation.charAt(0));

			Piece currentPiece = board[currentI][currentJ];
			// If it is a pawn to the end of the board

			if (currentPiece == null) {
				return "failed";
				//System.out.println("Illegal move, try again");
				//System.out.println();
				//execute();
			}
			if (Objects.equals(currentPiece.color, "white") && !Objects.equals(turn, "White's")) {
				return "failed";
				/*System.out.println("Illegal move, try again");
				System.out.println();
				execute();*/
			}
			if (Objects.equals(currentPiece.color, "black") && !Objects.equals(turn, "Black's")) {
				return "failed";
				/*System.out.println("Illegal move, try again");
				System.out.println();
				execute();*/
			}

			if (move.length() == 7 || (Objects.equals(currentPiece.identifier, "wp") && destinationI == 0)
					|| (Objects.equals(currentPiece.identifier, "bp") && destinationI == 7)) {
				
				if((Objects.equals(currentPiece.identifier, "wp") && destinationI != 0)
						|| (Objects.equals(currentPiece.identifier, "bp") && destinationI != 7)) {
					return "failed";
					/*System.out.println("Illegal move, try again");
					System.out.println();
					execute();*/
				}

				String uprgradePiece;

				if (move.length() == 7) {
					uprgradePiece = move.substring(6);
				} else {
					uprgradePiece = "Q";
				}

				if (currentPiece.isValid(destinationI, destinationJ, currentPiece)) {
					
					// currentPiece.updateLocation(destinationI, destinationJ);

					try{
						((Pawn) currentPiece).upgradePawn(uprgradePiece);
					}catch(Exception e) {
						return "failed";
						/*System.out.println("Illegal move, try again");
						System.out.println();
						execute();*/
		
					}

					currentPiece.move(destinationI, destinationJ, currentPiece);
					changeTurn();
					return "success";
					//execute();

				} else {
					return "failed";
					/*System.out.println("Illegal move, try again");
					System.out.println();
					execute();
					 */
				}
			} else {
				if (currentPiece.isValid(destinationI, destinationJ, currentPiece)) {
					if (Objects.equals(currentPiece.identifier, "wP") && destinationI == 0) {

					} else if (Objects.equals(currentPiece.identifier, "bP") && destinationI == 7) {

					} else {
						currentPiece.move(destinationI, destinationJ, currentPiece);
					}
					if (Objects.equals(turn, "White's")) {
						if (isCheck("white")) {
							currentPiece.move(currentI, currentJ, currentPiece);
							return "failed";
							/*
							System.out.println("Illegal move, try again");
							System.out.println();
							execute();

							 */
						}
						if (isCheck("black")) {
							if (checkMate("black")) {
								winner="White";
								return "checkMate";
								/*printBoard();
								System.out.println("Checkmate\nWhite Wins");
								System.exit(0);*/
							}

							state = "check";
							/*System.out.println("Check");
							System.out.println();*/
						}

					} else if (Objects.equals(turn, "Black's")) {
						if (isCheck("black")) {
							currentPiece.move(currentI, currentJ, currentPiece);
							return "failed";
							/*System.out.println("Illegal move, try again");
							System.out.println();
							execute();*/
						}
						if (isCheck("white")) {
							if (checkMate("white")) {
								winner="Black";
								return "checkMate";
								/*printBoard();
								System.out.println("Checkmate\nBlack Wins");
								System.exit(0);*/
							}
							state = "check";
							/*System.out.println("Check");
							System.out.println();*/
						}
					}
					if(currentPiece instanceof Pawn) {
						((Pawn)currentPiece).moveCounter = ((Pawn)currentPiece).moveCounter + 1;
						//System.out.println("Move counter in board: " + ((Pawn)currentPiece).moveCounter );
						//System.out.println("pawn moves 1");
						if(Math.abs(destinationI - currentI) == 2) {
							//System.out.println("pawn moves 2");
						((Pawn)currentPiece).moveCounter = ((Pawn)currentPiece).moveCounter + 1;
						//System.out.println("Move counter in board: " + ((Pawn)currentPiece).moveCounter );
						((Pawn)currentPiece).isEmpassantable = true;
						last2MovePawn = ((Pawn)currentPiece);
						if(draw && moveSinceDraw) {
						//	System.out.println("update draw");
							draw = false;
						}


						moveSinceDraw = true;
						changeTurn();
						if(state != null){
							return state;
						}else {
							return "success";
						}
						//execute();
						}
					}
					
					if(last2MovePawn!= null) {
				//	System.out.println("update empassant");
					last2MovePawn.isEmpassantable = false;
					last2MovePawn = null;
					}
					
					if(draw && moveSinceDraw) {
				//		System.out.println("update draw");
						draw = false;
					}
					
					moveSinceDraw = true;
					changeTurn();
					if(state != null){
						return state;
					}else {
						return "success";
					}
					//execute();
				} else {
					return "failed";
					/*System.out.println("Illegal move, try again");
					System.out.println();
					execute();*/
				}
			}
		}
		return "failed";
	}

	// Identifies if a given color is in check
	/**
	 * @param color either white or black, the color that we want to see if it is in
	 *              check
	 * @return a boolean true if it is in check
	 */
	public static boolean isCheck(String color) {
		for (int a = 0; a < 8; a++) {
			for (int b = 0; b < 8; b++) {
				for (int c = 0; c < 8; c++) {
					for (int d = 0; d < 8; d++) {
						if (board[a][b] instanceof King && ((Math.abs(a - c) > 1 || Math.abs(b - d) > 1))) {

						} else if (board[a][b] != null && board[a][b].isValid(c, d, board[a][b])
								&& board[c][d] instanceof King && board[c][d].color.equals(color)
								&& !board[a][b].color.equals(color)) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}



	/**
	 * @param color either white or black, the color that we want to see if it is in
	 *              checkmate
	 * @return a boolean true if it is in checkmate
	 */
	public boolean checkMate(String color) {
		for (int a = 0; a < 8; a++) {
			for (int b = 0; b < 8; b++) {
				for (int c = 0; c < 8; c++) {
					for (int d = 0; d < 8; d++) {
						boolean outOfMate = false;
						if (board[a][b] != null && board[a][b].isValid(c, d, board[a][b])
								&& board[a][b].color.equals(color)) {
							Piece p = board[c][d];
							board[a][b].move(c, d, board[a][b]);

							if (!isCheck(color))
								outOfMate = true;

							board[c][d].move(a, b, board[c][d]);
							board[c][d] = p;
						}
						if (outOfMate) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}

	/**
	 * 
	 */
	public static void changeTurn() {
		if (turn.equals("White's")) {
			turn = "Black's";
		} else {
			turn = "White's";
		}
	}

	/**
	 * @param x a character that we need to convert to its integer representation on the chess board
	 * @return the integer representation
	 */
	public int charToInt(char x) {

		int z = 0;

		switch (x) {

		case 'a':
			break;

		case 'b':
			z = 1;
			break;

		case 'c':
			z = 2;
			break;

		case 'd':
			z = 3;
			break;

		case 'e':
			z = 4;
			break;

		case 'f':
			z = 5;
			break;

		case 'g':
			z = 6;
			break;

		case 'h':
			z = 7;
			break;

		}

		return z;

	}

	public char intToChar(int x) {

		switch (x) {

			case 0:
				return 'a';

			case 1:
				return 'b';

			case 2:
				return 'c';


			case 3:
				return 'd';


			case 4:
				return 'e';


			case 5:
				return 'f';


			case 6:
				return 'g';


			case 7:
				return 'h';


		}


		return 'a';
	}

	/**
	 * @param x a row number that needs to be converted to its corresponding board row
	 * @return the board row
	 */
	public int rowToArrayIndex(char x) {

		int z = 0;

		switch (x) {

		case '8':
			break;

		case '7':
			z = 1;
			break;

		case '6':
			z = 2;
			break;

		case '5':
			z = 3;
			break;

		case '4':
			z = 4;
			break;

		case '3':
			z = 5;
			break;

		case '2':
			z = 6;
			break;

		case '1':
			z = 7;
			break;

		}

		return z;

	}

}
