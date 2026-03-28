import java.util.ArrayList;
import java.util.Scanner;

public class Ex7 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Array bidimensional usando ArrayList
        ArrayList<String[]> clientes = new ArrayList<>();

        // Clientes iniciais
        clientes.add(new String[]{"João Silva", "11-9999", "São Paulo"});
        clientes.add(new String[]{"Maria Souza", "21-8888", "Rio de Janeiro"});

        boolean rodando = true;

        while (rodando) {

            System.out.println("\n--- SISTEMA DE CLIENTES ---");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Listar Clientes");
            System.out.println("3 - Editar Cliente");
            System.out.println("4 - Excluir Cliente");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");

            String opcao = sc.nextLine();

            switch (opcao) {

                // CADASTRAR
                case "1":
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Telefone: ");
                    String telefone = sc.nextLine();

                    System.out.print("Cidade: ");
                    String cidade = sc.nextLine();

                    clientes.add(new String[]{nome, telefone, cidade});
                    System.out.println("Cliente cadastrado!");
                    break;

                // LISTAR
                case "2":
                    if (clientes.isEmpty()) {
                        System.out.println("Nenhum cliente cadastrado.");
                    } else {
                        System.out.println("\n--- LISTA DE CLIENTES ---");
                        for (int i = 0; i < clientes.size(); i++) {
                            System.out.println(
                                    i + " - " +
                                            clientes.get(i)[0] + " | " +
                                            clientes.get(i)[1] + " | " +
                                            clientes.get(i)[2]
                            );
                        }
                    }
                    break;

                // EDITAR
                case "3":
                    System.out.print("Digite o índice do cliente: ");
                    int idEditar = Integer.parseInt(sc.nextLine());

                    if (idEditar >= 0 && idEditar < clientes.size()) {
                        System.out.print("Novo telefone: ");
                        String novoTelefone = sc.nextLine();
                        clientes.get(idEditar)[1] = novoTelefone;
                        System.out.println("Telefone atualizado!");
                    } else {
                        System.out.println("Cliente não encontrado!");
                    }
                    break;

                // EXCLUIR
                case "4":
                    System.out.print("Digite o índice do cliente: ");
                    int idExcluir = Integer.parseInt(sc.nextLine());

                    if (idExcluir >= 0 && idExcluir < clientes.size()) {
                        clientes.remove(idExcluir);
                        System.out.println("Cliente removido!");
                    } else {
                        System.out.println("Cliente não encontrado!");
                    }
                    break;

                // SAIR
                case "5":
                    rodando = false;
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }

        sc.close();
    }
}
