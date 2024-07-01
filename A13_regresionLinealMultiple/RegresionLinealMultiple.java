import java.util.Scanner;

public class RegresionLinealMultiple {
    public static void main(String[] args) {
        double[][] puntos = leePuntos();
        double [][] matriz = regresionLinealMultiple(puntos);
        GaussJordan(matriz);
        despliegaSolucion(matriz);
    }

    public static double[][] leePuntos() {
        Scanner entrada = new Scanner(System.in);
        
        System.out.print("Cantidad de puntos que va a ingresar: ");
        int m = entrada.nextInt();
        double[][] xy = new double[m][3];
        
        for (int i = 0; i < m; i++) {
            System.out.print("Ingrese X1" + (i+1) + ": ");
            xy[i][0] = entrada.nextDouble();
        }
        for (int i = 0; i < m; i++) {
            System.out.print("Ingrese X2" + (i+1) + ": ");
            xy[i][1] = entrada.nextDouble();
        }
        for (int i = 0; i < m; i++) {
            System.out.print("Ingrese Y" + (i+1) + ": ");
            xy[i][2] = entrada.nextDouble();
        }

        return xy;
    }

    public static double[][] regresionLinealMultiple(double[][] puntos) {
        double AcuX1=0, AcuX2=0, AcuY=0, AcuX12=0, AcuX22=0, AcuX1X2=0, AcuXY=0, AcuX2Y=0;
        for (int i = 0; i < puntos.length; i++) {
            AcuX1 += puntos[i][0];
            AcuX2 += puntos[i][1];
            AcuY += puntos[i][2];
            AcuX12 += Math.pow(puntos[i][0], 2);
            AcuX22 += Math.pow(puntos[i][1], 2);
            AcuX1X2 += puntos[i][0] * puntos[i][1];
            AcuXY += puntos[i][0] * puntos[i][2];
            AcuX2Y += puntos[i][1] * puntos[i][2];
        }

        return new double[][]{
            {puntos.length, AcuX1, AcuX2, AcuY},
            {AcuX1, AcuX12, AcuX1X2, AcuXY},
            {AcuX2, AcuX1X2, AcuX22, AcuX2Y}
        };
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

    public static void despliegaSolucion(double[][] sistema) {
        System.out.println("/////////////////////////");
        System.out.println("y = " + sistema[0][3] + " + " + sistema[1][3] + "x1 + " + sistema[2][3] + "x2");
        System.out.println("/////////////////////////");
    }
}
