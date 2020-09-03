package com.josh.web;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(filterName = "nameCheck", urlPatterns = "/saving-info")
public class FilterRegisteredName implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("------------------------");
        System.out.println("Init" + this.getClass().getName().toString());
        System.out.println("------------------------");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        String[] notAllowed = { "bitch", "Bitch", "BITCH", 
        "fuck", "Fuck", "FUCK", 
        "shit", "Shit", "SHIT", 
        "ass", "Ass", "ASS", 
        "dick", "Dick", "DICK", 
        "cunt", "Cunt", "CUNT", 
        "penis", "Penis", "PENIS", 
        "cock", "Cock", "COCK", 
        "vagina", "Vagina", "VAGINA", 
        "boob", "Boob", "BOOB"
        };

        System.out.println("Checking name validity");
        boolean validUsername = false;

        if (username.length() >= 3 && password.length() >= 8) {
            for (String word : notAllowed) {
                if (username.contains(word)) {
                    validUsername = false;
                    break;
                } else {
                    validUsername = true;
                }
            }
        } else {
            System.out.println("Not valid . . .");
            resp.sendRedirect("http://localhost:8989/register");
        }

        if (validUsername) {
            chain.doFilter(request, response);
        } else {
            System.out.println("Cannot use a string of letters in name . . .");
            resp.sendRedirect("http://localhost:8989/register");
        }

    }

    @Override
    public void destroy() {
        System.out.println("------------------------");
        System.out.println("Init" + this.getClass().getName().toString());
        System.out.println("------------------------");
    }
}
