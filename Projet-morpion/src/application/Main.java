package application;
	
import java.nio.file.Paths;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Main extends Application {
	
	static String media = "resources/Confusion.mp3";
	static Media m = new Media(Paths.get(media).toUri().toString());
	public static MediaPlayer mediaPlayer = new MediaPlayer(m);
	static String media2 = "resources/MouseClick.mp3";
	static Media m2 = new Media(Paths.get(media2).toUri().toString());
	public static MediaPlayer mediaPlayer2 = new MediaPlayer(m2); 
	static String media3 = "resources/win.mp3" ;
	static Media m3 = new Media(Paths.get(media3).toUri().toString());
	public static MediaPlayer win = new MediaPlayer(m3); 
	static String media4 = "resources/lose.mp3";
	static Media m4 = new Media(Paths.get(media4).toUri().toString());
	public static MediaPlayer lose = new MediaPlayer(m4); 
	static String media5 = "resources/draw.mp3";
	static Media m5 = new Media(Paths.get(media5).toUri().toString());
	public static MediaPlayer draw = new MediaPlayer(m5); 
	static String media6 = "resources/restart.mp3"; 
	static Media m6 = new Media(Paths.get(media6).toUri().toString());
	public static MediaPlayer restart = new MediaPlayer(m6); 
	public static double volumeclick = mediaPlayer2.getVolume();
	public static double volumewin = win.getVolume();
	public static double volumelose = lose.getVolume();
	public static double volumedraw = draw.getVolume();
	public static double volumerestart = restart.getVolume();
	
	@Override 
	public void start(Stage primaryStage) {
		try {
			mediaPlayer.play();
			mediaPlayer.setVolume(0.3);
			mediaPlayer.setOnEndOfMedia(new Runnable() {
				public void run() {
					mediaPlayer.seek(Duration.ZERO);
					mediaPlayer.setVolume(0.3);
				}
			});
			mediaPlayer.play();
			Parent root = (Parent) FXMLLoader.load(getClass().getResource("/gui/homePage.fxml"));
			primaryStage.setTitle("MORPION");
			primaryStage.setScene(new Scene(root,650,495));
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
