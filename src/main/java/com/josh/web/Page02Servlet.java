package com.josh.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "page02", urlPatterns = "/page-hub/page02")
public class Page02Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void init() throws ServletException {
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        String title = "Page02";
        String backLink = "http://localhost:8989/page-hub";
        String history = "text history here";
        String textSubmit = "/page-hub/add-text";

        try{
        String html = "<!Doctype>" +
            "<html>" +
            "<head>" +
            "<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>" +
            "<title> " + title + " </title>" +
            "</head>" +
            "<body>" +
            "<h1> Page02 </h1>" +
            "<br/><br/>" +
            "<fieldset>" +
            "<p> " + history + " </p>" +
            "<br/><br/>" +
            "<form name=textAdd method=get action=" + textSubmit + ">" +
            "<label> Text: </label>" +
            "<input type=text name=text />" +
            "<br/><br/>" +
            "<input type=submit value=Text />" +
            "</form>" +
            "</fieldset>" +
            "<br/><br/>" +
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
        
    }
}
