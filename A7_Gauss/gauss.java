import java.util.Scanner;

public class gauss {

    public static void main(String[] args) {
        double[][] sistema = leeEcuaciones();
        despliegaSolucion(sistema);
        eliminacionGauss(sistema);
    }

    //Esto nomas es para no teclearla a mano cada prueba
    public static double[][] datosPrecargados() {
        return new double[][]{
            {4, 10, 8, 142},
            {2, 6, 7, 89.5},
            {9, 2, 3, 56.5}
        };
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

    public static void eliminacionGauss(double[][] sistema) {
        int n = sistema.length; // esta es cantidad de ecuaciones que hay
    
        // al final tuve que usar un pivote si o si porque nomas no me salia
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double factor = sistema[j][i] / sistema[i][i]; 
                for (int k = 0; k <= n; k++) { 
                    sistema[j][k] -= factor * sistema[i][k];
                }
            }
        }
    
        double[] solucion = new double[n]; // para guardar los valores
        for (int i = n - 1; i >= 0; i--) {
            solucion[i] = sistema[i][n] / sistema[i][i]; // sustitucion para encontrar la x
            for (int j = i - 1; j >= 0; j--) {
                sistema[j][n] -= sistema[j][i] * solucion[i]; // actualizamos lo hecho antes con lo nuevo
            }
        }
    
        System.out.println("Las soluciones son:");
        for (int i = 0; i < n; i++) {
            System.out.println("X" + (i + 1) + " = " + solucion[i]); 
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
