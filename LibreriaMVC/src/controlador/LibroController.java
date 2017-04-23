package libreriaMVC.controlador;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import libreriaMVC.Clases.Libro;
import libreriaMVC.PantallaLibro;

/**
 *
 * @author rmartinezm
 */
public class LibroController implements Initializable {

    @FXML
    private Text isbn;
    @FXML
    private Text titulo;
    @FXML
    private Text autores;
    @FXML
    private Text precio;
    @FXML
    private Text unidadesDisponibles;
    @FXML
    private Button aceptar;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Libro libro = PantallaLibro.libro;
        isbn.setText("ISBN: " + libro.getIsbn());
        titulo.setText("Título: " + libro.getTitulo());
        precio.setText("Precio: " + libro.getPrecio());
        unidadesDisponibles.setText("Unidades Disponibles: " + libro.getUnidadesDisponibles());
        
        ArrayList<String> listaAutores = libro.getAutores();
        String autoresString = "";
        for (int i= 0; i < listaAutores.size(); i++){
            if (i == 0 || i == listaAutores.size())
                autoresString += listaAutores.get(i).trim();
            else
                autoresString += ", " + listaAutores.get(i).trim();
        }
        autores.setText("Autores: " + autoresString);
    }    
    
    @FXML
    private void aceptar(ActionEvent ae) throws Exception{
        PantallaLibro.primaryStage.close();
    }
    
}
