package com.login_servlet;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve username and password from login form
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Dummy authentication (Replace with database validation)
        if ("admin".equals(username) && "password123".equals(password)) {
            // Create session
            HttpSession session = request.getSession();
            session.setAttribute("user", username);

            // Redirect to login success page
            response.sendRedirect("LoginSuccess.jsp");
        } else {
            // Redirect back to login page with error
            response.sendRedirect("LoginPage.jsp?error=Invalid Credentials");
        }
    }
}