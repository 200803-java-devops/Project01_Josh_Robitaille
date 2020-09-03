package com.josh.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "saveInfo", urlPatterns = "/saving-info")
public class SaveInfoServlet extends HttpServlet{
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        PrintWriter writer = resp.getWriter();
        String title = "Info Saved";
        String back = "http://localhost:8989/firewall";

        System.out.println(username + " : " + password);
        Firewall.users.put(username, password);
        System.out.println(Firewall.users.toString());

        try{
        String html = "<!Doctype html>" +
        "<html>" +
        "<head>" +
        "<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>" +
        "<title> " + title + " </title>" +
        "</head" +
        "<body>" +
        "<h2> Login Info Saved As </h2>" +
        "<h3> Username: " + username + " </h3>" +
        "<h3> Password: " + password + " </h3>" +
        "<a href=" + back + "> Back To Login </a>" +
        "</body>" +
        "</html>";

        writer.println(html);
        } finally{
            writer.close();
        }
    }
}