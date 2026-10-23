package BibliotecaRefactorizacion;

// aqui se define la clase Telefono con sus atributos y metodos

public class Telefono {

    //se modificaron los nombres de los atributos de la clase Telefono 
    //para que sean mas descriptivos y claros, ya que pertenecen a esta clase
    private String codigoArea;
    private String numero;


    public Telefono(String codigoArea, String numero) {
        this.codigoArea = codigoArea;
        this.numero = numero;
    }

    //metos refactorizados
    public String obtenerTelefonoCompleto() {
        return "(" + codigoArea + ") " + numero;
    }

    public boolean esTelefonoLocal() {
        return codigoArea.equals("999");
    }
}