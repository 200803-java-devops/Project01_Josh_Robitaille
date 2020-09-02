package com.josh.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "FirewallServlet", urlPatterns = { "/firewall" })
public class MainServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    public void destroy() {
        System.err.println("Shutting down firewall servlet");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        String title = "Main";
        String hubPage = "/page-hub";
        String register = "http://localhost:8989/register";

        try {
            String html = "<!Doctype html>" +
            "<html>" +
            "<head>" +
            "<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>" +
            "<title> " + title + " </title>" +
            "</head>" +
            "<body>" +
            "<h1> Main Page </h1>" +
            "<div id=content>" +
            "<a href=" + register + " style=font-size:20px> New User </a>" +
            "<br/></br>" +
            "<fieldset>" +
            "<legend> Login </legend>" +
            "<form name=loginForm method=post action=" + hubPage + ">" +
            "<label> Username: </label>" +
            "<input type=text name =username />" +
            "<br/>" +
            "<label> Password: </label>" +
            "<input type=password name=password />" +
            "<br/><br/>" +
            "<input type=submit value=Login />" +
            "</form>" +
            "</fieldset>" +
            "</div>" +
            "</body>" +
            "</html>";

            writer.println(html);
        } finally {
            writer.close();
        }

    }
}