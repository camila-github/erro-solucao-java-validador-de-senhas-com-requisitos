## Exercicio (Java):  Validador de senhas com requisitos

O exercicio publicado é referente ao treinamento do Bootcamp Java Developer - Introdução a Busca e Substituição em Java 
(https://digitalinnovation.one)


#### Descrição do Desafio:

Pedro e Fernando são os desenvolvedores em uma stratup e vão desenvolver o novo sistema de cadastro, e pediram a sua ajuda. Sua task é fazer o código que valide as senhas que são cadastradas, para isso você deve atentar aos requisitos a seguir:

- A senha deve conter, no mínimo, uma letra maiúscula, uma letra minúscula e um número;
- A mesma não pode ter nenhum caractere de pontuação, acentuação ou espaço;
- Além disso, a senha pode ter de 6 a 32 caracteres.

#### Entrada: 

A entrada contém vários casos de teste e termina com final de arquivo. Cada linha tem uma string S, correspondente a senha que é inserida pelo usuário no momento do cadastro.

#### Saída: 

A saída contém uma linha, que pode ser “Senha valida.”, caso a senha tenha cada item dos requisitos solicitados anteriormente, ou “Senha invalida.”, se um ou mais requisitos não forem atendidos.

Exemplos de Entrada  | Exemplos de Saída
------------- | -------------
Digital Innovation One | Senha invalida.
AbcdEfgh99 | Senha valida.
DigitalInnovationOne123 | Senha valida.
Digital Innovation One 123 | Senha invalida.
Aass9 | Senha invalida.
Aassd9 | Senha valida.


#### Java　

```java
//SOLUCAO 1

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
```

