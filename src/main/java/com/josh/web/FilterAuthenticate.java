package com.josh.web;

import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FilterAuthenticate implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("------------------------");
        System.out.println("Init" + this.getClass().getName().toString());
        System.out.println("------------------------");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        System.out.println("Authentication filter");

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Hashtable<String, String> userPair = new Hashtable<>();
        userPair.put(username, password);

        if (Firewall.users.contains(userPair)){
            chain.doFilter(request, response);
        } else{
            System.out.println("Failed login");
        resp.sendRedirect("http://localhost:8989/firewall");
        }        
    }

    @Override
    public void destroy() {
        System.out.println("------------------------");
        System.out.println("Init" + this.getClass().getName().toString());
        System.out.println("------------------------");
    }

}
