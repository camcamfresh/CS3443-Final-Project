package application.controller;

public class GameController implements Initializable {

	
  // @author Kyle Horsman
  
  	/**
	 * Adds the ability to control the snake to the scene
	 * @param scene
	 * @param snake
	 * @return scene
	 */
	public Scene addController(Scene scene, Snake snake){
		scene.setOnKeyPressed(new EventHandler<KeyEvent>(){

			@Override
			public void handle(KeyEvent k) {
				switch(k.getCode().toString()){
			  		case "UP":
			  			snake.setDirection(1);
			  			break;
			  		case "DOWN":
			  			snake.setDirection(3);
			  			break;
			  		case "LEFT":
			  			snake.setDirection(4);
			  			break;
			  		case "RIGHT":
			  			snake.setDirection(2);
			  			break;
				}
			}
		
		});
		return scene;
	}
  
	
	
	/**
	 * the logic for running the game
	 * @param s : the snake
	 * @param b	: the bounds of the playing screen
	 */
	public void startGame(Snake s, Bounds b){
		
		s.setX(b.getMaxX() / 2);
		s.setY(b.getMaxY() / 2);
		Pellet p = new Pellet();
		p.move();
		
		while(true){
			if(s.getX() >= b.getMaxX() || s.getX() <= b.getMinX()
					|| s.getY() >= b.getMaxY() || s.getY() <= b.getMinY()){
				//game over do something
				break;
			}
			if(s.collideWith(p)){
				s.collideResponse(p);
				p.collideResponse(s);
			}
		}
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		int x = 800;
		int y = 800;
		Pane pane = new Pane();
		Bounds bound = pane.getBoundsInLocal();
		Snake snake = new Snake();
		Scene scene = new Scene(pane, x, y);
		scene = addController(scene, snake);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
		startGame(snake, bound);
	}
  
}
