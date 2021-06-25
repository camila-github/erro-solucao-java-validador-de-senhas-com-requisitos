import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class ValidadorDeSenhas {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String senha;

        while ((senha = br.readLine()) != null) {
            boolean verificarTamanhoString = senha.length() >= 6 && senha.length() <= 32;
            boolean verificarCaracter = !senha.matches("^(?=.*[a-zA-Z])(?=.*[0-9])[A-Za-z0-9]+$");
            boolean verificarNumero = false;
            boolean letraMaiuscula = false;
            boolean letraMinuscula = false;

            for (int i = 0; i < senha.length(); i++) {
                if (Character.isDigit(senha.charAt(i))) {
                    verificarNumero = true;
                } else if (Character.isUpperCase(senha.charAt(i))) {
                    letraMaiuscula = true;
                } else if (Character.isLowerCase(senha.charAt(i))) {
                    letraMinuscula = true;
                }
            }

            if (verificarTamanhoString && !verificarCaracter 
                && verificarNumero && letraMaiuscula && letraMinuscula) {
                System.out.println("Senha valida.");
            } else {
                System.out.println("Senha invalida.");
            }
        }
    }
}