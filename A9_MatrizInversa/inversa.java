import java.util.Scanner;

public class inversa {

    public static void main(String[] args) {
       double[][] sistema = leeEcuaciones();
       sistema = matrizInversa(sistema);
       despliegaSolucion(sistema);
    }

    public static double[][] matrizInversa(double [][] sistema) {
        int numEcuaciones = sistema.length; 
        int numVariables = sistema[0].length -1;
        
        for (int i = 0; i < numEcuaciones; i++) {
            //para solo usar las variables de la diagonal que quiero
            double elementoDiagonal = sistema[i][i];
            
            // conseguir el uno
            for (int j = 0; j <= numVariables; j++) {
                sistema[i][j] /= elementoDiagonal;
            }
            
            // convertir el resto de la columna en cero
            for (int k = 0; k < numEcuaciones; k++) {
                if (k != i) {
                    double factor = sistema[k][i];
                    for (int j = 0; j <= numVariables; j++) {
                        sistema[k][j] -= factor * sistema[i][j];
                    }
                }
            }
        }
        return sistema;
    }

    public static double[][] leeEcuaciones() {
        
        double[][] sistema = {
            {0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 1}
        };

        Scanner entrada = new Scanner(System.in);
        
        for (int i = 0; i < 3; i++) {
            System.out.println("-----------------");
            System.out.println((i + 1) + "ra Ecuacion");
            System.out.println("-----------------");
            System.out.print("X1: ");
            sistema[i][0] = entrada.nextDouble();
            System.out.print("X2: ");
            sistema[i][1] = entrada.nextDouble();
            System.out.print("X3: ");
            sistema[i][2] = entrada.nextDouble();
        }

        return sistema;
    }

    public static void despliegaSolucion(double[][] sistema) {
        System.out.println("/////////////////////////");
        for (int i = 0; i < sistema.length; i++) {
            for (int j = 0; j < sistema[i].length; j++) {
                if (j < sistema[i].length) {
                    System.out.print(sistema[i][j] + " ");
                } 
                if (j == 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
        }
        System.out.println("/////////////////////////");
    }
}