package Mysnake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

public class Snake extends sameObject{

	private int speed;
	public int length;
	public static LinkedList<Point> snakebody=new LinkedList<>();
	boolean up,left,right,down=true;

	public int getlength() {
		return length;
	}
	public void setlength(int length) {
		this.length=length;
	}
	public Snake(int x,int y) {
		this.x=x;
		this.y=y;
		speed=15;
		length=1;
		this.alive=true;
	}
	public void SnakeHead(Graphics g) {
		g.setColor(Color.red);
		g.drawOval(x,y, block_size, block_size);
		
	}
	@Override
	public void draw(Graphics g) {
		OutOfBounds();
		eatbody();
		snakebody.add(new Point(x,y));
		SnakeHead(g);
		if(snakebody.size()==length+1)
			snakebody.remove(0);
		drawbody(g);
		
		snake_move();
		
	}
	private void OutOfBounds() {
		if(x<=0 || y<=0 || x>=(900-block_size) || y>=(600-block_size))
			alive=false;
	}
	private void eatbody() {
		for(int i=0;i<snakebody.size()-2;i++)
		if(snakebody.getLast().equals(snakebody.get(i)))
			alive=false;
		
	}
	public void drawbody(Graphics g) {
		g.setColor(Color.cyan);
		for(int i=snakebody.size()-2;i>=0;i--) {
			Point p=snakebody.get(i); 
			g.drawOval(p.x,p.y,block_size,block_size); 
			
		}
		
		
	}
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
		case 38: //up
			if(!down) {
				up=true;
				down=false;
				right=false;
				left=false;
			}
			break;
		case 40: //down
			if(!up) {
				up=false;
				down=true;
				right=false;
				left=false;
			}
			break;
		case 37: //left
			if(!right) {
				up=false;
				down=false;
				left=true;
				right=false;
			}
			break;
		case 39: //right
			if(!left) {
				up=false;
				down=false;
				left=false;
				right=true;
			}
			break;
		}
	}
	public void snake_move() {
		if(up)
			y-=speed;
		else if(down)
			y+=speed;
		else if(left)
			x-=speed;
		else if(right)
			x+=speed;
	}
	
}
