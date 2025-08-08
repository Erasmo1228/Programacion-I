/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Crud;

/**
 *
 * @author Gilbe
 */
public class MateriaGilbert {
    private String nombre;
    private String profesor;
    private int creditos;

    public MateriaGilbert(String nombre, String profesor, int creditos) {
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
