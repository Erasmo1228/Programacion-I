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
import java.util.Scanner;

import static Crud.AsignacionPrueba.*;
import static Crud.AulaPrueba.*;
import static Crud.EstudiantePrueba.*;
import static Crud.HorarioPrueba.*;
import static Crud.ProfesorPrueba.*;
import static Crud.MateriaPrueba.*;

//Clase creada para la gestion desde consola
/*
public class General {
    public static void main (String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        int opcion;
        int opcionmenu;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("*************");
            System.out.println("CRUD");
            System.out.println("1.Estudiantes");
            System.out.println("2.Profesores");
            System.out.println("3.Materias");
            System.out.println("4.Aulas");
            System.out.println("5.Horarios");
            System.out.println("6.Asignaciones");
            System.out.println("7.Salir");
            System.out.println("Introduzca una opcion");
            opcionmenu = sc.nextInt();
            switch (opcionmenu){
                case 1:
                    do {
                        mostrarMenu();
                        opcion = leerOpcion();
                        procesarOpcion(opcion);
                    } while (opcion != 6);
                    break;
                case 2: do{
                        mostrarMenuProfesores();
                        opcion = leerOpcionprofesores();
                        procesarOpcionProfesores(opcion);
                        }while (opcion != 6);
                        break;
                case 3:do {
                        mostrarMenuMateria();
                        opcion = leerOpcionMateria();
                        procesarOpcionMateria(opcion);
                        } while (opcion != 6);
                            break;
                case 4:do {
                    mostrarMenuAula();
                    opcion = leerOpcionAula();
                    procesarOpcionAula(opcion);
                } while (opcion != 6);
                    break;
                case 5:do {
                    mostrarMenuHorario();
                    opcion = leerOpcionHorario();
                    procesarOpcionHorario(opcion);
                } while (opcion != 6);
                    break;
                case 6: do {
                    mostrarMenutareas();
                    opcion = leerOpciontareas();
                    procesarOpciontareas(opcion);
                } while (opcion != 6);
                    break;
            }

        }while (opcionmenu != 7);

    }
}
*/