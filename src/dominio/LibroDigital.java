package dominio;

public class LibroDigital extends Libro {
    private final double tamanioMb;

    public LibroDigital(String titulo, String autor, int anio, double tamanioMb) throws DatoInvalidoException {
        super(titulo, autor, anio);
        if (tamanioMb <= 0) {
            throw new DatoInvalidoException("El tamaño en megas debe ser mayor que cero.");
        }
        this.tamanioMb = tamanioMb;
    }

    public double getTamanioMb() { return tamanioMb; }

    @Override
    public String descripcion() {
        return "[Digital] " + getTitulo() + " - " + getAutor() + " (" + getAnio() + "), " + tamanioMb + " MB";
    }
}
