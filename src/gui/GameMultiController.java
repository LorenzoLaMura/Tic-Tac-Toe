package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GameMultiController implements  Initializable{

	@FXML
	private Button restart;
	@FXML
	private Text text;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub 
		text.setVisible(false);
		retour.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
		restart.setBackground(new Background(new BackgroundFill(Color.GREEN, null, null)));
	} 
	
	SceneController sc = SceneController.getSceneController();
	private int[] isClicked = {0,0,0,0,0,0,0,0,0}; //if 0 not clicked, else clicked
	private int[] wichPlayer = {-1,-1,-1,-1,-1,-1,-1,-1,-1}; //if 0 player 1, if 1 player 2
	private int tour = 0; //if 0 player 1 play, if 1 player 2 play
	
	@FXML
	private ImageView a012;
	@FXML
	private ImageView a345;
	@FXML
	private ImageView a678;
	@FXML
	private ImageView a036;
	@FXML
	private ImageView a147;
	@FXML
	private ImageView a258;
	@FXML
	private ImageView a048;
	@FXML
	private ImageView a246;
	@FXML
	private ImageView ra0;
	@FXML
	private ImageView ra1;
	@FXML
	private ImageView ra2;
	@FXML
	private ImageView ra3;
	@FXML
	private ImageView ra4;
	@FXML
	private ImageView ra5;
	@FXML
	private ImageView ra6;
	@FXML
	private ImageView ra7;
	@FXML
	private ImageView ra8;
	@FXML
	private ImageView ua0;
	@FXML
	private ImageView ua1;
	@FXML
	private ImageView ua2;
	@FXML
	private ImageView ua3;
	@FXML
	private ImageView ua4;
	@FXML
	private ImageView ua5;
	@FXML
	private ImageView ua6;
	@FXML
	private ImageView ua7;
	@FXML
	private ImageView ua8;
	@FXML
	private Button retour;
	@FXML
	private Rectangle a1;
	@FXML
	private Rectangle a2;
	@FXML
	private Rectangle a3;
	@FXML
	private Rectangle b1;
	@FXML
	private Rectangle b2;
	@FXML
	private Rectangle b3;
	@FXML
	private Rectangle c1;
	@FXML
	private Rectangle c2;
	@FXML
	private Rectangle c3;
	
	public void Rinitialise() {
		text.setVisible(false);
		text.setText("");
		a012.setVisible(false);
		a345.setVisible(false);
		a678.setVisible(false);
		a036.setVisible(false);
		a147.setVisible(false);
		a258.setVisible(false);
		a048.setVisible(false);
		a246.setVisible(false);
		ra0.setVisible(false);
		ra1.setVisible(false);
		ra2.setVisible(false);
		ra3.setVisible(false);
		ra4.setVisible(false);
		ra5.setVisible(false);
		ra6.setVisible(false);
		ra7.setVisible(false);
		ra8.setVisible(false);
		ua0.setVisible(false);
		ua1.setVisible(false);
		ua2.setVisible(false);
		ua3.setVisible(false);
		ua4.setVisible(false);
		ua5.setVisible(false);
		ua6.setVisible(false);
		ua7.setVisible(false);
		ua8.setVisible(false);
		for(int i=0;i<=8;i++) {
			isClicked[i]=0;
			wichPlayer[i]=-1;
			tour = 0;
		}
	}
	
	public void OnClickRestart(ActionEvent event) {
		Rinitialise();
		Main.restart.play();
		Main.restart.seek(Duration.millis(0));
	}
	
	public void onClickButtonRetour(ActionEvent event) throws IOException {
		Rinitialise();
		Main.mediaPlayer2.play();
		Main.mediaPlayer2.seek(Duration.millis(0));
		//Human vs IA
		Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
		window.setScene(sc.getMenu());
		window.show();
	}
	
	public int verifyWin() {
		//verifier s'il y a un gagnant
		if(isClicked[0]==1 && isClicked[1]==1 && isClicked[2]==1) {
			if(wichPlayer[0]==1 && wichPlayer[1]==1 && wichPlayer[2]==1) {
				Main.win.play();
				Main.win.seek(Duration.millis(0));
				a012.setVisible(true);
				text.setVisible(true);
				text.setText("Player2 win");
				return 1;
			}
			else if(wichPlayer[0]==0 && wichPlayer[1]==0 && wichPlayer[2]==0) {
				Main.win.play();
				Main.win.seek(Duration.millis(0));
				a012.setVisible(true);
				text.setVisible(true);
				text.setText("Player1 win");
				return 0;
			}
		}
		if(isClicked[3]==1 && isClicked[4]==1 && isClicked[5]==1) {
			if(wichPlayer[3]==1 && wichPlayer[4]==1 && wichPlayer[5]==1) {
				Main.win.play();
				Main.win.seek(Duration.millis(0));
				a345.setVisible(true);
				text.setVisible(true);
				text.setText("Player2 win");
				return 1;
			}
			else if(wichPlayer[3]==0 && wichPlayer[4]==0 && wichPlayer[5]==0) {
				Main.win.play();
				Main.win.seek(Duration.millis(0));
				a345.setVisible(true);
				text.setVisible(true);
				text.setText("Player1 win");
				return 0;
			}
		}
		if(isClicked[6]==1 && isClicked[7]==1 && isClicked[8]==1) {
			if(wichPlayer[6]==1 && wichPlayer[7]==1 && wichPlayer[8]==1) {
				Main.win.play();
				Main.win.seek(Duration.millis(0));
				a678.setVisible(true);
				text.setVisible(true);
				text.setText("Player2 win");
				return 1;
			}
			else if(wichPlayer[6]==0 && wichPlayer[7]==0 && wichPlayer[8]==0) {
				Main.win.play();
				Main.win.seek(Duration.millis(0));
				a678.setVisible(true);
				text.setVisible(true);
				text.setText("Player1 win");
				return 0;
			}
		}
		if(isClicked[0]==1 && isClicked[3]==1 && isClicked[6]==1) {
			if(wichPlayer[0]==1 && wichPlayer[3]==1 && wichPlayer[6]==1) {
				Main.win.play();
				Main.win.seek(Duration.millis(0));
				a036.setVisible(true);
				text.setVisible(true);
				text.setText("Player2 win");
				return 1;
			}
			else if(wichPlayer[0]==0 && wichPlayer[3]==0 && wichPlayer[6]==0) {
				Main.win.play();
				Main.win.seek(Duration.millis(0));
				a036.setVisible(true);
				text.setVisible(true);
				text.setText("Player1 win");
				return 0;
			}
		}
		if(isClicked[1]==1 && isClicked[4]==1 && isClicked[7]==1) {
			if(wichPlayer[1]==1 && wichPlayer[4]==1 && wichPlayer[7]==1) {
				Main.win.play();
				Main.win.seek(Duration.millis(0));
				a147.setVisible(true);
				text.setVisible(true);
				text.setText("Player2 win");
				return 1;
			}
			else if(wichPlayer[1]==0 && wichPlayer[4]==0 && wichPlayer[7]==0) {
				Main.win.play();
				Main.win.seek(Duration.millis(0));
				a147.setVisible(true);
				text.setVisible(true);
				text.setText("Player1 win");
				return 0;
			}
		}
		if(isClicked[2]==1 && isClicked[5]==1 && isClicked[8]==1) {
			if(wichPlayer[2]==1 && wichPlayer[5]==1 && wichPlayer[8]==1) {
				Main.win.play();
				Main.win.seek(Duration.millis(0));
				a258.setVisible(true);
				text.setVisible(true);
				text.setText("Player2 win");
				return 1;
			}
			else if(wichPlayer[2]==0 && wichPlayer[5]==0 && wichPlayer[8]==0) {
				Main.win.play();
				Main.win.seek(Duration.millis(0));
				a258.setVisible(true);
				text.setVisible(true);
				text.setText("Player1 win");
				return 0;
			}
		}
		if(isClicked[0]==1 && isClicked[4]==1 && isClicked[8]==1) {
			if(wichPlayer[0]==1 && wichPlayer[4]==1 && wichPlayer[8]==1) {
				Main.win.play();
				Main.win.seek(Duration.millis(0));
				a048.setVisible(true);
				text.setVisible(true);
				text.setText("Player2 win");
				return 1;
			}
			else if(wichPlayer[0]==0 && wichPlayer[4]==0 && wichPlayer[8]==0) {
				Main.win.play();
				Main.win.seek(Duration.millis(0));
				a048.setVisible(true);
				text.setVisible(true);
				text.setText("Player1 win");
				return 0;
			}
		}
		if(isClicked[6]==1 && isClicked[4]==1 && isClicked[2]==1) {
			if(wichPlayer[6]==1 && wichPlayer[4]==1 && wichPlayer[2]==1) {
				Main.win.play();
				Main.win.seek(Duration.millis(0));
				a246.setVisible(true);
				text.setVisible(true);
				text.setText("Player2 win");
				return 1;
			}
			else if(wichPlayer[6]==0 && wichPlayer[4]==0 && wichPlayer[2]==0) {
				Main.win.play();
				Main.win.seek(Duration.millis(0));
				a246.setVisible(true);
				text.setVisible(true);
				text.setText("Player1 win");
				return 0;
			}
		}
		if(isClicked[0]==1 && isClicked[1]==1 && isClicked[2]==1 && isClicked[3]==1 && isClicked[4]==1 && isClicked[5]==1 && isClicked[6]==1 && isClicked[7]==1 && isClicked[8]==1) {
			Main.draw.play();
			Main.draw.seek(Duration.millis(0));
			text.setVisible(true);
			text.setText("Draw");
			return -1;
		}	
		return -1;
	}
	
	public void onClicka1() {
		if(isClicked[0]==0) {
			Main.mediaPlayer2.play();
			Main.mediaPlayer2.seek(Duration.millis(0));
			isClicked[0]=1;
			if(tour==0) {
				ra0.setVisible(true);
				wichPlayer[0]=tour;
				tour=1;
			}
			else {
				ua0.setVisible(true);
				wichPlayer[0]=tour;
				tour=0;
			}
			verifyWin();
		}
	}
	public void onClicka2() {
		if(isClicked[1]==0) {
			Main.mediaPlayer2.play();
			Main.mediaPlayer2.seek(Duration.millis(0));
			isClicked[1]=1;
			if(tour==0) {
				ra1.setVisible(true);
				wichPlayer[1]=tour;
				tour=1;
			}
			else {
				ua1.setVisible(true);
				wichPlayer[1]=tour;
				tour=0;
			}
			verifyWin();
		}
	}
	public void onClicka3() {
		if(isClicked[2]==0) {
			Main.mediaPlayer2.play();
			Main.mediaPlayer2.seek(Duration.millis(0));
			isClicked[2]=1;
			if(tour==0) {
				ra2.setVisible(true);
				wichPlayer[2]=tour;
				tour=1;
			}
			else {
				ua2.setVisible(true);
				wichPlayer[2]=tour;
				tour=0;
			}
			verifyWin();
		}
	}
	
	public void onClickb1() {
		if(isClicked[3]==0) {
			Main.mediaPlayer2.play();
			Main.mediaPlayer2.seek(Duration.millis(0));
			isClicked[3]=1;
			if(tour==0) {
				ra3.setVisible(true);
				wichPlayer[3]=tour;
				tour=1;
			}
			else {
				ua3.setVisible(true);
				wichPlayer[3]=tour;
				tour=0;
			}
			verifyWin();
		}
	}
	public void onClickb2() {
		if(isClicked[4]==0) {
			Main.mediaPlayer2.play();
			Main.mediaPlayer2.seek(Duration.millis(0));
			isClicked[4]=1;
			if(tour==0) {
				ra4.setVisible(true);
				wichPlayer[4]=tour;
				tour=1;
			}
			else {
				ua4.setVisible(true);
				wichPlayer[4]=tour;
				tour=0;
			}
			verifyWin();
		}
	}
	public void onClickb3() {
		if(isClicked[5]==0) {
			Main.mediaPlayer2.play();
			Main.mediaPlayer2.seek(Duration.millis(0));
			isClicked[5]=1;
			if(tour==0) {
				ra5.setVisible(true);
				wichPlayer[5]=tour;
				tour=1;
			}
			else {
				ua5.setVisible(true);
				wichPlayer[5]=tour;
				tour=0;
			}
			verifyWin();
		}
	}
	
	public void onClickc1() {
		if(isClicked[6]==0) {
			Main.mediaPlayer2.play();
			Main.mediaPlayer2.seek(Duration.millis(0));
			isClicked[6]=1;
			if(tour==0) {
				ra6.setVisible(true);
				wichPlayer[6]=tour;
				tour=1;
			}
			else {
				ua6.setVisible(true);
				wichPlayer[6]=tour;
				tour=0;
			}
			verifyWin();
		}
	}
	public void onClickc2() {
		if(isClicked[7]==0) {
			Main.mediaPlayer2.play();
			Main.mediaPlayer2.seek(Duration.millis(0));
			isClicked[7]=1;
			if(tour==0) {
				ra7.setVisible(true);
				wichPlayer[7]=tour;
				tour=1;
			}
			else {
				ua7.setVisible(true);
				wichPlayer[7]=tour;
				tour=0;
			}
			verifyWin();
		}
	}
	public void onClickc3() {
		if(isClicked[8]==0) {
			Main.mediaPlayer2.play();
			Main.mediaPlayer2.seek(Duration.millis(0));
			isClicked[8]=1;
			if(tour==0) {
				ra8.setVisible(true);
				wichPlayer[8]=tour;
				tour=1;
			}
			else {
				ua8.setVisible(true);
				wichPlayer[8]=tour;
				tour=0;
			}
			verifyWin();
		}
	}

}
