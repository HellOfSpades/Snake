package application;

import application.Player.Snake;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Updater extends AnimationTimer{
	
	GraphicsContext g = null;
	public boolean restart = false;
	
	Updater(){
		
	}
	@Override
	public void handle(long arg0) {
		if(g==null) {
			g = Game.getGame().controller.canvas.getGraphicsContext2D();
		}
		
		if(restart) {
			Game.getGame().started = false;
			restart = false;
			Game.getGame().snake = new Snake();
			Game.getGame().apple.setRandomPosition();
			
		}else {
			if(Game.getGame().started) {
				
				Game.getGame().snake.update();
			}
			
			g.setFill(Color.BLACK);
			g.fillRect(0, 0, Game.getGame().controller.canvas.getWidth(), Game.getGame().controller.canvas.getHeight());
			
			
			g.setFill(Color.GREEN);
			g.setStroke(Color.BLACK);
			for(int i = 0;i<Game.getGame().snake.segments.size();i++) {
				//System.out.println("drawing segment "+i);
				g.fillRect(Game.getGame().snake.segments.get(i).x*Game.getGame().cellWidth,Game.getGame().snake.segments.get(i).y*Game.getGame().cellHeight,Game.getGame().cellWidth,Game.getGame().cellHeight);
				g.strokeRect(Game.getGame().snake.segments.get(i).x*Game.getGame().cellWidth,Game.getGame().snake.segments.get(i).y*Game.getGame().cellHeight,Game.getGame().cellWidth,Game.getGame().cellHeight);
				
			}
			
			
			g.setFill(Color.RED);
			g.fillRect(Game.getGame().apple.x*Game.getGame().cellWidth,Game.getGame().apple.y*Game.getGame().cellHeight,Game.getGame().cellWidth,Game.getGame().cellHeight);
			
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

}
