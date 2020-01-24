import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;
import java.util.Arrays;


public class ticTacToe {
	//define global variables
	//define the string arrary board 
	public static String[] playBoard = {"?", "?", "?",
										"?", "?", "?",
										"?", "?", "?"};
	//initialize playing status
	//public static boolean playing = true;
	public static String declareWinner = null;
	public static String human = "O";
	public static String cpu = "X";
	public static String currentPlayer = cpu;
	public static HashMap<String, Integer> hmap = new HashMap<String, Integer>() {{
		put("X", 10);
      	put("O", -10);
      	put("Tie", 0);
	}};

	//calls method to print the board
	public static void printBoard() {
		System.out.println("");
		System.out.println(playBoard[0] + " | " + playBoard[1] + " | " + playBoard[2] + "		1 | 2 | 3");
		System.out.println(playBoard[3] + " | " + playBoard[4] + " | " + playBoard[5] + "		4 | 5 | 6");
		System.out.println(playBoard[6] + " | " + playBoard[7] + " | " + playBoard[8] + "		7 | 8 | 9");
		System.out.println("");
	}

	//checks if the current players turn is logically correct
	public static void HumanPlayer(String player) {
		//loop until player makes valid decision
		boolean checkValid = true;
		while (checkValid) {
			System.out.println("It is " + player + "'s turn to play");
			Scanner pickAreaOnBoard = new Scanner(System.in);
			System.out.println("Choose an open position on the board to play.");
			String playerLocation = pickAreaOnBoard.nextLine();

			//make sure player's moves does not go off board
			if (!playerLocation.equals("1") && !playerLocation.equals("2") && !playerLocation.equals("3") 
				&& !playerLocation.equals("4") && !playerLocation.equals("5") && !playerLocation.equals("6") 
				&& !playerLocation.equals("7") && !playerLocation.equals("8") && !playerLocation.equals("9")) {
				System.out.println("Invalid input");
				printBoard();

			}
			else {
				//substract 1 because board index is difference of 1, exit loop once the position is valid
				int findOnBoard = Integer.parseInt(playerLocation) - 1;
				if (playBoard[findOnBoard].equals("?")) {
					playBoard[findOnBoard] = player;
					printBoard();
					//thereExistWinner();
					int chWin = thereExistWinner();
					checkValid = false;

				}
				else {
					System.out.println("That spot is occupied, please try again");
				}
			}

		}
	}

	//checks to see if any of the players have a win with rows
	public static String winByRows() {
		if (playBoard[0].equals(playBoard[1]) && playBoard[0].equals(playBoard[2]) && !playBoard[0].equals("?")) {
			//playing = false;
			declareWinner = playBoard[0];
			return declareWinner;
			//System.out.println(declareWinner);
		}
		else if(playBoard[3].equals(playBoard[4]) && playBoard[3].equals(playBoard[5]) && !playBoard[3].equals("?")) {
			//playing = false;
			declareWinner = playBoard[3];
			return declareWinner;
			//System.out.println(declareWinner);
		}
		else if(playBoard[6].equals(playBoard[7]) && playBoard[6].equals(playBoard[8]) && !playBoard[6].equals("?")) {
			//playing = false;
			declareWinner = playBoard[6];
			return declareWinner;
			//System.out.println(declareWinner);
		}
		else {
			return null;
		}
	}


	//check to see if any of the players have a win with colums
	public static String winByColums() {
		if (playBoard[0].equals(playBoard[3]) && playBoard[0].equals(playBoard[6]) && !playBoard[0].equals("?")) {
			//playing = false;
			declareWinner = playBoard[0];
			return declareWinner;
			//System.out.println(declareWinner);
		}
		else if(playBoard[1].equals(playBoard[4]) && playBoard[1].equals(playBoard[7]) && !playBoard[1].equals("?")) {
			//playing = false;
			declareWinner = playBoard[1];
			return declareWinner;
			//System.out.println(declareWinner);
		}
		else if(playBoard[2].equals(playBoard[5]) && playBoard[2].equals(playBoard[8]) && !playBoard[2].equals("?")) {
			//playing = false;
			declareWinner = playBoard[2];
			return declareWinner;
			//System.out.println(declareWinner);
		}
		else {
			return null;
		}
	}

