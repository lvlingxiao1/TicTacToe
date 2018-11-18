package tictactoe;

import java.util.ArrayList;

public class GameBoard {
	private Unit[][] board = new Unit[3][3];
	private boolean finished;

	public GameBoard() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = new Unit();
			}
		}
		finished = false;
	}

	/**
	 * 0=not finished 1=p1 wins 2=p2 wins 3=draw
	 * 
	 * @return
	 */
	public int getResult() {
		if (((board[0][0].state == board[1][1].state && board[1][1].state == board[2][2].state)
				|| (board[2][0].state == board[1][1].state && board[1][1].state == board[0][2].state))
				&& board[1][1].state != 0) {
			finished = true;
			return board[1][1].state;
		} else {
			for (int i = 0; i < 3; i++) {
				if ((board[i][0].state == board[i][1].state && board[i][1].state == board[i][2].state && board[i][0].state != 0)) {
					finished = true;
					return board[i][0].state;
				}
				if ((board[0][i].state == board[1][i].state && board[1][i].state == board[2][i].state && board[0][i].state != 0)) {
					finished = true;
					return board[0][i].state;
				}
			}
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j].state == 0) {
					return 0;
				}
			}
		}
		finished = true;
		return 3;
	}

	/**
	 * Use this in the training phase.
	 * 
	 * @param x
	 * @param player
	 */
	public void setMove(int x, int player) {
		if (board[x % 3][x / 3].state == 0) {
			// System.out.println("setMove"+ x%3 +" "+ x/3);
			board[x % 3][x / 3].state = player;
		} else {
			System.out.println("Error: Placing chess in an occupied position. Check your math!");
			System.exit(0);
		}
	}

	/**
	 * Use this in the training phase.
	 * 
	 * @param x
	 */
	public void revertMove(int x) {
		board[x % 3][x / 3].state = 0;
	}

	public ArrayList<Integer> getPossibleMoves() {
		ArrayList<Integer> a = new ArrayList<Integer>();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j].getState() == 0) {
					a.add(i + j * 3);
				}
			}
		}
		// System.out.println(this);
		return a;
	}
	
	public boolean isAvailable(int x, int y) {
		return (board[x][y].state == 0);
	}

	public String toString() {
		String stringForm = "";
		for (int j = 0; j < 3; j++) {
			for (int i = 0; i < 3; i++) {
				stringForm += " ";
				stringForm += board[i][j] + " ";
				if (i < 2) {
					stringForm += "|";
				}
			}
			if (j < 2) {
				stringForm += "\n---+---+---";
			}
			stringForm += "\n";
		}
		return stringForm;
	}

	public boolean isFinished() {
		return finished;
	}
}
