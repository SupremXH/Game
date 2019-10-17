package Mysnake;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SnakeGUI extends JFrame {
	public boolean run = true;
	public Snake snake = new Snake(100, 100);
	public Food food = new Food();

	public void snake_load() {
		this.setTitle("SNAKE");
		this.setSize(900, 600);
		Container c = getContentPane();
		this.setLocationRelativeTo(null);
		this.setBackground(Color.BLACK);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				snake.keyPressed(e);	
			}
		});
		Mythread t = new Mythread();
		c.add(new drawsnake());
		this.setVisible(true);
		t.start();
	}

	class drawsnake extends JPanel {
		public void paint(Graphics g) {
			if (snake.alive) {
				snake.draw(g);
				if (food.alive) {
					food.draw(g);
					food.ate(snake);
				} else
					food = new Food();
			} else {
				new Mythread().stopRunning();
				g.setFont(new Font("Calibri", Font.BOLD, 80));
				g.drawString("Game Over", 250, 300);
			}
		}
	}

	class Mythread extends Thread {
		public void run() {
			while (run) {
				repaint();
				try {
					sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}
		public void stopRunning() {
			run = false;
		}
	}
}
