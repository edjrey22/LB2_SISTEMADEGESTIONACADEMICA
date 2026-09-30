package org.example;

import org.example.presentacion.EstudianteUI;
import org.example.presentacion.CursoUI;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== SISTEMA DE GESTIÓN ACADÉMICA ===");
            System.out.println("1. Gestionar estudiantes");
            System.out.println("2. Gestionar cursos");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            if (!sc.hasNextInt()) {
                System.out.println("Opción no válida");
                sc.nextLine();
                opcion = -1;
                continue;
            }

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Ha elegido Gestionar Estudiante.");
                    EstudianteUI.mostrarMenu(sc);
                    break;
                case 2:
                    System.out.println("Ha elegido Gestionar Cursos.");
                    CursoUI.mostrarMenu(sc);
                    break;
                case 0:
                    System.out.println("Sistema finalizado.");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 0);

        sc.close();
    }
}
