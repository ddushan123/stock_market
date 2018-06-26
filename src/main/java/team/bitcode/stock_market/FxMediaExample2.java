/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.bitcode.stock_market;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.ImageIcon;
import javax.swing.UnsupportedLookAndFeelException;
import static team.bitcode.stock_market.Frame.showPanelNewPlayer;

/**
 *
 * @author DUSH
 */
public class FxMediaExample2 extends Application{
  public Stage stage;
  public static Frame frame;
	public static void main(String[] args) 
	{
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    try {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(FxMediaExample2.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InstantiationException ex) {
                        Logger.getLogger(FxMediaExample2.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IllegalAccessException ex) {
                        Logger.getLogger(FxMediaExample2.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (UnsupportedLookAndFeelException ex) {
                        Logger.getLogger(FxMediaExample2.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
            }
		Application.launch(args);
	}
	
	@Override
	public void start(Stage st) 
	{
                stage=st;
		try{
                // Locate the media content in the CLASSPATH
		URL mediaUrl = getClass().getResource("/Video.mp4");
		String mediaStringUrl = mediaUrl.toExternalForm();
		
		// Create a Media
		Media media = new Media(mediaStringUrl);
		
		// Create a Media Player
		final MediaPlayer player = new MediaPlayer(media);
		// Automatically begin the playback
		player.setAutoPlay(true);
		
		// Create a 400X300 MediaView
                Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        
		MediaView mediaView = new MediaView(player);
		mediaView.setFitWidth(dim.width);
		mediaView.setFitHeight(dim.height);		
		mediaView.setSmooth(true);
		
		VBox root = new VBox(mediaView);
		
		

		// Create the Scene
		Scene scene = new Scene(root);
		// Add the scene to the Stage
                
		stage.setScene(scene);
		// Set the title of the Stage
		//stage.setTitle("A simple Media Example");
		// Display the Stage
                 stage.sizeToScene();
                 
                 stage.setResizable(false);
                 stage.setAlwaysOnTop(true);
                 stage.setFullScreenExitHint("");
                 stage.setFullScreen(true);
                 stage.show();	
                 
                 
                 /*Timer t1=new Timer();
                 t1.schedule(new TimerTask() {
                 @Override
                 public void run() {
                 
                 }
                 }, 0);*/
                    
                 Timer t= new Timer();
                 t.schedule(new TimerTask() {
                    @Override
                    public void run() {
                       frame= new Frame();
                      frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/icon2.png")));
                      
                       File file = new File("players/player_name.plyr");
                        if(!file.exists()){
                            Frame.log=1;
                        }
                        else{
                            Frame.log=2;
                        }
                       Frame.showTradingCenter();
                       showPanelNewPlayer();
                       frame.show();
                       if(InternetConnection.getInternetStatus()) {
                       frame.openStartupDilog();
                            try {
                                File folder = new File("data");
                                if(!folder.exists()){
                                    folder.mkdir();
                                }
                                ReadExcel readExcel = new ReadExcel();
                                readExcel.initExcel();
                                frame.setNYSETab();
                                frame.setLSETab();
                                frame.setNSMTab();
                               
                            } catch (URISyntaxException ex) {
                                Logger.getLogger(Startup.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (IOException ex) {
                                Logger.getLogger(Startup.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        
                       frame.closeStartupDilog();
                       }
                       else{
                           System.exit(0);
                       }
                       /*Startup s= new Startup();
                       s.show();
                       s.addWindowListener(new WindowListener() {
                       @Override
                       public void windowOpened(WindowEvent e) {
                       frame.setEnabled(false);
                       }
                       
                       @Override
                       public void windowClosing(WindowEvent e) {}
                       
                       @Override
                       public void windowClosed(WindowEvent e) {
                       frame.setEnabled(true);
                       }
                       
                       @Override
                       public void windowIconified(WindowEvent e) {}
                       
                       @Override
                       public void windowDeiconified(WindowEvent e) {}
                       
                       @Override
                       public void windowActivated(WindowEvent e) {}
                       
                       @Override
                       public void windowDeactivated(WindowEvent e) {}
                       });*/
                     
                    }
                }, 5000);
                
            PauseTransition delay = new PauseTransition(Duration.millis(6000));
            delay.setOnFinished( event -> stage.close() );
            delay.play();
            
                }catch(Exception ex){
                    System.out.println(ex);
                }
	}	
}