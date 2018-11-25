package tictactoe;

import java.io.IOException;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class GameModel implements EventHandler<MouseEvent> {
	
	GameTree decision;
	GameGUI gui;
	int phase;
	PlayerMove player1;
	AIMove player2;
	GameBoard game;
	
	private static final int PLAYERTURN=0,AITURN=1,FINISHED=2;
	
	public GameModel() throws ClassNotFoundException, IOException {
		decision = new GameTree();
		decision.readFromFile();
		phase=2;
	}
	
	public void newGame() {
		gui.restartPaint();
		game = new GameBoard();
		player1 = new PlayerMove(game, 1);
		player2 = new AIMove(game, 2, decision.root);
		phase = (int) (Math.random() * 2);
//		phase = 0; // 0 = force going first, 1 = force going second
		System.out.println("New Game!\nPlayer " + (phase + 1) + " first!");
		System.out.println(game);
	}
	
	public void updateGame() {
		if (game != null && phase != FINISHED) {
			if (phase == PLAYERTURN) {
				if (player1.position != -1) {
					gui.drawYuyuko(player1.position);
					player2.updatePlayerMove(player1.position);
					player1.position = -1;
					phase = AITURN;
				}
			} else if (phase == AITURN) {
				int position=player2.move();
				gui.drawYukari(position);
				phase = PLAYERTURN;
			}
			
			if (game.isFinished()) {
				phase = FINISHED;
				gui.finishPaint();
			}
				
		}
	}
	
	@Override
	public void handle(MouseEvent e) {
		if (phase==PLAYERTURN) {
			player1.parseInput(e);
		} else if (phase == FINISHED) {
			newGame();
		}
	}
}
