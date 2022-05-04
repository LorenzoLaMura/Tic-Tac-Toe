package gui;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class SceneController {

	static SceneController sc;
	private static Scene menu;
	private static Scene apprantissage;
	private static Scene home;
	private static Scene conf;
	private static Scene mod;
	private static Scene hvsh;
	private static Scene options;
	private static Scene about;
	private static Scene hvsia;
	
	
	public SceneController() {
		super();
	}
	

	static public SceneController getSceneController() {
		if (sc == null ) {
			sc = new SceneController();
		}
		return sc;
	}
	
	public Scene getHVAI() throws IOException {
		if (hvsia == null) {
			hvsia = new Scene((Parent) FXMLLoader.load(getClass().getResource("GameAI.fxml")));
		}
		return hvsia;
	}
	
	public Scene getAbout() throws IOException {
		if (about == null) {
			about = new Scene((Parent) FXMLLoader.load(getClass().getResource("about.fxml")));
		}
		return about;
	}

	public Scene getMenu() throws IOException {
		if (menu == null) {
			menu = new Scene((Parent) FXMLLoader.load(getClass().getResource("menu.fxml")));
		}
		return menu;
	}
	
	public Scene getOptions() throws IOException {
		if (options == null) {
			options = new Scene((Parent) FXMLLoader.load(getClass().getResource("option.fxml")));
		}
		return options;
	}
 
	public Scene getApprantissage() throws IOException {
		if (apprantissage == null) {
			apprantissage = new Scene((Parent) FXMLLoader.load(getClass().getResource("apprantissage.fxml")));
		}
		return apprantissage;
	}
	
	public Scene getHome() throws IOException {
		if (home == null) {
			home = new Scene((Parent) FXMLLoader.load(getClass().getResource("homePage.fxml")));
		}
		return home;
	}
	
	public Scene getConf() throws IOException {
		if (conf == null) {
			conf = new Scene((Parent) FXMLLoader.load(getClass().getResource("configuration.fxml")));
		}
		return conf;
	}
	
	public Scene getMod() throws IOException {
		if (mod == null) {
			mod = new Scene((Parent) FXMLLoader.load(getClass().getResource("modeles.fxml")));
		}
		return mod;
	}
	
	public Scene getHvsH() throws IOException {
		if (hvsh == null) {
			hvsh = new Scene((Parent) FXMLLoader.load(getClass().getResource("gameMulti.fxml")));
		}
		return hvsh;
	}
	
}
