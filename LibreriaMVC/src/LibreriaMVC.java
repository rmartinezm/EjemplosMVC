package libreriaMVC;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.io.*;
import libreriaMVC.Clases.Libro;

/**
 *
 * @author rmartinezm
 */
public class LibreriaMVC extends Application {
    
    public static Stage primaryStage;
        
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("vista/inicio.fxml"));
     
        LibreriaMVC.primaryStage = primaryStage;
        
        primaryStage.setTitle("Librería!");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    /**
    * Guarda la Lista de libros que le pasamos en el archivo libreria.
    **/
    public static void guarda(ArrayList<Libro> libros){

        File archivo = new File("libreria");
        ObjectOutputStream oos;
        
        try{
            oos = new ObjectOutputStream(new FileOutputStream(archivo));
            oos.writeObject(libros);
            oos.close();
        }catch(IOException ioe){}
    }
    
    /**
    * Lee la lista de libros que tenemos en el archivo libreria.
    **/
    public static ArrayList<Libro> recupera(){
        
        File archivo = new File("libreria");
        ObjectInputStream ois;
        
        try{
            ois = new ObjectInputStream(new FileInputStream(archivo));
            @SuppressWarnings("unchecked")
            ArrayList<Libro> libros = (ArrayList<Libro>) ois.readObject();
            ois.close();
            return libros;
        }catch(Exception e){}
        
        return null;
    } 
    
}
