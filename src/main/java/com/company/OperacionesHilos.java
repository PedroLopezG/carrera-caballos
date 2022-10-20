package com.company;

class OperacionesHilos extends Thread {
    private int numhilo;
    private ventanas ventana_hilo;
    private final int meta = 50;
    private Resultados res;
    private int numCarrera;

    OperacionesHilos(int i, Resultados res, int numCarrera){
        this.numhilo = i;
        ventana_hilo = new ventanas("Corredor " + numhilo, i*300, i);
        this.res = res;
        this.numCarrera = numCarrera-1;
    }

    public void run(){
        String[] nombres = new String[]{"Caramelo", "Arthur","Bolt","Joffrey","Ren","Speed","Ash","Kiriko","Roy"};
        String cadena;
        int metros = 1;
        int i = 1;
        int nNombre = (int) (Math.random()*9);
        while (metros < meta){
            cadena="El caballo #" + numhilo + " " + nombres[nNombre] + ", sprint " + i +  " y " + metros + " metros recorridos\n"; //Guardo cadena
            ventana_hilo.escribecadena(cadena); //Imprimo cadena en ventana
            try{
                sleep(1000);
            }catch(InterruptedException e) {
                System.out.println("Hilo Interrumpido.");
            }

            i++; //Sumo sprint
            metros = metros + (int) (Math.random() * 20); //Sumo metros aleatorios
        }
        res.carrera[numCarrera][numhilo-1]=i;

        System.out.println("El caballo #"+ numhilo +" ha FINALIZADO"); //Imprimo en consola
        cadena= "El caballo #" + numhilo + " " + nombres[nNombre] + " ha FINALIZADO"; //Guardo cadena
        ventana_hilo.escribecadena(cadena); //Imprimo cadena

    }

}
