<%@ page import="java.sql.*" %>
<%@ page import="javax.servlet.http.HttpSession" %>

<h2>Select a Movie</h2>
<form action="selectMovie" method="post">
    <select name="movieId">
        <%
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie_db", "root", "123456");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM movies");
            while(rs.next()) {
        %>
            <option value="<%= rs.getInt("id") %>"><%= rs.getString("title") %></option>
        <%
            }
        %>
    </select>
    <input type="submit" value="Select">
</form>