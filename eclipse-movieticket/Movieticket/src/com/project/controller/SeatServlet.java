package com.project.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/bookSeat")
public class SeatServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String seatNo = req.getParameter("seatNo");
        HttpSession session = req.getSession();
        int userId = (int) session.getAttribute("userId");
        int movieId = (int) session.getAttribute("movieId");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie_db", "root", "123456");
            PreparedStatement ps = con.prepareStatement("INSERT INTO bookings(user_id, movie_id, seat_no) VALUES (?, ?, ?)");
            ps.setInt(1, userId);
            ps.setInt(2, movieId);
            ps.setString(3, seatNo);
            ps.executeUpdate();
            resp.sendRedirect("success.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}