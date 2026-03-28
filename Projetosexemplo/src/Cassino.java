import java.util.Random;
import java.util.Scanner;

public class Cassino {

    // Classe Usuario
    static class Usuario {
        private String nome;
        private double saldo;

        public Usuario(String nome, double saldo) {
            this.nome = nome;
            this.saldo = saldo;
        }

        public String getNome() {
            return nome;
        }

        public double getSaldo() {
            return saldo;
        }

        public void adicionarSaldo(double valor) {
            saldo += valor;
        }

        public boolean apostar(double valor) {
            if (valor > saldo) {
                System.out.println("Saldo insuficiente!");
                return false;
            }
            saldo -= valor;
            return true;
        }
    }

    // Main
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("=== Bem-vindo ao Site de Apostas ===");
        System.out.print("Digite seu nome: ");
        String nome = sc.nextLine();
        Usuario usuario = new Usuario(nome, 100.0); // saldo inicial 100

        boolean continuar = true;

        while (continuar) {
            System.out.println("\nSeu saldo: R$" + usuario.getSaldo());
            System.out.print("Quanto deseja apostar? (0 para sair): R$");
            double aposta = sc.nextDouble();
            if (aposta == 0) {
                System.out.println("Obrigado por jogar! Saldo final: R$" + usuario.getSaldo());
                break;
            }

            if (!usuario.apostar(aposta)) {
                continue;
            }

            System.out.println("Escolha seu número da sorte (1 a 6): ");
            int escolha = sc.nextInt();
            int resultado = rand.nextInt(6) + 1; // número aleatório 1 a 6

            System.out.println("Resultado do dado: " + resultado);

            if (escolha == resultado) {
                double ganho = aposta * 5; // multiplica aposta por 5 se acertar
                System.out.println("Parabéns! Você ganhou R$" + ganho);
                usuario.adicionarSaldo(ganho);
            } else {
                System.out.println("Você perdeu a aposta.");
            }

            System.out.print("Deseja continuar jogando? (s/n): ");
            char resp = sc.next().toLowerCase().charAt(0);
            if (resp != 's') {
                continuar = false;
                System.out.println("Obrigado por jogar! Saldo final: R$" + usuario.getSaldo());
            }
        }

        sc.close();
    }
}
