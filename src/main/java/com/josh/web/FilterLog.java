package com.josh.web;

import java.io.IOException;
import java.util.Date;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;

@WebFilter(filterName = "log", urlPatterns = "/*")
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
        System.out.println("------------------------");
        System.out.println(">>> IP address: " + ipAddress + " >>> Time: " + new Date().toString());
        System.out.println("------------------------");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("------------------------");
        System.out.println("Destroy " + this.getClass().getName().toString());
        System.out.println("------------------------");
    }
}