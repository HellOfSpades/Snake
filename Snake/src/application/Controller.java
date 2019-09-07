package application;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;

public class Controller {
	
	@FXML
	Canvas canvas;
	
	public void initialize() {
		Game.newGame(this);
		Game.getGame().apple.setRandomPosition();
	}

}
