package com.ohgiraffers.filter;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(value = "/first/filter")
public class FirstFilterTestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("여기는 델타 델타 호출 확인바란다.");
        PrintWriter out = resp.getWriter();

        out.println("<!doctype html>");
        out.println("<html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h3>필터 확인 용 서블릿 확인 요청</h3>");
        out.println("</body>");
        out.println("</html>");

        out.flush();
        out.close();
    }
}