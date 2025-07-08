import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Bem vindo à calculadora!");
        System.out.println();

        while (true) {
            exibirMenu();

            int operacao = 0;
            boolean entradaValida = false;
            while (!entradaValida) {
                System.out.print("Opção: ");
                try {
                    operacao = sc.nextInt();
                    entradaValida = true;
                } catch (InputMismatchException e) {
                    System.out.println("Por favor, digite um número válido.");
                    sc.next();
                }
            }
            System.out.println();

            while (operacao > 5 || operacao < 1) {
                System.out.printf("Opção inválida. Por favor, digite novamente a opção desejada: %n%n");
                operacao = sc.nextInt();
            }

            if (operacao == 5) {
                break;
            }

            System.out.print("Informe o primeiro valor: ");
            double primeiro = sc.nextDouble();

            System.out.print("Informe o segundo valor: ");
            double segundo = sc.nextDouble();

            double resultado;
            if (operacao == 1) {
                resultado = somar(primeiro, segundo);
            } else if (operacao == 2) {
                resultado = subtrair(primeiro, segundo);
            } else if (operacao == 3) {
                resultado = multiplicar(primeiro, segundo);
            } else {
                while (segundo == 0){
                    System.out.print("O denominador não pode ser zero. Por favor, digite outro número: ");
                    segundo = sc.nextDouble();
                }
                resultado = dividir(primeiro, segundo);
            }

            System.out.printf("Resultado: %.2f%n%n", resultado);

            System.out.print("Deseja continuar (s/n): ");
            String resp = sc.next().trim().toLowerCase();
            System.out.println();

            if (resp.equals("n") || resp.equals("nao")) {
                break;
            }
        }

        System.out.println("Obrigado por usar a calculadora. Até a próxima!");

        sc.close();
    }

    public static double somar(double n1, double n2) {
        return n1 + n2;
    }

    public static double subtrair(double n1, double n2) {
        return n1 - n2;
    }

    public static double multiplicar(double n1, double n2) {
        return n1 * n2;
    }

    public static double dividir(double n1, double n2) {
        return n1 / n2;
    }

    public static void exibirMenu() {
        System.out.println("Selecione a operação: ");
        System.out.println("1) Soma");
        System.out.println("2) Subtração");
        System.out.println("3) Multiplicação");
        System.out.println("4) Divisão");
        System.out.println("5) Sair");
        System.out.println();
    }
}
