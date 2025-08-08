/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Crud;

/**
 *
 * @author Erasmo
 */
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
/* En esta clase se crea la interacion con la base de datos y metodos que permiten
  interactuar y añadir, leer, eliminar y lista informacion con la base de datos
 */
public class AsignacionPrueba {
    public static  final AsignacionDAO tareas = new AsignacionDAO();

    public  static void mostrarMenutareas() {
        System.out.println("**CRUD Asignaciones**");
        System.out.println("1. Crear asignaacion");
        System.out.println("2. Listar asignacion");
        System.out.println("3. Leer asignacion");
        System.out.println("4. Actualizar asignacion");
        System.out.println("5. Eliminar asignacion");
        System.out.println("6. Atras");
    }

    public  static int leerOpciontareas() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduzca una opción: ");
        return scanner.nextInt();
    }

    public static int  procesarOpciontareas(int opcion) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        switch (opcion) {
            case 1:
                crearTarea();
                break;
            case 2:
                listarTarea();
                break;
            case 3:
                leerTarea();
                break;
            case 4:
                actualizarTarea();
                break;
            case 5:
                eliminarTarea();
                break;
            case 6:
                System.out.println("Saliendo del programa...");
                break;
            default:
                System.out.println("Opción no válida.");
        }
        return opcion;
    }

    private static void crearTarea() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduzca el id de la asignacion: ");
        int id = scanner.nextInt();
        System.out.println("Introduzca el id del estudiante");
        int est = scanner.nextInt();
        System.out.println("Introduzca el id del profesor");
        int prof = scanner.nextInt();
        System.out.println("Introduzca el id de la materia");
        int mat = scanner.nextInt();
        System.out.println("Introduzca el id del aula");
        int aula = scanner.nextInt();
        System.out.println("Introduza del id del horario");
        int hora = scanner.nextInt();

        Asignacion tarea = new Asignacion();
        tarea.setId_asignacion(id);
        tarea.setId_estudiante(est);
        tarea.setId_profesor(prof);
        tarea.setId_materia(mat);
        tarea.setId_aula(aula);
        tarea.setId_horario(hora);

        tareas.create(tarea);
        System.out.println("Asignacion creada correctamente.");
    }

    private static void leerTarea() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduzca el ID de la asignacion: ");
        int id = scanner.nextInt();

        Asignacion tarea = tareas.read(id);

        if (tarea != null) {
            System.out.println("**Asignacion encontrada**");
            System.out.println("ID_asginacion : " + tarea.getId_asignacion());
            System.out.println("Id_estudiante:  " +tarea.getId_estudiante());
            System.out.println("Id_profesor: "+tarea.getId_profesor());
            System.out.println("Id_materia: "+tarea.getId_materia());
            System.out.println("Id_horario: "+tarea.getId_horario());
            System.out.println("Id_aula: "+tarea.getId_aula());
        } else {
            System.out.println("Asignacion no encontrada.");
        }
    }

    private static void actualizarTarea() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduzca el id de la asignacion: ");
        int id = scanner.nextInt();
        leerTarea();
        System.out.println("Introduzca el id del estudiante");
        int est = scanner.nextInt();
        System.out.println("Introduzca el id del profesor");
        int prof = scanner.nextInt();
        System.out.println("Introduzca el id de la materia");
        int mat = scanner.nextInt();
        System.out.println("Introduzca el id del aula");
        int aula = scanner.nextInt();
        System.out.println("Introduza del id del horario");
        int hora = scanner.nextInt();

        Asignacion tarea = new Asignacion();
        tarea.setId_asignacion(id);
        tarea.setId_estudiante(est);
        tarea.setId_profesor(prof);
        tarea.setId_materia(mat);
        tarea.setId_aula(aula);
        tarea.setId_horario(hora);

        tareas.update(tarea);
        System.out.println("Asignacion actualizada correctamente.");
    }

    private static void eliminarTarea() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduzca el ID de la asignacion : ");
        int id = scanner.nextInt();

        tareas.delete(id);
        System.out.println("Asignacion eliminada correctamente.");
    }

    private static void listarTarea() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        List<Asignacion> tarea = tareas.getAll();

        for (Asignacion deber : tarea) {
            System.out.println("ID_asginacion : " + deber.getId_asignacion());
            System.out.println("Id_estudiante:  " +deber.getId_estudiante());
            System.out.println("Id_profesor: "+deber.getId_profesor());
            System.out.println("Id_materia: "+deber.getId_materia());
            System.out.println("Id_horario: "+deber.getId_horario());
            System.out.println("Id_aula: "+deber.getId_aula());
            System.out.println();
        }
    }
}
