package gui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ConfigurationController implements Initializable{
	
	SceneController sc = SceneController.getSceneController();
	
	@FXML
	private Button set;
	@FXML
	private Button retour;
	@FXML
	private TextField h_facile;
	@FXML
	private TextField l_facile;
	@FXML
	private TextField lr_facile;
	@FXML
	private TextField h_difficile;
	@FXML
	private TextField l_difficile;
	@FXML
	private TextField lr_difficile;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
		// TODO Auto-generated method stub
		String file = "resources/config.txt";
		BufferedReader br;
		br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(file))));
		String facile = br.readLine();
		String difficile = br.readLine();
		String[] tabFacile = facile.split(":");
		String[] tabDifficile = difficile.split(":");
		h_facile.setText(tabFacile[1]);
		h_difficile.setText(tabDifficile[1]);
		lr_facile.setText(tabFacile[2]);
		lr_difficile.setText(tabDifficile[2]);
		l_facile.setText(tabFacile[3]);
		l_difficile.setText(tabDifficile[3]);
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void OnClickSet(ActionEvent event) throws IOException {
		Main.mediaPlayer2.play();
		Main.mediaPlayer2.seek(Duration.millis(0));
		String file = "resources/config.txt";
		BufferedWriter br = new BufferedWriter(new FileWriter(file));
		br.write("F:"+h_facile.getText()+":"+lr_facile.getText()+":"+l_facile.getText());
		br.newLine();
		br.write("D:"+h_difficile.getText()+":"+lr_difficile.getText()+":"+l_difficile.getText());
		br.newLine();
		br.close();
	}
	
	public void onClickRetour(ActionEvent event) throws IOException {
		String file = "resources/config.txt";
		BufferedReader br;
		br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(file))));
		String facile = br.readLine();
		String difficile = br.readLine();
		String[] tabFacile = facile.split(":");
		String[] tabDifficile = difficile.split(":");
		h_facile.setText(tabFacile[1]);
		h_difficile.setText(tabDifficile[1]);
		lr_facile.setText(tabFacile[2]);
		lr_difficile.setText(tabDifficile[2]);
		l_facile.setText(tabFacile[3]);
		l_difficile.setText(tabDifficile[3]);
		Main.mediaPlayer2.play();
		Main.mediaPlayer2.seek(Duration.millis(0));
		Stage window = (Stage) (set).getScene().getWindow();
		window.setScene(sc.getHome());
		window.show(); 
	}

}
