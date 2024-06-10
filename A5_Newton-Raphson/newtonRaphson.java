import java.util.Scanner;

public class newtonRaphson {

    public static void main(String[] args) {
        newtonRaphson();
    }

    public static void newtonRaphson() {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Ingrese el error aproximado: ");
        double vError = entrada.nextDouble();
        System.out.print("Ingrese el valor inicial: ");
        double x = entrada.nextDouble();

        newtonRaphsonRecursivo(vError, x, 0);
    }

    public static void newtonRaphsonRecursivo(double vError, double x, int iteracion) {
        
        double siguienteX = x - (f(x) / fprima(x));

        System.out.println(iteracion + ")");
        System.out.printf("X%d= %6.6f   F(X)= %6.6f   F'(X)= %6.6f\n", iteracion, x, f(x), fprima(x));
        iteracion += 1;

        if (Math.abs(f(x)) < vError) {
            System.out.println("--------------------------");
            System.out.printf("Valor de raiz: %7f", siguienteX);
            System.out.println("\n" + //
                                "--------------------------");
        } else {
            
            newtonRaphsonRecursivo(vError, siguienteX, iteracion);
        }
    }

    public static double f(double X) {
        return 0.95 * Math.pow(X, 3) - 5.9 * Math.pow(X, 2) + 10.9 * X - 6;
    }

    public static double fprima(double X) {
        return 2.85 * Math.pow(X, 2) - 11.8 * X + 10.9;
    }
}

