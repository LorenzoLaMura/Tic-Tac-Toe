package gui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import ai.Coup;
import ai.MultiLayerPerceptron;
import ai.SigmoidalTransferFunction;
import ai.Test;
import application.Main;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ApprantissageController implements Initializable{
	
	@FXML
    private Button play;
	
	boolean modelExist;
	
	int a=0;
	
	public static MultiLayerPerceptron net; 
	
	SceneController sc = SceneController.getSceneController();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		play.setVisible(false);
		retour.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
		play.setBackground(new Background(new BackgroundFill(Color.GREEN, null, null)));
	}
	
	@FXML
    private TextArea msgBox;
	@FXML
    private Button btStart;
	@FXML
    private Button retour;
	@FXML
    private ProgressBar pgrBar;

	

    public void onClickPlay() throws IOException {
    	Main.mediaPlayer2.play();
		Main.mediaPlayer2.seek(Duration.millis(0));
		a=1;
		Stage window = (Stage) (btStart).getScene().getWindow();
		window.setScene(sc.getHVAI());
		window.show();
    }
    

	public void onClickButtonStart() throws IOException {
		System.out.println("valeur de a ="+a);
		Task<Void> task = new Task<>() { 
	        @Override protected Void call() throws Exception {
	        	try {
	        		Main.mediaPlayer2.play();
	        		Main.mediaPlayer2.seek(Duration.millis(0));
	        		
	        		String file = "resources/config.txt";
	        		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(file))));
	    			String facile = br.readLine();
	    			String difficile = br.readLine();
	    			String[] tabFacile = facile.split(":");
	    			String[] tabDifficile = difficile.split(":");
	    			int hf = Integer.parseInt(tabFacile[1]);
	    			int hd = Integer.parseInt(tabDifficile[1]);
	    			double lrf = Double.parseDouble(tabFacile[2]);
	    			double lrd = Double.parseDouble(tabDifficile[2]);
	    			int lf = Integer.parseInt(tabFacile[3]);
	    			int ld = Integer.parseInt(tabDifficile[3]);
	    			
	    			String fileModeFacile = "mlp_"+hf+"_"+lrf+"_"+lf+".srl";
	    			String fileModeDifficile = "mlp_"+hd+"_"+lrd+"_"+ld+".srl";
	    			
	    			if(MenuController.niveau==0) {
						//Si on selectionne le mode Facile
		    			if(new File("resources/models/"+fileModeFacile).exists()) {
		    				net = MultiLayerPerceptron.load("resources/models/"+fileModeFacile);
		    				if(net!=null) {
		    					System.out.println("pas vide");
		    				}
		    				modelExist=true;
		    			}
		    			else {
		    				modelExist=false;
		    				int layers[] = new int[lf+2];
		    				layers[0] = 9;
		    				for(int i=1; i<lf;i++) {
		    					layers[i] = hf;
		    					if(i+1==lf) {
		    						layers[i] = 9;
		    						layers[i+1] = hf;
		    					}
		    				}
		    				net = new MultiLayerPerceptron(layers, lrf, new SigmoidalTransferFunction());
		    			} 
	    			}
	    			else {
		    			//Si on selectionne le mode Difficile
		    			if(new File("resources/models/"+fileModeDifficile).exists()) {
		    				modelExist=true;
		    				net = MultiLayerPerceptron.load("resources/models/"+fileModeDifficile);
		    			}
		    			else {
		    				modelExist=false;
		    				int layers[] = new int[ld+2];
		    				layers[0] = 9;
		    				for(int i=0; i<ld;i++) {
		    					layers[i+1] = hd;
		    				}
		    				layers[layers.length-1] = 9;
		    				net = new MultiLayerPerceptron(layers, lrd, new SigmoidalTransferFunction());
		    			}
	    			}
	    		
	    			br.close();
	        		
	    			if(modelExist==false) {
		    			System.out.println();
		    			System.out.println("START TRAINING ..."); 
		    			System.out.println();
		    			//
		    			int size = 9;
		    			int[] layers = new int[]{ size, 128, size };
		    			//
		    			double error = 0.0 ;
		    			net = new MultiLayerPerceptron(layers, 0.1, new SigmoidalTransferFunction());
		    			double epochs = 10000000 ;
		
		    			System.out.println("---");
		    			System.out.println("Load data ...");
		    			HashMap<Integer, Coup> mapTrain = Test.loadCoupsFromFile("./resources/train_dev_test/train.txt");
		    			HashMap<Integer, Coup> mapDev = Test.loadCoupsFromFile("./resources/train_dev_test/dev.txt");
		    			HashMap<Integer, Coup> mapTest = Test.loadCoupsFromFile("./resources/train_dev_test/test.txt");
		    			System.out.println("---");
		    			//TRAINING ...
		    			for(int i = 0; i < epochs; i++){
		
		    				Coup c = null ;
		    				while ( c == null )
		    					c = mapTrain.get((int)(Math.round(Math.random() * mapTrain.size())));
		
		    				error += net.backPropagate(c.in, c.out);
		
		    				if ( i % 10000 == 0 ) System.out.println("Error at step "+i+" is "+ (error/(double)i));
		    				updateMessage("Error at step "+i+" is "+ (error/(double)i));
		    				updateProgress(i,epochs);
		    			}
		    			error /= epochs ;
		    			if ( epochs > 0 )
		    				System.out.println("Error is "+error);
		    			//
		    			System.out.println("Learning completed!");
		    			updateMessage("Learning completed!");
		    			btStart.setDisable(false);
		    			if(MenuController.niveau==1) net.save("resources/models/"+fileModeDifficile);
		    			else net.save("resources/models/"+fileModeFacile);
		    			play.setVisible(true);
		    			/*//TEST ...
		    			double[] inputs = new double[]{0.0, 1.0};
		    			double[] output = net.forwardPropagation(inputs);
		
		    			System.out.println(inputs[0]+" or "+inputs[1]+" = "+Math.round(output[0])+" ("+output[0]+")");*/
	    			}
	    			else {
	    				System.out.println("Learning already present. Now you can Play!");
		    			updateMessage("Learning already present. Now you can Play!");
		    			play.setVisible(true);
		    			btStart.setDisable(false);
		    			updateProgress(0,0);
	    			}
	    		} 
	    		catch (Exception e) {
	    			System.out.println("Test.test()");
	    			e.printStackTrace();
	    			System.exit(-1);
	    		}
				return null;
	        }

	    };
		if(a==0) {
			Main.mediaPlayer2.play();
			Main.mediaPlayer2.seek(Duration.millis(0));
			btStart.setDisable(true);
			pgrBar.setProgress(0.0);
		    Thread th = new Thread(task);
		    pgrBar.progressProperty().bind(task.progressProperty());
		    task.messageProperty().addListener(new ChangeListener<String>() {
				@Override
				public void changed(ObservableValue<? extends String> obervable, String oldValue, String newValue) {
					msgBox.appendText("\n");
					msgBox.appendText(newValue);
				}});
	        th.start();
	        a++;
	        btStart.setText("RESTART");
		}
		else {
			Main.restart.play();
			Main.restart.seek(Duration.millis(0));
			a=0;
			rinitialisation();
		}
	}
	
	private void rinitialisation() {
		play.setVisible(false);
		msgBox.setText("");
		btStart.setText("Start");
		pgrBar = new ProgressBar();
	}

	public void onClickButtonRetour(ActionEvent event) throws IOException {
		Main.mediaPlayer2.play();
		Main.mediaPlayer2.seek(Duration.millis(0));
		Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
		window.setScene(sc.getMenu());
		window.show();
	}	
	
}
