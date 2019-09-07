package application;

import java.util.Random;

public class Apple {
	public int x;
	public int y;
	
	Apple(){
		
	}
	public void setRandomPosition() {
		Random random = new Random();
		
		while(true) {
			x = random.nextInt(Game.cellsH);
			y = random.nextInt(Game.cellsV);
			
			boolean notfound = true;
			
			for(int i = 0;i<Game.getGame().snake.segments.size();i++) {
				if(this.x==Game.getGame().snake.segments.get(i).x && this.y==Game.getGame().snake.segments.get(i).y) {
					notfound = false;
				}
			}
			
			if(notfound)break;
		}
	}
}
