package application.controller;

public class GameController implements Initializable {

	
  // @author Kyle Horsman
  // WIP
  
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
  
	public void startGame(Snake s, Bounds b){
		
		Pellet p = new Pellet();
		
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
		startGame(snake, bound);
	}
  
}
