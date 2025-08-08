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
public class AulaPrueba {
    public static  final AulaDAO aulas = new AulaDAO();

    public  static void mostrarMenuAula() {
        System.out.println("**CRUD Aula**");
        System.out.println("1. Crear Aula");
        System.out.println("2. Listar Aulas");
        System.out.println("3. Leer Aula");
        System.out.println("4. Actualizar Aula");
        System.out.println("5. Eliminar Aula");
        System.out.println("6. Atras");
    }

    public  static int leerOpcionAula() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduzca una opción: ");
        return scanner.nextInt();
    }

    public static int  procesarOpcionAula(int opcion) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        switch (opcion) {
            case 1:
                crearaula();
                break;
            case 2:
                listaraula();
                break;
            case 3:
                leeraula();
                break;
            case 4:
                actualizaraula();
                break;
            case 5:
                eliminaraula();
                break;
            case 6:
                System.out.println("Saliendo del programa...");
                break;
            default:
                System.out.println("Opción no válida.");
        }
        return opcion;
    }

    private static void crearaula() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduzca el id del aula: ");
        int id = scanner.nextInt();
        System.out.print("Introduzca el nombre: ");
        String nombre = scanner.next();
        System.out.print("Introduzca la capacidad: ");
        int capacidad = scanner.nextInt();

        Aula aula = new Aula();
        aula.setId_aula(id);
        aula.setNombre(nombre);
        aula.setCapacidad(capacidad);

        aulas.create(aula);
        System.out.println("Aula creada correctamente.");
    }

    private static void leeraula() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduzca el ID del aula: ");
        int id = scanner.nextInt();

        Aula aula = aulas.read(id);

        if (aula != null) {
            System.out.println("**Aula encontrada**");
            System.out.println("ID: " + aula.getId_aula());
            System.out.println("Nombre: " + aula.getNombre());
            System.out.println("Capacidad: " + aula.getCapacidad());
        } else {
            System.out.println("Aula no encontrada.");
        }
    }

    private static void actualizaraula() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduzca el ID del aula: ");
        int id = scanner.nextInt();
        leeraula();
        System.out.print("Introduzca el nombre: ");
        String nombre = scanner.next();
        System.out.print("Introduzca la capacidad: ");
        int capacidad = scanner.nextInt();

        Aula aula = new Aula();
        aula.setId_aula(id);
        aula.setNombre(nombre);
        aula.setCapacidad(capacidad);

        aulas.update(aula);
        System.out.println("Aula actualizada correctamente.");
    }

    private static void eliminaraula() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduzca el ID del aula : ");
        int id = scanner.nextInt();

        aulas.delete(id);
        System.out.println("Aula eliminada correctamente.");
    }

    private static void listaraula() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        List<Aula> aula = aulas.getAll();

        for (Aula aula1 : aula) {
            System.out.println("ID: " + aula1.getId_aula());
            System.out.println("Nombre: " + aula1.getNombre());
            System.out.println("Capacidad: " + aula1.getCapacidad());
            System.out.println();
        }
    }
}
