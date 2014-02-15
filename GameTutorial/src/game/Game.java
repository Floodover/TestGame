package game;

import input.KeyInput;
import input.MouseInput;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import libs.Audio;
import libs.ObjectIDs;

import org.lwjgl.openal.AL;

import screens.LoadScreen;
import screens.Menu;
import utils.AudioPlayer;
import utils.ResourceLoader;
import utils.TextFile;
import utils.Updater;
import world.Level;
import Controller.Camera;
import Controller.Controller;
import Entity.Player;
import enums.GameState;
import gfx.Renderer;
import gfx.Textures;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 640;
	public static final int HEIGHT = WIDTH / 4 * 3;
	public static final String TITLE = "Game Tutorial";
	private static Game game = new Game();
	public static GameState state = GameState.LOADING;

	private boolean running = false;
	private Thread thread;
	private Renderer gfx;
	private Camera camera;
	private Menu menu;
	private Controller controller = new Controller();
	private Textures tex;
	public Level levelOne;

	private int time = 100;
	private int counter = 0;
	
	public static Game getInstance() {
		return game;
	}

	public Menu getMenu() {
		return menu;
	}

	public Controller getController() {
		return controller;
	}

	public Textures getTextureHandler() {
		return tex;
	}

	public void init() { // start up everything
		ResourceLoader.preLoad();
		TextFile.writeFile("./test.txt", "test"); //write a text file
	}
	
	private void load() {
		
		switch(counter){
		case 0:
			ResourceLoader.loadImages();
			counter++;
			LoadScreen.LoadBarMove();
			return;
		case 1:
			ResourceLoader.loadFonts();
			counter++;
			LoadScreen.LoadBarMove();
			return;
		case 2:
			ResourceLoader.loadSounds();
			counter++;
			LoadScreen.LoadBarMove();
			return;
		case 3:
			tex = new Textures();
			counter++;
			LoadScreen.LoadBarMove();
			return;
		case 4:
			menu = new Menu();
			counter++;
			LoadScreen.LoadBarMove();
			return;
		case 5:
			gfx = new Renderer();
			counter++;
			LoadScreen.LoadBarMove();
			return;
		case 6:
			MouseInput mouse = new MouseInput();
			this.addMouseListener(mouse);
			this.addMouseMotionListener(mouse);
			counter++;
			LoadScreen.LoadBarMove();
			return;
		case 7:
			levelOne = new Level(1);
			counter++;
			LoadScreen.LoadBarMove();
			return;
		case 8:
			controller.addObject(new Player(100,HEIGHT - 220, ObjectIDs.PLAYER, tex));
			camera = new Camera(0,0);
			this.addKeyListener(new KeyInput());
			counter++;
			LoadScreen.LoadBarMove();
			return;	
		case 9:
			Updater.checkForUpdate(false);
			counter++;
			LoadScreen.LoadBarMove();
			return;		
		case 10:
			counter++;
			LoadScreen.LoadBarMove();
			state = GameState.MENU;
			AudioPlayer.playMusic(Audio.MUSIC_TEST);
			return;		
		}
	}
	
	public void tick() {
		if(state == GameState.LOADING) {
			time --;
			if(time <=0) {
				load();
				time = 20;
			}
		}
		if (state == GameState.GAME) {
			controller.tick();
			camera.tick();
		}
	}

	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3); // Triple buffering set to double for now
			return;
		}

		Graphics g = bs.getDrawGraphics();
		Graphics2D g2 = (Graphics2D) g;
		g.setColor(new Color(0, 100, 100));
		g.fillRect(0, 0, WIDTH, HEIGHT);

		// ////////////////////////////////////////////////////////////
		if(state == GameState.LOADING)
			LoadScreen.render(g);
		else {
		gfx.renderBackground(g);
		if(camera != null)
		g2.translate(camera.getX(), camera.getY());
		gfx.renderForeground(g);
		if (camera != null)
		g2.translate(-camera.getX(), -camera.getY());
		}
		///////////////////////////////////////////////////////////////
		g.dispose();
		bs.show();
	}

	// When the thread starts it starts this
	@Override
	public void run() {
		// Game loop
		init(); // start the loop
		long lastTime = System.nanoTime(); // get the system time
		final double numTicks = 60.0; // sixty ticks in a second
		double n = 1000000000 / numTicks;
		double delta = 0;
		int frames = 0;
		int ticks = 0;
		long timer = System.currentTimeMillis();

		while (running) {
			long currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / n;
			lastTime = currentTime;

			if (delta >= 1) {
				tick();
				ticks++;
				delta--;
			}
			render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				// System.out.println("Ticks:"ticks + " FPS: " + frames);
				Window.setTitle(TITLE + "        FPS: " + frames);
				ticks = 0;
				frames = 0;

			}
			// Fix the Frame rate from going CRAZY!
			try {
				Thread.sleep(8); // Find a more specific timer that will be
									// better
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		stop();
	}

	public static void main(String args[]) {
		Window.initWindow(TITLE);
		Window.addGame(game);
		Window.creatWindow();
		game.start(); // start the game
	}

	// //////////This section is for starting and ending the game
	private synchronized void start() {
		if (running)
			return;
		else
			running = true;
		thread = new Thread(this);
		thread.start();
	}

	private synchronized void stop() {
		if (!running)
			return;
		else
			running = false;

		cleanUp();
		System.exit(1); // exit without an error
	}

	private void cleanUp() {
		AL.destroy();
	}
	
	public static void exit() {
		game.stop();
	}

}