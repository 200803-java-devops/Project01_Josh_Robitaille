package com.josh.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "pages", urlPatterns = "/page-hub")
public class PagesServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        String title = "Hub";
        String username = req.getParameter("username");
        String backLink = "http://localhost:8989/firewall";
        String changePassword = "http://localhost:8989//page-hub/change-password?username=" + username;
        String page01 = "http://localhost:8989/page-hub/page01";
        String page02 = "http://localhost:8989/page-hub/page02";
        String page03 = "http://localhost:8989/page-hub/page03";

        System.out.println(username);
        try {
            String html = "<!Doctype html>" +
            "<html>" +
            "<head>" +
            "<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>" +
            "<title> " + title + " </title>" +
            "</head>" +
            "<body>" +
            "<h1> Hub Page </h1>" +
            "<br/>" +
            "<h3> Welcome " + username + " </h3>" +
            "<fieldset>" +
            "<legend> Page Links </legend>" +
            "<a href =" + page01 + "> Page01 </a>" +
            "<br/>" +
            "<a href =" + page02 + "> Page02 </a>" +
            "<br/>" +
            "<a href =" + page03 + "> Page03 </a>" +
            "<br/>" +
            "<a href =" + changePassword + "> Change Password </a>" +
            "<br/>" +
            "<a href =" + backLink + "> Back </a>" +
            "</fieldset>" +
            "</body>" +
            "</html>";

            writer.println(html);
        } finally {
            writer.close();
        }

    }
}