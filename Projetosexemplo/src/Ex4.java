import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        String[] produtos = new String[5];

        System.out.println("=== Cadastro de Produtos ===");


        for (int i = 0; i < produtos.length; i++) {
            System.out.print("Digite o nome do produto " + (i + 1) + ": ");
            produtos[i] = sc.nextLine();
        }


        System.out.println("\n=== Lista de Produtos ===");
        for (String produto : produtos) {
            System.out.println("- " + produto);
        }


        sc.close();
    }
}






