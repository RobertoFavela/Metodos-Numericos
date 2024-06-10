import java.util.Scanner;

public class secante {
    public static void main(String[] args) {
        secante();
    }

    public static void secante() {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Ingrese el valor inicial: ");
        double Xuno = entrada.nextDouble();
        System.out.print("Ingrese el valor final: ");
        double Xdos = entrada.nextDouble();

        System.out.printf("X%d= %6.6f   F(X)= %6.6f\n", 1, Xuno, f(Xuno));
        secanteRecursiva(Xuno, Xdos, 2);
    }

    public static void secanteRecursiva(double Xuno, double Xdos, int numeroX) {
        double siguienteX = Xdos - ((f(Xdos) * (Xuno - Xdos)) / (f(Xuno) - f(Xdos)));

        System.out.printf("X%d= %6.6f   F(X)= %6.6f\n", numeroX, Xdos, f(Xdos));
        numeroX += 1;

        if (Math.abs(f(siguienteX)) < 0.001) {
            System.out.println("--------------------------");
            System.out.printf("Valor de raiz: %7f", siguienteX);
            System.out.println("\n" + "--------------------------");
        } else {
            secanteRecursiva(Xdos, siguienteX, numeroX);
        }
    }

    public static double f(double x) {
        return 8 * Math.sin(x) * Math.exp(-x) - 1;
    }
}
