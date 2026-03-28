import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite um número: ");
        int numero = 1;
        long fatorial = 1;
        for (int i = numero; i >= 1; i--) {
            fatorial *= i;
        }

        System.out.println((numero + "! = " + fatorial));
sc.close();





        }




    }








