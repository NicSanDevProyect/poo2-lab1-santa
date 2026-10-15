package dominio;

public class LibroDigital extends Libro {
    private final double tamanioMb;

    public LibroDigital(String titulo, String autor, int anio, double tamanioMb) {
        super(titulo, autor, anio);
        this.tamanioMb = tamanioMb;
    }

    public double getTamanioMb() { return tamanioMb; }

    @Override
    public String descripcion() {
        return "[Digital] " + getTitulo() + " - " + getAutor() + " (" + getAnio() + "), " + tamanioMb + " MB";
    }
}
