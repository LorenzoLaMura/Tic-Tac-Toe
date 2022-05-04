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
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ModelesController implements Initializable{
	
	SceneController sc = SceneController.getSceneController();
	
	@FXML
	private ListView list; 
	@FXML
	private Button valider;
	@FXML
	private Button remove;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) { 
		// TODO Auto-generated method stub
		remove.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));		
		File dir  = new File("resources/models");
	    File[] liste = dir.listFiles();
	    for(File item : liste){
	    	if(item.isFile()) list.getItems().add(item.getName());
	    }
	}
	
	public void onClickRetour(ActionEvent event) throws IOException {
		Main.mediaPlayer2.play();
		Main.mediaPlayer2.seek(Duration.millis(0));
		Stage window = (Stage) (valider).getScene().getWindow();
		window.setScene(sc.getHome());
		window.show();
	}
	
	public void onClickRemove(ActionEvent event) throws IOException {		
		Main.mediaPlayer2.play();
		Main.mediaPlayer2.seek(Duration.millis(0));
		File file = new File("resources/models/" + list.getSelectionModel().getSelectedItem());
	    if(file.delete()) System.out.println(file.getName() + " est supprimé.");
	    else System.out.println("Opération de suppression echouée");
		list.getItems().remove(list.getSelectionModel().getSelectedItem());
	}
}
