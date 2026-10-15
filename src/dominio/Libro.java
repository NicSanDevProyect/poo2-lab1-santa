package dominio;

public abstract class Libro {
    private final String titulo;
    private final String autor;
    private final int anio;

    protected Libro(String titulo, String autor, int anio) {
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
    }

    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public int getAnio() { return anio; }

    /** Cada tipo de libro describe a su manera. */
    public abstract String descripcion();
}
