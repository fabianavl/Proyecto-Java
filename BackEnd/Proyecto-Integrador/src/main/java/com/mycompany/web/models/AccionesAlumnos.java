package com.mycompany.web.models;

import com.mycompany.web.models.Alumno;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccionesAlumnos {

    // insertar registro
    public static int registrarAlumno(Alumno a) {
        int estado = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/inscripciones", "root", "");

            // insercion de valores
            String query = "INSERT INTO datos_alumno(dni, nombre, apellido, titulo_curso) VALUES(?,?,?,?)";
            String dni = a.getDni();
            String nombre = a.getNombre();
            String apellido = a.getApellido();
            String titulo_curso = a.getTituloCurso();

            PreparedStatement pst = conexion.prepareStatement(query);
            pst.setString(1, dni);
            pst.setString(2, nombre);
            pst.setString(3, apellido);
            pst.setString(4, titulo_curso);

            estado = pst.executeUpdate();

            conexion.close();

        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Error: algo salió mal");
        }

        return estado;

    }

    // actualizar registro
    public static int actualizarAlumno(Alumno a) {
        int estado = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/inscripciones", "root", "");

            String query = "UPDATE datos_alumno SET nombre=?, apellido=?,titulo_curso=? WHERE dni=?";

            String dni = a.getDni();
            String nombre = a.getNombre();
            String apellido = a.getApellido();
            String titulo_curso = a.getTituloCurso();

            PreparedStatement pst = conexion.prepareStatement(query);
            pst.setString(1, nombre);
            pst.setString(2, apellido);
            pst.setString(3, titulo_curso);
            pst.setString(4, dni);

            estado = pst.executeUpdate();

            conexion.close();

        } catch (Exception e) {
            System.out.println("Error: algo salió mal");
        }

        return estado;

    }

    // consultar registro por dni
    public static Alumno verAlumno(String dniAConsultar) {
        Alumno alumnoADevolver = new Alumno();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/inscripciones", "root", "");

            String query = "SELECT * FROM datos_alumno WHERE dni=?";

            PreparedStatement pst = conexion.prepareStatement(query);
            pst.setString(1, dniAConsultar);

            ResultSet consultaAlumno = pst.executeQuery();

            if (consultaAlumno.next()) {
                alumnoADevolver.setDni(consultaAlumno.getString(1));
                alumnoADevolver.setNombre(consultaAlumno.getString(2));
                alumnoADevolver.setApellido(consultaAlumno.getString(3));
                alumnoADevolver.setTituloCurso(consultaAlumno.getString(4));
                conexion.close();
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Error: algo salió mal");
        }

        return alumnoADevolver;

    }

    // Consulta de TODOS los registros de una tabla
    public static List<Alumno> verTodosLosAlumnos() {
        List<Alumno> listaAlumnosADevolver = new ArrayList<Alumno>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/inscripciones", "root", "");

            String query = "SELECT * FROM datos_alumno";

            PreparedStatement pst = conexion.prepareStatement(query);

            ResultSet consultaAlumno = pst.executeQuery();

            while (consultaAlumno.next()) {
                Alumno alumnoADevolver = new Alumno(); // EN CADA VUELTA NECESITAREMOS INSTANCIAR UN NUEVO OBJETO
                alumnoADevolver.setDni(consultaAlumno.getString(1));
                alumnoADevolver.setNombre(consultaAlumno.getString(2));
                alumnoADevolver.setApellido(consultaAlumno.getString(3));
                alumnoADevolver.setTituloCurso(consultaAlumno.getString(4));
                listaAlumnosADevolver.add(alumnoADevolver);
            }
            conexion.close();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Error: algo salió mal");
        }

        return listaAlumnosADevolver;

    }

}
