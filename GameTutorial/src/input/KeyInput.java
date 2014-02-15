package input;

import enums.Direction;
import game.Game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import libs.ObjectIDs;
import Entity.Player;
import core.CoreObject;

public class KeyInput extends KeyAdapter {

	private Player player;

	private boolean[] keyDown = new boolean[2];

	public KeyInput() {
		for (CoreObject obj : Game.getInstance().getController().getObjects()) {
			if (obj.getId() == ObjectIDs.PLAYER)
				player = (Player) obj;
		}

	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		switch (Game.state) {
		case GAME:
			if (key == KeyEvent.VK_SPACE && !player.isJumping()) {
				player.setVelY(-13);
				player.setJumping(true);
			}

			if (key == KeyEvent.VK_A) {
				player.setVelX(-5);
				player.setMoving(true);
				player.setDirection(Direction.LEFT);
				keyDown[0] = true;
			}

			if (key == KeyEvent.VK_D) {
				player.setVelX(5);
				player.setMoving(true);
				player.setDirection(Direction.RIGHT);
				keyDown[1] = true;
			}

			break;
		case MENU:
			break;
		case OPTIONS:
			break;
		case PAUSE:
			break;
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		switch (Game.state) {
		case GAME:
			if (key == KeyEvent.VK_A) {
				keyDown[0] = false;
				player.setMoving(false);
			}
			if (key == KeyEvent.VK_D) {
				keyDown[1] = false;
				player.setMoving(false);
			}
			if (keyDown[0] && !keyDown[1])
				player.setVelX(-5);
			if (!keyDown[0] && keyDown[1])
				player.setVelX(5);
			if (!keyDown[0] && !keyDown[1])
				player.setVelX(0);

			break;
		case MENU:
			break;
		case OPTIONS:
			break;
		case PAUSE:
			break;
		}
	}

}
