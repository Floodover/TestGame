package utils;

import java.io.IOException;

import libs.Audio;
import libs.Images;
import libs.Reference;

public class ResourceLoader {

	private static BufferedImageLoader imageLoader = new BufferedImageLoader();

	public static void preLoad() {
		try{
			Images.loading =imageLoader.loadImage("/loading/loading.png");
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public static void loadImages() {

		try {
			//fix this around to make it easier to find the files
			Images.title = imageLoader.loadImage("titles/title.png");
			//32 x 32 blocks
			Images.blocks32 = imageLoader.loadImage("/blocks/blocks32.png");
			Images.spritesheetblocks32 = ImageModifier.resizeImage(Images.blocks32, Reference.ALPHA_RGB, 0, 0, 256, 256, 1); //Had to change to get the image to go 256x256 scale 1
			//rock blocks
            Images.rockyBlocksHD = imageLoader.loadImage("/blocks/rocky_blocks.png");
            Images.spritesheetRockyBlocks = ImageModifier.resizeImage(Images.rockyBlocksHD, Reference.ALPHA_RGB, 0, 0, 512, 512, 0.25);
            //metal blocks
            Images.metalBlocksHD = imageLoader.loadImage("/blocks/metal_blocks.png");
            Images.spritesheetMetalBlocks = ImageModifier.resizeImage(Images.metalBlocksHD, Reference.ALPHA_RGB, 0, 0, 512, 512, 0.25);
            //liquid blocks
            Images.liquidHD = imageLoader.loadImage("/blocks/liquid.png");
            Images.spritesheetLiquid = ImageModifier.resizeImage(Images.liquidHD, Reference.ALPHA_RGB, 0, 0, 512, 512, 0.25);
            
            //Character
            Images.spritesheetPlayer = imageLoader.loadImage("/characters/female.png");
            
            //Level maps
            Images.levelOne = imageLoader.loadImage("levels/level1.png");
            
            //Images.loading = imageLoader.loadImage("loading.png");
            
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void loadFonts() {
		Fonts.addFont(new Fonts("Transformers Movie.TTF"));
	}

	public static void loadSounds() {
		AudioPlayer.addSound(Audio.TESTSOUND, "testsound.ogg");

		AudioPlayer.addMusic(Audio.MUSIC_TEST, "background.ogg");
	}
}
