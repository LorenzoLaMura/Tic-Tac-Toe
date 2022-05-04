package gui;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javafx.util.Duration;

public class AboutController implements Initializable{
	
	SceneController sc = SceneController.getSceneController();
 
	@FXML
	private Button valider;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) { 
	}
	
	public void onClickRetour(ActionEvent event) throws IOException {
		Main.mediaPlayer2.play();
		Main.mediaPlayer2.seek(Duration.millis(0));
		Stage window = (Stage) (valider).getScene().getWindow();
		window.setScene(sc.getHome());
		window.show();
	}
}
