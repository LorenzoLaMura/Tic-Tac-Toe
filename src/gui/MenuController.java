package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MenuController implements Initializable{
	
	static public int niveau=0;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		back.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));		
	} 
	
	SceneController sc = SceneController.getSceneController();
	
	@FXML
	private Button HvsH;
	@FXML
	private Button HvsIA;
	@FXML
	private Button back;
	@FXML
	private CheckBox facile;
	@FXML
	private CheckBox difficile;
	@FXML
	private MenuBar menu;
	@FXML
	private MenuItem Configuration;
	@FXML
	private MenuItem Modeles;
	@FXML
	private MenuItem about;
	
	public void onClickAbout(ActionEvent event) throws IOException {
		Main.mediaPlayer2.play();
		Main.mediaPlayer2.seek(Duration.millis(0));
		Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
		window.setScene(sc.getAbout());
		window.show();
	}
	
	public void onClickButtonHvsH(ActionEvent event) throws IOException {
		Main.mediaPlayer2.play();
		Main.mediaPlayer2.seek(Duration.millis(0));
		//Human vs Human
		Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
		window.setScene(sc.getHvsH());
		window.show();
	}
	
	public void onClickButtonBack(ActionEvent event) throws IOException {
		Main.mediaPlayer2.play();
		Main.mediaPlayer2.seek(Duration.millis(0));
		//Human vs IA
		Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
		window.setScene(sc.getHome());
		window.show();
	}
	
	public void onClickButtonHvsIA(ActionEvent event) throws IOException {
		Main.mediaPlayer2.play();
		Main.mediaPlayer2.seek(Duration.millis(0));
		//Human vs IA
		Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
		window.setScene(sc.getApprantissage());
		window.show();
	}
	
	public void onClickFacile() {
		niveau = 0;
		Main.mediaPlayer2.play();
		Main.mediaPlayer2.seek(Duration.millis(0));
		boolean f = (boolean) facile.isSelected();
		boolean d = (boolean) difficile.isSelected();
		if(f==false && d==false) {
			facile.setSelected(true);
		}
		else if(f==true) {
			difficile.setSelected(false);
		}

	}
	
	public void onClickDifficile() {
		niveau = 1;
		Main.mediaPlayer2.play();
		Main.mediaPlayer2.seek(Duration.millis(0));
		boolean f = (boolean) facile.isSelected();
		boolean d = (boolean) difficile.isSelected();
		if(f==false && d==false) {
			difficile.setSelected(true);
		}
		else if(d==true) {
			facile.setSelected(false);
		}
	}
	
	public void onClickMenuConfiguration() {
		System.out.println("Configurationnnn");
	}
	
	public void onClickMenuModeles() {
		System.out.println("Modeles");
	}

}
