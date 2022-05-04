package gui;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
import javafx.util.Duration;

public class HomePageController implements Initializable{
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		exitGame.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
		
		FadeTransition ft = new FadeTransition(Duration.millis(3000), nav);
		ft.setFromValue (0.01);
		ft.setToValue (1.0);
		ft.play();
		FadeTransition ft2 = new FadeTransition(Duration.millis(7000), ufo);
		ft2.setFromValue (0.01);
		ft2.setToValue (1.0);
		ft2.play();
		
		Path path = new Path();
		path.getElements().add(new MoveTo(0, 0));
		path.getElements().add(new LineTo(100, 70));
		PathTransition pathTransition = new PathTransition(Duration.millis(5000), path);
		pathTransition.setNode(nav);
		pathTransition.play();
		
		RotateTransition rt = new RotateTransition(Duration. millis(3000), ufo);
		rt.setByAngle(-120);
		rt.setCycleCount(Timeline.INDEFINITE);
		rt.setAutoReverse(true);
		rt.play(); 
	}
	
	SceneController sc = SceneController.getSceneController();
	
	@FXML
	private Button startGame;
	@FXML
	private Button exitGame;
	@FXML
	private Button options;
	@FXML
	private MenuBar menu;
	@FXML
	private MenuItem Configuration;
	@FXML
	private MenuItem Modeles;
	@FXML
	private MenuItem about;
	@FXML
	private ImageView ufo;
	@FXML
	private ImageView nav;
	
	public void onClickAbout(ActionEvent event) throws IOException {
		Main.mediaPlayer2.play();
		Main.mediaPlayer2.seek(Duration.millis(0));
		Stage window = (Stage) (startGame).getScene().getWindow();
		window.setScene(sc.getAbout());
		window.show();
	}
	
	public void onClickOptions(ActionEvent event) throws IOException {
		Main.mediaPlayer2.play();
		Main.mediaPlayer2.seek(Duration.millis(0));
		Stage window = (Stage) (options).getScene().getWindow();
		window.setScene(sc.getOptions());
		window.show();
	}
	
	public void onClickStartGame(ActionEvent event) throws IOException {
		Main.mediaPlayer2.play();
		Main.mediaPlayer2.seek(Duration.millis(0));
		Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
		window.setScene(sc.getMenu());
		window.show();
	}
	
	public void onClickExitGame(ActionEvent event) throws IOException {
		Main.mediaPlayer2.play();
		Main.mediaPlayer2.seek(Duration.millis(0));
		Stage stage = (Stage) exitGame.getScene().getWindow();
	    stage.close();
	}
	
	public void onClickMenuConfiguration(ActionEvent event) throws IOException {
		Main.mediaPlayer2.play();
		Main.mediaPlayer2.seek(Duration.millis(0));
		Stage window = (Stage) (startGame).getScene().getWindow();
		window.setScene(sc.getConf());
		window.show();
	}
	
	public void onClickMenuModeles(ActionEvent event) throws IOException {
		Main.mediaPlayer2.play();
		Main.mediaPlayer2.seek(Duration.millis(0));
		Stage window = (Stage) (startGame).getScene().getWindow();
		window.setScene(sc.getMod());
		window.show();
	}

}
