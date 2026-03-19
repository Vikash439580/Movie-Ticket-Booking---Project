<%
    String userName = (String) session.getAttribute("userName");
    if (userName == null) {
        response.sendRedirect("login.jsp");
    }
%>

<h2>Welcome, <%= userName %>!</h2>
<a href="movies.jsp">Choose a Movie</a>