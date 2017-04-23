package libreriaMVC;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author rmartinezm
 */
public class PantallaAgregaLibro extends Application {
    
    public static Stage primaryStage;
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("vista/agrega_libro.fxml"));        
        
        PantallaAgregaLibro.primaryStage = primaryStage;
        
        primaryStage.setTitle("Agrega Libro!");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }    
}
    