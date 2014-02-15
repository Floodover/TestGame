package screens;

import game.Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import libs.Images;
import libs.Reference;
import utils.Button;

public class Menu {

	public Button play, options, quit;
	//private static int centerY = Main.HEIGHT /2;
	
	public Menu() {
		int fillerY = 150;
		play = new Button(Reference.CENTER_X - 100, fillerY, 200, 50).setText("Play");
		options = new Button(Reference.CENTER_X -100,fillerY+=60, 200, 50).setText("Options");
		quit = new Button(Reference.CENTER_X -100,fillerY+=60, 200, 50).setText("Quit");
	}
	
	/**
	 * @param g
	 */
	public void render(Graphics g) {
		Graphics2D g2 = (Graphics2D)g; //added to test out Graphics2D
		g2.setColor(Color.BLACK);
		g2.fillRect(0, 0, Game.WIDTH,Game.HEIGHT);
		g2.drawImage(Images.title,0,0, null); //Draw the title in the window bar
		
		Font font = new Font("Transformers Movie", Font.PLAIN, 40); //name inside the font file
		g2.setFont(font);
		
		play.drawButton(g2, 58);
		options.drawButton(g2, 37);
		quit.drawButton(g2, 70);

	}
}
