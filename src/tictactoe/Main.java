package tictactoe;

import java.io.IOException;
import java.util.Scanner;

public class Main {
	
	Scanner scanner=new Scanner(System.in);
	
	public static void main(String[] arg) throws IOException, ClassNotFoundException {

//		Training t=new Training();
//		t.run();
//		GameTree decision = t.decision;
//
//		decision.printToFile();
		
		GameTree decision = new GameTree();
		decision.readFromFile();

		Main gameMain = new Main();
		gameMain.startGame(decision);

	}

	public void newGame(GameTree decision) {
		GameBoard game = new GameBoard();
		CommandMove player1 = new PlayerMove(game, 1);
		CommandMove player2 = new AIMove(game, 2, decision.root);
		int position;
		int turn = (int) (Math.random() * 2);
//		turn = 1;
		System.out.println("New Game!\nPlayer " + (turn + 1) + " first!");
		System.out.println(game);
		while (!game.isFinished()) {
			if (turn == 0) {
				position = player1.move();
				((AIMove) player2).updatePlayerMove(position);
				turn = 1;
			} else {
				player2.move();
				turn = 0;
			}
		}
	}

	public void startGame(GameTree decision) {
		while(true) {
			newGame(decision);
			scanner.nextLine();
		}
	}
}
