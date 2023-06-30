/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examenformativo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author Stefanny
 */
public class GestorTareas {
    private Stack<Tarea> pilaTareas;
    private Queue<Tarea> colaTareas;

    public GestorTareas() {
        pilaTareas = new Stack<>();
        colaTareas = new LinkedList<>();
    }

    public void agregarTareaPila(Tarea tarea) {
        pilaTareas.push(tarea);
    }

    public void agregarTareaCola(Tarea tarea) {
        colaTareas.add(tarea);
    }

    public Tarea eliminarTareaPila(String nombreTarea) {
        Stack<Tarea> tempStack = new Stack<>();
        Tarea tareaEliminada = null;

        while (!pilaTareas.isEmpty()) {
            Tarea tarea = pilaTareas.pop();
            if (tarea.getNombre().equals(nombreTarea)) {
                tareaEliminada = tarea;
                break;
            }
            tempStack.push(tarea);
        }

        while (!tempStack.isEmpty()) {
            pilaTareas.push(tempStack.pop());
        }

        return tareaEliminada;
    }

    public Tarea eliminarTareaCola(String nombreTarea) {
        Queue<Tarea> tempQueue = new LinkedList<>();
        Tarea tareaEliminada = null;

        while (!colaTareas.isEmpty()) {
            Tarea tarea = colaTareas.poll();
            if (tarea.getNombre().equals(nombreTarea)) {
                tareaEliminada = tarea;
                break;
            }
            tempQueue.add(tarea);
        }

        while (!tempQueue.isEmpty()) {
            colaTareas.add(tempQueue.poll());
        }

        return tareaEliminada;
    }

    public void mostrarTareasPila() {
        for (Tarea tarea : pilaTareas) {
            System.out.println("Nombre: " + tarea.getNombre());
            System.out.println("Descripción: " + tarea.getDescripcion());
            System.out.println();
        }
    }

    public void mostrarTareasCola() {
        for (Tarea tarea : colaTareas) {
            System.out.println("Nombre: " + tarea.getNombre());
            System.out.println("Descripción: " + tarea.getDescripcion());
            System.out.println();
        }
    }
}