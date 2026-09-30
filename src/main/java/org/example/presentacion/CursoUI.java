package org.example.presentacion;

import org.example.bussines.Curso;

import org.example.bussines.CursoService;

import java.util.Scanner;

public class CursoUI {
    private static final CursoService service = new CursoService();


    public static void mostrarMenu(Scanner sc) {
        int opcion;

        do {
            System.out.println("\n=== GESTIÓN DE CURSOS ===");
            System.out.println("1. Registrar");
            System.out.println("2. Listar");
            System.out.println("3. Actualizar");
            System.out.println("4. Eliminar");
            System.out.println("0. Regresar");
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
                    registrar(sc);
                    break;
                case 2:
                    listar();
                    break;
                case 3:
                    actualizar(sc);
                    break;
                case 4:
                    eliminar(sc);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 0);
    }

    private static void registrar(Scanner sc) {
        int id = leerId(sc);
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Descripción: ");
        String descripcion = sc.nextLine();

        service.registrar(new Curso(id, nombre, descripcion));
        System.out.println("Curso registrado.");
    }

    private static void listar() {
        if (service.listar().isEmpty()) {
            System.out.println("No hay cursos registrados.");
            return;
        }

        service.listar().forEach(e -> System.out.println(
                e.getId() + " - " + e.getNombre() + " - " + e.getDescripcion()));
    }

    private static void actualizar(Scanner sc) {
        int id = leerId(sc);
        System.out.print("Nuevo nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Nueva descripción: ");
        String descripcion = sc.nextLine();

        boolean actualizado = service.actualizar(new Curso(id, nombre, descripcion));
        System.out.println(actualizado ? "Curso actualizado." : "Curso no encontrado.");
    }

    private static void eliminar(Scanner sc) {
        int id = leerId(sc);
        boolean eliminado = service.eliminar(id);
        System.out.println(eliminado ? "Curso eliminado." : "Curso no encontrado.");
    }

    private static int leerId(Scanner sc) {
        while (true) {
            System.out.print("ID: ");
            if (sc.hasNextInt()) {
                int id = sc.nextInt();
                sc.nextLine();
                return id;
            }
            System.out.println("El ID debe ser un número entero.");
            sc.nextLine();
        }
    }
}
