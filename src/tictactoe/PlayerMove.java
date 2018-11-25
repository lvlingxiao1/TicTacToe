package tictactoe;

import javafx.scene.input.MouseEvent;

public class PlayerMove extends CommandMove {

	int position;
	
	public PlayerMove(GameBoard board, int pNum) {
		super(board,pNum);
		position = -1;
	}

	@Override
	public int move() {
		board.setMove(position, pNum);
		System.out.print("Player's Turn!\n"+board);
		doIWin();
		return position;
	}
	
	void parseInput(MouseEvent e) {
		int x=(int) (e.getX()/267);
		int y=(int) (e.getY()/267);
		if (x<0 || x>2 || y<0 || y>2 || !board.isAvailable(x,y)) {
			System.out.println("Invalid input.");
		} else {
			position = y*3+x;
			move();
		}
	}

}
