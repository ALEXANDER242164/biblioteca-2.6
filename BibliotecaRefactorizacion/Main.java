package BibliotecaRefactorizacion;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Main {

    public static void main(String[] args) {

        // REFACTOR: Remove Middle Man.
        // Ahora el Main utiliza Catalogo directamente en lugar de Recepcion(CLASE ELIMINADA)
        Catalogo catalogo = new Catalogo();

        catalogo.agregar(
            new Libro( "Java Basico", "R. Perez", "978-1-11111-111-1", "NOVEDAD", 
            5, 300)
         );

        catalogo.agregar(
            new Libro("Estructuras de Datos", "M. Diaz", "978-2-22222-222-2", "NORMAL",
                3, 400)
            );

        System.out.println(
            "Libros registrados: " + catalogo.total()
        );

        Libro libro = catalogo.buscarPorTitulo("java basico");

        Socio socio = new Socio("Ana Lopez", "Merida", "999", "1234567");

        Date fechaPrestamo =
            new GregorianCalendar(
                2026, Calendar.OCTOBER, 1
            ).getTime();

        Date fechaDevolucion =
            new GregorianCalendar(
                2026, Calendar.OCTOBER, 22
            ).getTime();

        // REFACTOR: Move Field.
        // Los 14 dias del plazo ahora se pasan a Prestamo.
        Prestamo prestamo = new Prestamo(
            libro,
            socio,
            fechaPrestamo,
            fechaDevolucion,
            14
        );

        System.out.println("-----------------------------");

        prestamo.imprimirResumen();

        System.out.println("-----------------------------");

        // REFACTOR: Hide Delegate.
        System.out.println(
            "Ciudad del socio: " + prestamo.getCiudadSocio()
        );

        System.out.println(
            "Telefono del socio: " + prestamo.getTelefonoSocio()
        );

        System.out.println(
            "Autor del libro: " + prestamo.getLibro().getAutor()
        );

        int retraso = prestamo.calcularDiasRetraso();

        System.out.println("Dias de retraso: " + retraso);

        // La multa se calcula directamente desde Libro.
        System.out.println(
            "Multa: $" + libro.calcularMulta(retraso)
        );


        // El ISBN(CLASE ELIMINADA) ahora es un String que pertenece a Libro.
        System.out.println("ISBN: " + libro.getIsbn());

        System.out.println(
            "Telefono local: " + socio.esTelefonoLocal()
        );
    }
}