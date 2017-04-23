package libreriaMVC;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import libreriaMVC.Clases.Libro;

/**
 *
 * @author rmartinezm
 */
public class PantallaLibro extends Application{
    
    public static Stage primaryStage;
    public static Libro libro;
    
    public PantallaLibro(Libro libro){
        super();
        PantallaLibro.libro = libro;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        PantallaLibro.primaryStage = primaryStage;
        
        Parent root = FXMLLoader.load(getClass().getResource("vista/libro.fxml"));
        
        primaryStage.setTitle("Vista Libro!");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
    
}
