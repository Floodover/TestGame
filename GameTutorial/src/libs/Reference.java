package libs;

import java.awt.image.BufferedImage;

import game.Game;

public class Reference {
	//add more references for the maps etc.
	public static final int CENTER_X = Game.WIDTH /2;
	public static final int CENTER_Y = Game.WIDTH /2;
	
	public static final String RESOURCE_LOCATION = "./resources/";
	public static final String SPRITE_LOCATION = RESOURCE_LOCATION + "sprites/";
	
 	public static final String FONT_LOCATION = RESOURCE_LOCATION + "fonts/";
 	public static final String SOUND_LOCATION = RESOURCE_LOCATION + "sounds/";
 	
 	public static final int ALPHA_RGB = BufferedImage.TYPE_INT_ARGB;
 	
 	public static final String LOADING_LOCATION = "./loading/";
}
