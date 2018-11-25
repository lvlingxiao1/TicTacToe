package tictactoe;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.StrokeLineCap;
import javafx.stage.Stage;

public class GameGUI {

	GameModel model;
	Canvas canvas;
	GraphicsContext g;
	Image finishImg, yuyukoImg, yukariImg;

	public GameGUI(Stage stage, GameModel model) {
		this.model = model;
		model.gui = this;
		finishImg = new Image(getClass().getResourceAsStream("img/finish.png"));
		yuyukoImg = new Image(getClass().getResourceAsStream("img/yuyuko.png"));
		yukariImg = new Image(getClass().getResourceAsStream("img/yukari.png"));
		initUI(stage);
	}

	private void initUI(Stage stage) {
		StackPane pane = new StackPane();
		canvas = new Canvas(800, 800);
		g = this.canvas.getGraphicsContext2D();
		pane.getChildren().add(canvas);
		pane.addEventHandler(MouseEvent.MOUSE_CLICKED, model);
		restartPaint();

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.setTitle("tic tac toe");
		stage.getIcons().add(yuyukoImg);

		AnimationTimer timer = new AnimationTimer() {
			public void handle(long now) {
				model.updateGame();
			}
		};
		timer.start();

		model.newGame();
		stage.show();

	}

	public void restartPaint() {

		// Clear the canvas
		g.clearRect(0, 0, 800, 800);

		g.setLineWidth(8);
		g.setLineCap(StrokeLineCap.ROUND);

		g.strokeLine(268, 16, 268, 784);
		g.strokeLine(532, 16, 532, 784);
		g.strokeLine(16, 268, 784, 268);
		g.strokeLine(16, 532, 784, 532);
	}

	public void finishPaint() {
		g.drawImage(finishImg, 50, 320);
	}

	public void drawYuyuko(int position) {
		int x = position % 3 * 264 + 8;
		int y = position / 3 * 264 + 8;
		g.drawImage(yuyukoImg, x, y, 256, 256);
	}

	public void drawYukari(int position) {
		int x = position % 3 * 264 + 8;
		int y = position / 3 * 264 + 8;
		g.drawImage(yukariImg, x, y, 256, 256);
	}

}
