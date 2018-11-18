package tictactoe;

public abstract class CommandMove {
	GameBoard board;
	int pNum;

	public CommandMove(GameBoard board, int pNum) {
		this.board = board;
		this.pNum = pNum;
	}

	public abstract int move();

	public void doIWin() {
		int result = board.getResult();
		if (result > 0 && result < 3) {
			System.out.println("Player " + pNum + " wins!\n\n");
		} else {
			if (result == 3) {
				System.out.println("Draw!\n\n");
			}
		}
	}
}
