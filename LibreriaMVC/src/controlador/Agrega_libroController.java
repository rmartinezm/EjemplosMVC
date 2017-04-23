package libreriaMVC.controlador;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

import libreriaMVC.Clases.Libro;
import libreriaMVC.PantallaAgregaLibro;
import libreriaMVC.LibreriaMVC;
import libreriaMVC.modelo.Modelo;

/**
 * FXML Controller class
 *
 * @author rmartinezm
 */
public class Agrega_libroController implements Initializable {

    @FXML
    private TextField tfIsbn;
    @FXML
    private TextField tfTitulo;
    @FXML
    private TextField tfAutores;
    @FXML
    private TextField tfPrecio;
    @FXML
    private TextField tfDisponibles;
    
    private Modelo modelo;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        modelo = new Modelo();
    }    
    
    @FXML
    private void agregaLibro(ActionEvent ae) throws Exception{
        ArrayList<Libro> libros = Controlador.dameListaLibros();
        
        String miISBN, miTitulo, misAutores, miPrecio, miDisponibles;
        miISBN = tfIsbn.getText().trim();
        miTitulo = tfTitulo.getText().trim();
        misAutores = tfAutores.getText().trim();
        miPrecio = tfPrecio.getText().trim();
        miDisponibles = tfDisponibles.getText().trim();
        
        if (miISBN.isEmpty() || miTitulo.isEmpty() || misAutores.isEmpty() ||
                miPrecio.isEmpty() || miDisponibles.isEmpty()){
            // Mostraremos dialogo de error
            JOptionPane.showMessageDialog(null, "Todos los datos son necesarios para el registro.");
            PantallaAgregaLibro.primaryStage.close();
        }else{
            Libro nuevoLibro = modelo.creaLibro(miISBN, miTitulo, misAutores, miPrecio, miDisponibles); 
            if (libros.contains(nuevoLibro)){
                JOptionPane.showMessageDialog(null, "Libro ya registrado.");
                PantallaAgregaLibro.primaryStage.close();   
                return;
            }                
            if (nuevoLibro != null){
                
                ArrayList<Libro> listaLibros = Controlador.dameListaLibros();
                listaLibros.add(nuevoLibro);
                
                LibreriaMVC libreriaMVC = new LibreriaMVC();
                
                libreriaMVC.guarda(listaLibros);
                JOptionPane.showMessageDialog(null, "Registro Éxitoso.");
                
                if(PantallaAgregaLibro.primaryStage != null)
                    PantallaAgregaLibro.primaryStage.close();
                libreriaMVC.start(LibreriaMVC.primaryStage);               
                
            }else{                            
                JOptionPane.showMessageDialog(null, "Datos incorrectos, favor de verificar.");
                PantallaAgregaLibro.primaryStage.close();
            }
        }           
    }
    
    @FXML
    private void cancelar(ActionEvent ae){
        PantallaAgregaLibro.primaryStage.close();
    }
    
}
