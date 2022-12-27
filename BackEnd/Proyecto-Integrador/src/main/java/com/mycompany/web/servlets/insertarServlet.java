package com.mycompany.web.servlets;

import java.io.IOException;

import com.mycompany.web.models.AccionesAlumnos;
import com.mycompany.web.models.Alumno;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/nuevoalumno")
public class insertarServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String d, n, a, c;
        d = req.getParameter("dni");
        n = req.getParameter("nombre");
        a = req.getParameter("apellido");
        c = req.getParameter("curso");

        Alumno nuevoAlumno = new Alumno();
        nuevoAlumno.setDni(d);
        nuevoAlumno.setNombre(n);
        nuevoAlumno.setApellido(a);
        nuevoAlumno.setTituloCurso(c);

        int estado = AccionesAlumnos.registrarAlumno(nuevoAlumno);

        if (estado == 1) {
            resp.sendRedirect("exito.jsp");
            System.out.println("Todo en orden");
        } else {
            System.out.println("Error");
            resp.sendRedirect("error.jsp");
        }

    }
}
