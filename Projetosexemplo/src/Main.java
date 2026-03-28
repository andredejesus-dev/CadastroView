import java.util.Random;  // ← ESSENCIAL

public class Main {

    public static void main(String[] args) {
        System.out.println("CPF gerado: " + gerarCPF());
    }

    public static String gerarCPF() {
        Random random = new Random();
        int[] cpf = new int[11];

        for (int i = 0; i < 9; i++) {
            cpf[i] = random.nextInt(10);
        }

        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += cpf[i] * (10 - i);
        }
        cpf[9] = (11 - (soma % 11)) >= 10 ? 0 : (11 - (soma % 11));

        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += cpf[i] * (11 - i);
        }
        cpf[10] = (11 - (soma % 11)) >= 10 ? 0 : (11 - (soma % 11));

        StringBuilder cpfStr = new StringBuilder();
        for (int i : cpf) {
            cpfStr.append(i);
        }

        return cpfStr.toString();
    }
}
