/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

/**
 *
 * @author Gilbe
 */
public class Materia {
    private String nombre;
    private String profesor;
    private int creditos;

    public Materia(String nombre, String profesor, int creditos) {
        this.nombre = nombre;
        this.profesor = profesor;
        this.creditos = creditos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getProfesor() {
        return profesor;
    }

    public int getCreditos() {
        return creditos;
    }

    public String toString() {
        return nombre + " (Prof: " + profesor + ", Créditos: " + creditos + ")";
    }
}
