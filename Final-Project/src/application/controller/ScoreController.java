package application.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ScoreController implements EventHandler<ActionEvent>{
	
	@FXML
	private Label name1, name2, name3, name4, name5,
				score1, score2, score3, score4, score5;
	
	@FXML
	private Button menuButton;
	
	@Override
	public void handle(ActionEvent event) {
		if(event.getSource() == menuButton) {
			try {
				Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/Main.fxml"));
				Parent root = (Parent) loader.load();
				stage.setScene(new Scene(root));
				stage.show();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * This method initializes the object by loading the scores provided in the HighScore Model.
	 * It should be called before the stage is shown.
	 */
	public void init() {
		
	}
	
}