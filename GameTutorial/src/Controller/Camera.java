package Controller;

import libs.ObjectIDs;
import game.Game;
import Entity.Player;
import core.CoreObject;

public class Camera {

	private float x,y;
	private Player player;
	
	public Camera(float x, float y) {
		this.x = x;
		this.y =y;
		for(CoreObject obj : Game.getInstance().getController().getObjects())
			if(obj.getId() == ObjectIDs.PLAYER)
				player = (Player) obj;
	}
	
	public void tick() {
		//x = - player.getX() + Game.WIDTH /2; //Puts player in the middle of the screen
		x += ((-player.getX() + Game.WIDTH /2) -x) * .0275f;; //x +=(Target - value) * constant VERY COOL
	}

	/**
	 * @return the x
	 */
	public float getX() {
		return x;
	}

	/**
	 * @return the y
	 */
	public float getY() {
		return y;
	}
	
	
}
