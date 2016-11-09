package Processos;

/**
 *
 * @author a1711199
 */
public enum Tipo {
    Usuario("U"),
    Sistema("S");
    String texto;

    private Tipo(String texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {
        return texto;
    }
}
