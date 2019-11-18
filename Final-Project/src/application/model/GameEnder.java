// @author Kyle Horsman

public class GameEnder {
  private Snake snake;
	private String name;
	
	public GameEnder(Snake snake, String name){
		this.snake = snake;
	}
	
	public void endGame(){
		HighScore score = new HighScore(snake.getLength(), name);
		try{
			
	}
  	
  	public String getName(){
  		return name;
  	}
  	
  	public Snake getSnake(){
  		return snake;
  	}
}
