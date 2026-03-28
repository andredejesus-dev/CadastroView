import java.util.Scanner;

public class ExercicioTernario {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // --- Exercício 1: Sistema de Login ---
        System.out.print("Digite seu nome: ");
        String nome = sc.nextLine();

        boolean estaLogado = !nome.isEmpty();
        String status = (estaLogado) ? "Bem-vindo de volta, " + nome + "!" : "Por favor, faça login";
        System.out.println(status);

        // --- Exercício 2: Desconto na Loja ---
        System.out.print("Digite o valor da compra: R$");
        double valorCompra = sc.nextDouble();
        int desconto = (valorCompra > 100) ? 10 : 0;
        System.out.println("Valor da compra: R$" + valorCompra + " - Desconto: " + desconto + "%");

        // --- Exercício 3: Sensor de Temperatura ---
        System.out.print("Digite a temperatura atual: ");
        int temperatura = sc.nextInt();
        String clima = (temperatura >= 30) ? "Quente" : "Frio";
        System.out.println("Temperatura: " + temperatura + "°C - Clima: " + clima);

        sc.close();
    }
}
