package libreriaMVC.Clases;

import java.util.ArrayList;
import java.io.Serializable;

/**
 *
 * @author rmartinezm
 */
public class Libro implements Serializable {
    
    private String isbn;
    private String titulo;
    private ArrayList<String> autores;
    private double precio;
    private int unidadesDisponibles;

    public Libro(String isbn, String titulo, ArrayList<String> autores, double precio, int unidadesDisponibles) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autores = autores;
        // Redondeamos el precio a dos decimales
        this.precio = Math.round(precio * 100.0)/100.0;
        this.unidadesDisponibles = unidadesDisponibles;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public ArrayList<String> getAutores() {
        return autores;
    }

    public void setAutores(ArrayList<String> autores) {
        this.autores = autores;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getUnidadesDisponibles() {
        return unidadesDisponibles;
    }

    public void setUnidadesDisponibles(int unidadesDisponibles) {
        this.unidadesDisponibles = unidadesDisponibles;
    }
    
    @Override
    public String toString(){
        return titulo;
    }
    
    public boolean mismoTituloYAutores(Libro libro){
        return libro.getTitulo().equals(titulo) && autores.equals(libro.autores);
    }
    
    /** 
     * Si tienen mismo Título y mismo autor(es) los concideraremos como iguales
     **/
    @Override
    public boolean equals(Object o){
        if (o instanceof Libro){
            @SuppressWarnings("unchecked") Libro libro = (Libro) o;
            return mismoTituloYAutores(libro);
        }
        return false;
    }
    
}
