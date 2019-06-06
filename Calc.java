package com.oc.Controller;

import com.oc.Model.Operation;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(name = "Calc" , urlPatterns = {"/calc"})
public class Calc extends HttpServlet {

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html");

    Operation operation1 = new Operation();          /* <--------- Cree une instance de la classe operation, selon modele MVC afin de faire le calcule dans bean Operation*/
    operation1.calculette(request);

    request.setAttribute("operation1",
        operation1);   /* <-------- Envoie de l'instance "operation1" et ses attribues à la JSP calc.jsp */

    this.getServletContext().getRequestDispatcher("/WEB-INF/calc.jsp")
        .forward(request, response);
  }

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html");



    this.getServletContext().getRequestDispatcher("/WEB-INF/calc.jsp")
        .forward(request, response);
  }
}