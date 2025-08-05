/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import java.time.LocalDateTime;

public class SesionEstudio {
    private Materia materia;
    private LocalDateTime inicio;
    private int duracionMinutos;

    public SesionEstudio(Materia materia, LocalDateTime inicio, int duracionMinutos) {
        this.materia = materia;
        this.inicio = inicio;
        this.duracionMinutos = duracionMinutos;
    }

    public Materia getMateria() {
        return materia;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public String toString() {
        return "Estudiar " + materia.getNombre() + " desde " + inicio +
               " por " + duracionMinutos + " minutos.";
    }
}