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
public class HorarioPrueba {
    public static  final HorarioDAO horas = new HorarioDAO();

    public  static void mostrarMenuHorario() {
        System.out.println("**CRUD Horario**");
        System.out.println("1. Crear Horario");
        System.out.println("2. Listar Horarios");
        System.out.println("3. Leer Horario");
        System.out.println("4. Actualizar Horario");
        System.out.println("5. Eliminar Horario");
        System.out.println("6. Atras");
    }

    public  static int leerOpcionHorario() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduzca una opción: ");
        return scanner.nextInt();
    }

    public static int  procesarOpcionHorario(int opcion) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        switch (opcion) {
            case 1:
                crearhorario();
                break;
            case 2:
                listarhorario();
                break;
            case 3:
                leerhorario();
                break;
            case 4:
                actualizarhorario();
                break;
            case 5:
                eliminarhorario();
                break;
            case 6:
                System.out.println("Saliendo del programa...");
                break;
            default:
                System.out.println("Opción no válida.");
        }
        return opcion;
    }


    private static void crearhorario() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduzca el id del horario: ");
        int id = scanner.nextInt();
        System.out.print("Introduzca el dia: ");
        String dia = scanner.next();
        System.out.print("Introduzca la Fecha inicio: ");
        String inicio = scanner.next();
        System.out.print("Introduzca la Fecha fin: ");
        String fin = scanner.next();
        System.out.println("Introduzca el id del aula");
        int aula = scanner.nextInt();

        Horario horario = new Horario();
        horario.setId_horario(id);
        horario.setDia(dia);
        horario.setFechaInicio(inicio);
        horario.setFechaFin(fin);
        horario.setId_aula(aula);

        horas.create(horario);
        System.out.println("Horario creada correctamente.");
    }

    private static void leerhorario() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduzca el ID del horario: ");
        int id = scanner.nextInt();

        Horario horario = horas.read(id);

        if (horario != null) {
            System.out.println("**Horario encontrado**");
            System.out.println("ID: " + horario.getId_horario());
            System.out.println("Dia: " + horario.getDia());
            System.out.println("Fecha Inicio: " + horario.getFechaInicio());
            System.out.println("Fecha fin : " + horario.getFechaFin());
            System.out.println("Id aula: " + horario.getId_aula());
        } else {
            System.out.println("Horario no encontrado.");
        }
    }

    private static void actualizarhorario() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduzca el id del horario: ");
        int id = scanner.nextInt();
        leerhorario();
        System.out.print("Introduzca el dia: ");
        String dia = scanner.next();
        System.out.print("Introduzca la Fecha inicio: ");
        String inicio = scanner.next();
        System.out.print("Introduzca la Fecha fin: ");
        String fin = scanner.next();
        System.out.println("Introduzca el id del aula");
        int aula = scanner.nextInt();

        Horario horario = new Horario();
        horario.setId_horario(id);
        horario.setDia(dia);
        horario.setFechaInicio(inicio);
        horario.setFechaFin(fin);
        horario.setId_aula(aula);

        horas.create(horario);
        System.out.println("Horario actualizado correctamente.");
    }

    private static void eliminarhorario() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduzca el ID del horario : ");
        int id = scanner.nextInt();

        horas.delete(id);
        System.out.println("Horario eliminada correctamente.");
    }

    private static void listarhorario() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        List<Horario> horarios = horas.getAll();

        for (Horario horario1 : horarios) {
            System.out.println("ID: " + horario1.getId_horario());
            System.out.println("Dia: " + horario1.getDia());
            System.out.println("FechaInicio: " + horario1.getFechaInicio());
            System.out.println("FechaFin: " + horario1.getFechaFin());
            System.out.println("Id aula: " + horario1.getId_aula());
            System.out.println();
        }
    }
}
