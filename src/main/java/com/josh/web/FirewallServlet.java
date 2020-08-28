package com.josh.web;

import java.io.IOException;
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
        resp.getWriter().println("Firewall");
    }

    @Override
    public void destroy() {
        System.out.println("Shutting down firewall servlet");
    }
}