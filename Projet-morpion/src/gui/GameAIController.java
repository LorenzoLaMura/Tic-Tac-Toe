package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import ai.MultiLayerPerceptron;
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

public class GameAIController implements  Initializable{

	double[] output = new double[9];
	
	@FXML
	private Button restart;
	@FXML
	private Text text;
	
	SceneController sc = SceneController.getSceneController();
	private double[] isClicked = {0,0,0,0,0,0,0,0,0}; //if 0 not clicked, else clicked
	private double[] clicked = {0,0,0,0,0,0,0,0,0}; //if 0 not clicked, 1 clicked by Human et 0 clicked by AI
	private int[] wichPlayer = {-1,-1,-1,-1,-1,-1,-1,-1,-1}; //if 0 player 1, if 1 player 2
	private int tour = 0; //if 0 player 1 play, if 1 player 2 play
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub 
		text.setVisible(false);
		retour.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
		restart.setBackground(new Background(new BackgroundFill(Color.GREEN, null, null)));
	} 
	
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
				Main.lose.play();
				Main.lose.seek(Duration.millis(0));
				a012.setVisible(true);
				text.setVisible(true);
				text.setText("AI win");
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
				Main.lose.play();
				Main.lose.seek(Duration.millis(0));
				a345.setVisible(true);
				text.setVisible(true);
				text.setText("AI win");
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
				Main.lose.play();
				Main.lose.seek(Duration.millis(0));
				a678.setVisible(true);
				text.setVisible(true);
				text.setText("AI win");
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
				Main.lose.play();
				Main.lose.seek(Duration.millis(0));
				a036.setVisible(true);
				text.setVisible(true);
				text.setText("AI win");
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
				Main.lose.play();
				Main.lose.seek(Duration.millis(0));
				a147.setVisible(true);
				text.setVisible(true);
				text.setText("AI win");
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
				Main.lose.play();
				Main.lose.seek(Duration.millis(0));
				a258.setVisible(true);
				text.setVisible(true);
				text.setText("AI win");
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
				Main.lose.play();
				Main.lose.seek(Duration.millis(0));
				a048.setVisible(true);
				text.setVisible(true);
				text.setText("AI win");
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
				Main.lose.play();
				Main.lose.seek(Duration.millis(0));
				a246.setVisible(true);
				text.setVisible(true);
				text.setText("AI win");
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
	
	public void caseClick(int max) {
		if(max == 0) {
			onClicka1();
		}
		else if(max == 1) {
			onClicka2();
		}
		else if(max == 2) {
			onClicka3();
		}
		else if(max == 3) {
			onClickb1();
		}
		else if(max == 4) {
			onClickb2();
		}
		else if(max == 5) {
			onClickb3();
		}
		else if(max == 6) {
			onClickc1();
		}
		else if(max == 7) {
			onClickc2();
		}
		else if(max == 8) {
			onClickc3();
		}
	}
	
	public void choisirCase() {
		output = ApprantissageController.net.forwardPropagation(clicked);
		int max = 0;
		double max2 = 0;
		for(int i=0; i<9; i++) {
			if(isClicked[i]==0) {
				max = i;
				max2 = output[0];
				break;
			}
		}
		for(int i1=0; i1<9; i1++) {
			if(max2<output[i1] && isClicked[i1]==0) {
				max2=output[i1];
				max=i1;
			}
		}
		System.out.println(max);
		caseClick(max);
	}
	
	public void onClicka1() {
		if(isClicked[0]==0) {
			Main.mediaPlayer2.play();
			Main.mediaPlayer2.seek(Duration.millis(0));
			isClicked[0]=1;
			if(tour==0) {
				clicked[0]=1;
				ra0.setVisible(true);
				wichPlayer[0]=tour;
				tour=1;
			}
			else {
				clicked[0]=-1;
				ua0.setVisible(true); 
				wichPlayer[0]=tour;
				tour=0;
			}
			int n = verifyWin();
			if(tour==1 && n==-1)
				choisirCase();
		}
	}
	public void onClicka2() {
		if(isClicked[1]==0) {
			Main.mediaPlayer2.play();
			Main.mediaPlayer2.seek(Duration.millis(0));
			isClicked[1]=1;
			if(tour==0) {
				clicked[1]=1;
				ra1.setVisible(true);
				wichPlayer[1]=tour;
				tour=1;
			}
			else {
				clicked[1]=-1;
				ua1.setVisible(true);
				wichPlayer[1]=tour;
				tour=0;
			}
			verifyWin();
			int n = verifyWin();
			if(tour==1 && n==-1)
				choisirCase();
		}
	}
	public void onClicka3() {
		if(isClicked[2]==0) {
			Main.mediaPlayer2.play();
			Main.mediaPlayer2.seek(Duration.millis(0));
			isClicked[2]=1;
			if(tour==0) {
				clicked[2]=1;
				ra2.setVisible(true);
				wichPlayer[2]=tour;
				tour=1;
			}
			else {
				clicked[2]=-1;
				ua2.setVisible(true);
				wichPlayer[2]=tour;
				tour=0;
			}
			verifyWin();
			int n = verifyWin();
			if(tour==1 && n==-1)
				choisirCase();
		}
	}
	
	public void onClickb1() {
		if(isClicked[3]==0) {
			Main.mediaPlayer2.play();
			Main.mediaPlayer2.seek(Duration.millis(0));
			isClicked[3]=1;
			if(tour==0) {
				clicked[3]=1;
				ra3.setVisible(true);
				wichPlayer[3]=tour;
				tour=1;
			}
			else {
				clicked[3]=-1;
				ua3.setVisible(true);
				wichPlayer[3]=tour;
				tour=0;
			}
			verifyWin();
			int n = verifyWin();
			if(tour==1 && n==-1)
				choisirCase();
		}
	}
	public void onClickb2() {
		if(isClicked[4]==0) {
			Main.mediaPlayer2.play();
			Main.mediaPlayer2.seek(Duration.millis(0));
			isClicked[4]=1;
			if(tour==0) {
				clicked[4]=1;
				ra4.setVisible(true);
				wichPlayer[4]=tour;
				tour=1;
			}
			else {
				clicked[4]=-1;
				ua4.setVisible(true);
				wichPlayer[4]=tour;
				tour=0;
			}
			verifyWin();
			int n = verifyWin();
			if(tour==1 && n==-1)
				choisirCase();
		}
	}
	public void onClickb3() {
		if(isClicked[5]==0) {
			Main.mediaPlayer2.play();
			Main.mediaPlayer2.seek(Duration.millis(0));
			isClicked[5]=1;
			if(tour==0) {
				clicked[5]=1;
				ra5.setVisible(true);
				wichPlayer[5]=tour;
				tour=1;
			}
			else {
				clicked[5]=-1;
				ua5.setVisible(true);
				wichPlayer[5]=tour;
				tour=0;
			}
			verifyWin();
			int n = verifyWin();
			if(tour==1 && n==-1)
				choisirCase();
		}
	}
	
	public void onClickc1() {
		if(isClicked[6]==0) {
			Main.mediaPlayer2.play();
			Main.mediaPlayer2.seek(Duration.millis(0));
			isClicked[6]=1;
			if(tour==0) {
				clicked[6]=1;
				ra6.setVisible(true);
				wichPlayer[6]=tour;
				tour=1;
			}
			else {
				clicked[6]=-1;
				ua6.setVisible(true);
				wichPlayer[6]=tour;
				tour=0;
			}
			verifyWin();
			output = ApprantissageController.net.forwardPropagation(isClicked);
			int n = verifyWin();
			if(tour==1 && n==-1)
				choisirCase();
		}
	}
	public void onClickc2() {
		if(isClicked[7]==0) {
			Main.mediaPlayer2.play();
			Main.mediaPlayer2.seek(Duration.millis(0));
			isClicked[7]=1;
			if(tour==0) {
				clicked[7]=1;
				ra7.setVisible(true);
				wichPlayer[7]=tour;
				tour=1;
			}
			else {
				clicked[7]=-1;
				ua7.setVisible(true);
				wichPlayer[7]=tour;
				tour=0;
			}
			verifyWin();
			int n = verifyWin();
			if(tour==1 && n==-1)
				choisirCase();
		}
	}
	public void onClickc3() {
		if(isClicked[8]==0) {
			Main.mediaPlayer2.play();
			Main.mediaPlayer2.seek(Duration.millis(0));
			isClicked[8]=1;
			if(tour==0) {
				clicked[8]=1;
				ra8.setVisible(true);
				wichPlayer[8]=tour;
				tour=1;
			}
			else {
				clicked[8]=-1;
				ua8.setVisible(true);
				wichPlayer[8]=tour;
				tour=0;
			}
			verifyWin();
			int n = verifyWin();
			if(tour==1 && n==-1)
				choisirCase();
		}
	}

}
