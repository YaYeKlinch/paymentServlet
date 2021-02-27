package com.example.payment.controller.filter;

import com.example.payment.entity.Role;
import com.example.payment.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/add-payment", "users"})
public class AdminFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if(servletResponse.isCommitted()){
            return;
        }
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        if(session != null){
            User user = (User)session.getAttribute("LoggedUser");
            if(user != null && user.getRole() == Role.USER){
                response.sendRedirect("/accounts");
            }else{
                filterChain.doFilter(request, response);
            }
        }
        else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
