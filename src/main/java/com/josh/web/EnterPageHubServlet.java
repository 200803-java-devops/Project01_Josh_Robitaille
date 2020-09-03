package com.josh.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "loginToPages", urlPatterns = "/enter-page-hub")
public class EnterPageHubServlet extends HttpServlet {
    
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("http://localhost:8989/page-hub?username=" + req.getParameter("username"));
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
