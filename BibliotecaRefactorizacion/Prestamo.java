package BibliotecaRefactorizacion;

import java.util.Date;

public class Prestamo {
    private Libro libro;
    private Socio socio;
    private Date fechaPrestamo;
    private Date fechaDevolucion;

    // REFACTOR: Move Field.
    // el atributo de socio que se trajo a la clase Prestamo
    private int diasPlazoPrestamo;

    public Prestamo(Libro libro, Socio socio, Date fechaPrestamo, Date fechaDevolucion, int diasPlazoPrestamo) {
        this.libro = libro;
        this.socio = socio;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.diasPlazoPrestamo = diasPlazoPrestamo;
    }

    public Libro getLibro() {
        return libro;
    }

    public Socio getSocio() {
        return socio;
    }

    // REFACTOR: Hide Delegate.
    // Main ya no necesita acceder directamente a Socio para obtener la ciudad.
    public String getCiudadSocio() {
        return socio.getCiudad();
    }

    // REFACTOR: Hide Delegate.
    // Prestamo proporciona directamente el telefono del socio.
    public String getTelefonoSocio() {
        return socio.obtenerTelefonoCompleto();
    }

    // REFACTOR: Introduce Foreign Method.
    // Se utiliza sumarDias para calcular la fecha de vencimiento.
    public Date calcularFechaVencimiento() {
        return sumarDias(fechaPrestamo, diasPlazoPrestamo);
    }

    private Date sumarDias(Date fecha, int dias) {
        return new Date(
            fecha.getTime() + dias * 24L * 60 * 60 * 1000
        );
    }

    public int calcularDiasRetraso() {
        return new FechaBiblioteca().diasEntre(
            calcularFechaVencimiento(),
            fechaDevolucion
        );
    }

    // REFACTOR: Move Method.
    // ahora el calculo de la multa se realiza en la clase Libro
    @Deprecated
    public double calcularMulta(int diasRetraso) {
        return libro.calcularMulta(diasRetraso);
    }


    public void imprimirResumen() {
        FechaBiblioteca fechas = new FechaBiblioteca();

        System.out.println("Libro: " + libro.getTitulo());
        System.out.println("Socio: " + socio.getNombre());

        System.out.println(
            "Prestado: " + fechas.formatearFecha(fechaPrestamo)
        );

        System.out.println(
            "Vence: " + fechas.formatearFecha(calcularFechaVencimiento())
        );

        System.out.println(
            "Vence en fin de semana: "
            + fechas.esFinDeSemana(calcularFechaVencimiento())
        );

        System.out.println(
            "Devuelto: " + fechas.formatearFecha(fechaDevolucion)
        );
    }
}