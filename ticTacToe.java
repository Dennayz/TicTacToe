import java.util.Scanner;
import java.util.Arrays;

public class ticTacToe {
	//define global variables
	//define the string arrary board 
	public static String[] playBoard = {"?", "?", "?",
										"?", "?", "?",
										"?", "?", "?"};
	//initialize playing status
	public static boolean playing = true;
	public static String declareWinner = "";
	public static String currentPlayer = "X";
	
	//calls method to print the board
	public static void printBoard() {
		System.out.println("");
		System.out.println(playBoard[0] + " | " + playBoard[1] + " | " + playBoard[2] + "		1 | 2 | 3");
		System.out.println(playBoard[3] + " | " + playBoard[4] + " | " + playBoard[5] + "		4 | 5 | 6");
		System.out.println(playBoard[6] + " | " + playBoard[7] + " | " + playBoard[8] + "		7 | 8 | 9");
		System.out.println("");
	}

	//checks if the current players turn is logically correct
	public static void validPlay(String player) {
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
					checkValid = false;
				}
				else {
					System.out.println("That spot is occupied, please try again");
				}
			}

		}
	}

	//checks to see if any of the players have a win with rows
	public static void winByRows() {
		if (playBoard[0].equals(playBoard[1]) && playBoard[0].equals(playBoard[2]) && !playBoard[0].equals("?")) {
			playing = false;
			declareWinner = playBoard[0];
			//System.out.println(declareWinner);
		}
		else if(playBoard[3].equals(playBoard[4]) && playBoard[3].equals(playBoard[5]) && !playBoard[3].equals("?")) {
			playing = false;
			declareWinner = playBoard[3];
			//System.out.println(declareWinner);
		}
		else if(playBoard[6].equals(playBoard[7]) && playBoard[6].equals(playBoard[8]) && !playBoard[6].equals("?")) {
			playing = false;
			declareWinner = playBoard[6];
			//System.out.println(declareWinner);
		}

	}

	//check to see if any of the players have a win with colums
	public static void winByColums() {
		if (playBoard[0].equals(playBoard[3]) && playBoard[0].equals(playBoard[6]) && !playBoard[0].equals("?")) {
			playing = false;
			declareWinner = playBoard[0];
			//System.out.println(declareWinner);
		}
		else if(playBoard[1].equals(playBoard[4]) && playBoard[1].equals(playBoard[7]) && !playBoard[1].equals("?")) {
			playing = false;
			declareWinner = playBoard[1];
			//System.out.println(declareWinner);
		}
		else if(playBoard[2].equals(playBoard[5]) && playBoard[2].equals(playBoard[8]) && !playBoard[2].equals("?")) {
			playing = false;
			declareWinner = playBoard[2];
			//System.out.println(declareWinner);
		}
	}

	//check to see if any of the players have a diagonal win
	public static void winByDiagonal() {
		if (playBoard[0].equals(playBoard[4]) && playBoard[0].equals(playBoard[8]) && !playBoard[0].equals("?")) {
			playing = false;
			declareWinner = playBoard[0];
			//System.out.println(declareWinner);
		}
		else if(playBoard[2].equals(playBoard[4]) && playBoard[2].equals(playBoard[6]) && !playBoard[2].equals("?")) {
			playing = false;
			declareWinner = playBoard[2];
			//System.out.println(declareWinner);
		}

	}

	//check to see if there exist a tie
	public static void CheckForTie() {
		//returns true if all strings in the array are not "?", meaning there are not open slots anymore
		boolean match = Arrays.stream(playBoard).allMatch(s -> !s.equals("?"));
		if (match == true) {
			playing = false;
			System.out.println("Tie");
		}
	}

	//Switch players turns
	public static void switchPlayer() {
		if (currentPlayer.equals("X")) {
			currentPlayer = "O";
		}
		else {
			currentPlayer = "X";
		}	
	}

	//check if there is already a winner
	public static void thereExistWinner() {
		winByRows();
		winByColums();
		winByDiagonal();

	}

		
	public static void main(String[] args) {
		Scanner chooseToPlay = new Scanner(System.in);
		System.out.println("Hello! Do you wish to play Tic Tac Toe: yes or no?");
		String receiveInput = chooseToPlay.next();
		if (receiveInput.equals("yes")) {
			printBoard();
			while (playing) {
				validPlay(currentPlayer);
				thereExistWinner();
				CheckForTie();
				switchPlayer();
				if (declareWinner.equals("X") || declareWinner.equals("O")) {
					System.out.println(declareWinner + " wins!");
				}
			}
		}	
		else {
			System.out.println("Thanks for playing!");
		}
	}
}	
	