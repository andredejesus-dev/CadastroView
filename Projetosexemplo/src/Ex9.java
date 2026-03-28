import java.util.Scanner;
import java.util.ArrayList;

public class Ex9 {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Matriz de clientes: [linha][coluna]
        // 0 = Nome | 1 = Telefone | 2 = Cidade
        String[][] clientes = new String[5][3]; // até 5 clientes

        int totalClientes = 0;
        boolean rodando = true;

        while (rodando) {

            System.out.println("\n--- SISTEMA DE CLIENTES ---");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Editar Telefone");
            System.out.println("4 - Excluir");
            System.out.println("5 - Sair");
            System.out.print("Opção: ");

            int opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            switch (opcao) {

                case 1: // CADASTRAR
                    if (totalClientes < clientes.length) {
                        System.out.print("Nome: ");
                        clientes[totalClientes][0] = sc.nextLine();

                        System.out.print("Telefone: ");
                        clientes[totalClientes][1] = sc.nextLine();

                        System.out.print("Cidade: ");
                        clientes[totalClientes][2] = sc.nextLine();

                        totalClientes++;
                        System.out.println("Cliente cadastrado!");
                    } else {
                        System.out.println("Limite de clientes atingido!");
                    }
                    break;

                case 2: // LISTAR
                    if (totalClientes == 0) {
                        System.out.println("Nenhum cliente cadastrado.");
                    } else {
                        System.out.println("\n--- LISTA DE CLIENTES ---");
                        for (int i = 0; i < totalClientes; i++) {
                            System.out.println(
                                    i + " - " +
                                            clientes[i][0] + " | " +
                                            clientes[i][1] + " | " +
                                            clientes[i][2]
                            );
                        }
                    }
                    break;

                case 3: // EDITAR
                    System.out.print("Índice do cliente: ");
                    int idEditar = sc.nextInt();
                    sc.nextLine();

                    if (idEditar >= 0 && idEditar < totalClientes) {
                        System.out.print("Novo telefone: ");
                        clientes[idEditar][1] = sc.nextLine();
                        System.out.println("Telefone atualizado!");
                    } else {
                        System.out.println("Cliente não encontrado!");
                    }
                    break;

                case 4: // EXCLUIR
                    System.out.print("Índice do cliente: ");
                    int idExcluir = sc.nextInt();
                    sc.nextLine();

                    if (idExcluir >= 0 && idExcluir < totalClientes) {
                        for (int i = idExcluir; i < totalClientes - 1; i++) {
                            clientes[i] = clientes[i + 1];
                        }
                        totalClientes--;
                        System.out.println("Cliente removido!");
                    } else {
                        System.out.println("Cliente não encontrado!");
                    }
                    break;

                case 5:
                    rodando = false;
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }

        sc.close();
    }
}





