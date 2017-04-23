package libreriaMVC.modelo;

import javafx.event.ActionEvent;
import java.util.ArrayList;
import javafx.fxml.FXML;

import libreriaMVC.Clases.Libro;

/**
 *
 * @author rmartinezm
 */
public class Modelo {    
    
    /**
     * @param libro libro que se agregará a la lista
     * @param list lista en la que se agregará el libro
     * @return <code>true</code> si el libro fue agregado éxitosamente,
     * <code>false</code> en otro caso.
     */
    @FXML
    public boolean agregaLibro(ArrayList<Libro> list, Libro libro){
        if (!list.contains(libro)){
            list.add(libro);
            return true;
        }
        return false;
    }
    
    /**
     * Método que proporciona un nuevo Libro con los parametros ingresados.
     * 
     * @param isbn el ISBN del nuevo libro
     * @param titulo el Título del nuevo libro
     * @param autores los Autores del libro separados por coma
     * @param precio el Precio del nuevo libro
     * @param disponibles la cantiadad de unidades disponibles del nuevo libro
     * 
     * @return Libro con los datos proporcionados si estos son válidos, 
     * null en otro caso.
     **/    
    public Libro creaLibro(String isbn, String titulo, String autores,
            String precio, String disponibles){
        
        if (isbn.trim().isEmpty() || titulo.trim().isEmpty())
            return null;
        
        try{
            double precioDouble = Double.parseDouble(precio.trim());
            int disponiblesInt = Integer.parseInt(disponibles.trim());
            
            ArrayList<String> autoresList = new ArrayList<>();
            String[] cadaAutor = autores.split(",");
            
            for (String miAutor: cadaAutor)
                if (!miAutor.trim().isEmpty())
                    autoresList.add(miAutor.trim());
            
            return (autoresList.isEmpty())? null: 
                    new Libro(isbn, titulo, autoresList, precioDouble, disponiblesInt);
        }catch(NumberFormatException e){}
        
        return null;
    }    
}
