package com.josh.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "FirewallServlet", urlPatterns = { "/firewall" })
public class FirewallServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();

        try {
            writer.println("<!Doctype html>");
            writer.println("<html>");
            writer.println("<head>");
            writer.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
            writer.println("<title> Firewall </title>");
            writer.println("</head>");
            writer.println("<body>");
            writer.println("<h2> Firewall Demo </h2>");
            String img = "Firewall/Fire.jpg";
            String alt = "Flame";
            writer.println("<img src=" + img + " alt=" + alt + ">");
            writer.println("</body>");
            writer.println("</html>");
        } finally {
            writer.close();
        }

    }

    @Override
    public void destroy() {
        System.out.println("Shutting down firewall servlet");
    }
}