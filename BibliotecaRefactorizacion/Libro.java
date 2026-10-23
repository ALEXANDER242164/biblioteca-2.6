package BibliotecaRefactorizacion;

public class Libro {
    private String titulo;
    private String autor;

    // INLINE CLASS

    private String isbn; 
    
    /**REFACTOR: clase ISBN integrada a clase Libro
     * Se eliminar la clase isbn ya que usando la tecnica inline el cual
     * no cumple un gran papel es decir no nos cambiene tener una clase sola para
     * eso.
     */

    private String categoria;
    private double multaPorDia;
    private double valorReposicion;

    public Libro(String titulo, String autor, String isbn,
                 String categoria, double multaPorDia,
                 double valorReposicion) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.categoria = categoria;
        this.multaPorDia = multaPorDia;
        this.valorReposicion = valorReposicion;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getMultaPorDia() {
        return multaPorDia;
    }

    public double getValorReposicion() {
        return valorReposicion;
    }

    
    // MOVE METHOD

    /**REFACTOR: metodo calcular multa
     * se movio el metodo calcular multa de la clase Libro a la clase Libro, 
     * ya que este metodo es mas relevante para la clase Libro que para la clase Prestamo. 
     */

    public double calcularMulta(int diasRetraso) {
        if (diasRetraso <= 0) {
            return 0;
        }

        double multa = diasRetraso * multaPorDia;

        if (categoria.equals("NOVEDAD")) {
            multa = multa * 2;
        }

        if (multa > valorReposicion) {
            multa = valorReposicion;
        }

        return multa;
    }
}