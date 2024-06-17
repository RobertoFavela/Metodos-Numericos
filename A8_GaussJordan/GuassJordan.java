import java.util.Scanner;

public class GuassJordan {
    
    public static void main(String[] args) {
        double[][] sistema = leeEcuaciones();
        GaussJordan(sistema);
        despliegaSolucion(sistema);
    }

    public static void GaussJordan(double[][] sistema) {
        int numEcuaciones = sistema.length; 
        int numVariables = sistema[0].length - 1; // el -1 es por la ultima columna de resultados)
        
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

    //Este metodo nos imprime todo el sistema de ecuaciones que reciba
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
