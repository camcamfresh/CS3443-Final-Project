package application.controller;

import java.util.ArrayList;

import application.model.HighScore;
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
		ArrayList<HighScore> users = HighScore.getAllUserScores();
		int usersSize = users.size();
		
		if(usersSize > 0) {
			HighScore user = users.get(0);
			name1.setText(user.getName());
			score1.setText(String.valueOf(user.getScore()));
			name1.setVisible(true);
			score1.setVisible(true);
		}
		
		if(usersSize > 1) {
			HighScore user = users.get(1);
			name2.setText(user.getName());
			score2.setText(String.valueOf(user.getScore()));
			name2.setVisible(true);
			score2.setVisible(true);
		}
		
		if(usersSize > 2) {
			HighScore user = users.get(2);
			name3.setText(user.getName());
			score3.setText(String.valueOf(user.getScore()));
			name3.setVisible(true);
			score3.setVisible(true);
		}
		
		if(usersSize > 3) {
			HighScore user = users.get(3);
			name4.setText(user.getName());
			score4.setText(String.valueOf(user.getScore()));
			name4.setVisible(true);
			score4.setVisible(true);
		}
		
		if(usersSize > 4) {
			HighScore user = users.get(4);
			name5.setText(user.getName());
			score5.setText(String.valueOf(user.getScore()));
			name5.setVisible(true);
			score5.setVisible(true);
		}
		
	}
	
}
