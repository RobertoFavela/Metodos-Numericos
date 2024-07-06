/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.reglarectangulo;

import java.util.Scanner;

/**
 *
 * @author tacot
 */
public class ReglaRectangulo {

    public static void main(String[] args) {

        ReglaRectangulo R = new ReglaRectangulo();
        
        int n;
        double limiteI, limiteS;

        Scanner tec = new Scanner(System.in);

        System.out.println("Introduce el limite inferior");
        limiteI = tec.nextDouble();

        System.out.println("Introduce el limite superior");
        limiteS = tec.nextDouble();

        System.out.println("Introduce el numero de segmentos");
        n = tec.nextInt();
        
       R.reglaRectangulo(limiteI, limiteS, n);
    }

    public void reglaRectangulo(double limiteI, double limiteS, int n) {

        double[] puntos = new double[n];
        double[] puntosMedios = new double[n];
        double[] alturas = new double[n];
        double[] areas = new double[n];

        double base;
        base = limiteS / n;

        for (int i = 1; i < n+1; i++) {
            puntos[i-1] = (base * i);
        }

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                puntosMedios[i] = puntos[i] / 2;
            } else {
                puntosMedios[i] = (puntos[i] + puntos[i - 1]) / 2;
            }
        }

        for (int i = 0; i < n; i++) {
            alturas[i] = (1 - Math.pow(Math.E, (-2 * puntosMedios[i])));
        }

        for (int i = 0; i < n; i++) {
            areas[i] = base * alturas[i];
        }
        
        
        desplegarSolucion(puntos, puntosMedios, alturas, areas);
    }

    public void desplegarSolucion(double[] puntos, double[] puntosMedios, double[] alturas, double[] areas) {
        System.out.println("----------------------------------------------------------");
        System.out.println("|  puntos  |  puntosM  |  alturas |   areas  | areaTotal |");
        System.out.println("----------------------------------------------------------");

        for (int i = 0; i < puntos.length; i++) {

            if (i == 0) {
                
                double totalA=0;
                
                for (int j = 0; j < areas.length; j++) {
                    totalA += areas[j];
                }
                
                System.out.println(String.format("|%-10f| %-10f|%-10f|%-10f| %-10f|",
                        puntos[i], puntosMedios[i], alturas[i], areas[i], totalA));
                
            } else {
                System.out.println(String.format("|%-10f| %-10f|%-10f|%-10f|",
                        puntos[i], puntosMedios[i], alturas[i], areas[i]));
            }
        }
    }
}
