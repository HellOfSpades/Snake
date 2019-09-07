package application;

import application.Player.Snake;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Game {
	
	private static Game game;
	public Controller controller;
	public Updater updater;
	public Snake snake;
	public Apple apple;
	public boolean started;
	public static double cellWidth;
	public static double cellHeight;
	public static int cellsH;
	public static int cellsV;
	
	public static Game getGame() {
		return game;
		
	}
	
	public static void newGame(Controller controller) {
		game = new Game(controller);
	}
	
	private Game(Controller controller) {
		cellsH = 64;
		cellsV = 40;
		cellHeight = 20;
		cellWidth = 20;
		
		this.controller = controller;
		started = false;
		updater = new Updater();
		snake = new Snake();
		apple = new Apple();
		started = false;
		updater.start();
		
	}
	
	public void compileActionPressed(KeyEvent e) {
		if(!started) {
			started = true;
		}
		
			
		if (e.getCode() == KeyCode.UP && snake.dir!=0 && snake.dir!=1) {
	        snake.dir = 0;
	    }
		if (e.getCode() == KeyCode.DOWN && snake.dir!=0 && snake.dir!=1) {
			snake.dir = 1;
	    }
		if (e.getCode() == KeyCode.LEFT && snake.dir!=2 && snake.dir!=3) {
			snake.dir = 2;
	    }
		if (e.getCode() == KeyCode.RIGHT && snake.dir!=2 && snake.dir!=3) {
			snake.dir = 3;
	    }
			
		
	}

}
