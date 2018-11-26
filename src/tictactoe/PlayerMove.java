package tictactoe;

import javafx.scene.input.MouseEvent;

public class PlayerMove {

	private GameBoard board;
	private GameModel model;
	int pNum, position;

	public PlayerMove(GameBoard board, GameModel model, int pNum) {
		this.board = board;
		this.pNum = pNum;
		this.model = model;
	}

	void move() {
		board.setMove(position, pNum);
		System.out.print("Player's Turn!\n" + board);
		model.updatePlayerMove();
	}

	void parseInput(MouseEvent e) {
		int x = (int) (e.getX() / 267);
		int y = (int) (e.getY() / 267);
		if (x < 0 || x > 2 || y < 0 || y > 2 || !board.isAvailable(x, y)) {
			System.out.println("Invalid input.");
		} else {
			position = y * 3 + x;
			move();
		}
	}

}
