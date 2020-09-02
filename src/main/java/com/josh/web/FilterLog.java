package com.josh.web;

import java.io.IOException;
import java.util.Date;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FilterLog implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("------------------------");
        System.out.println("Init" + this.getClass().getName().toString());
        System.out.println("------------------------");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        String ipAddress = request.getRemoteAddr();
        System.out.println("IP address: " + ipAddress + ", Time: " + new Date().toString());
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("------------------------");
        System.out.println("Destroy " + this.getClass().getName().toString());
        System.out.println("------------------------");
    }
}