	//check to see if any of the players have a diagonal win
	public static String winByDiagonal() {
		if (playBoard[0].equals(playBoard[4]) && playBoard[0].equals(playBoard[8]) && !playBoard[0].equals("?")) {
			//playing = false;
			declareWinner = playBoard[0];
			return declareWinner;
			//System.out.println(declareWinner);
		}
		else if(playBoard[2].equals(playBoard[4]) && playBoard[2].equals(playBoard[6]) && !playBoard[2].equals("?")) {
			//playing = false;
			declareWinner = playBoard[2];
			return declareWinner;
			//System.out.println(declareWinner);
		}
		else {
			return null;
		}

	}

	//check to see if there exist a tie
	public static String CheckForTie() {
		//returns true if all strings in the array are not "?", meaning there are not open slots anymore
		boolean match = Arrays.stream(playBoard).allMatch(s -> !s.equals("?"));
		if (match == true) {
			//playing = false;
			declareWinner = "Tie";
			return declareWinner;
		}
		return null;
	}

	//Switch players turns
	public static void switchPlayer() {
		if (currentPlayer == human) {
			currentPlayer = cpu;
		}
		else {
			currentPlayer = human;
		}
	}

	//check if there is already a winner
	public static int thereExistWinner() {
		String chRow  = winByRows();
		String chCol = winByColums();
		String chDiagonal = winByColums();
		String chTie = CheckForTie();
		if (chRow != null) {
			int grabVal = hmap.get(chRow);
			//playing = false;
			return grabVal;
		}
		if (chCol != null) {
			int grabVal = hmap.get(chCol);
			//playing = false;
			return grabVal;
		}
		if (chDiagonal != null) {
			int grabVal = hmap.get(chDiagonal);
			//playing = false;
			return grabVal;
		}
		if (chTie != null) {
			int grabVal = hmap.get(chTie);
			//playing = false;
			return grabVal;
		}
		return -1;

	}
 
	public static void cpuDecision() {
		int placesToGo = -1;
		Integer bestScore = -1;
		for (int i = 0; i < playBoard.length; i++) {
			if (playBoard[i].equals("?")) {
				playBoard[i] = currentPlayer;
				int score = minimax(playBoard, 0, false);
				playBoard[i] = "?";
				if (score > bestScore) {
					bestScore = score;
					placesToGo = i;
				}
			}
		}
		playBoard[placesToGo] = currentPlayer;
		currentPlayer = human;
		printBoard();
	}

	private static int minimax(String[] board, int depth, boolean isMax) {
		int ch = thereExistWinner();
		if (ch != -1) {
			return ch;
		}
	
		else if (isMax) {
			int bestVal = Integer.MIN_VALUE;
			for (int i = 0; i < board.length; i++) {
				if (board[i].equals("?") && !board[i].equals(currentPlayer)) {
					board[i] = currentPlayer;
					int value = minimax(board, depth+1, false);
					//System.out.println(value);
					board[i] = "?";
					//bestVal = Math.max(value, bestVal);
					if (bestVal < value) {
						bestVal = value;
					}
				}
			}
			return bestVal;
		}
		else {
			int bestVal = Integer.MAX_VALUE;
			for (int i = 0; i < board.length; i++) {
				if (board[i].equals("?")) {
					board[i] = human;
					int value = minimax(board, depth+1, true);
					//System.out.println(value);
					board[i] = "?";
					//bestVal = Math.min(value, bestVal);
					if (bestVal > value) {
						bestVal = value;
					}
					
				}
			}
			return bestVal;
		}
		
	}

	public static void main(String[] args) {
		int isThereWinner = -1;
		Scanner chooseToPlay = new Scanner(System.in);
		System.out.println("Hello! Do you wish to play Tic Tac Toe: yes or no?");
		String receiveInput = chooseToPlay.next();
		if (receiveInput.equals("yes")) {
			//printBoard();
			while(isThereWinner == -1) {
				cpuDecision();
				//switchPlayer();
				HumanPlayer(currentPlayer);
				isThereWinner = thereExistWinner();
				if (isThereWinner == 0) {
					System.out.println("Tie");
				}
				for (Map.Entry<String, Integer> arr : hmap.entrySet()){
					if (isThereWinner == arr.getValue()) {
						System.out.println(arr.getKey() + " Wins!");
					}
				}
				switchPlayer();
			}
		}	
		else {
			System.out.println("Thanks for playing!");
		}
	}
}	
	