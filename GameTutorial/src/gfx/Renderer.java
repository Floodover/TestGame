package gfx;

import game.Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class Renderer {
	
	public void renderBackground(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		switch (Game.state) {
		case GAME:
			break;
		case MENU:
			Game.getInstance().getMenu().render(g);
			break;
		case OPTIONS:
			break;
		case PAUSE:
			break;
		default:
			g2.setColor(Color.RED);
			g2.drawString("UNKOWN GAME STATE", 150, 150);
			break;
		}
	}

	public void renderForeground(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		switch(Game.state) {
		case GAME:
			Game.getInstance().getController().render(g);
			break;
		case MENU:
			break;
		case OPTIONS:
			break;
		case PAUSE:
			break;
		default:
			g2.setColor(Color.RED);
			g2.drawString("UNKOWN GAME STATE", 150, 150);
			break;
		
		}
	}
}
