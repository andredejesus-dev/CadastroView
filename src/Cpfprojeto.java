import java.util.Random;

public class Cpfprojeto {


    public static String gerarCPF() {
        Random random = new Random();
        int[] cpf = new int[11];

        // Gera os 9 primeiros dígitos
        for (int i = 0; i < 9; i++) {
            cpf[i] = random.nextInt(10);
        }

        // Primeiro dígito verificador
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += cpf[i] * (10 - i);
        }
        cpf[9] = (11 - (soma % 11)) >= 10 ? 0 : (11 - (soma % 11));

        // Segundo dígito verificador
        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += cpf[i] * (11 - i);
        }
        cpf[10] = (11 - (soma % 11)) >= 10 ? 0 : (11 - (soma % 11));

        // Converte para String
        StringBuilder cpfStr = new StringBuilder();
        for (int i : cpf)
            cpfStr.append(i);

        return cpfStr.toString();
    }

    }








