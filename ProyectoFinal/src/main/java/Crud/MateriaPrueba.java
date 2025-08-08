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
public class MateriaPrueba {
    public static  final MateriaDAO asignatura = new MateriaDAO();

    public  static void mostrarMenuMateria() {
        System.out.println("**CRUD Materia**");
        System.out.println("1. Crear Materia");
        System.out.println("2. Listar Materias");
        System.out.println("3. Leer Materia");
        System.out.println("4. Actualizar Materia");
        System.out.println("5. Eliminar Materia");
        System.out.println("6. Atras");
    }

    public  static int leerOpcionMateria() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduzca una opción: ");
        return scanner.nextInt();
    }

    public static int  procesarOpcionMateria(int opcion) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        switch (opcion) {
            case 1:
                crearMaterias();
                break;
            case 2:
                listarMaterias();
                break;
            case 3:
                leerMaterias();
                break;
            case 4:
                actualizarMaterias();
                break;
            case 5:
                eliminarMaterias();
                break;
            case 6:
                System.out.println("Saliendo del programa...");
                break;
            default:
                System.out.println("Opción no válida.");
        }
        return opcion;
    }

    private static void crearMaterias() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduzca el id de la materia: ");
        int id = scanner.nextInt();
        System.out.print("Introduzca el nombre de la materia: ");
        String nombre = scanner.next();
        System.out.print("Introduz los creditos: ");
        int creditos = scanner.nextInt();
        System.out.println("Introduzca la descripcion");
        String descripcion = scanner.next();
        System.out.println("Introduzca el id estudiante");
        int estudiante = scanner.nextInt();
        System.out.println("Introduzca el id profesor");
        int profesor = scanner.nextInt();

        Materia asignatura1 = new Materia();
        asignatura1.setId_materia(id);
        asignatura1.setNombre(nombre);
        asignatura1.setCreditos(creditos);
        asignatura1.setDescripcion(descripcion);
        asignatura1.setId_estudiante(estudiante);
        asignatura1.setId_profesor(profesor);

        asignatura.create(asignatura1);
        System.out.println("Materia creada correctamente.");
    }

    private static void leerMaterias() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduzca el ID de la materia: ");
        int id = scanner.nextInt();

        Materia asignatura1  = asignatura.read(id);

        if (asignatura1 != null) {
            System.out.println("**Materia encontrada**");
            System.out.println("ID: " + asignatura1.getId_materia());
            System.out.println("Nombre: " + asignatura1.getNombre());
            System.out.println("Creditos: " + asignatura1.getCreditos());
            System.out.println("Descripcion: "+ asignatura1.getDescripcion());
            System.out.println("Id_estudiante: " +asignatura1.getId_estudiante());
            System.out.println("Id_profesor: " +asignatura1.getId_profesor());
        } else {
            System.out.println("Materia no encontrada.");
        }
    }

    private static void actualizarMaterias() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduzca el ID de la materia: ");
        int id = scanner.nextInt();
        leerMaterias();
        System.out.print("Introduzca el nombre: ");
        String nombre = scanner.next();
        System.out.print("Introduz los creditos: ");
        int creditos = scanner.nextInt();
        System.out.println("Introduzca la descripcion");
        String descripcion = scanner.next();
        System.out.println("Introduzca el id estudiante");
        int estudiante = scanner.nextInt();
        System.out.println("Introduzca el id profesor");
        int profesor = scanner.nextInt();

        Materia asignatura1 = new Materia();
        asignatura1.setId_materia(id);
        asignatura1.setNombre(nombre);
        asignatura1.setCreditos(creditos);
        asignatura1.setDescripcion(descripcion);
        asignatura1.setId_estudiante(estudiante);
        asignatura1.setId_profesor(profesor);

        asignatura.update(asignatura1);
        System.out.println("Materia actualizada correctamente.");
    }

    private static void eliminarMaterias() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduzca el ID de la materia : ");
        int id = scanner.nextInt();

        asignatura.delete(id);
        System.out.println("Persona eliminada correctamente.");
    }

    private static void listarMaterias() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        List<Materia> asignaturas = asignatura.getAll();

        for (Materia materia : asignaturas) {
            System.out.println("ID: " + materia.getId_materia());
            System.out.println("Nombre: " + materia.getNombre());
            System.out.println("Creditos: " + materia.getCreditos());
            System.out.println("Descripcion: " + materia.getDescripcion());
            System.out.println("id_estudiante: " + materia.getId_estudiante());
            System.out.println("Id_profesor: " + materia.getId_profesor());
            System.out.println();
        }
    }

}
