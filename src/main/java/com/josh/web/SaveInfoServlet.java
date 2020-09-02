package com.josh.web;

import java.io.IOException;

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

        System.out.println(username + " : " + password);
        Firewall.users.put(username, password);
        System.out.println(Firewall.users.toString());

        resp.sendRedirect("http://localhost:8989/firewall");
    }
}