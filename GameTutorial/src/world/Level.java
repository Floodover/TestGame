package world;

import game.Game;
import gfx.Textures;

import java.awt.image.BufferedImage;

import libs.Images;
import libs.ObjectIDs;
import objects.Block;
import Controller.Controller;
import Entity.Player;

public class Level {

	public BufferedImage image;
	private Controller controller = Game.getInstance().getController();
	private Textures tex = Game.getInstance().getTextureHandler();

	public Level(int levelNumber) {
		switch (levelNumber) {
		case 1:
			image = Images.levelOne;
			break;
		default:
			image = Images.levelOne;
		}
	}

	public void loadLevel() {
		int w = image.getWidth();
		int h = image.getWidth();

		for (int x = 0; x < w; x++) {
			for (int y = 0; y < h; y++) {
				int pixel = image.getRGB(x, y);
				int red = (pixel >> 16) & 0x000000FF; // Modified this to actually work!
												
												
				int green = (pixel >> 8) & 0x000000FF;
				int blue = (pixel) & 0x000000FF;

				if (red == 255 && green == 255 && blue == 0)
					controller.addObject(new Player(x * 32, y * 32,ObjectIDs.PLAYER, tex)); //Load player
				else if (red == 255 && green == 255 && blue == 255)											
					addBlock(x, y, ObjectIDs.BLOCK_RUBY,tex.blockAsteroidCenter);
				
				else {
					if (red == 255) // pure red
						addBlock(x, y, ObjectIDs.BLOCK_ASTEROID_TOP_RIGHT,
								tex.blockAsteroidTopRight);
					if (red == 250)
						addBlock(x, y, ObjectIDs.BLOCK_ASTEROID_TOP_LEFT,
								tex.blockAsteroidTopLeft);
					if (red == 245)
						addBlock(x, y, ObjectIDs.BLOCK_ASTEROID_TOP,
								tex.blockAsteroidTop);
					if (red == 240)
						addBlock(x, y, ObjectIDs.BLOCK_ASTEROID_TOP_SIDES,
								tex.blockAsteroidTopSides);
					if (red == 150)
						addBlock(x, y, ObjectIDs.BLOCK_METAL_GRIP,
								tex.blockMetalGrip);
					if (red == 140)
						addBlock(x, y, ObjectIDs.BLOCK_METAL_SHEET,
								tex.blockMetalSheet);
					if (green == 255)
						addBlock(x, y, ObjectIDs.LIQUID_LAVA, tex.lava);
					
					if (blue == 255)
						addBlock(x, y, ObjectIDs.BLOCK_DIAMOND, tex.blockDiamond);

				}
			}
		}
	}

	private void addBlock(int x, int y, int id, BufferedImage texture) {
		controller.addObject(new Block(x * 32, y * 32, id, texture));
	}
}
