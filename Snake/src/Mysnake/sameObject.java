package Mysnake;

import java.awt.Graphics;
import java.awt.Rectangle;

public  abstract class sameObject {
	int x;
	int y;
	public boolean alive;
	public abstract void draw(Graphics g);
	public final int block_size=15;
	public Rectangle getRectangle() {
		return new Rectangle(x,y,block_size,block_size);
	}
}
