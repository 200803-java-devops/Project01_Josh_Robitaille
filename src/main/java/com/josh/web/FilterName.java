package com.josh.web;

import java.io.IOException;

import javax.servlet.*;

public class FilterName implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub
        Filter.super.init(filterConfig);
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
        Filter.super.destroy();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        chain.doFilter(request, response);
    }
}