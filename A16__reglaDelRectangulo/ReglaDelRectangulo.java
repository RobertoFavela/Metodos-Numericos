import java.util.Scanner;

public class ReglaDelRectangulo {
    
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Ingrese su limite inferior: ");
        double limiteInferior = entrada.nextDouble();

        System.out.print("Ingrese su limite superior: ");
        double limiteSuperior = entrada.nextDouble();

        System.out.print("Ingrese el numero de segmentos: ");
        int segmentos = entrada.nextInt();

        ReglaDelRectangulo(limiteInferior, limiteSuperior, segmentos);
    }

    public static void ReglaDelRectangulo(double limiteInferior, double limiteSuperior, int segmentos ) {

        double[] puntos = new double[segmentos];
        double[] puntosMedios = new double[segmentos];
        double[] alturas = new double[segmentos];
        double[] areas = new double[segmentos];

        double base = (limiteSuperior - limiteInferior) / segmentos;

        for (int i = 1; i < segmentos+1; i++) {
            puntos[i-1] = (base * i);
        }

        for (int i = 0; i < segmentos; i++) {
            if (i == 0) {
                puntosMedios[i] = puntos[i] / 2;
            } else {
                puntosMedios[i] = (puntos[i] + puntos[i - 1]) / 2;
            }
        }

        for (int i = 0; i < segmentos; i++) {
            alturas[i] = funcion(puntosMedios[i]);
        }

        for (int i = 0; i < segmentos; i++) {
            areas[i] = base * alturas[i];
        }


        desplegarSolucion(areas);
    }


    public static double funcion(double x) {
        return (1 - Math.pow(Math.E, (-2 * x)));
    }

    public static void desplegarSolucion(double[] areas) {
        double areaTotal = 0;
        System.out.println("----------------------------");
        System.out.println("   Area de los segmentos ");
        for(int i = 0; i < areas.length; i++) {
            System.out.println(areas[i]);
            areaTotal += areas[i];
        }
        System.out.println("----------------------------");
        System.out.println("Area total: " + areaTotal);
        System.out.println("----------------------------");
    }
}
