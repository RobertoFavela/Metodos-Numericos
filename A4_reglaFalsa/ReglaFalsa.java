import java.util.Scanner;

public class ReglaFalsa {
    public static void main(String[] args) {
        ReglaFalsa();
    }

    public static void ReglaFalsa() {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Ingrese el error aproximado: ");
        double vError = entrada.nextDouble();
        System.out.print("Ingrese el valor inicial: ");
        double vInicial = entrada.nextDouble();
        System.out.print("Ingrese el valor final: ");
        double vFinal = entrada.nextDouble();
        
        ReglaFalsaRecursiva(vInicial, vFinal, vError, 1);
    }

    public static void ReglaFalsaRecursiva(double Xizq, double Xder, double vError, int iteracion) {
        double Fizq = f(Xizq);
        double Fder = f(Xder);
        double Xm = m(Xizq, Xder, Fizq, Fder);
        double fXm = f(Xm);

        System.out.println(iteracion + ")");
        System.out.printf("Xizq= %6.6f     F(Xizq)= %6.6f\n", Xizq, Fizq);
        System.out.printf("Xder= %6.6f     F(Xder)= %6.6f\n", Xder, Fder);
        System.out.printf("  Xm= %6.6f       F(Xm)= %6.6f\n", Xm, fXm);

        if (Math.abs(Xder - Xizq) < vError) {
            System.out.println("Raiz aproximada: " + Xm);
        } else {
            iteracion += 1;
            if (Fizq * fXm < 0) {
                ReglaFalsaRecursiva(Xizq, Xm, vError, iteracion);
            } else {
                ReglaFalsaRecursiva(Xm, Xder, vError, iteracion);
            }
        }
    }

    //metodo para realizar la sustitucion en la funcion
    public static double f(double x) {
        // f(x) = x^4 - 8x^3 - 35x^2 + 450x - 1001
        return Math.pow(x, 4) - 8 * Math.pow(x, 3) - 35 * Math.pow(x, 2) + 450 * x - 1001;
    }
    
    // Metodo para calcular Xm en cada iteracion
    public static double m(double Xizq, double Xder, double Fizq, double Fder) {
        return (Xizq * Fder - Xder * Fizq) / (Fder - Fizq);
    }
}
