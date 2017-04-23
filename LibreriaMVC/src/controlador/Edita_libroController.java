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
import libreriaMVC.PantallaEditaLibro;
import libreriaMVC.LibreriaMVC;
import libreriaMVC.modelo.Modelo;

/**
 * @author rmartinezm
 */
public class Edita_libroController implements Initializable {

    @FXML
    private TextField tfTitulo;
    @FXML
    private TextField tfAutores;
    @FXML
    private TextField tfPrecio;
   
    private Modelo modelo;
    private Libro libro;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        modelo = new Modelo();
        libro = PantallaEditaLibro.libro;
        tfTitulo.setText(libro.getTitulo());
        tfPrecio.setText(libro.getPrecio() + "");
        
        ArrayList<String> listaAutores = libro.getAutores();
        String autoresString = "";
        for (int i = 0; i < listaAutores.size(); i++){
            if (i == 0)
                autoresString += listaAutores.get(i);
            else
                autoresString += ", " + listaAutores.get(i);
        }
        
        tfAutores.setText(autoresString);
    }        
    
    @FXML
    private void cancelar(ActionEvent ae){
        PantallaEditaLibro.primaryStage.close();
    }
    
    @FXML 
    private void editarLibro(ActionEvent ae) throws Exception{
        int position = PantallaEditaLibro.position;
        ArrayList<Libro> listaLibros = Controlador.dameListaLibros();
        
        Libro nuevoLibro = modelo.creaLibro(libro.getIsbn(), tfTitulo.getText(), tfAutores.getText(),
                tfPrecio.getText(), libro.getUnidadesDisponibles() + "");
        if (nuevoLibro == null){            
            JOptionPane.showMessageDialog(null, "Datos Incorrectos para la edición.");
            PantallaEditaLibro.primaryStage.close();
        }else{
            listaLibros.remove(position);
            modelo.agregaLibro(listaLibros, nuevoLibro);
            
            LibreriaMVC libreriaMVC = new LibreriaMVC();
                
            libreriaMVC.guarda(listaLibros);
            JOptionPane.showMessageDialog(null, "Cambio Realizado con éxito.");
                
            if(PantallaEditaLibro.primaryStage != null)
                PantallaEditaLibro.primaryStage.close();
            libreriaMVC.start(LibreriaMVC.primaryStage);  
        }
    }
    
}
