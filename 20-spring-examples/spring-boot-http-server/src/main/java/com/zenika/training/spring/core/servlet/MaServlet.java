package com.zenika.training.spring.core.servlet;

import com.zenika.training.spring.core.service.Service;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MaServlet extends HttpServlet {

    private int internalVar = 0;

    public void init() {
        executeService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        internalVar = internalVar + 100;
        response.getWriter().write("<h1>CECI EST LE TEXTE DE RETOUR : " + internalVar + "</h1>");
    }


    private void executeService() {
        ApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());

        Service clientService = (Service) context.getBean("service");

        clientService.execute();
    }
}
