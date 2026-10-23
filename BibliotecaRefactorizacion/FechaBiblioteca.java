package BibliotecaRefactorizacion;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

// REFACTOR: Introduce Local Extension.
// Se extiende Date para incorporar operaciones de fechas.
public class FechaBiblioteca extends Date {

    public FechaBiblioteca() {
        super();
    }

    public FechaBiblioteca(Date fecha) {
        super(fecha.getTime());
    }

    // REFACTOR: Se trajo desde Prestamo.
    public int diasEntre(Date desde, Date hasta) {
        double milisPorDia = 24.0 * 60 * 60 * 1000;

        return (int) Math.round(
            (hasta.getTime() - desde.getTime()) / milisPorDia
        );
    }

    // REFACTOR: Se trajo desde Prestamo.
    public String formatearFecha(Date fecha) {
        return new SimpleDateFormat("dd/MM/yyyy").format(fecha);
    }

    // REFACTOR: Se trajo desde Prestamo.
    public boolean esFinDeSemana(Date fecha) {
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(fecha);

        int dia = calendario.get(Calendar.DAY_OF_WEEK);

        return dia == Calendar.SATURDAY
            || dia == Calendar.SUNDAY;
    }
}