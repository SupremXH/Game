package Mysnake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class Food extends sameObject{



	Point p=new Point(x,y);
	public Food(){
		this.x=(int)(Math.random()*59)*block_size;
		this.y=(int)(Math.random()*39)*block_size;
		if(x>900-block_size)
			this.x=(int)(Math.random()*60)*block_size;
		if(y>600-block_size)
			this.y=(int)(Math.random()*40)*block_size;
		this.alive=true;
	}
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.blue);
		g.fillOval(x, y, block_size, block_size);
	}
	public void ate(Snake snake) {
		if(snake.getRectangle().intersects(getRectangle())&&alive&&snake.alive){
			this.alive=false;
			snake.setlength(snake.getlength()+1);
		}
	}
}
