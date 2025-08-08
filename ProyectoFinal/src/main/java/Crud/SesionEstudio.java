/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Crud;

import java.time.LocalDateTime;

public class SesionEstudio {
    private MateriaGilbert materia;
    private LocalDateTime inicio;
    private int duracionMinutos;

    public SesionEstudio(MateriaGilbert materia, LocalDateTime inicio, int duracionMinutos) {
        this.materia = materia;
        this.inicio = inicio;
        this.duracionMinutos = duracionMinutos;
    }

    public MateriaGilbert getMateria() {
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