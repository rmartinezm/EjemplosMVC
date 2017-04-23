package libreriaMVC;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import libreriaMVC.Clases.Libro;

/**
 * @author rmartinezm
 */
public class PantallaEditaLibro extends Application {
     
    public static Stage primaryStage;
    public static Libro libro;
    public static int position;
    
    public PantallaEditaLibro(Libro libro, int position){
        super();
        PantallaEditaLibro.libro = libro;
        PantallaEditaLibro.position = position;
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("vista/edita_libro.fxml"));        
        
        PantallaEditaLibro.primaryStage = primaryStage;
        
        primaryStage.setTitle("Edita Libro!");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }    
}
