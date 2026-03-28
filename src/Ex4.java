import java.util.Scanner;

public class Ex4 {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número de 1 a 4: ");
        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1: // Primavera
                System.out.println("Primavera em SP:");
                System.out.println("- Qualidades:");
                System.out.println("  • Temperaturas amenas");
                System.out.println("  • Florescimento de árvores e parques");
                System.out.println("  • Maior sensação de bem-estar");
                System.out.println("- Problemas:");
                System.out.println("  • Aumento de alergias devido ao pólen");
                System.out.println("  • Chuvas passageiras podem causar transtornos no trânsito");
                break;
            case 2: // Verão
                System.out.println("Verão em SP:");
                System.out.println("- Qualidades:");
                System.out.println("  • Dias mais longos e ensolarados");
                System.out.println("  • Ótimo para lazer ao ar livre e praias próximas");
                System.out.println("- Problemas:");
                System.out.println("  • Chuvas fortes e tempestades frequentes");
                System.out.println("  • Possibilidade de alagamentos e trânsito lento");
                System.out.println("  • Calor intenso em horários de pico");
                break;
            case 3: // Outono
                System.out.println("Outono em SP:");
                System.out.println("- Qualidades:");
                System.out.println("  • Temperaturas agradáveis");
                System.out.println("  • Céu geralmente limpo e clima estável");
                System.out.println("- Problemas:");
                System.out.println("  • Mudança de temperatura pode causar resfriados");
                System.out.println("  • Folhas secas podem gerar sujeira nas ruas e praças");
                break;
            case 4: // Inverno
                System.out.println("Inverno em SP:");
                System.out.println("- Qualidades:");
                System.out.println("  • Clima seco e dias ensolarados");
                System.out.println("  • Menos chuva e mais facilidade em eventos ao ar livre");
                System.out.println("- Problemas:");
                System.out.println("  • Clima seco pode afetar a pele e vias respiratórias");
                System.out.println("  • Risco maior de gripe e resfriados");
                System.out.println("  • Temperaturas baixas à noite e madrugada");
                break;
            default:
                System.out.println("Número inválido. Digite entre 1 e 4.");
        }

        scanner.close();
    }
}
