package com.example.payment.controller.servlet;


import com.example.payment.entity.Role;
import com.example.payment.entity.dto.UserDto;
import com.example.payment.exception.EmailExistsException;
import com.example.payment.service.user.UserService;
import com.example.payment.service.user.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

import static java.util.Objects.isNull;

@WebServlet("/registration")
public class Registration extends HttpServlet {
    private UserService userService;
    private boolean allMatches;

    @Override
    public void init(){
        userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        allMatches = true;
        UserDto user = getValidatedDto(request);
        boolean registered = registerAndAddErrorAttributes(user,request);
        if(registered){
            forwardSuccess(request,response);
        }else{
            forwardError(user,request,response);
        }
    }
    private boolean registerAndAddErrorAttributes(UserDto user, HttpServletRequest request){
        boolean registered = false;
        if(allMatches){
            try{
                registered = tryRegisterOrAddRegistrationErrorAttr(user,request);
            }catch (EmailExistsException ex){
                request.setAttribute("emailExists",true);
            }
        }
        return registered;
    }
    private boolean tryRegisterOrAddRegistrationErrorAttr(UserDto user, HttpServletRequest request){
        if(userService.registerUser(user)){
            return true;
        }else{
            request.setAttribute("registrationError",true);
            return false;
        }
    }
    private UserDto getValidatedDto(HttpServletRequest request) throws IOException {
        UserDto user = null;
        try {
            user = new UserDto(
                    request.getParameter("firs_name"),
                    request.getParameter("last_name"),
                    request.getParameter("username"),
                    request.getParameter("password"),
                    request.getParameter("confirmedPassword"));

            validateUser(request, user);

        } catch (IllegalArgumentException ex) {
            allMatches = false;
        }
        return user;
    }
    private void validateUser(HttpServletRequest request, UserDto dto) throws IOException {
        Properties regex = new Properties();
        regex.load(getServletContext().getResourceAsStream("/resources/regexp.properties"));

        //check fields filled
        checkNotEmpty(dto.getFirs_name(),"nameEmpty",request);
        checkNotEmpty(dto.getLast_name(),"surnameEmpty",request);
        checkNotEmpty(dto.getUsername(),"emailEmpty",request);
        checkNotEmpty(dto.getPassword(),"passwordEmpty",request);

        //check fields corresponds to regex
        if(allMatches) {
            matchesRegex(dto.getFirs_name(),regex.getProperty("pattern.name"),"nameWrong",request);
            matchesRegex(dto.getLast_name(),regex.getProperty("pattern.name"),"surnameWrong",request);
            matchesRegex(dto.getUsername(),regex.getProperty("pattern.email.regexp"),"emailWrong",request);

            passwordMatching(dto.getPassword(),dto.getConfirmedPassword(),"passwordsNotEqual",request);
        }
    }

    private void checkNotEmpty(String param, String emptyAttribute, ServletRequest request){
        if(isNull(param) || param.isEmpty()){
            request.setAttribute(emptyAttribute,true);
            allMatches = false;
        }
    }
    private void matchesRegex(String param, String regex ,String wrongRegexAttribute, ServletRequest request){
        if (!param.matches(regex)) {
            request.setAttribute(wrongRegexAttribute,true);
            allMatches = false;
        }
    }
    private void passwordMatching(String password, String confirm, String attribute, ServletRequest request){
        if(!password.equals(confirm)){
            request.setAttribute(attribute,true);
            allMatches = false;
        }
    }
    private void forwardError(UserDto dto, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("values",dto);
        response.setStatus(400);
        request.getRequestDispatcher("/register.jsp").forward(request, response);
    }

    private void forwardSuccess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("registered",true);
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }
}
