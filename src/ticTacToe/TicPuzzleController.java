package ticTacToe;

public class TicPuzzleController {
	
	public static void main(String[] arg) {	
		TicPuzzleController tpc = new TicPuzzleController();
		tpc.startGame();
	}
	
	public void newGame() {
		TicPuzzle ticPuzzle = new TicPuzzle();
		System.out.println(ticPuzzle);
		CommandMove player1 = new PlayerMove(ticPuzzle, 1);
		CommandMove player2 = new PlayerMove(ticPuzzle, 2);
		boolean notFinneshed = true;
		while (notFinneshed) {
			if (player1.move() == 1){
				notFinneshed = false;
				player1.isWin();
			}else if(player2.move() == 2){
				notFinneshed = false;
				player2.isWin();
			}
		}
	}
	
	public void startGame() {
		while(true) {
			newGame();
		}
	}
}
