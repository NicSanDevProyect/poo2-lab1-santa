package dominio;

public class LibroFisico extends Libro {
    private final int paginas;

    public LibroFisico(String titulo, String autor, int anio, int paginas) throws DatoInvalidoException {
        super(titulo, autor, anio);
        if (paginas <= 0) {
            throw new DatoInvalidoException("El número de páginas debe ser mayor que cero.");
        }
        this.paginas = paginas;
    }

    public int getPaginas() { return paginas; }

    @Override
    public String descripcion() {
        return "[Físico] " + getTitulo() + " - " + getAutor() + " (" + getAnio() + "), " + paginas + " páginas";
    }
}
