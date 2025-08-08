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
public class EstudiantePrueba {
    public static  final EstudianteDAO Student = new EstudianteDAO();

    public  static void mostrarMenu() {
        System.out.println("**CRUD Estudiante**");
        System.out.println("1. Crear estudiante");
        System.out.println("2. Listar estudiante");
        System.out.println("3. Leer estudiante");
        System.out.println("4. Actualizar estudiante");
        System.out.println("5. Eliminar estudiante");
        System.out.println("6. Atras");
    }

    public  static int leerOpcion() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduzca una opción: ");
        return scanner.nextInt();
    }

    public static int  procesarOpcion(int opcion) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        switch (opcion) {
            case 1:
                crearPersona();
                break;
            case 2:
                listarPersonas();
                break;
            case 3:
                leerPersona();
                break;
            case 4:
                actualizarPersona();
                break;
            case 5:
                eliminarPersona();
                break;
            case 6:
                System.out.println("Saliendo del programa...");
                break;
            default:
                System.out.println("Opción no válida.");
        }
        return opcion;
    }

    private static void crearPersona() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduzca el id del estudiante: ");
        int id = scanner.nextInt();
        System.out.print("Introduzca el nombre: ");
        String nombre = scanner.next();
        System.out.print("Introduzca el email: ");
        String correo = scanner.next();
        System.out.println("Introduzca la carrera");
        String carrera = scanner.next();

        Estudiante estudiante = new Estudiante();
        estudiante.setId_estudiante(id);
        estudiante.setNombre(nombre);
        estudiante.setCorreo(correo);
        estudiante.setCarrera(carrera);

        Student.create(estudiante);
        System.out.println("Estudiante creado correctamente.");
    }

    private static void leerPersona() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduzca el ID del estudiante: ");
        int id = scanner.nextInt();

        Estudiante estudiante = Student.read(id);

        if (estudiante != null) {
            System.out.println("**Estudiante encontrado**");
            System.out.println("ID: " + estudiante.getId_estudiante());
            System.out.println("Nombre: " + estudiante.getNombre());
            System.out.println("Correo: " + estudiante.getCorreo());
            System.out.println("Carrera: "+ estudiante.getCarrera());
        } else {
            System.out.println("Estudiante no encontrado.");
        }
    }

    private static void actualizarPersona() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduzca el ID del estudiante: ");
        int id = scanner.nextInt();
        leerPersona();
        System.out.print("Introduzca el nombre: ");
        String nombre = scanner.next();
        System.out.println("\n");
        System.out.print("Introduzca el email: ");
        String Correo = scanner.next();
        System.out.println("Introzca la carrera: ");
        String carrera = scanner.next();

        Estudiante estudiante = new Estudiante();
        estudiante.setId_estudiante(id);
        estudiante.setNombre(nombre);
        estudiante.setCorreo(Correo);
        estudiante.setCarrera(carrera);

        Student.update(estudiante);
        System.out.println("Estudiante actualizado correctamente.");
    }

    private static void eliminarPersona() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduzca el ID del estudiante : ");
        int id = scanner.nextInt();

        Student.delete(id);
        System.out.println("Persona eliminada correctamente.");
    }

    private static void listarPersonas() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        List<Estudiante> estudiantes = Student.getAll();

        for (Estudiante estudiante : estudiantes) {
            System.out.println("ID: " + estudiante.getId_estudiante());
            System.out.println("Nombre: " + estudiante.getNombre());
            System.out.println("Correo: " + estudiante.getCorreo());
            System.out.println("Carrera: " + estudiante.getCarrera());
            System.out.println();
        }
    }
}