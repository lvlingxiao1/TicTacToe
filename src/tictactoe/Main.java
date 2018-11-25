package tictactoe;

import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	GameModel model;
	GameGUI gui;

	public static void main(String[] args) throws IOException, ClassNotFoundException {

//		Training t=new Training();
//		t.run();
//		GameTree decision = t.decision;
//
//		decision.printToFile();

		launch(args);

	}

	@Override
	public void start(Stage Stage) throws Exception {
		model = new GameModel();
		gui = new GameGUI(Stage, model);

	}
}
