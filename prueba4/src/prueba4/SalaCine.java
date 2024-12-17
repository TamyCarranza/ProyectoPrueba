/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba4;

/**
 *
 * @author tamar
 */
public class SalaCine {
    private String pelicula;
    private int filas;
    private int columnas;
    private String[][] asientos;

    public SalaCine(String pelicula, int filas, int columnas) {
        this.pelicula = pelicula;
        this.filas = filas;
        this.columnas = columnas;
        this.asientos = new String[filas][columnas];
    }

    public String getPelicula() {
        return pelicula;
    }

    public void setPelicula(String pelicula) {
        this.pelicula = pelicula;
    }

    public void setTamanioSala(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.asientos = new String[filas][columnas]; // Reiniciar asientos
    }

    public boolean asignarAsiento(int fila, int columna, String empleadoId) {
        if (asientos[fila][columna] == null) {
            asientos[fila][columna] = empleadoId;
            return true;
        }
        return false;
    }

    public void liberarAsiento(int fila, int columna) {
        asientos[fila][columna] = null;
    }

    public void mostrarAsientos() {
        char letra = 'A';
        for (int i = 0; i < filas; i++) {
            System.out.print(letra + " ");
            for (int j = 0; j < columnas; j++) {
                System.out.print((asientos[i][j] == null ? "[ ]" : "[X]") + " ");
            }
            System.out.println();
            letra++;
        }
    }

    // Método necesario para obtener la matriz de asientos
    public String[][] getAsientos() {
        return asientos;
    }
}