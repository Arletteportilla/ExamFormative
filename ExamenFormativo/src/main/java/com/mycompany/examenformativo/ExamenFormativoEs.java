/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.examenformativo;

/**
 *
 * @author Stefanny
 */
import java.util.Scanner;



public class ExamenFormativoEs {
    public static void main(String[] args) {
        GestorTareas gestor = new GestorTareas();
        Scanner scanner = new Scanner(System.in);

        int opcion = 0;
        while (opcion != 4) {
            System.out.println("---- Gestor de Tareas ----");
            System.out.println("1. Agregar una tarea");
            System.out.println("2. Eliminar una tarea de la pila");
            System.out.println("3. Eliminar una tarea de la cola");
            System.out.println("4. Mostrar todas las tareas");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea después de leer el entero

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre de la tarea: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese la descripción de la tarea: ");
                    String descripcion = scanner.nextLine();
                    Tarea tarea = new Tarea(nombre, descripcion);
                    gestor.agregarTareaPila(tarea);
                    gestor.agregarTareaCola(tarea);
                    System.out.println("Tarea agregada exitosamente.");
                    System.out.println();
                    break;
                case 2:
                    System.out.print("Ingrese el nombre de la tarea a eliminar de la pila: ");
                    String nombrePila = scanner.nextLine();
                    Tarea tareaPila = gestor.eliminarTareaPila(nombrePila);
                    if (tareaPila != null) {
                        System.out.println("Tarea eliminada de la pila: " + tareaPila.getNombre());
                    } else {
                        System.out.println("La pila está vacía o no se encontró la tarea especificada.");
                    }
                    System.out.println();
                    break;
                case 3:
                    System.out.print("Ingrese el nombre de la tarea a eliminar de la cola: ");
                    String nombreCola = scanner.nextLine();
                    Tarea tareaCola = gestor.eliminarTareaCola(nombreCola);
                    if (tareaCola != null) {
                        System.out.println("Tarea eliminada de la cola: " + tareaCola.getNombre());
                    } else {
                        System.out.println("La cola está vacía o no se encontró la tarea especificada.");
                    }
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Todas las tareas pendientes:");
                    System.out.println("Pila:");
                    gestor.mostrarTareasPila();
                    System.out.println("Cola:");
                    gestor.mostrarTareasCola();
                    System.out.println();
                    break;
                case 5:
                    System.out.println("Saliendo del gestor de tareas...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    System.out.println();
                    break;
            }
        }

        scanner.close();
    }
}
