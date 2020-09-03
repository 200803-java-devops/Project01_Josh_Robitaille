package com.josh.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "changePassword", urlPatterns = "/page-hub/change-password")
public class ChangePasswordServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void init() throws ServletException {
        super.init();    
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        String title = "Password Change";
        String backLink = "http://localhost:8989/page-hub";
        String page = "/saving-info?username=" + req.getParameter("username") + "&change=yes";

        try{
        String html = "<!Doctype>" +
            "<html>" +
            "<head>" +
            "<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>" +
            "<title> " + title + " </title>" +
            "</head>" +
            "<body>" +
            "<h1> Change Password </h1>" +
            "<br/><br/>" +
            "<fieldset>" +
            "<legend> New Password </legend>" +
            "<form name=passwordChange method=post action=" + page + ">" +
            "<label> New Password: </label>" +
            "<input type=password name=password />" +
            "<br/><br/>" +
            "<input type=submit value=SetNewPassword />" +
            "</form>" +
            "</fieldset>" +
            "<br/>" +
            "<a href =" + backLink + "> Back </a>" +
            "</body>" +
            "</html>";

            writer.println(html);
        } finally {
            writer.close();
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
