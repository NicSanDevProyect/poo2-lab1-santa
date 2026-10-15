package dominio;

/** Excepción propia: el negocio rechaza un dato (título vacío, año absurdo, etc.). */
public class DatoInvalidoException extends Exception {
    public DatoInvalidoException(String mensaje) {
        super(mensaje);
    }
}
