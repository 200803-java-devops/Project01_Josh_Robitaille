package com.josh.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "login", urlPatterns = "/login")
public class LoginServlet extends HttpServlet{

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    public void destroy() {
        System.err.println("Shutting down login servlet");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        String title = "Login";

        try{
            writer.println("<!Doctype html>");
            writer.println("<html>");
            writer.println("<head>");
            writer.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
            writer.println("<title> " + title + " </title>");
            writer.println("</head>");
            writer.println("<body>");
            writer.println("<h2> Login Page </h2>");
            writer.println("</body>");
            writer.println("</html>");
        } finally{
            writer.close();
        }
    }
}