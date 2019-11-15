package application.controller;

public class GameController implements Initializable {

	
  // @author Kyle Horsman
  // WIP
  
  public class Controller {
		public Controller(Scene scene, Snake snake){
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
		}
	}
  
  @Override
  public void initialize(URL arg0, ResourceBundle arg1) {
		Snake s = new Snake();
		Controller c = new Controller(scene, s);  // get scene somehow
		  
  }
  
}
