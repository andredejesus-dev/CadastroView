import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        double v1, v2, Resultado;
        int soma;

        System.out.println("digite o primeiro valor");
        v1 = scan.nextDouble();
        System.out.println("digite o segundo valor");
        v2 = scan.nextDouble();
        System.out.println("digite o operador");
        System.out.println("1 soma");
        System.out.println("2 subtraçâo");
        System.out.println("3 multiplicação");
        System.out.println("4 divisão");
        soma = scan.nextInt();
        switch (soma) {
            case 1:
                Resultado = v1 + v2;
                System.out.println(Resultado);
            case 2:
                Resultado = v1 - v2;
                System.out.println(Resultado);
                break;
            case 3:
                Resultado = v1 * v2;
                System.out.println(Resultado);
                break;
            case 4:
                Resultado = v1 / v2;
                break;
            default:
                System.out.println("valor invalido");


        }

    }
}