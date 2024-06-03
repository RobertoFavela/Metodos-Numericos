import java.util.Scanner;

public class Biseccion {
    public static void main(String[] args) {
        biseccion();
    }

    public static void biseccion() {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Ingrese el error aproximado: ");
        double vError = entrada.nextDouble();
        System.out.print("Ingrese el valor inicial: ");
        double vInicial = entrada.nextDouble();
        System.out.print("Ingrese el valor final: ");
        double vFinal = entrada.nextDouble();
        
        biseccionRecursiva(vInicial, vFinal, vError, 1);
    }

    public static void biseccionRecursiva(double Xizq, double Xder, double vError, int iteracion) {
        double Fizq = f(Xizq), Fder = f(Xder), Xm = m(Xizq, Xder), fXm = f(Xm);

        System.out.println(iteracion + ")");
        System.out.printf("Xizq= %6.6f     F(Xizq)= %6.6f\n", Xizq, Fizq);
        System.out.printf("Xder= %6.6f     F(Xder)= %6.6f\n", Xder, Fder);
        System.out.printf("  Xm= %6.6f       F(Xm)= %6.6f\n", Xm, fXm);

        iteracion += 1;

        if (Math.abs(fXm) < vError) {
            System.out.println("----------------------------------------\n" +
                  "    Raiz aproximada: " + Xm + "\n" +
                  "----------------------------------------");
        } else {
            if (fXm > 0) {
                biseccionRecursiva(Xm, Xder, vError, iteracion);
            } else {
                biseccionRecursiva(Xizq, Xm, vError, iteracion);
            }
        }
    }

    //metodo para realizar la sustitucion en la funcion
    public static double f(double x) {
        // f(x) = sin(x) - x^2
        return Math.sin(x) - Math.pow(x, 2);
    }

    //metodo para ahorrarme sacar la Xm cada iteracion
    public static double m(double Xizq, double Xder) {
        return (Xizq + Xder) / 2;
    }
}

