package libreriaMVC.controlador;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import java.util.ArrayList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

import libreriaMVC.Clases.Libro;
import libreriaMVC.modelo.Modelo;
import libreriaMVC.LibreriaMVC;
import libreriaMVC.PantallaAgregaLibro;
import libreriaMVC.PantallaEditaLibro;
import libreriaMVC.PantallaLibro;
import libreriaMVC.PantallaSumaLibros;

/**
 *
 * @author rmartinezm
 */
public class Controlador implements Initializable{
   
    @FXML
    private ListView<String> libros; 
    private static ArrayList<Libro> listaLibros;
    private final Modelo modelo = new Modelo();
    
    @FXML
    private Button btn_elimina;
    @FXML
    private Button btn_edita;
    @FXML
    private Button btn_ver;
    @FXML
    private Button btn_sumalibros;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        // Leemos la informacion de la lista de libros y lo asignamos a listaLibros
        listaLibros = LibreriaMVC.recupera();
        
        if (listaLibros == null)
            listaLibros = new ArrayList<>();
        
        ArrayList<String> autores = new ArrayList<>();
        
        ObservableList<String> items = libros.getItems(); 
        
        for (Libro libro: listaLibros)  
            items.add(libro.toString());
        
        btn_elimina.setDisable(true);
        btn_edita.setDisable(true);
        btn_ver.setDisable(true);
        btn_sumalibros.setDisable(true);
        
        if (libros.getSelectionModel().getSelectedItem() != null){
            btn_elimina.setDisable(false);
            btn_edita.setDisable(false);
            btn_ver.setDisable(false);
            btn_sumalibros.setDisable(false);
        }
        
    }
    
    public static ArrayList<Libro> dameListaLibros(){
        return listaLibros;
    }
    
    @FXML
    private void handleMouseClick(MouseEvent arg0) {
        if (!listaLibros.isEmpty() && libros.getSelectionModel().getSelectedItem() != null){
            btn_elimina.setDisable(false);
            btn_edita.setDisable(false);
            btn_ver.setDisable(false);
            btn_sumalibros.setDisable(false);
        }
    }
    
    @FXML
    private void agregaLibro(ActionEvent ae) throws Exception{
        PantallaAgregaLibro pal = new PantallaAgregaLibro();
        pal.start(new Stage());
    }
    
    @FXML
    private void verLibro(ActionEvent ae) throws Exception{
        PantallaLibro pl = new PantallaLibro(listaLibros.get(libros.getSelectionModel().getSelectedIndex()));
        pl.start(new Stage());
    }
    
    @FXML
    private void editaLibro(ActionEvent ae) throws Exception{
        PantallaEditaLibro pal = new PantallaEditaLibro(listaLibros.get(libros.getSelectionModel().getSelectedIndex()), 
                                                           libros.getSelectionModel().getSelectedIndex());
        pal.start(new Stage());    
    }
    
    @FXML
    private void sumaLibro(ActionEvent ae) throws Exception{
        PantallaSumaLibros psl = new PantallaSumaLibros(listaLibros.get(libros.getSelectionModel().getSelectedIndex()));
        psl.start(new Stage());
    }
    
    @FXML
    private void eliminaLibro(ActionEvent ae) throws Exception{
        if (JOptionPane.showConfirmDialog(null, "Estas seguro de eliminar este elemento?", "Eliminar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            listaLibros.remove(libros.getSelectionModel().getSelectedIndex());
            LibreriaMVC libreriaMVC = new LibreriaMVC();
            libreriaMVC.guarda(listaLibros);
            libreriaMVC.start(LibreriaMVC.primaryStage);
        } else {
            // no option
            JOptionPane.showMessageDialog(null, "Elemento no eliminado.");
        }
    }
    
    
}
