package com.mycompany.a1_tabula;

import java.util.Scanner;

/**
 * @author favela
 */
public class Tabula {

    public static void main(String[] args) {
        Tabula.tabula();
    }

    public static void tabula() {
        Double inferior, superior, incremento;

        try (Scanner entrada = new Scanner(System.in)) {
            System.out.println("-----------------------------------\n"
                    + " Funcion a despejar: f(x)=senx-x^2\n"
                    + "-----------------------------------");
            System.out.print("Ingrese su valor inferior: ");
            inferior = entrada.nextDouble();
            System.out.print("Ingrese su valor superior: ");
            superior = entrada.nextDouble();
            System.out.print("Ingrese su valor de incremento: ");
            incremento = entrada.nextDouble();
        }

        System.out.println("-----------------------------------");

        System.out.println("----------------\n"
                + "   X    |     Y \n"
                + "----------------");
        for (Double i = inferior; i <= superior; i += incremento) {
            Double funcion = Math.sin(i) - Math.pow(i, 2);
            System.out.printf("%.5f   %.5f%n", i, funcion);
        }
        System.out.println("----------------");
    }
}
