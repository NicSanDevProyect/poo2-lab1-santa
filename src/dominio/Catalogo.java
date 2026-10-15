package dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Catalogo {
    private final List<Libro> libros = new ArrayList<>();

    public void agregar(Libro libro) {
        libros.add(libro);
    }

    public List<Libro> listar() {
        return Collections.unmodifiableList(libros);
    }

    /** Sobrecarga 1: por título (coincidencia parcial, sin distinguir mayúsculas). */
    public List<Libro> buscar(String titulo) {
        List<Libro> resultado = new ArrayList<>();
        for (Libro l : libros) {
            if (l.getTitulo().toLowerCase().contains(titulo.trim().toLowerCase())) {
                resultado.add(l);
            }
        }
        return resultado;
    }

    /** Sobrecarga 2: por año exacto. */
    public List<Libro> buscar(int anio) {
        List<Libro> resultado = new ArrayList<>();
        for (Libro l : libros) {
            if (l.getAnio() == anio) {
                resultado.add(l);
            }
        }
        return resultado;
    }
}
