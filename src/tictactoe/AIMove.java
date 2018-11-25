package tictactoe;

public class AIMove extends CommandMove {

	private GameTreeNode curr;

	public AIMove(GameBoard board, int pNum, GameTreeNode curr) {
		super(board, pNum);
		this.curr = curr;
	}

	public int decide() {
		int bestChoice = -1;
		double bestWinRate = 0, bestDrawRate = 0;
		System.out.println("Win Rates:");
		for (int i = 0; i < 9; i++) {
			if (curr.child[i] != null) {
				System.out.printf("" + i + ": %.3f ", curr.child[i].winRate);
				if (curr.child[i].winRate > bestWinRate) {
					bestWinRate = curr.child[i].winRate;
					bestChoice = i;
				}
			}
		}
		System.out.println();
		if (bestChoice != -1) {
			return randomizedChoice(0, bestWinRate);
		}
		System.out.println("Draw rates:");
		for (int i = 0; i < 9; i++) {
			if (curr.child[i] != null) {
				System.out.printf("" + i + ": %.3f ", curr.child[i].drawRate);
				if (curr.child[i].drawRate > bestDrawRate) {
					bestDrawRate = curr.child[i].drawRate;
					bestChoice = i;
				}
			}
		}
		System.out.println();
		if (bestChoice != -1) {
			return randomizedChoice(1, bestDrawRate);
		}
		System.out.println("I lose.");
		for (int i = 0; i < 9; i++) {
			if (curr.child[i] != null) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public int move() {
		System.out.println("AI's Turn!");
		int choice = decide();
		if (choice != -1) {
			curr = curr.child[choice];
			board.setMove(choice, pNum);
			System.out.println(board);
		}
		doIWin();
		return choice;
	}

	public void updatePlayerMove(int p) {
		if (curr.child[p] == null) {
			System.out.println("This game does not exist! What happened!");
		} else {
			curr = curr.child[p];
		}
	}

	/**
	 * return a randomized choice for equally good choices
	 * 
	 * @param type 0 = win, 1 = draw
	 */
	public int randomizedChoice(int type, double rate) {
		int x;
		if (type == 0) {
			x = (int) (Math.random() * 9);
			while (true) {
				if (curr.child[x] != null) {
					if (curr.child[x].winRate == rate)
						break;
				}
				x = (int) (Math.random() * 9);
			}
		} else {
			x = (int) (Math.random() * 9);
			while (true) {
				if (curr.child[x] != null) {
					if (curr.child[x].drawRate == rate)
						break;
				}
				x = (int) (Math.random() * 9);
			}
		}
		return x;
	}
}
