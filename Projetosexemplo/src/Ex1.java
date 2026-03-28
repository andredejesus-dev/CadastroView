import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o valor do desconto:");
        double valor = sc.nextDouble();
        System.out.println("Digite o valor do perecentual");
        double percentual = sc.nextDouble();
        double valorfinal = calcualardesconto(valor, percentual);
        System.out.println("Valor com desconto:" + valorfinal);
        sc.close();
    }

    public static double calcualardesconto(double valor, double percentual) {
        double desconto = (valor * percentual) / 100;
        return valor - desconto;
    }


}

