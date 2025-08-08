/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Crud;

/**
 *
 * @author Erasmo
 */
// En esta clase esta creada los atributos de las entidades y sus respectivos metodos setters y getters

public class Horario {
    private int id_horario;
    private String dia;
    private String FechaInicio;
    private String FechaFin;
    private int id_aula;

    public int getId_horario() {
        return id_horario;
    }

    public void setId_horario(int id_horario) {
        this.id_horario = id_horario;
    }

    public String getDia() {
        return dia;
    }

    public String getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        FechaInicio = fechaInicio;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getFechaFin() {
        return FechaFin;
    }

    public int getId_aula() {
        return id_aula;
    }

    public void setId_aula(int id_aula) {
        this.id_aula = id_aula;
    }

    public void setFechaFin(String fechaFin) {
        this.FechaFin = fechaFin;
    }
}
