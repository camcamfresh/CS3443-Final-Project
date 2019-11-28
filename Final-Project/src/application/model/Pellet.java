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
		int x = 10*Math.round(rand.nextInt(590)/10);
		int y = 10*Math.round(rand.nextInt(390)/10);
		this.setX(x);
		this.setY(y);
	}
}
