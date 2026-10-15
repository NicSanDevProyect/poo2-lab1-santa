package dominio;

public class LibroFisico extends Libro {
    private final int paginas;

    public LibroFisico(String titulo, String autor, int anio, int paginas) {
        super(titulo, autor, anio);
        this.paginas = paginas;
    }

    public int getPaginas() { return paginas; }

    @Override
    public String descripcion() {
        return "[Físico] " + getTitulo() + " - " + getAutor() + " (" + getAnio() + "), " + paginas + " páginas";
    }
}
