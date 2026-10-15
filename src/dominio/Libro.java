package dominio;

import java.time.Year;

public abstract class Libro {
    public static final int ANIO_MINIMO = 1450;

    private final String titulo;
    private final String autor;
    private final int anio;

    protected Libro(String titulo, String autor, int anio) throws DatoInvalidoException {
        if (titulo == null || titulo.isBlank()) {
            throw new DatoInvalidoException("El título no puede estar vacío.");
        }
        if (autor == null || autor.isBlank()) {
            throw new DatoInvalidoException("El autor no puede estar vacío.");
        }
        int anioActual = Year.now().getValue();
        if (anio < ANIO_MINIMO || anio > anioActual) {
            throw new DatoInvalidoException(
                    "El año debe estar entre " + ANIO_MINIMO + " y " + anioActual + ".");
        }
        this.titulo = titulo.trim();
        this.autor = autor.trim();
        this.anio = anio;
    }

    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public int getAnio() { return anio; }

    /** Cada tipo de libro describe a su manera. */
    public abstract String descripcion();
}
