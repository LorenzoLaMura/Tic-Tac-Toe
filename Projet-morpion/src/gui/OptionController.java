package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;
import javafx.util.Duration;

public class OptionController {
	
	@FXML
	private CheckBox audio1;
	@FXML
	private CheckBox audio2;
	@FXML
	private Button retour;
	
	static int a1 = 0;
	static int a2 = 0;
	
	SceneController sc = SceneController.getSceneController();
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	}
	
	public void onClickAudio1(ActionEvent event) {
		if(a1==0) {
			Main.mediaPlayer2.play();
			Main.mediaPlayer2.seek(Duration.millis(0));
			Main.mediaPlayer.stop();
			a1++; 
		}
		else {
			Main.mediaPlayer2.play();
			Main.mediaPlayer2.seek(Duration.millis(0));
			Main.mediaPlayer.play();
			Main.mediaPlayer.setOnEndOfMedia(new Runnable() {
				public void run() {
					Main.mediaPlayer.seek(Duration.ZERO);
					Main.mediaPlayer.setVolume(0.3);
				}
			});
			a1=0;
		}
	}
	
	public void onClickAudio2(ActionEvent event) {
		if(a2==0) {
			Main.restart.setVolume(0);
			Main.draw.setVolume(0);
			Main.lose.setVolume(0);
			Main.win.setVolume(0);
			Main.mediaPlayer2.setVolume(0);
			a2++;
		}
		else {
			Main.restart.setVolume(Main.volumerestart);
			Main.draw.setVolume(Main.volumedraw);
			Main.lose.setVolume(Main.volumelose); 
			Main.win.setVolume(Main.volumewin);
			Main.mediaPlayer2.setVolume(Main.volumeclick);
			Main.mediaPlayer2.play();
			Main.mediaPlayer2.seek(Duration.millis(0));
			a2=0;
		}
	}
	
	public void onClickButtonRetour(ActionEvent event) throws IOException {
		Main.mediaPlayer2.play();
		Main.mediaPlayer2.seek(Duration.millis(0));
		//Human vs IA
		Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
		window.setScene(sc.getHome());
		window.show();
	}
	
}
