package libreriaMVC.controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javax.swing.JOptionPane;

import libreriaMVC.Clases.Libro;
import libreriaMVC.PantallaSumaLibros;
import libreriaMVC.LibreriaMVC;

/**
 *
 * @author rmartinezm
 */
public class Suma_libroController implements Initializable {

    @FXML
    private Text textMisLibros;
    @FXML
    private TextField tfLibrosASumar;
    @FXML
    private Button btn_aceptar;
    
    private Libro libro;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        libro = PantallaSumaLibros.libro;
        textMisLibros.setText("La cantidad de libros disponibles que tiene: " + libro.getTitulo() +  " son: "
                + libro.getUnidadesDisponibles());
    }    
    
    @FXML
    private void agregaLibros(ActionEvent ae) throws Exception{
        int cantidad = 0;
        LibreriaMVC libreriaMVC = new LibreriaMVC();
        try{
            cantidad = Integer.parseInt(tfLibrosASumar.getText().trim());
            if (cantidad > 0){
                libro.setUnidadesDisponibles(libro.getUnidadesDisponibles()+cantidad);
                libreriaMVC.guarda(Controlador.dameListaLibros());                
                JOptionPane.showMessageDialog(null, "Datos Actualizados.");
                PantallaSumaLibros.primaryStage.close();
                libreriaMVC.start(LibreriaMVC.primaryStage);
            }else{                      
                JOptionPane.showMessageDialog(null, "Cantidad Incorrecta.");
                PantallaSumaLibros.primaryStage.close();
            }                
        }catch(NumberFormatException e){                  
            JOptionPane.showMessageDialog(null, "Cantidad Incorrecta.");
            PantallaSumaLibros.primaryStage.close();
        }
    }
    
    @FXML
    private void cancelar(ActionEvent ae){
        PantallaSumaLibros.primaryStage.close();
    }
    
}
