package com.company;

//Guardo los resultados de cada carrera
class Resultados {
    int[][] carrera;
    int[] carreras;
    String[][] cadena;

    Resultados(int numCorredores, int numCarrera) {
        this.carrera = new int[numCarrera][numCorredores];
        this.carreras = new int[numCarrera];
        this.cadena = new String[numCarrera][numCorredores];
    }

    void getResultados() {

        for (int t = 0; t < 1; t++) {
            for (int i = 0; i < carrera.length; i++) {
                this.cadena[t][i] = "Carrera " + this.carreras[t] + ": El caballo " + (i + 1) + " ha tardado: " + this.carrera[t][i] + " sprints\n";
            }
        }
    }
}
