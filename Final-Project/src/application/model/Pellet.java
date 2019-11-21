package application.model;

import java.util.Random;

/**
 * @author Cary Inzerello
 */
public class Pellet extends Collidable{
	
	@Override
	public void collideResponse(Collidable c) {
		this.move();		
	}
	
	/**
	 * Moves the pellet to a new space.
	 */
	public void move() {
		Random rand = new Random();
		int x = rand.nextInt(255);
		int y = rand.nextInt(255);
		this.setX(x);
		this.setY(y);
	}
}
