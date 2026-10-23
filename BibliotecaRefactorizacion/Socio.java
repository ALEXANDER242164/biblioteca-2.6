package BibliotecaRefactorizacion;

// EXTRACT CLASS
// REFACTOR: Clase Telefono
/** notamos que la clase socio tenia dos atributos que correspondian a telefono,
 * por lo que decidimos extraerlos a una nueva clase llamada Telefono, 
 * y asi poder tener una mejor organizacion del codigo
**/

public class Socio {
    private String nombre;
    private String ciudad;
    private Telefono telefono;

    // MOVE FIEL
    
    //EFACTOR: atributo diasPlazoPrestamo
    /**
    * tambien se movievo el atributo diasPlazoPrestamo de la clase Socio a la clase Prestamo, 
    * ya que este atributo es mas relevante para la clase Prestamo que para la clase Socio.
    */

    public Socio(String nombre, String ciudad,
                 String telefonoCodigoArea, String telefonoNumero) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.telefono = new Telefono( telefonoCodigoArea, telefonoNumero);
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

    public String obtenerTelefonoCompleto() {
        return telefono.obtenerTelefonoCompleto();
    }

    public boolean esTelefonoLocal() {
        return telefono.esTelefonoLocal();
    }
}