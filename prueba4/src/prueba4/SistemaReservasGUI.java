/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
/**
 *
 * @author tamar
 */
public class SistemaReservasGUI {
    // Instancias de las clases proporcionadas
    private static SalaCine salaCine = new SalaCine("Megalodon", 5, 6);
    private static Actividad gimnasio = new Actividad("Gimnasio", "2 pm - 7 pm", 5);
    private static Actividad baile = new Actividad("Baile", "7 pm", 30);
    private static Barista barista = new Barista(10);

    public static void main(String[] args) {
        crearMenuPrincipal();
    }

    private static void crearMenuPrincipal() {
        JFrame frame = new JFrame("Sistema de Reservas Básico");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(5, 1));

        // Botones del menú principal
        agregarBoton(panel, "Reservar Asiento en Cine", e -> reservarAsientoCine());
        agregarBoton(panel, "Mostrar Asientos del Cine", e -> mostrarAsientosCine());
        agregarBoton(panel, "Reservar Actividad", e -> reservarActividad());
        agregarBoton(panel, "Reservar Bebida (Barista)", e -> reservarBebidaBarista());
        agregarBoton(panel, "Listar Reservas del Barista", e -> listarReservasBarista());

        frame.add(panel);
        frame.setVisible(true);
    }

    // Método corregido para agregar botones
    private static void agregarBoton(JPanel panel, String texto, ActionListener listener) {
        JButton boton = new JButton(texto);
        boton.addActionListener(listener);
        panel.add(boton);
    }

    // Métodos de funcionalidad
    private static void reservarAsientoCine() {
        int fila = Integer.parseInt(JOptionPane.showInputDialog("Ingrese fila (0-4):"));
        int columna = Integer.parseInt(JOptionPane.showInputDialog("Ingrese columna (0-5):"));
        String idEmpleado = JOptionPane.showInputDialog("Ingrese ID del empleado:");

        if (salaCine.asignarAsiento(fila, columna, idEmpleado)) {
            JOptionPane.showMessageDialog(null, "Asiento reservado con éxito.");
        } else {
            JOptionPane.showMessageDialog(null, "El asiento ya está ocupado.");
        }
    }

    private static void mostrarAsientosCine() {
        StringBuilder asientos = new StringBuilder("Asientos de la sala:\n");
        char letra = 'A';
        for (int i = 0; i < salaCine.getAsientos().length; i++) {
            asientos.append(letra).append(" ");
            for (int j = 0; j < salaCine.getAsientos()[i].length; j++) {
                asientos.append(salaCine.getAsientos()[i][j] == null ? "[ ]" : "[X]").append(" ");
            }
            asientos.append("\n");
            letra++;
        }
        JOptionPane.showMessageDialog(null, asientos.toString());
    }

    private static void reservarActividad() {
        String[] opciones = {"Gimnasio", "Baile"};
        String actividad = (String) JOptionPane.showInputDialog(null, "Seleccione actividad:", "Reservar Actividad",
                JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

        String idEmpleado = JOptionPane.showInputDialog("Ingrese ID del empleado:");
        Actividad seleccionada = actividad.equals("Gimnasio") ? gimnasio : baile;

        if (seleccionada.reservar(idEmpleado)) {
            JOptionPane.showMessageDialog(null, "Actividad reservada con éxito.");
        } else {
            JOptionPane.showMessageDialog(null, "No hay cupo disponible.");
        }
    }

    private static void reservarBebidaBarista() {
        String[] menu = {"Café normal", "Capuchino", "Chocolate", "Moka"};
        String bebida = (String) JOptionPane.showInputDialog(null, "Seleccione bebida:", "Reservar Bebida",
                JOptionPane.QUESTION_MESSAGE, null, menu, menu[0]);

        String hora = JOptionPane.showInputDialog("Ingrese hora de entrega:");
        String idEmpleado = JOptionPane.showInputDialog("Ingrese ID del empleado:");

        if (barista.reservarBebida(idEmpleado, bebida, hora)) {
            JOptionPane.showMessageDialog(null, "Bebida reservada con éxito.");
        } else {
            JOptionPane.showMessageDialog(null, "Ya tiene una reserva.");
        }
    }

    private static void listarReservasBarista() {
        StringBuilder reservas = new StringBuilder("Reservas del barista:\n");
        reservas.append(obtenerReservasBarista());
        JOptionPane.showMessageDialog(null, reservas.toString());
    }

    private static String obtenerReservasBarista() {
        StringBuilder resultado = new StringBuilder();
        barista.listarReservas(); // La salida va a consola según tu clase original
        resultado.append("Ver consola para detalles de reservas.");
        return resultado.toString();
    }
}
