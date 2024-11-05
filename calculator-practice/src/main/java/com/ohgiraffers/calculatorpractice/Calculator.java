package com.ohgiraffers.calculatorpractice;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;

@WebServlet(value = "/menu/order")
public class Calculator extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int num1 = Integer.parseInt(req.getParameter("number1"));
        int num2 = Integer.parseInt(req.getParameter("number2"));
        String operator = req.getParameter("operator");

        HashMap<String, String> result = new 스위치().totalNumber(operator, num1 , num2 );

        System.out.println(result);

        System.out.println("result : " + result.get("result"));
        System.out.println("msg : " + result.get("message"));

        req.setAttribute("num1", num1);
        req.setAttribute("num2", num2);
        req.setAttribute("result",result.get("result"));
        req.setAttribute("msg",result.get("message"));

        RequestDispatcher rd = req.getRequestDispatcher("/jsp/answer.jsp");
        rd.forward(req,resp);
    }
}
