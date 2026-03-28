import java.util.Scanner;

public class Ex8 {

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            // Pergunta quantos alunos serão cadastrados
            System.out.print("Quantos alunos serão cadastrados? ");
            int totalAlunos = sc.nextInt();
            sc.nextLine(); // limpar buffer

            // Validação
            if (totalAlunos <= 0) {
                System.out.println("Quantidade inválida!");
                sc.close();
                return;
            }

            // Array bidimensional: [aluno][dados]
            // dados: 0 = nome | 1 = idade | 2 = curso
            String[][] tabelaAlunos = new String[totalAlunos][3];

            // Preenchendo a matriz
            for (int i = 0; i < totalAlunos; i++) {
                System.out.println("\nCadastro do aluno " + (i + 1));

                System.out.print("Nome: ");
                tabelaAlunos[i][0] = sc.nextLine();

                System.out.print("Idade: ");
                tabelaAlunos[i][1] = sc.nextLine();

                System.out.print("Curso: ");
                tabelaAlunos[i][2] = sc.nextLine();
            }

            // Geração do relatório
            System.out.println("\n-------- ALUNOS CADASTRADOS --------");

            for (int i = 0; i < tabelaAlunos.length; i++) {
                System.out.println(
                        "Aluno: " + tabelaAlunos[i][0] +
                                " | Idade: " + tabelaAlunos[i][1] +
                                " | Curso: " + tabelaAlunos[i][2]
                );
            }

            sc.close();
        }
    }


