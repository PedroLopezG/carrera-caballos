package com.company;

import javax.swing.*;
import java.util.Scanner;

public class Caballo {

    static int numCarreras;
    private static OperacionHilos corredor[];
    private static int numCorredores;

    public static void Lanzar(Scanner teclado) {

        String corredores = JOptionPane.showInputDialog(null, "¿Cuántos Caballos?");
        numCorredores = Integer.parseInt(corredores);
        numCarreras = numCorredores;
        Resultados res = new Resultados(numCorredores, numCarreras);
        corredor = new OperacionHilos[numCarreras];

        for (int i = 0; i < 1; i++) {
            corredor[i] = new OperacionHilos(i + 1, res, numCarreras);
            corredor[i].start(); //Empiezo el hilo
            try {
                corredor[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        JOptionPane.showMessageDialog(null,"La carrera ha finalizado... Han llegado los " + numCarreras + " caballos");
        res.getResultados();
        for (int t = 0; t < 1; t++) {
            System.out.println("--------------------------------------------------------------------------------");
            for (int i = 0; i < numCorredores; i++)
                System.out.print(res.cadena[t][i]);

            System.out.println("--------------------------------------------------------------------------------");
        }
    }
}

