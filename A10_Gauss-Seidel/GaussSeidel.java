import java.util.Scanner;

public class GaussSeidel {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        double[][] sistema = leeEcuaciones();
        System.out.print("Ingrese el valor del error: ");
        double valorError = entrada.nextDouble();
        seidel(sistema, 0, 0, 0, 0, valorError);

    }

    public static void seidel(double[][] sistema, double x1, double x2, double x3, int iteracion, double valorError) {
        
        double x1Nuevo = (sistema[0][3]-(sistema[0][1]*x2)-(sistema[0][2]*x3))/sistema[0][0];
        double x2Nuevo = (sistema[1][3]-(sistema[1][0]*x1Nuevo)-(sistema[1][2]*x3))/sistema[1][1];
        double x3Nuevo = (sistema[2][3]-(sistema[2][0]*x1Nuevo)-(sistema[2][1]*x2Nuevo))/sistema[2][2];

        System.out.println(iteracion + ")");
        System.out.println("x1 = " + x1Nuevo);
        System.out.println("x2 = " + x2Nuevo);
        System.out.println("x3 = " + x3Nuevo);
        iteracion += 1;

        if (x1Nuevo - x1 < valorError && x2Nuevo - x2 < valorError && x3Nuevo - x3 < valorError) {
            System.out.println();
        } else {
            seidel(sistema, x1Nuevo, x2Nuevo, x3Nuevo, iteracion, valorError);
        }
    }

    public static double[][] leeEcuaciones() {
        
        Scanner entrada = new Scanner(System.in);
        
        System.out.print("Ingrese el numero de ecuaciones a usar: ");
        int numEcuaciones = entrada.nextInt();
        
        if (numEcuaciones > 10) {
            System.out.println("No puedes usar mas de 10 ecuaciones");
            return null;
        } else {
            double[][] sistema = new double[numEcuaciones][4];

            for (int i = 0; i < numEcuaciones; i++) {
                System.out.println("-----------------");
                System.out.println((i + 1) + "ra Ecuacion");
                System.out.println("-----------------");
                System.out.print("X1: ");
                sistema[i][0] = entrada.nextDouble();
                System.out.print("X2: ");
                sistema[i][1] = entrada.nextDouble();
                System.out.print("X3: ");
                sistema[i][2] = entrada.nextDouble();
                System.out.print("Rs: ");
                sistema[i][3] = entrada.nextDouble();
            }

            return sistema;
        }

    }

    public static void despliegaSolucion(double[][] sistema) {
        System.out.println("/////////////////////////");
        for (int i = 0; i < sistema.length; i++) {
            for (int j = 0; j < sistema[i].length; j++) {
                if (j < sistema[i].length - 1) {
                    System.out.print(sistema[i][j] + "X" + (j + 1) + " ");
                } else {
                    System.out.print("= " + sistema[i][j]);
                }
            }
            System.out.println();
        }
        System.out.println("/////////////////////////");
    }
}
