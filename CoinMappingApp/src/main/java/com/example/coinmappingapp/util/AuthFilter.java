package com.example.coinmappingapp.util;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class AuthFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String uri = req.getRequestURI();
        boolean isLogin = uri.endsWith("loginUser.jsp") || uri.endsWith("login") || uri.endsWith("cadastroUser.jsp");

        boolean loggedIn = req.getSession().getAttribute("usuarioLogado") != null;


        if (!loggedIn && !isLogin) {
            resp.sendRedirect("loginUser.jsp");
        } else {
            chain.doFilter(request, response);
        }
    }
}
