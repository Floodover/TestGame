package screens;

import game.Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import libs.Images;



public class LoadScreen {

	private static int width = 541;
	private static int height = 51;
	private static int numResources = 10;
	private static int loadAdd = width /numResources;
	private static int loadStatus = 0;
	
	private static String msg = "Loading Resources...";
	
	public static void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
		g.drawImage(Images.loading, 0,0,null);
		g.setColor(Color.RED);
		g.drawRect(49, 399, width, height);
		g.setColor(Color.YELLOW);
		g.setFont(new Font("Arial",Font.PLAIN, 18));
		g.drawString(msg, 51,395);
		g.setColor(Color.ORANGE);
		g.fillRect(50, 400, loadStatus, 50);
	}
	
	public static void LoadBarMove() {
		loadStatus += loadAdd;
	}
	
	public static void setMessage (String msg) {
		LoadScreen.msg = msg;
	}
	
}
