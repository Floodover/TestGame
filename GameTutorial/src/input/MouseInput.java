package input;

import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import screens.Menu;
import utils.AudioPlayer;

import libs.Audio;
import enums.GameState;
import game.Game;

public class MouseInput extends MouseAdapter {

	public static boolean pressed = false;

	public static int MOUSE_X, MOUSE_Y;
	public static Rectangle MOUSE = new Rectangle(1, 1, 1, 1);

	private Menu menu = Game.getInstance().getMenu();
	
	@Override
	public void mouseClicked(MouseEvent e) {
		int mouse = e.getButton();
		if (mouse == MouseEvent.BUTTON1) {
			Rectangle rect = new Rectangle(e.getX(), e.getY(), 1, 1);
			
			switch (Game.state) {
			case GAME:
				break;
			case MENU:
				if (rect.intersects(menu.play)) {
					AudioPlayer.playSound(Audio.TESTSOUND);
					Game.getInstance().levelOne.loadLevel();
					Game.state = GameState.GAME;
					
				}else if (rect.intersects(menu.options)) {
					AudioPlayer.playSound(Audio.TESTSOUND); 
					Game.state = GameState.OPTIONS;
					
				}else if (rect.intersects(menu.quit)) {
					AudioPlayer.playSound(Audio.TESTSOUND); //can add a sound to each based on movement blah blah if I want code was there on site
					Game.exit(); //sound is to quit to hear when exiting
				}
				break;
			case OPTIONS:
				break;
			case PAUSE:
				break;
			default:
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		pressed = true;
	}

	@Override
	public void mouseReleased(MouseEvent e) {

		pressed = false;
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		MOUSE_X = e.getX();
		MOUSE_Y = e.getY();
		MOUSE = new Rectangle(MOUSE_X, MOUSE_Y, 1, 1);
	}
}
