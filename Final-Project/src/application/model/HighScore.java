package application.model;
/**
 * 
 * @author Cary Inzerello
 *
 */
public class HighScore {
	private int score;
	private String name;
	
	public HighScore() {
		this(0, "");		
	}
	public HighScore(int score, String name) {
		super();
		this.score = score;
		this.name = name;
	}

	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
}
