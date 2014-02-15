package gfx;

import java.awt.image.BufferedImage;

import libs.Images;
import utils.SpriteSheet;

public class Textures {

	private SpriteSheet blocks32sheet;
	public BufferedImage blockRuby;
	public BufferedImage blockDiamond;
	
	private SpriteSheet rockSheet;
	private SpriteSheet metalSheet;
	private SpriteSheet liquidSheet;
	private SpriteSheet playerSheet;
	
	public BufferedImage blockAsteroidCenter;
	public BufferedImage blockAsteroidTopRight;
	public BufferedImage blockAsteroidTopLeft;
	public BufferedImage blockAsteroidTopSides;
	public BufferedImage blockAsteroidTop;

	public BufferedImage blockMetalGrip;
	public BufferedImage blockMetalLined;
	public BufferedImage blockMetalSheet;
	public BufferedImage blockMetalRough;
	public BufferedImage blockMetalSmooth;

	public BufferedImage lava;
	public BufferedImage toxicWaste;
	public BufferedImage water;
	public BufferedImage coldWater;

	public BufferedImage playerStandingRight;
	public BufferedImage playerStandingLeft;
	public BufferedImage playerStanding[] = new BufferedImage[2];
	public BufferedImage playerRight[] = new BufferedImage[4];
	public BufferedImage playerLeft[] = new BufferedImage[4];

	public Textures() {

		blocks32sheet = new SpriteSheet(Images.spritesheetblocks32, 32);
		
		rockSheet = new SpriteSheet(Images.spritesheetRockyBlocks, 32);
		metalSheet = new SpriteSheet(Images.spritesheetMetalBlocks, 32);
		liquidSheet = new SpriteSheet(Images.spritesheetLiquid, 32);
		
		playerSheet = new SpriteSheet(Images.spritesheetPlayer, 32, 70);

		initTextures();
	}

	private void initTextures() {

		blockRuby = blocks32sheet.getSprite(3, 1);
		blockDiamond = blocks32sheet.getSprite(2, 1);
		
		blockAsteroidCenter = rockSheet.getSprite(1, 1);
		blockAsteroidTop = rockSheet.getSprite(2, 1);
		blockAsteroidTopRight = rockSheet.getSprite(3, 1);
		blockAsteroidTopLeft = rockSheet.getSprite(4, 1);
		blockAsteroidTopSides = rockSheet.getSprite(1, 2);

		blockMetalGrip = metalSheet.getSprite(1, 1);
		blockMetalLined = metalSheet.getSprite(2, 1);
		blockMetalSheet = metalSheet.getSprite(3, 1);
		blockMetalRough = metalSheet.getSprite(4, 1);
		blockMetalSmooth = metalSheet.getSprite(1, 2);

		lava = liquidSheet.getSprite(1, 1);
		toxicWaste = liquidSheet.getSprite(2, 1);
		water = liquidSheet.getSprite(3, 1);
		coldWater = liquidSheet.getSprite(4, 1);

		playerStanding[0] = playerSheet.getSprite(6, 1);
		playerStanding[1] = playerSheet.getSprite(7, 1);

		playerStandingRight = playerSheet.getSprite(12, 1);
		playerStandingLeft = playerSheet.getSprite(1, 1);

		playerRight[0] = playerSheet.getSprite(12, 1);
		playerRight[1] = playerSheet.getSprite(8, 1);
		playerRight[2] = playerSheet.getSprite(9, 1);
		playerRight[3] = playerSheet.getSprite(10, 1);

		playerLeft[0] = playerSheet.getSprite(1, 1);
		playerLeft[1] = playerSheet.getSprite(2, 1);
		playerLeft[2] = playerSheet.getSprite(3, 1);
		playerLeft[3] = playerSheet.getSprite(4, 1);
	}
}
