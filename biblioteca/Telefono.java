package biblioteca;

public class Telefono {

    // Extract Class
    private String telefonoCodigoArea;
    private String telefonoNumero;

    public Telefono(String telefonoCodigoArea, String telefonoNumero) {
        this.telefonoCodigoArea = telefonoCodigoArea;
        this.telefonoNumero = telefonoNumero;
    }

    public String getTelefonoCodigoArea() {
        return telefonoCodigoArea;
    }

    public String getTelefonoNumero() {
        return telefonoNumero;
    }

    public String obtenerTelefonoCompleto() {
        return "(" + telefonoCodigoArea + ") " + telefonoNumero;
    }

    public boolean esTelefonoLocal() {
        return telefonoCodigoArea.equals("999");
    }
}