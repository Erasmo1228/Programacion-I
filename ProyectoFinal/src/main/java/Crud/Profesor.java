/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Crud;

/**
 *
 * @author Erasmo
 */// En esta clase esta creada los atributos de las entidades y sus respectivos metodos setters y getters
public class Profesor {

    private int id_profesor;
    private String nombre;
    private String EmailProfesor;
    private String Especialidad;

    public int getId_profesor() {
        return id_profesor;
    }

    public void setId_profesor(int id_profesor) {
        this.id_profesor = id_profesor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmailProfesor() {
        return EmailProfesor;
    }

    public void setEmailProfesor(String emailProfesor) {
        EmailProfesor = emailProfesor;
    }

    public String getEspecialidad() {
        return Especialidad;
    }

    public void setEspecialidad(String especialidad) {
        Especialidad = especialidad;
    }
}
