package com.josh.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "register", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;

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
        String title = "Register";
        String action = "/saving-info";
        String backLink = "http://localhost:8989/firewall";

        try{
            String html = "<!Doctype html>" +
            "<html>" +
            "<head>" +
            "<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>" +
            "<title> " + title + " </title>" +
            "</head>" +
            "<body>" +
            "<h1> Register Page </h1>" +            
            "<fieldset>" +
            "<legend> Register </legend>" +
            "<form name=loginForm method=post action=" + action + ">" +
            "<label> Username: </label>" +
            "<input type=text name =username />" +
            "<br/>" +
            "<label> Password: </label>" +
            "<input type=password name=password />" +
            "<br/><br/>" +
            "<input type=submit value=Register />" +
            "</form>" +
            "</fieldset>" +
            "<br/><br/>" +
            "<fieldset>" +
            "<legend> Rules </legend>" +
            "<ul> " +
            "<li> Username </li>" +
            "<ul>" +
            "<li> Username cannot be shorter then 3 characters </li>" +
            "<li> Username cannot contain vulgar strings of letters </li>" +
            "</ul>" +
            "<li> Password </li>" +
            "<ul>" +
            "<li> Password cannot be shorter then 8 characters </li>" +
            "</ul>" +
            "</ul>" +
            "</fieldset>" +
            "<br/>" +
            "<a href =" + backLink + "> Back </a>" +
            "</body>" +
            "</html>";

            writer.println(html);
        } finally{
            writer.close();
        }
    }
}