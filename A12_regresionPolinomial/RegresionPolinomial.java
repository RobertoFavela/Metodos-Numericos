import java.util.Scanner;

public class RegresionPolinomial {
    public static void main(String[] args) {
        double[][] puntos = leePuntos();
        double [][] matriz = regresionPolinomial(puntos);
        GaussJordan(matriz);
        despliegaSolucion(matriz);
    }

    public static double[][] leePuntos() {
        Scanner entrada = new Scanner(System.in);
        
        System.out.print("Cantidad de puntos que va a ingresar: ");
        int m = entrada.nextInt();
        double[][] xy = new double[m][2];
        
        for (int i = 0; i < m; i++) {
            System.out.print("Ingrese X" + (i+1) + ": ");
            xy[i][0] = entrada.nextDouble();
        }
        for (int i = 0; i < m; i++) {
            System.out.print("Ingrese Y" + (i+1) + ": ");
            xy[i][1] = entrada.nextDouble();
        }

        return xy;
    }

    public static double[][] regresionPolinomial(double[][] puntos) {
        double AcuX=0, AcuY=0, AcuX2=0, AcuX3=0, AcuX4=0, AcuXY=0, AcuX2Y=0;
        for (int i = 0; i < puntos.length; i++) {
            AcuX += puntos[i][0];
            AcuY += puntos[i][1];
            AcuX2 += Math.pow(puntos[i][0], 2);
            AcuX3 += Math.pow(puntos[i][0], 3);
            AcuX4 += Math.pow(puntos[i][0], 4);
            AcuXY += puntos[i][0] * puntos[i][1];
            AcuX2Y += Math.pow(puntos[i][0], 2) * puntos[i][1];
        }

        return new double[][]{
            {puntos[0].length, AcuX, AcuX2, AcuY},
            {AcuX, AcuX2, AcuX3, AcuXY},
            {AcuX2, AcuX3, AcuX4, AcuX2Y}
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