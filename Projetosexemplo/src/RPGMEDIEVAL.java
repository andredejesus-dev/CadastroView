import java.util.Random;import java.util.Random;
import java.util.Scanner;

public class RPGMEDIEVAL {

    static class Jogador {
        String nome;
        int vida;
        int ataque;

        public Jogador(String nome) {
            this.nome = nome;
            this.vida = 100;
            this.ataque = 20;
        }

        public boolean atacar(Inimigo inimigo) {
            Random rand = new Random();
            int dano = rand.nextInt(ataque / 2) + ataque / 2; // dano aleatório
            inimigo.vida -= dano;
            System.out.println(nome + " causou " + dano + " de dano ao " + inimigo.nome + "!");
            return inimigo.vida <= 0;
        }
    }

    static class Inimigo {
        String nome;
        int vida;
        int ataque;

        public Inimigo(String nome, int vida, int ataque) {
            this.nome = nome;
            this.vida = vida;
            this.ataque = ataque;
        }

        public boolean atacar(Jogador jogador) {
            Random rand = new Random();
            int dano = rand.nextInt(ataque / 2) + ataque / 2;
            jogador.vida -= dano;
            System.out.println(nome + " causou " + dano + " de dano a " + jogador.nome + "!");
            return jogador.vida <= 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("=== Bem-vindo ao RPG Medieval ===");
        System.out.print("Digite o nome do seu herói: ");
        String nomeJogador = sc.nextLine();

        Jogador heroi = new Jogador(nomeJogador);

        // Lista de inimigos
        Inimigo[] inimigos = {
                new Inimigo("Goblin", 30, 10),
                new Inimigo("Esqueleto", 40, 15),
                new Inimigo("Orc", 50, 20),
                new Inimigo("Dragão", 100, 25)
        };

        for (Inimigo inimigo : inimigos) {
            System.out.println("\nUm " + inimigo.nome + " apareceu!");

            while (heroi.vida > 0 && inimigo.vida > 0) {
                System.out.println("\n" + heroi.nome + " - Vida: " + heroi.vida);
                System.out.println(inimigo.nome + " - Vida: " + inimigo.vida);

                System.out.println("Escolha uma ação:");
                System.out.println("1 - Atacar");
                System.out.println("2 - Fugir");
                System.out.print("Opção: ");
                int opcao = sc.nextInt();

                if (opcao == 1) {
                    if (heroi.atacar(inimigo)) {
                        System.out.println("Você derrotou o " + inimigo.nome + "!");
                        break;
                    }
                    if (inimigo.atacar(heroi)) {
                        System.out.println("Você foi derrotado pelo " + inimigo.nome + "...");
                        System.out.println("GAME OVER");
                        sc.close();
                        return;
                    }

                } else if (opcao == 2) {
                    if (rand.nextBoolean()) {
                        System.out.println("Você conseguiu fugir do " + inimigo.nome + "!");
                        break;
                    } else {
                        System.out.println("Você não conseguiu fugir!");
                        if (inimigo.atacar(heroi)) {
                            System.out.println("Você foi derrotado pelo " + inimigo.nome + "...");
                            System.out.println("GAME OVER");
                            sc.close();
                            return;
                        }
                    }
                } else {
                    System.out.println("Opção inválida!");
                }
            }
        }

        System.out.println("\nParabéns, " + heroi.nome + "! Você derrotou todos os inimigos!");
        sc.close();
    }
}
