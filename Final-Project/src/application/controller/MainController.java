package application.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * 
 * @author Cameron
 * This is the Controller for the Main.fxml
 */

public class MainController implements EventHandler<ActionEvent>{
	
	@FXML
	private Button startButton, scoreButton, exitButton;

	/**
	 * This is the handle method it takes an ActionEvent from button clicks on Main.fxml
	 */
	@Override
	public void handle(ActionEvent event) {
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		
		if(event.getSource() == startButton) {
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/Game.fxml"));
				Parent root = (Parent) loader.load();
				stage.setScene(new Scene(root));
				stage.show();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(event.getSource() == scoreButton) {
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/Score.fxml"));
				Parent root = (Parent) loader.load();
				
				ScoreController controller = loader.getController();
				controller.init();
				
				stage.setScene(new Scene(root));
				stage.show();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(event.getSource() == exitButton) {
			Platform.exit();
			System.exit(0);	
		}
		
	}	
}
