package com.example.payment.controller.servlet;

import com.example.payment.controller.command.Command;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class MainServlet extends AbstractServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getRequestURI();
        path = path.replaceAll("\\d+/?","");
        processPageRequest(req,resp,path);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getRequestURI();
        path = path.replaceAll("\\d+/?","");
        processRestRequest(req,resp,path);
    }

    private void processRestRequest(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
        Command command = urlToPostCommand.get(path);
        request.getRequestDispatcher(command.execute(request)).forward(request,response);
    }

    private void processPageRequest(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
        Command command = urlToGetCommand.get(path);
        request.getRequestDispatcher(command.execute(request)).forward(request,response);
    };
}
