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
public class ProfesorPrueba {
    public static final ProfesorDAO teacher = new ProfesorDAO();

    public  static void mostrarMenuProfesores() {
        System.out.println("**CRUD Profesores**");
        System.out.println("1. Crear profesor");
        System.out.println("2. Listar Profesores");
        System.out.println("3. Leer profesores");
        System.out.println("4. Actualizar profesores");
        System.out.println("5. Eliminar profesor");
        System.out.println("6. Atras");
    }

    public static int leerOpcionprofesores() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduzca una opción: ");
        return scanner.nextInt();
    }

    public static void procesarOpcionProfesores(int opcion) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        switch (opcion) {
            case 1:
                crearProfesor();
                break;
            case 2:
                listarProfesor();
                break;
            case 3:
                leerProfesor();
                break;
            case 4:
                actualizarProfesor();
                break;
            case 5:
                eliminarProfesor();
                break;
            case 6:
                System.out.println("Saliendo del programa...");
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    private static void crearProfesor() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduzca el id del profesor: ");
        int id = scanner.nextInt();
        System.out.print("Introduzca el nombre: ");
        String nombre = scanner.next();
        System.out.print("Introduzca el email: ");
        String correo = scanner.next();
        System.out.println("Introduzca la especialidad");
        String especialidad = scanner.next();

        Profesor teacher1 = new Profesor();
        teacher1.setId_profesor(id);
        teacher1.setNombre(nombre);
        teacher1.setEmailProfesor(correo);
        teacher1.setEspecialidad(especialidad);

        teacher.create(teacher1);
        System.out.println("Profesor creado correctamente.");
    }

    private static void leerProfesor() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduzca el ID del profesor: ");
        int id = scanner.nextInt();

        Profesor teacher1 = teacher.read(id);

        if (teacher1 != null) {
            System.out.println("**Profesor encontrado**");
            System.out.println("ID: " + teacher1.getId_profesor());
            System.out.println("Nombre: " + teacher1.getNombre());
            System.out.println("Correo: " + teacher1.getEmailProfesor());
            System.out.println("Especialidad: " + teacher1.getEspecialidad());
        } else {
            System.out.println("Profesor no encontrado.");
        }
    }

    private static void actualizarProfesor() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduzca el ID del profesor: ");
        int id = scanner.nextInt();
        leerProfesor();
        System.out.print("Introduzca el nombre: ");
        String nombre = scanner.next();
        System.out.println("\n");
        System.out.print("Introduzca el email: ");
        String Correo = scanner.next();
        System.out.println("Introduzca la especialidad: ");
        String especialidad = scanner.next();

        Profesor teacher1 = new Profesor();
        teacher1.setId_profesor(id);
        teacher1.setNombre(nombre);
        teacher1.setEmailProfesor(Correo);
        teacher1.setEspecialidad(especialidad);

        teacher.update(teacher1);
        System.out.println("Profesor actualizado correctamente.");
    }

    private static void eliminarProfesor() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduzca el ID del profesor : ");
        int id = scanner.nextInt();

        teacher.delete(id);
        System.out.println("Profesor eliminado correctamente.");
    }

    private static void listarProfesor() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        List<Profesor> teacher1 = teacher.getAll();

        for (Profesor teacher : teacher1) {
            System.out.println("ID: " + teacher.getId_profesor());
            System.out.println("Nombre: " + teacher.getNombre());
            System.out.println("Correo: " + teacher.getEmailProfesor());
            System.out.println("Especialidad: " +teacher.getEspecialidad());
            System.out.println();
        }
    }
}
