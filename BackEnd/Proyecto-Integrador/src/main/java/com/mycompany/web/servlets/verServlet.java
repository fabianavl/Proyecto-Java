package com.mycompany.web.servlets;

import java.io.IOException;

import com.mycompany.web.models.AccionesAlumnos;
import com.mycompany.web.models.Alumno;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/veralumno")
public class verServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String d = req.getParameter("dni");

        Alumno registro = AccionesAlumnos.verAlumno(d);

        req.setAttribute("a", registro);

        RequestDispatcher respuesta = req.getRequestDispatcher("/infoAlumno.jsp");

        // nos permite redirigirnos y mostrar la vista
        respuesta.forward(req, resp);

    }

}
