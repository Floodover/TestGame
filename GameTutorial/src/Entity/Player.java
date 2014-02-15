package Entity;

import enums.Direction;
import game.Game;
import gfx.Animation;
import gfx.Textures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import objects.Block;
import core.CoreObject;

public class Player extends CoreObject {

	private static ArrayList<CoreObject> gameObjects = Game.getInstance().getController().getObjects();
	
	private float gravity = 0.50f;

	private boolean falling = true;
	private boolean jumping = false;
	private boolean moving = false;

	private Animation animeStanding;
	private Animation animeRight;
	private Animation animeLeft;

	private Direction direction = Direction.RIGHT;

	public Player(float x, float y, int id, Textures tex) {
		super(x, y, id, tex);
		this.setSize(32, 70);
		animeStanding = new Animation(3, tex.playerStanding);
		animeRight = new Animation(3, tex.playerRight);
		animeLeft = new Animation(3, tex.playerLeft);
	}
	

	@Override
	public void tick() {
		x += velX;
		y += velY;

		fall(); // character falls
		checkCollision();
		
		if (moving) {
			if (direction == Direction.RIGHT)
				animeRight.runAnimation();
			else if (direction == Direction.LEFT)
				animeLeft.runAnimation();
		}
		if (!moving) {
			animeStanding.runAnimation();
		}
	}

	@Override
	public void render(Graphics g) {
		Graphics2D g2 = (Graphics2D) g; // Added Graphics2D to test out this way

		      g2.setColor(Color.red);
		      g2.draw(getTopBounds());
		      g2.draw(getBottomBounds());
		      g2.draw(getRightBounds());
		      g2.draw(getLeftBounds());

		if (!moving) {
			 if (direction == Direction.RIGHT)
			 g2.drawImage(tex.playerStandingRight, (int) x, (int) y, null);
			 else if (direction == Direction.LEFT)
			 g2.drawImage(tex.playerStandingLeft, (int) x, (int) y, null);
			animeStanding.drawAnimation(g2, x, y);
			
		} else {
			if (direction == Direction.RIGHT)
				animeRight.drawAnimation(g2, x, y);
			else if (direction == Direction.LEFT)
				animeLeft.drawAnimation(g2, x, y);
		}
	}

	// ///Collision detection
	private void checkCollision() {

		for (CoreObject obj : gameObjects) {
			if (obj instanceof Block) {
				// if (obj.getId() == ObjectIDs.BLOCK_STONE || obj.getId() ==
				// ObjectIDs.BLOCK_METAL) {
				// block = (Block) obj;
				if (getBottomBounds().intersects(obj.getTopBounds())) {
					velY = 0;
					y = obj.getY() - height;
					jumping = false;
					falling = false;
				}else 
					falling = true;
				
				if (getTopBounds().intersects(obj.getBottomBounds())) {
					fall();
					y = obj.getY() + obj.getHeight();
				}
				if (getRightBounds().intersects(obj.getLeftBounds())) {
					velX = 0;
					x = obj.getX() - width;
				}
				if (getLeftBounds().intersects(obj.getRightBounds())) {
					velX = 0;
					x = obj.getX() + obj.getWidth();
				}
			}
		}
	}

	public void fall() {
		if (falling)
			velY += gravity;
	}

	public boolean isJumping() {
		return jumping;
	}

	public void setJumping(boolean jumping) {
		this.jumping = jumping;
	}

	/**
	 * @return true if the player is moving
	 */
	public boolean isMoving() {
		return moving;
	}

	/**
	 * @param moving
	 *            the moving to set
	 */
	public void setMoving(boolean moving) {
		this.moving = moving;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;

	}

	public Direction getDirection() {
		return direction;

	}
}
