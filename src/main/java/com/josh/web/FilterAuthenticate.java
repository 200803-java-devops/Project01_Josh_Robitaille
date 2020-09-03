package com.josh.web;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(filterName = "authenticate", urlPatterns = "/enter-page-hub")
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

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        System.out.println(">>> saved users: " + Firewall.users.toString());
        System.out.println(">>> param user pair: " + username + "=" + password);

        if (Firewall.users.containsKey(username)) {
            if (Firewall.users.get(username).equals(password)) {
                chain.doFilter(request, response);
            }
        } else{
            System.out.println("Login Failed . . .");
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