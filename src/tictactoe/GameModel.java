package tictactoe;

import java.io.IOException;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class GameModel implements EventHandler<MouseEvent> {

	private GameTree decision;
	private GameGUI gui;
	private PlayerMove player1;
	private AIMove player2;
	private GameBoard game;
	private int phase;

	private static final int PLAYERTURN = 0, AITURN = 1, FINISHED = 2;

	public GameModel() throws ClassNotFoundException, IOException {
		decision = new GameTree();
		decision.readFromFile();
		phase = 2;
	}
	
	void setGUI(GameGUI g) {
		gui=g;
	}

	void newGame() {
		gui.restartPaint();
		game = new GameBoard();
		player1 = new PlayerMove(game, this, 1);
		player2 = new AIMove(game, this, 2, decision.root);
		phase = (int) (Math.random() * 2);
//		phase = 0; // 0 = force going first, 1 = force going second

		if (phase == AITURN) {
			updateAIMove();
		}

		System.out.println("New Game!\nPlayer " + (phase + 1) + " first!");
		System.out.println(game);
	}

	void updatePlayerMove() {
		phase = AITURN;
		gui.drawYuyuko(player1.position);
		player2.updatePlayerMove(player1.position);
		checkFinish(1);
		
		if (phase == AITURN) {
			updateAIMove();
		}
	}

	private void updateAIMove() {
		phase = PLAYERTURN;
		player2.move();
		gui.drawYukari(player2.position);
		checkFinish(2);
	}

	private void checkFinish(int x) {
		int result = game.getResult();
		if (result > 0 && result < 3) {
			System.out.println("Player " + x + " wins!\n\n");
			phase = FINISHED;
			gui.finishPaint();
		} else {
			if (result == 3) {
				System.out.println("Draw!\n\n");
				phase = FINISHED;
				gui.finishPaint();
			}
		}
	}
	
	@Override
	public void handle(MouseEvent e) {
		if (phase == PLAYERTURN) {
			player1.parseInput(e);
		} else if (phase == FINISHED) {
			newGame();
		}
	}
}
