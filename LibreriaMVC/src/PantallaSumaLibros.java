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
public class PantallaSumaLibros extends Application{
    
    public static Stage primaryStage;
    public static Libro libro;
    
    public PantallaSumaLibros(Libro libro){
        super();
        PantallaSumaLibros.libro = libro;
    }
        
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("vista/suma_libro.fxml"));
     
        PantallaSumaLibros.primaryStage = primaryStage;
        
        primaryStage.setTitle("Agrega Libros!");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
    
}
