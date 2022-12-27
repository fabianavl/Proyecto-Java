package com.mycompany.web.models;

import java.io.Serializable;

public class Alumno implements Serializable {

    private String dni, nombre, apellido, titulo_curso;

    public Alumno() {

    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTituloCurso() {
        return titulo_curso;
    }

    public void setTituloCurso(String titulo_curso) {
        this.titulo_curso = titulo_curso;
    }

}
