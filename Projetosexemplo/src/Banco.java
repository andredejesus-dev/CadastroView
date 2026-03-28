import java.util.Scanner;

public class Banco {

    // Classe Conta estática para poder usar dentro do main
    static class Conta {
        private String nome;
        private double saldo;

        // Taxas de juros
        private static final double JUROS_POSITIVO = 0.02; // 2% ao mês
        private static final double JUROS_NEGATIVO = 0.05; // 5% ao mês (dívida)

        public Conta(String nome, double saldoInicial) {
            this.nome = nome;
            this.saldo = saldoInicial;
        }

        public String getNome() {
            return nome;
        }

        public double getSaldo() {
            return saldo;
        }

        public void depositar(double valor) {
            saldo += valor;
            System.out.println("Depósito de R$" + valor + " realizado com sucesso!");
        }

        public boolean sacar(double valor) {
            if (valor > saldo) {
                System.out.println("Saldo insuficiente! Você poderá ficar no negativo e pagar juros.");
                saldo -= valor; // permitir saldo negativo
                return false;
            } else {
                saldo -= valor;
                System.out.println("Saque de R$" + valor + " realizado com sucesso!");
                return true;
            }
        }

        public void aplicarJuros() {
            if (saldo >= 0) {
                double ganho = saldo * JUROS_POSITIVO;
                saldo += ganho;
                System.out.println("Juros positivo aplicado: R$" + String.format("%.2f", ganho));
            } else {
                double divida = saldo * JUROS_NEGATIVO; // saldo negativo
                saldo += divida; // divida é negativa, aumenta dívida
                System.out.println("Juros negativo aplicado: R$" + String.format("%.2f", divida));
            }
        }
    }

    // Main
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Bem-vindo ao Banco Java ===");
        System.out.print("Digite seu nome: ");
        String nome = sc.nextLine();

        Conta conta = new Conta(nome, 0.0); // saldo inicial zero

        boolean continuar = true;

        while (continuar) {
            System.out.println("\nOlá " + conta.getNome() + "! Seu saldo: R$" + String.format("%.2f", conta.getSaldo()));
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Depositar");
            System.out.println("2 - Sacar");
            System.out.println("3 - Aplicar juros");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            int opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Valor do depósito: R$");
                    double deposito = sc.nextDouble();
                    conta.depositar(deposito);
                    break;
                case 2:
                    System.out.print("Valor do saque: R$");
                    double saque = sc.nextDouble();
                    conta.sacar(saque);
                    break;
                case 3:
                    conta.aplicarJuros();
                    break;
                case 0:
                    continuar = false;
                    System.out.println("Obrigado por usar o Banco Java!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }

        sc.close();
    }
}
