package com.project.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/selectMovie")
public class MovieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int movieId = Integer.parseInt(req.getParameter("movieId"));
        HttpSession session = req.getSession();
        session.setAttribute("movieId", movieId);
        resp.sendRedirect("seats.jsp");
    }
}