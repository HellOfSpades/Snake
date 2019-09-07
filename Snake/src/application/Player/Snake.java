package application.Player;

import java.util.ArrayList;

import application.Game;

public class Snake {
	public int dir;
	public ArrayList<Segment> segments;
	public int x;
	public int y;
	
	public Snake(){
		dir = 0;
		segments = new ArrayList<Segment>();
		segments.add(new Segment(Game.getGame().cellsH/2,Game.getGame().cellsV/2));
		segments.add(new Segment(Game.getGame().cellsH/2,Game.getGame().cellsV/2));
		segments.add(new Segment(Game.getGame().cellsH/2,Game.getGame().cellsV/2));
		segments.add(new Segment(Game.getGame().cellsH/2,Game.getGame().cellsV/2));
		segments.add(new Segment(Game.getGame().cellsH/2,Game.getGame().cellsV/2));
	}
	
	public void update() {
		
		segments.remove(0);
		
		int x = segments.get(segments.size()-1).x;
		int y = segments.get(segments.size()-1).y;
		
		switch(dir) {
			case 0: 
				if(y>0)y--;
				break;
				
			case 1: 
				if(y<Game.cellsV-1)y++;
				break;
		
			case 2: 
				if(x>0)x--;
				break;
		
			case 3: 
				if(x<Game.cellsH-1)x++;
				break;
		
		}
		
		segments.add(new Segment(x,y));
		
		for(int i = 0;i<segments.size()-1;i++) {
			if(segments.get(i).x==segments.get(segments.size()-1).x && segments.get(i).y==segments.get(segments.size()-1).y) {
				System.out.println(i);
				Game.getGame().updater.restart = true;
			}
		}
		
		if(Game.getGame().apple.x==segments.get(segments.size()-1).x && Game.getGame().apple.y==segments.get(segments.size()-1).y) {
			
			for(int i = 0;i<5;i++) {
				segments.add(0, new Segment(segments.get(0).x,segments.get(0).y));
			}
			Game.getGame().apple.setRandomPosition();
		}
	}

}
