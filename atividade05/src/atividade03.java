import java.util.Scanner;

public class atividade03 {
    public static void main(String[] args) {
        Scanner numeroInteiro = new Scanner(System.in);
        System.out.println("insira um numero inteiro");
        int numero = numeroInteiro.nextInt();
        if (numero % 2 == 0){System.out.println("esse numero é impar");}
    }

}
