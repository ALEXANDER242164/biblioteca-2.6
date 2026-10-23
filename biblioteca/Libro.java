package biblioteca;

public class Libro {
    private String titulo;
    private String autor;
    private String isbn; // Se uso inline para simplificar el código y evitar la creación de una clase
                         // ISBN separada
    // Refactor: Se eliminar la clase isnb ya que usando la tecnica inline el cual
    // no cumple un gran papel es decir no nos cambiene tener una clase sola para
    // eso.
    private String categoria; // "NOVEDAD" o "NORMAL"
    private double multaPorDia;
    private double valorReposicion;

    public Libro(String titulo, String autor, String isbn, String categoria,
            double multaPorDia, double valorReposicion) {
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
}
