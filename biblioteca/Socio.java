package biblioteca;

// EXTRACT CLASS
// REFACTOR: Clase Telefono
/** notamos que la clase socio tenia dos atributos que correspondian a telefono,
 * por lo que decidimos extraerlos a una nueva clase llamada Telefono, 
 * y asi poder tener una mejor organizacion del codigo
**/

// MOVE FIELD
/**
 * tambien se movio el atributo diasPlazoPrestamo a la clase Socio,
 * ya que este atributo es mas relevante para
 * la clase Socio que para la clase Prestamo.
 */
public class Socio {

    private String nombre;
    private String ciudad;
    private Telefono telefono;

    public Socio(String nombre, String ciudad, Telefono telefono) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}