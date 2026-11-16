package utilitario;

public class Validacion {

    public static boolean esTextoValido(String texto) {
        return texto != null && !texto.trim().isEmpty();
    }

    public static boolean esPositivo(double valor) {
        return valor > 0;
    }
}
